package io.github.filiperodrigues.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class InternacionalizacaoConfig {

    @Bean
    public MessageSource messageSource(){

        //configurar fonte de menssagens do arquivo properties tem que tratar como resourse bundle
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages"); //buscar arquivo de messagens properties
        messageSource.setDefaultEncoding("ISO-8859-1");//Qual arquivo de encoding utilizado
        messageSource.setDefaultLocale(Locale.getDefault());
        return messageSource;
    }

    //metodo que faz a interpolação entra as menssagens(integração entre as mesngens)
    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
