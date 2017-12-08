package ru.library.config.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.library.dao.daoimpl.UsersDaoImp;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@ComponentScan
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    private static final Logger logger = Logger.getLogger(WebSecurityConfig.class);

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        logger.info(dataSource.toString());
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(UsersDaoImp.SQL_FIND_USERS_BY_LOGIN)
                .authoritiesByUsernameQuery(UsersDaoImp.SQL_FIND_USER_AND_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        //как правильно выполнять разлогинивание
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}