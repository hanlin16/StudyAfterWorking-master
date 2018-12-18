package com.journaldev.spring.jpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.journaldev.spring.jpa"
})
class PersistenceContext {

	//Configure the required beans here
    @Bean
  public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("1234QWERasdf");
        return  dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        entityManagerFactoryBean.setPackagesToScan("com.journaldev.spring.jpa");

        Properties jpaProperties = new Properties();

        //Configures the used database dialect. This allows Hibernate to create SQL
        //that is optimized for the used database.
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        //Specifies the action that is invoked to the database when the Hibernate
        //SessionFactory is created or closed.
        jpaProperties.put("hibernate.hbm2ddl.auto",true);

        //If the value of this property is true, Hibernate writes all SQL
        //statements to the console.
        jpaProperties.put("hibernate.show_sql",true);

        //If the value of this property is true, Hibernate will format the SQL
        //that is written to the console.
        jpaProperties.put("hibernate.format_sql",true);

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}