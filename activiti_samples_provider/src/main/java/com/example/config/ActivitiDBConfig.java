package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * @date 2018/11/28 10:56
 * @desc activiti数据源配置
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "activitiLocalContainerEntityManagerFactoryBean",
        transactionManagerRef = "activitiPlatformTransactionManager",
        basePackages = "com.example.repository.activiti"
)
public class ActivitiDBConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Primary
    @Bean(name = "activitiDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.activiti")
    public DataSource activitiDataSource() {

        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "activitiEntityManager")
    public EntityManager activitiEntityManager(EntityManagerFactoryBuilder builder) {
        return activitiLocalContainerEntityManagerFactoryBean(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "activitiLocalContainerEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean activitiLocalContainerEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(activitiDataSource())
                .properties(jpaProperties.getProperties())
                .packages(new String[] { "com.example.model.activiti" })
                .persistenceUnit("activitiPersistenceUnit")
                .build();
    }

    @Primary
    @Bean(name = "activitiPlatformTransactionManager")
    public PlatformTransactionManager activitiPlatformTransactionManager(EntityManagerFactoryBuilder builder) {

        return new JpaTransactionManager(activitiLocalContainerEntityManagerFactoryBean(builder).getObject());
    }
}

