package liga.medical.medicalmonitoring.api;

import liga.medical.medicalmonitoring.dto.Message;

public interface MessageHandler {
    void messageHandling(Message message);
}
