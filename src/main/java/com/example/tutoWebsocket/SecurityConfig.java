package com.example.tutoWebsocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("root").password("root").roles("admin").and().withUser("root2")
				.password("root").roles("admin");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin()
		.loginPage("/login.html")
		.loginProcessingUrl("/login")
		.and()
		.authorizeRequests()
		.antMatchers("/login.html","index.html")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.csrf().disable();
		
//		http.authorizeRequests()
//		 .antMatchers("/login.html").permitAll()
//		.anyRequest().authenticated()
//		.and().formLogin().
//		loginPage("/hello")
//        .loginProcessingUrl("/login")
////        .failureUrl("/login?error")
////        .defaultSuccessUrl("/success")
//        .permitAll();
		
//		
//        .loginPage("/hello")
//        //指定自定义form表单请求的路径
//        .loginProcessingUrl("/authentication/form")
//        .failureUrl("/login?error")
//        .defaultSuccessUrl("/success")
//        //必须允许所有用户访问我们的登录页（例如未验证的用户，否则验证流程就会进入死循环）
//        //这个formLogin().permitAll()方法允许所有用户基于表单登录访问/login这个page。
//        .permitAll();
//        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
//        http .csrf().disable();
	}

}