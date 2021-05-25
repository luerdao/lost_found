package com.luerdao.config;
import com.luerdao.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .formLogin().loginPage("/tologin").loginProcessingUrl("/loginProcess").permitAll().successForwardUrl("/")
                .and()
                .authorizeRequests().antMatchers("/pc/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/common/**").hasRole("USER")
                .antMatchers("/super/**").hasRole("S_ADMIN")
                .anyRequest().authenticated()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }
        @Bean
    public UserDetailsServiceImpl userDetailsService(){
        return new UserDetailsServiceImpl();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }
    @Bean
    NoOpPasswordEncoder noOpPasswordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
