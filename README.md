# BACKEND IS
Backend part of IS_EXAMPLE project. The project is an example of system for employees communication and work organization. This system allows to read and write messages, watch company's departments and offices, search info about employees, close tasks and etc.
**Frontend part (client's interface):** https://github.com/gigagibi/IS_example_frontend
## Tech stack
- Java
- Spring Boot
- JPA
- PostgreSQL
- JWT (io.jsonwebtoken.jjwt)

**Additional**
- Lombok
- Swagger UI

**IDE**
- Intelij IDEA
## Run JAR file
Write the following in command line from project's root directory:
```bash
java -DSPRING_DATASOURCE_URL="url" -DSPRING_DATASOURCE_USERNAME="username" -DSPRING_DATASOURCE_PASSWORD="password" -jar src/main/docker/is_backend/IS-0.0.1-SNAPSHOT.jar
```

## Run with docker-compose
In src/main/docker directory:
```bash
docker-compose up
```
## Default admin user
Login: ```admin```
Password: ```admin```

Bearer token for swagger: "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY0MjU1MDQwMH0.URRA6imfDdHJDVx_sOSZUTPZSPIIG_6j03zEGTXp92U4BfSVl8DXyhczHV3CwNr0HVpvnKwooWg_hF9X7LU3aA" (paste with "Bearer " word)

## Database Scheme
![Физ схема](https://user-images.githubusercontent.com/70891118/147501487-4e89bfed-db27-4cd9-9c09-1498a794652b.png)

## API
Swagger UI is available at the url: http://localhost:88/swagger-ui/
![image](https://user-images.githubusercontent.com/70891118/147486932-ae4da2c2-2813-4b8f-929e-94b9bb58eba7.png)
![image](https://user-images.githubusercontent.com/70891118/147486937-33fda1b8-0d70-4fb3-9846-c156bf61a56c.png)
![image](https://user-images.githubusercontent.com/70891118/147486942-ac0b8149-e402-4acb-ba76-1c7bfe90e267.png)
![image](https://user-images.githubusercontent.com/70891118/147486949-a7af3bc6-ae90-4b09-bc39-46b90f9620bc.png)
![image](https://user-images.githubusercontent.com/70891118/147486957-bdae3631-256b-4710-a40e-e91f74ffc778.png)
![image](https://user-images.githubusercontent.com/70891118/147486963-a1079c84-9afc-49ed-ba04-ff01b7953ddc.png)
![image](https://user-images.githubusercontent.com/70891118/147486970-e1fdfc03-f6d7-4e5e-afed-74ab4bc75642.png)
![image](https://user-images.githubusercontent.com/70891118/147486975-f883e942-e8a4-4ed2-a7f5-79a4ab6589cc.png)
![image](https://user-images.githubusercontent.com/70891118/147486978-c9f7f3f2-da75-468f-a2f2-2e7cfbd29521.png)
![image](https://user-images.githubusercontent.com/70891118/147486987-f666c6ac-ff0c-40ac-970f-2c195d33b4ca.png)
