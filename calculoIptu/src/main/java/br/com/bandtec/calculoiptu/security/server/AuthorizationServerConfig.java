package br.com.bandtec.calculoiptu.security.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
//explicito é melhor q implicito
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private TokenStore tokenStore;

    //sproing injeta esse objetoem tempo de execucao
    @Autowired
    private AuthenticationManager authenticationManager;

    //daria pra criar o proprio authManager
    //caso quisesse criar token personalizado
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                //diz pra gerenciar somente em memoria, não hd
                .approvalStoreDisabled()
                .tokenStore(tokenStore);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                //vai criar 'banco' em memoria pra gerenciar tokens
                .inMemory()
                .withClient("loginiptu")
                .secret("senhaiptu")
                .authorizedGrantTypes("client_credentials")
                //da pra personalizar os escopos
                //ex colocar 'vidaloka'
                .scopes("read", "write")
                //colocar em minutos esse tempo
                .accessTokenValiditySeconds(1800)
                //'escopo'
                //nome da aplicação na base de segurança
                //como se fosse grupo endpoint
                //daria pra criar outros escopos com diferentes senha e client
                //trocar bandtesteapi pelo nome da minha api
                .resourceIds("calculo-iptu-api");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                //diz oq é pra contecer quando der certo
                //todos os exemplos tem essa mesma linha
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }
}
