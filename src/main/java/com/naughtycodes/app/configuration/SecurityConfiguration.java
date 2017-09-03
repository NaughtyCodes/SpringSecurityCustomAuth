package com.naughtycodes.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.naughtycodes.app.security.SpringFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);
//		auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
//		auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
	http.addFilterAfter(new SpringFilter(), BasicAuthenticationFilter.class);
    http.authorizeRequests()
    	.antMatchers("/**").hasAuthority("ROLE_ADMIN")
	.and().authorizeRequests()
		.anyRequest().denyAll();
    
    
    
//    .and().formLogin().loginPage("/auth")
//    .usernameParameter("username")
//    .passwordParameter("password")
//    .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    
    //.httpBasic().disable();
		
//	  http.authorizeRequests()
//	  	.antMatchers("/", "/home").permitAll()
//	  	.antMatchers("/admin/**").access("hasRole('ADMIN')")
//	  	.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//	  	.and().formLogin().loginPage("/login")
//	  	.usernameParameter("ssoId").passwordParameter("password")
//	  	.and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}
}
