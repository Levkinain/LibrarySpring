package ru.library.config.dao;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
@ComponentScan (basePackages = {"ru.library.dao" , "ru.library.service"})
public class ServiceConfig {
    private static final Logger logger = Logger.getLogger(ServiceConfig.class);

    @Bean(name = "DataSource")
    public DataSource getDataSource() {
        logger.debug("Getting data source");
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .setName("test")
                .build();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);

        return transactionManager;
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) throws NamingException {

        logger.debug("Configuring Liquibase");
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(getDataSource());
        liquibase.setChangeLog("classpath:/changelog/changelog-master.xml");
        return liquibase;
    }
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return  new JdbcTemplate(getDataSource());
    }
}
