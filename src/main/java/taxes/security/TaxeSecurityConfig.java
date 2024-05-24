package taxes.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class TaxeSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        /* Pour fixer les utilisateurs */

        auth.inMemoryAuthentication().withUser( "cheikh" ).password(
                "{noop}cheikh" ).roles( "ADMIN", "USER" );
        auth.inMemoryAuthentication().withUser( "user" ).password(
                "{noop}user" ).roles( "USER" );

        /* Recuperation des utilisateurs dans une BD */
        /*
         * auth.jdbcAuthentication().dataSource( dataSource )
         * .usersByUsernameQuery(
         * "select username as principal,password as credentials from users where username = ?"
         * ) .authoritiesByUsernameQuery(
         * "select username as principal , role from users_roles where username = ?"
         * ) .rolePrefix( "ROLE_" ) .passwordEncoder( new Md4PasswordEncoder()
         * );
         */
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http.formLogin().loginPage( "/login" );
        // http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests().antMatchers( "/addEntreprise", "/addTaxe", "/formEntreprise" ).hasRole( "ADMIN" );
        http.authorizeRequests().antMatchers( "/entreprises", "/taxes", "/listTaxes" ).hasRole( "USER" );
        http.exceptionHandling().accessDeniedPage( "/403" );
    }
}
