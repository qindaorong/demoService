package com.qindaorong.demo.core.framework.configuration;


import com.qindaorong.demo.core.framework.components.DemoAuthenticationEntryPoint;
import com.qindaorong.demo.core.framework.components.DemoLogoutSuccessHandler;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
public class OAuth2ServerConfiguration {
    
    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        
        @Autowired
        private DemoAuthenticationEntryPoint demoAuthenticationEntryPoint;
        
        @Autowired
        private DemoLogoutSuccessHandler demoLogoutSuccessHandler;
        
        @Override
        public void configure(HttpSecurity http) throws Exception {
            
            http
              .exceptionHandling()
              .authenticationEntryPoint(demoAuthenticationEntryPoint)
              .and()
              .logout()
              .logoutUrl("/oauth/logout")
              .logoutSuccessHandler(demoLogoutSuccessHandler)
              .and()
              .authorizeRequests()
              .antMatchers("/api/city/*").permitAll()
              .antMatchers("/secure/**").authenticated();
            
        }
        
    }
    
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter implements EnvironmentAware {
        
        private static final String ENV_OAUTH = "authentication.oauth.";
        private static final String PROP_CLIENTID = "clientid";
        private static final String PROP_SECRET = "secret";
        private static final String PROP_TOKEN_VALIDITY_SECONDS = "tokenValidityInSeconds";
        
        private RelaxedPropertyResolver propertyResolver;
        
        @Inject
        private DataSource dataSource;
        
        @Bean
        public TokenStore tokenStore() {
            return new JdbcTokenStore(dataSource);
        }
        
        @Inject
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;
        
        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints)
          throws Exception {
            endpoints
              .tokenStore(tokenStore())
              .authenticationManager(authenticationManager)
              .pathMapping("/oauth/token", "/oauth/*");;
        }
        
        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients
              .jdbc(dataSource);
        }
        
        @Override
        public void setEnvironment(Environment environment) {
            this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_OAUTH);
        }
        
    }
}
