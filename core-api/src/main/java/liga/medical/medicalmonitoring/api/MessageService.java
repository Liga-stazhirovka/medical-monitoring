package liga.medical.medicalmonitoring.api;

import liga.medical.medicalmonitoring.dto.MessageDto;

public interface MessageService {
    void routing(MessageDto message);
}
