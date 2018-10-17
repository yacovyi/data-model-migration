package com.ws.ng;

import com.ws.ng.configuration.Config;
import com.ws.ng.providers.KafkaProducerCreator;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

/**
 * This is the class that does the logic, similar to Engine in WS.
 * It is different from the handler in being initialized as a Singleton by HK2.
 * The handler on the other hand is instantiated for every request.
 */
public class StatusService {
    static final Logger logger = LogManager.getLogger(StatusService.class.getName());

    private final Config config;

    private final KafkaProducer<String, String> producer;

    @Inject
    public StatusService(Config config, KafkaProducerCreator producerCreator) {
        this.config = config;
        this.producer = producerCreator.createProducer();
    }

    public void produceMessageTokafka(String message) {
        String body = "test";
        producer.send(new ProducerRecord<>(body,message));
        logger.trace(String.format("Message with body: %s was produced", body));
    }


}
