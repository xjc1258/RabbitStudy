package com.xuejc.bootrabbit.Sender;

import com.xuejc.bootrabbit.config.RabbitMqConfig;
import com.xuejc.bootrabbit.entiy.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Component
public class FirstSender {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     *
     * @param uuid
     * @param message 消息
     */
    public void send(String uuid, Object message) {
        // CorrelationData correlationId = new CorrelationData(uuid);
   /*     String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = new Date().toString();
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);*/

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1);
        userInfo.setUserName("pan_junbiao的博客");
        userInfo.setBlogUrl("https://blog.csdn.net/pan_junbiao");
        userInfo.setBlogRemark("您好，欢迎访问 pan_junbiao的博客");

        logger.info(userInfo.toString());
        //配置交换机，队列key3，消息
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTINGKEY3, message);
    }


}
