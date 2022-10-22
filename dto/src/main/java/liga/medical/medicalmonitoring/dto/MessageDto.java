package liga.medical.medicalmonitoring.dto;

import liga.medical.medicalmonitoring.message_status.MessageStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageDto {
    private MessageStatus status;
    private String message;
}
