package com.example.IS.configs;

import com.example.IS.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.IS.repositories")
@Import({SecurityConfig.class, SwaggerConfiguration.class})
public class ISConfiguration implements WebMvcConfigurer{
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.username}")
    private String username;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .allowedHeaders("*")
                .allowedOrigins("http://localhost:3000");
    }

    @Bean
    public DataSource dataSource() throws IOException {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName("org.postgresql.Driver");
        builder.url(url);
        builder.username(username);
        builder.password(password);
        return builder.build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws IOException {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.example.IS.models");
        factory.setDataSource(dataSource());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
