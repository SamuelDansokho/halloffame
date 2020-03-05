package com.personal.halloffame.config

import com.personal.halloffame.service.UserService
import com.personal.halloffame.utils.AuthProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    var userDetailsService: UserDetailsService? = null

    @Autowired
    private val accessDeniedHandler: AccessDeniedHandler? = null


    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(object : Http403ForbiddenEntryPoint() {})
                .and()
                .authenticationProvider(getProvider())
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler(AuthentificationLoginSuccessHandler())
                .failureHandler(SimpleUrlAuthenticationFailureHandler())
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(AuthentificationLogoutSuccessHandler())
                .invalidateHttpSession(true)
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/user").authenticated()
                .anyRequest().permitAll()
    }

    private class AuthentificationLoginSuccessHandler : SimpleUrlAuthenticationSuccessHandler() {
        @Throws(IOException::class, ServletException::class)
        override fun onAuthenticationSuccess(request: HttpServletRequest?,
                                             response: HttpServletResponse, authentication: Authentication?) {
            response.status = HttpServletResponse.SC_OK
        }
    }

    private class AuthentificationLogoutSuccessHandler : SimpleUrlLogoutSuccessHandler() {
        @Throws(IOException::class, ServletException::class)
        override fun onLogoutSuccess(request: HttpServletRequest?, response: HttpServletResponse,
                                     authentication: Authentication?) {
            response.status = HttpServletResponse.SC_OK
        }
    }

    @Bean
    fun getProvider(): AuthenticationProvider? {
        val provider = AuthProvider()
        provider.setUserDetailsService(userDetailsService)
        return provider
    }

}