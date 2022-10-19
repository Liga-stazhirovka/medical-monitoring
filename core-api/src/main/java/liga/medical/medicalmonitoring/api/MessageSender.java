package liga.medical.medicalmonitoring.api;

import liga.medical.medicalmonitoring.producer.MessageProducer;

public interface MessageSender {
    void sendToDailyQueue(MessageProducer messageProducer);

    void sendToAlertQueue(MessageProducer messageProducer);

    void sendToErrorQueue(MessageProducer messageProducer);
}
