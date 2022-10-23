package liga.medical.medicalmonitoring.core.producer;

import liga.medical.medicalmonitoring.api.MessageSender;
import liga.medical.medicalmonitoring.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageSenderImpl implements MessageSender {
    @Value("${spring.rabbitmq.alert_queue}")
    private String alertQueue;

    @Value("${spring.rabbitmq.daily_queue}")
    private String dailyQueue;

    @Value("${spring.rabbitmq.error_queue}")
    private String errorQueue;

    private final RabbitTemplate template;

    @Override
    public void sendToAlertQueue(MessageProducer messageProducer) {
        template.convertAndSend(alertQueue, messageProducer);
        System.out.printf("Message send to queue: %s \nMessage: %s\n", alertQueue,
                messageProducer.getMessage());
    }

    @Override
    public void sendToDailyQueue(MessageProducer messageProducer) {
        template.convertAndSend(dailyQueue, messageProducer);
        System.out.printf("Message send to queue: %s \nMessage: %s\n",
                dailyQueue, messageProducer.getMessage());
    }

    @Override
    public void sendToErrorQueue(MessageProducer messageProducer) {
        template.convertAndSend(errorQueue, messageProducer);
        System.out.printf("Message send to queue: %s \nMessage: %s\n", errorQueue,
                messageProducer.getMessage());
    }
}
