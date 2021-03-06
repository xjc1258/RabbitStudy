package com.xuejc.bootrabbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xjc
 * 自动配置I
 * 1、RabbitAutoConfiguration
 * 2、有自动配置了连接工厂ConnectionFactory；
 * 3、RabbitProperties 封装了RabbitMQ的配置;
 * 4、RabbitTemplate;给RabbitMQ发送和接收消息
 * <p>
 * 5、AmqpAdmin  RabbitMQ系统管理功能组件
 * AmqpAdmin : 创建和删除 Queue,Exchange，Binding    创建和删除队列,绑定规则
 * <p>
 * 6、@EnableRabbit  + @RabbitListener  监听消息队列的内容
 */
@EnableRabbit
@SpringBootApplication
public class BootrabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootrabbitApplication.class, args);
    }

}
