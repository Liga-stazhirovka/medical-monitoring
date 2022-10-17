package liga.medical.medicalmonitoring.core.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    public static final String HOST = "localhost";
    public static final String QUEUE_NAME = "common_monitoring";
    public static final String ALERT_QUEUE = "alert_queue";
    public static final String DAILY_QUEUE = "daily_queue";
    public static final String ERROR_QUEUE = "error_queue";
    public static final String EXCHANGE_NAME = "exchange_common_monitoring";

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(HOST);
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        rabbitTemplate.setExchange(EXCHANGE_NAME);
        return rabbitTemplate;
    }

    @Bean
    public Queue getAlertQueue() {
        return new Queue(ALERT_QUEUE);
    }

    @Bean
    public Queue getDailyQueue() {
        return new Queue(DAILY_QUEUE);
    }

    @Bean
    public Queue getErrorQueue() {
        return new Queue(ERROR_QUEUE);
    }


    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding errorBinding1() {
        return BindingBuilder.bind(getAlertQueue()).to(directExchange()).with(ALERT_QUEUE);
    }

    @Bean
    public Binding infoBinding() {
        return BindingBuilder.bind(getErrorQueue()).to(directExchange()).with(ERROR_QUEUE);
    }

    @Bean
    public Binding warningBinding() {
        return BindingBuilder.bind(getDailyQueue()).to(directExchange()).with(DAILY_QUEUE);
    }
}
