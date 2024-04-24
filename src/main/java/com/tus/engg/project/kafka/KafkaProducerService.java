//package com.tus.engg.project.kafka;
//
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.clients.producer.RecordMetadata;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.Properties;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;
//
//@Service
//public class KafkaProducerService {
//
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public KafkaProducerService(@Value("${kafka.bootstrap-servers}") String bootstrapServers) {
//        Properties properties = new Properties();
//        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        
//        this.kafkaTemplate = new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(properties));
//    }
//
//    public void produce(String topic, String message) throws ExecutionException, InterruptedException {
//        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
//        final Future<RecordMetadata> send = this.kafkaTemplate.send(record);
//        final RecordMetadata recordMetadata = send.get();
//        System.out.println(recordMetadata);
//    }
//}
