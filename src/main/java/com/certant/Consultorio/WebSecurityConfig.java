package com.certant.Consultorio;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Autowired
	public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passEncoder)
				.usersByUsernameQuery(
						"SELECT nombre_de_usuario, contrasena, deshabilitado from usuario where nombre_de_usuario=?")
				.authoritiesByUsernameQuery(
						"SELECT u.nombre_de_usuario, p.rol from perfiles p inner join usuario u on p.id=u.perfiles_id where u.nombre_de_usuario=?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/index", "/", "/css/**", "/images/**", "/js/**", "/vendor/**").permitAll()
				.antMatchers("/perfiles/").hasAuthority("Administrador").antMatchers("/perfiles/lista")
				.hasAnyAuthority("Auditor", "Administrador").antMatchers("/perfiles/lista/edit/**")
				.hasAuthority("Administrador").antMatchers("/perfiles/lista/delete/**").hasAuthority("Administrador")
				.antMatchers("/perfiles/lista/**").hasAnyAuthority("Auditor", "Administrador")

				.antMatchers("/usuarios/").hasAuthority("Administrador").antMatchers("/usuarios/lista")
				.hasAnyAuthority("Auditor", "Administrador").antMatchers("/usuarios/lista/edit/**")
				.hasAuthority("Administrador").antMatchers("/usuarios/lista/delete/**").hasAuthority("Administrador")
				.antMatchers("/usuarios/lista/**").hasAnyAuthority("Auditor", "Administrador")

				.antMatchers("/departamento/").hasAuthority("Administrador").antMatchers("/departamento/lista")
				.hasAnyAuthority("Auditor", "Administrador").antMatchers("/departamento/lista/edit/**")
				.hasAuthority("Administrador").antMatchers("/departamento/lista/delete/**")
				.hasAuthority("Administrador")

				.antMatchers("/espacios/lista").hasAnyAuthority("Auditor", "Administrador")
				.antMatchers("/espacios/crear/tradicional").hasAnyAuthority("Administrador")
				.antMatchers("/espacios/crear/laboratorio").hasAnyAuthority("Administrador")

				.antMatchers("/nota-pedido/").hasAnyAuthority("Auditor", "Administrador")
				.antMatchers("/nota-pedido/manage").hasAnyAuthority("Administrador")
				.antMatchers(HttpMethod.POST, "/api/nota-pedido/").hasAnyAuthority("Auditor", "Administrador")
				.antMatchers("/api/nota-pedido/accept/**").hasAnyAuthority("Administrador")
				.antMatchers("/api/nota-pedido/reject/**").hasAnyAuthority("Administrador").antMatchers("/api/**")
				.hasAnyAuthority("Auditor", "Administrador")

				.anyRequest().authenticated().and().formLogin().permitAll().and().logout().permitAll();
	}

}
