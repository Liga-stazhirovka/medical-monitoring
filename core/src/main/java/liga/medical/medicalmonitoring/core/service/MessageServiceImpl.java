package liga.medical.medicalmonitoring.core.service;

import liga.medical.medicalmonitoring.api.MessageSender;
import liga.medical.medicalmonitoring.api.MessageService;
import liga.medical.medicalmonitoring.dto.MessageDto;
import liga.medical.medicalmonitoring.message_status.MessageStatus;
import liga.medical.medicalmonitoring.utils.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageSender producer;
    private final MessageMapper mapper;

    @Override
    public void routing(MessageDto message) {
        MessageStatus status = message.getStatus();
        switch (status) {
            case ALERT:
                producer.sendToAlertQueue(mapper.toProducer(message));
                break;
            case DAILY:
                producer.sendToDailyQueue(mapper.toProducer(message));
                break;
            case ERROR:
                producer.sendToErrorQueue(mapper.toProducer(message));
            default:
                System.out.println("Status: '" + status + "' not found!");
        }
    }
}
