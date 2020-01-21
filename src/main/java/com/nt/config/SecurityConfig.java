package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends  WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource ds;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
           auth.jdbcAuthentication().dataSource(ds).usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?").authoritiesByUsernameQuery("SELECT ROLEID,ROLE,UNAME FROM USER_ROLES WHERE UNAME=?");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home.htm").access("permitAll").antMatchers("/running.htm").access("hasAnyRole('ROLE_PASSENGER','ROLE_ADMIN')").and().formLogin().and().logout().logoutSuccessUrl("/home.htm").and().exceptionHandling().accessDeniedPage("/access_denied.jsp").and().rememberMe().and().sessionManagement().invalidSessionUrl("/timeout.jsp").maximumSessions(2).expiredUrl("/timeout.jsp");

	}

}
