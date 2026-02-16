package com.pm.patientservice.kafka;

import com.pm.patientservice.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = {"patient"})
@ActiveProfiles("test")
public class KafkaProducerTest {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
    public void testSendEvent() {
        Patient patient = new Patient();
        patient.setId(UUID.randomUUID());
        patient.setName("John Doe");
        patient.setEmail("john.doe@example.com");

        kafkaProducer.sendEvent(patient);
        // If no exception is thrown, the autowiring and basic execution worked.
    }
}
