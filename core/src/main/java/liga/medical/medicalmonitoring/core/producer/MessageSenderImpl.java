package liga.medical.medicalmonitoring.core.producer;

import liga.medical.medicalmonitoring.api.MessageSender;
import liga.medical.medicalmonitoring.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static liga.medical.medicalmonitoring.core.config.RabbitConfiguration.DAILY_QUEUE;
import static liga.medical.medicalmonitoring.core.config.RabbitConfiguration.ALERT_QUEUE;
import static liga.medical.medicalmonitoring.core.config.RabbitConfiguration.ERROR_QUEUE;

@Component
@RequiredArgsConstructor
public class MessageSenderImpl implements MessageSender {
    private final RabbitTemplate template;

    @Override
    public void sendToDailyQueue(MessageProducer messageProducer) {
        template.convertAndSend(DAILY_QUEUE, messageProducer);
        System.out.printf("Message send to queue: %s \nMessage: %s\n",
                DAILY_QUEUE, messageProducer.getMessage());
    }

    @Override
    public void sendToAlertQueue(MessageProducer messageProducer) {
        template.convertAndSend(ALERT_QUEUE, messageProducer);
        System.out.printf("Message send to queue: %s \nMessage: %s\n", ALERT_QUEUE,
                messageProducer.getMessage());
    }

    @Override
    public void sendToErrorQueue(MessageProducer messageProducer) {
        template.convertAndSend(ERROR_QUEUE, messageProducer);
        System.out.printf("Message send to queue: %s \nMessage: %s\n", ERROR_QUEUE,
                messageProducer.getMessage());
    }
}
