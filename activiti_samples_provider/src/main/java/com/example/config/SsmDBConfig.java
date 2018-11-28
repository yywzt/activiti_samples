package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/28 11:03
 * @desc
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "ssmLocalContainerEntityManagerFactoryBean",
        transactionManagerRef = "ssmPlatformTransactionManager",
        basePackages = "com.example.repository.ssm"
)
public class SsmDBConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Bean(name = "ssmDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ssm")
    public DataSource ssmDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ssmEntityManager")
    public EntityManager ssmEntityManager(EntityManagerFactoryBuilder builder) {
        return ssmLocalContainerEntityManagerFactoryBean(builder).getObject().createEntityManager();
    }

    @Bean(name = "ssmLocalContainerEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean ssmLocalContainerEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(ssmDataSource())
                .properties(jpaProperties.getProperties())
                .packages(new String[] { "com.example.model.ssm" })
                .persistenceUnit("ssmPersistenceUnit")
                .build();
    }

    @Bean(name = "ssmPlatformTransactionManager")
    public PlatformTransactionManager ssmPlatformTransactionManager(EntityManagerFactoryBuilder builder) {

        return new JpaTransactionManager(ssmLocalContainerEntityManagerFactoryBean(builder).getObject());
    }
}