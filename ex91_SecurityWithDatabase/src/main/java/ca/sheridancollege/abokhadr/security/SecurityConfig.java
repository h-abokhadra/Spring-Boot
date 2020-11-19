package ca.sheridancollege.abokhadr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ca.sheridancollege.abokhadr.services.UserDetailsServiceImpl;

@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService)
	.passwordEncoder(passwordEncoder());
	}
	
	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Never do this in a production system (csrf, permit-all)
	http.csrf().disable();
	http.headers().frameOptions().disable();
	http.authorizeRequests()
	.antMatchers("/secure/**").hasRole("USER")
	.antMatchers("/", "/js/**", "/css/**", "/images/**", "/**").permitAll()
	// Never do this in a production system (csrf, permit-all)
	.antMatchers("/h2-console/**").permitAll()
	.anyRequest().authenticated()
	.and().formLogin()
	.loginPage("/login").permitAll()
	.and().logout()
	.invalidateHttpSession(true)
	.clearAuthentication(true)
	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	.logoutSuccessUrl("/login?logout").permitAll()
	.and().exceptionHandling()
	.accessDeniedHandler(accessDeniedHandler);
}
	
	
}
