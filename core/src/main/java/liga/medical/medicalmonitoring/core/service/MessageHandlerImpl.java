package liga.medical.medicalmonitoring.core.service;

import liga.medical.medicalmonitoring.api.MessageHandler;
import liga.medical.medicalmonitoring.dto.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static liga.medical.medicalmonitoring.core.config.RabbitConfiguration.*;

@Component
@RequiredArgsConstructor
public class MessageHandlerImpl implements MessageHandler {
    private final RabbitTemplate template;

    @Override
    @RabbitListener(queues = QUEUE_NAME)
    public void messageHandling(Message message) {
        selectAndSend(message);
    }

    private void selectAndSend(Message message) {
        switch (message.getStatus()) {
            case DAILY: {
                template.convertAndSend(DAILY_QUEUE, message);
                System.out.printf("Message send to queue: %s \n Message: %s ", DAILY_QUEUE, message.getMessage());
            }
            break;
            case ALERT: {
                template.convertAndSend(ALERT_QUEUE, message);
                System.out.printf("Message send to queue: %s \n Message: %s ", ALERT_QUEUE, message.getMessage());
            }
            break;
            case ERROR: {
                template.convertAndSend(ERROR_QUEUE, message);
                System.out.printf("Message send to queue: %s \n Message: %s ", ERROR_QUEUE, message.getMessage());
            }
            break;
        }
    }
}
