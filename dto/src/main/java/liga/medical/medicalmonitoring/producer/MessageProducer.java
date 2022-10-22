package liga.medical.medicalmonitoring.producer;

import liga.medical.medicalmonitoring.message_status.MessageStatus;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;

import java.io.Serializable;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageProducer implements Serializable {
    private MessageStatus status;
    private String message;
}
