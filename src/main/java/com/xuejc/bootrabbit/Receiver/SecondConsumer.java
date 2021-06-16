package com.xuejc.bootrabbit.Receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SecondConsumer {
    /**
     * 这里监听了两个queues，只要其中一个有消息就会消费
     */
    @RabbitListener(queues = {"first-queue", "second-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(String message) throws Exception {
        // 处理消息
        System.out.println("FirstConsumer {} handleMessage :" + message);
    }


}
