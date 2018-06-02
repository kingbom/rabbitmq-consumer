package com.kingbom.rabbitmq.consumer.service;

import com.kingbom.rabbitmq.consumer.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by bombay on 2/6/2018 AD.
 */
@Component
public class TransactionConsumer {

    private final Logger log = LoggerFactory.getLogger(TransactionConsumer.class);

    @RabbitListener(queues="${kingbom.rabbitmq.queue}", containerFactory="jsaFactory")
    public void recievedMessage(Transaction transaction) {
        log.info("Recieved transaction id : {} member id : {} ", transaction.getId(), transaction.getMemberId());
    }
}
