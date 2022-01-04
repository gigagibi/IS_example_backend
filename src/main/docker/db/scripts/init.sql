--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0
-- Dumped by pg_dump version 14.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id integer NOT NULL,
    surname character varying(55),
    name character varying(55),
    patronym character varying(55),
    hire_date date,
    dismissal_date date,
    email character varying(40),
    position_id integer,
    department_id integer,
    login character varying(30),
    password character varying,
    role_id integer
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: count_of_employees; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.count_of_employees AS
 SELECT count(users.user_id) AS count
   FROM public.users
  WHERE (users.dismissal_date IS NULL);


ALTER TABLE public.count_of_employees OWNER TO postgres;

--
-- Name: current_employee; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.current_employee AS
 SELECT users.user_id,
    users.surname,
    users.name,
    users.patronym,
    users.hire_date,
    users.dismissal_date,
    users.email,
    users.position_id,
    users.department_id
   FROM public.users
  WHERE (users.dismissal_date IS NULL)
  ORDER BY users.name;


ALTER TABLE public.current_employee OWNER TO postgres;

--
-- Name: department_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.department_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.department_sequence OWNER TO postgres;

--
-- Name: departments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departments (
    department_id integer NOT NULL,
    name character varying(55),
    office_id integer
);


ALTER TABLE public.departments OWNER TO postgres;

--
-- Name: time_entries; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.time_entries (
    entry_id integer NOT NULL,
    task_id integer,
    hours integer,
    entry_date timestamp with time zone
);


ALTER TABLE public.time_entries OWNER TO postgres;

--
-- Name: entries_between; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.entries_between AS
 SELECT time_entries.task_id,
    time_entries.hours,
    time_entries.entry_date
   FROM public.time_entries
  WHERE ((time_entries.task_id IN ( SELECT time_entries.task_id
           FROM public.users
          WHERE (users.user_id = 3))) AND (time_entries.entry_date >= '2021-09-30 00:00:00+03'::timestamp with time zone) AND (time_entries.entry_date <= '2021-12-03 00:00:00+03'::timestamp with time zone));


ALTER TABLE public.entries_between OWNER TO postgres;

--
-- Name: hours_between; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.hours_between AS
 SELECT sum(time_entries.hours) AS sum
   FROM public.time_entries
  WHERE ((time_entries.task_id IN ( SELECT time_entries.task_id
           FROM public.users
          WHERE (users.user_id = 6))) AND (time_entries.entry_date >= '2021-09-30 00:00:00+03'::timestamp with time zone) AND (time_entries.entry_date <= '2021-12-06 00:00:00+03'::timestamp with time zone));


ALTER TABLE public.hours_between OWNER TO postgres;

--
-- Name: message_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.message_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.message_sequence OWNER TO postgres;

--
-- Name: messages; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.messages (
    message_id integer NOT NULL,
    sender_id integer NOT NULL,
    receiver_id integer NOT NULL,
    text character varying,
    "time" timestamp without time zone,
    is_saw boolean
);


ALTER TABLE public.messages OWNER TO postgres;

--
-- Name: office_departments; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.office_departments AS
 SELECT departments.department_id,
    departments.name,
    departments.office_id
   FROM public.departments
  WHERE (departments.office_id = 15);


ALTER TABLE public.office_departments OWNER TO postgres;

--
-- Name: office_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.office_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.office_sequence OWNER TO postgres;

--
-- Name: offices; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.offices (
    office_id integer NOT NULL,
    address character varying(100)
);


ALTER TABLE public.offices OWNER TO postgres;

--
-- Name: projects; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projects (
    project_id integer NOT NULL,
    name character varying(50),
    description character varying(1100),
    customer character varying(55),
    planned_start_date date,
    fact_start_date date,
    planned_finish_date date,
    fact_finish_date date,
    planned_cost integer,
    fact_cost integer,
    planned_profit integer,
    fact_profit integer
);


ALTER TABLE public.projects OWNER TO postgres;

--
-- Name: tasks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tasks (
    task_id integer NOT NULL,
    start_date date,
    finish_date date,
    project_id integer,
    user_id integer,
    name character varying(55),
    description character varying(500),
    task_type_id integer
);


ALTER TABLE public.tasks OWNER TO postgres;

--
-- Name: pm_projects; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.pm_projects AS
 SELECT projects.project_id,
    projects.name,
    projects.description,
    projects.customer,
    projects.planned_start_date,
    projects.fact_start_date,
    projects.planned_finish_date,
    projects.fact_finish_date,
    projects.planned_cost,
    projects.fact_cost,
    projects.planned_profit,
    projects.fact_profit
   FROM public.projects
  WHERE (projects.project_id IN ( SELECT tasks.project_id
           FROM public.tasks
          WHERE ((tasks.task_type_id = 1) AND (tasks.user_id = 6))));


ALTER TABLE public.pm_projects OWNER TO postgres;

--
-- Name: position_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.position_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.position_sequence OWNER TO postgres;

--
-- Name: positions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.positions (
    pos_id integer NOT NULL,
    name character varying(30),
    grade integer
);


ALTER TABLE public.positions OWNER TO postgres;

--
-- Name: project_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.project_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.project_sequence OWNER TO postgres;

--
-- Name: role_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_sequence OWNER TO postgres;

--
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    role_id integer NOT NULL,
    name character varying
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- Name: task_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.task_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.task_sequence OWNER TO postgres;

--
-- Name: task_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.task_type (
    task_type_id integer NOT NULL,
    task_type character varying(30)
);


ALTER TABLE public.task_type OWNER TO postgres;

--
-- Name: task_type_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.task_type_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.task_type_sequence OWNER TO postgres;

--
-- Name: time_entry_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.time_entry_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.time_entry_sequence OWNER TO postgres;

--
-- Name: user_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_sequence OWNER TO postgres;

--
-- Name: users_by_projects; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.users_by_projects AS
 SELECT DISTINCT u.name,
    u.surname
   FROM (public.users u
     JOIN public.tasks t ON ((u.user_id = t.user_id)))
  WHERE (t.project_id = 3);


ALTER TABLE public.users_by_projects OWNER TO postgres;

--
-- Name: users_from_office; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.users_from_office AS
 SELECT u.name,
    u.surname
   FROM public.users u
  WHERE (u.department_id IN ( SELECT d.department_id
           FROM public.departments d
          WHERE (d.office_id = 15)));


ALTER TABLE public.users_from_office OWNER TO postgres;

--
-- Name: users_projects; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.users_projects AS
 SELECT projects.project_id,
    projects.name,
    projects.description,
    projects.customer,
    projects.planned_start_date,
    projects.fact_start_date,
    projects.planned_finish_date,
    projects.fact_finish_date,
    projects.planned_cost,
    projects.fact_cost,
    projects.planned_profit,
    projects.fact_profit
   FROM public.projects
  WHERE (projects.project_id IN ( SELECT tasks.project_id
           FROM public.tasks
          WHERE (tasks.user_id = 3)));


ALTER TABLE public.users_projects OWNER TO postgres;

--
-- Name: departments departments_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departments
    ADD CONSTRAINT departments_pk PRIMARY KEY (department_id);


--
-- Name: offices offices_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.offices
    ADD CONSTRAINT offices_pk PRIMARY KEY (office_id);


--
-- Name: positions positions_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.positions
    ADD CONSTRAINT positions_pk PRIMARY KEY (pos_id);


--
-- Name: projects projects_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projects
    ADD CONSTRAINT projects_pk PRIMARY KEY (project_id);


--
-- Name: roles roles_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pk PRIMARY KEY (role_id);


--
-- Name: messages table_name_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT table_name_pk PRIMARY KEY (message_id);


--
-- Name: task_type task_type_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.task_type
    ADD CONSTRAINT task_type_pk PRIMARY KEY (task_type_id);


--
-- Name: tasks tasks_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pk PRIMARY KEY (task_id);


--
-- Name: time_entries time_entries_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.time_entries
    ADD CONSTRAINT time_entries_pk PRIMARY KEY (entry_id);


--
-- Name: users users_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pk PRIMARY KEY (user_id);


--
-- Name: departments departments_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departments
    ADD CONSTRAINT departments_fk FOREIGN KEY (office_id) REFERENCES public.offices(office_id);


--
-- Name: time_entries fkfohb8frbtyjjx7ebqujd0v9tq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.time_entries
    ADD CONSTRAINT fkfohb8frbtyjjx7ebqujd0v9tq FOREIGN KEY (task_id) REFERENCES public.tasks(task_id);


--
-- Name: messages table_name_users_user_id_fk_receiver; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT table_name_users_user_id_fk_receiver FOREIGN KEY (receiver_id) REFERENCES public.users(user_id);


--
-- Name: messages table_name_users_user_id_fk_sender; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT table_name_users_user_id_fk_sender FOREIGN KEY (sender_id) REFERENCES public.users(user_id);


--
-- Name: tasks tasks_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_fk FOREIGN KEY (project_id) REFERENCES public.projects(project_id);


--
-- Name: tasks tasks_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_fk_1 FOREIGN KEY (task_type_id) REFERENCES public.task_type(task_type_id);


--
-- Name: tasks tasks_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_fk_2 FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- Name: users users___fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users___fk_2 FOREIGN KEY (role_id) REFERENCES public.roles(role_id);


--
-- Name: users users_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_fk FOREIGN KEY (position_id) REFERENCES public.positions(pos_id);


--
-- Name: users users_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_fk_1 FOREIGN KEY (department_id) REFERENCES public.departments(department_id);


insert into public.roles values (1, 'ROLE_ADMIN');
insert into public.roles values (2, 'ROLE_USER');
insert into public.users values (1, 'admin', 'admin', 'admin', '04.01.2022', null, 'none', null, null, 'admin', '$2a$12$zjlIaRq6ckk11IxSKueIXOBno9Mr.e/j01pKUOiix8EYDqWiT0J22', 1);

--
-- PostgreSQL database dump complete
--

