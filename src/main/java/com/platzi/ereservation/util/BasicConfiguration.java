package com.platzi.ereservation.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.platzi.ereservation.util.Consts.*;

/**
 * Class to handle security.
 */
@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Peticiones autenticadas con un formulario de login con un método de autenticación básico.
     * @param httpSecurity
     * @throws Exception
     */
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin().loginPage(URL_APP + URL_LOGIN).permitAll()
            .failureUrl(URL_APP + URL_LOGIN + "?error=true")
            .defaultSuccessUrl(URL_APP + URL_HOME);

        httpSecurity.csrf().disable();  // Habilitar ejecuciones en el Swagger para almacenamiento en la BD.
    }

    /**
     * Configurar el método de autenticación, por lo cuál se utiliza un método en memoria.
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication().withUser(USERNAME).password(encoder.encode(PASSWORD)).roles(ROLES);
    }

    /**
     * Se configura qué rutas de la aplicación se deben excluir en el proceso de login (recursos estáticos).
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
