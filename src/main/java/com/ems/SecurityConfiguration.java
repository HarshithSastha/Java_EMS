package com.ems;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username, password, enabled from user where username=?")
			.authoritiesByUsernameQuery("select username, user_role from user where username=?");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * "ROLE_USER", "ROLE_ADMIN", "user", "test" are roles defined for User model
		 * Modified User model From firstname and last name variable to username
		 * and added new variable enable in User model
		 */
		
		
		http.authorizeRequests()
		.antMatchers("/").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN", "user", "test")
        .antMatchers("/list").hasAuthority("test")
        .anyRequest().fullyAuthenticated();
		http.httpBasic();
		
		
		
		/*
		 * http.authorizeHttpRequests(). antMatchers("/health").hasRole("ADMIN").
		 * antMatchers("/list").hasRole("ADMIN").
		 * antMatchers("/empoyees").hasAnyRole("USER","ADMIN").and().formLogin();
		 */
		
//		http.authorizeRequests()
//		.antMatchers("/list").hasRole("user")
//        .anyRequest()
//        .authenticated()
//        .and()
//        .formLogin();
//		
		
//		http.authorizeRequests()
//		.antMatchers("list").hasAuthority("test")
//		.anyRequest().authenticated().and().formLogin();
		
//		http
//		.authorizeRequests()
//		.antMatchers("/").permitAll()
//		.antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN")
//		.antMatchers("/addNewEmployee").hasAnyRole("ADMIN")
//		.anyRequest().authenticated().and().httpBasic();
		

	}
}
