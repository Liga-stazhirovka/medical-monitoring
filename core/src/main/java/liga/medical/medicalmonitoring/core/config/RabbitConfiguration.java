package liga.medical.medicalmonitoring.core.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Value("${spring.rabbitmq.username}")
    private String userName;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.alert_queue}")
    private String alertQueue;

    @Value("${spring.rabbitmq.daily_queue}")
    private String dailyQueue;

    @Value("${spring.rabbitmq.error_queue}")
    private String errorQueue;

    @Value("${spring.rabbitmq.routingkey_alert}")
    private String routingKeyAlert;

    @Value("${spring.rabbitmq.routingkey_daily}")
    private String routingKeyDaily;

    @Value("${spring.rabbitmq.routingkey_error}")
    private String routingKeyError;

    @Bean
    CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
        cachingConnectionFactory.setUsername(userName);
        cachingConnectionFactory.setPassword(password);
        return cachingConnectionFactory;
    }

    @Bean
    AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate() {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        rabbitTemplate.setExchange(exchange);
        return rabbitTemplate;
    }

    @Bean
    Queue getAlertQueue() {
        return new Queue(alertQueue);
    }

    @Bean
    Queue getDailyQueue() {
        return new Queue(dailyQueue);
    }

    @Bean
    Queue getErrorQueue() {
        return new Queue(errorQueue);
    }

    @Bean
    DirectExchange myExchange() {
        return ExchangeBuilder.directExchange(exchange).build();
    }

    @Bean
    Binding alertBinding() {
        return BindingBuilder.bind(getAlertQueue()).to(myExchange()).with(routingKeyAlert);
    }

    @Bean
    Binding dailyBinding() {
        return BindingBuilder.bind(getDailyQueue()).to(myExchange()).with(routingKeyDaily);
    }

    @Bean
    Binding errorBinding() {
        return BindingBuilder.bind(getErrorQueue()).to(myExchange()).with(routingKeyError);
    }
}
