package com.uema.poo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//Classe de configuração do SpringSecurity

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//Injeção da classe UserDetailsServiceImpl
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	 //Método que faz a criptografia de senhas
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}
	
	
	
	//método de configuração, aqui é definido como o spring security vai funcionar no sistema
	//Definido a parte de autorização do user, quais caminhos cada Role irá acessar
	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http
 		.cors().and().csrf().disable()
 		.authorizeRequests().antMatchers("/").permitAll()
 		.antMatchers("/area-de-cadastro").permitAll()
 		//Apenas os user com a Role "EDITOR" vai conseguir acessar 'adicionar-noticia'
 		.antMatchers("/adicionar-noticia").hasRole("EDITOR")
 		.and()
 		.formLogin()
 		.loginPage("/login")
 		.failureUrl("/login-error")
 		.and()
 		.logout();
 	}
	
	
	//Método que define quais dados serão utilizados para fazer a autenticação do spring security
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
		//Defino que os dados utilizados serão do objeto userDetailsService do tipo UserDetailsServiceImpl
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}
	
	
	
	
	

}
