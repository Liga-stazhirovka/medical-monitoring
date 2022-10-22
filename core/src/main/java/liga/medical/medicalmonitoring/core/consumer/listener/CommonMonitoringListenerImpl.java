package liga.medical.medicalmonitoring.core.consumer.listener;

import liga.medical.medicalmonitoring.api.CommonMonitoringListener;
import liga.medical.medicalmonitoring.api.MessageService;
import liga.medical.medicalmonitoring.consumer.MessageConsumer;
import liga.medical.medicalmonitoring.utils.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static liga.medical.medicalmonitoring.core.config.RabbitConfiguration.QUEUE_NAME;

@Component
@RequiredArgsConstructor
public class CommonMonitoringListenerImpl implements CommonMonitoringListener {
    private final MessageService messageService;
    private final MessageMapper mapper;

    @Override
    @RabbitListener(queues = QUEUE_NAME)
    public void listenCommonMonitoring(MessageConsumer messageConsumer) {
        messageService.routing(mapper.toDto(messageConsumer));
    }
}
