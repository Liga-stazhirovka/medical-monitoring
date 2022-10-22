package liga.medical.medicalmonitoring.utils;

import liga.medical.medicalmonitoring.consumer.MessageConsumer;
import liga.medical.medicalmonitoring.dto.MessageDto;
import liga.medical.medicalmonitoring.producer.MessageProducer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface MessageMapper {
    MessageDto toDto(MessageConsumer messageConsumer);

    MessageProducer toProducer(MessageDto messageDto);
}
