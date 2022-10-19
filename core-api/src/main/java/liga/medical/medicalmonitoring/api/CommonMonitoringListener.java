package liga.medical.medicalmonitoring.api;

import liga.medical.medicalmonitoring.consumer.MessageConsumer;

public interface CommonMonitoringListener {
    void listenCommonMonitoring(MessageConsumer messageConsumer);
}
