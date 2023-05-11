package dev.riv.REST_TurboBasic.utilities;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;


@Configuration
//@EnableWebSecurity
public class SpringConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public HashGenerator hashGenerator() {
        return new HashGenerator();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/v1/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().disable()
//                .httpBasic().disable()
//                .build();
//    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User
//                .withUsername("rivanman")
//                .password(passwordEncoder().encode("password"))
//                .roles("owner")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(8);
//    }


}
