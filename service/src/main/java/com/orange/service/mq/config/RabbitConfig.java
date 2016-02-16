package com.orange.service.mq.config;


import com.orange.service.mq.handler.TempHandler;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/16 0016.
 */
@Configuration
@EnableRabbit
public class RabbitConfig {
/*
    @Value("${exchange.name}")
    private String exchangeName;
    @Value("${topic.exchange.name}")
    private String topicExchangeName;

    //*队列名称,请根据实际情况更改*//*
    @Value("${qu.terminal.manage}")
    private String tempQuequeName;

    //*路由关键字,请根据实际情况更改*//*
    @Value("${rk.terminal.state}")
    private String tempRoutingkey;

    @Autowired
    private ConnectionFactory rabbitConnectionFactory;

    //*消息格式转换器，可根据实际情况更改*//*
    @Autowired
    @Qualifier("tempSendConverter")
    private MessageConverter tempSendConverter;

    //*消息格式转换器，可根据实际情况更改*//*
    @Autowired
    @Qualifier("tempReceiveConverter")
    private MessageConverter tempReceiveConverter;

    //*消息处理器，可根据实际情况更改*//*
    @Autowired
    private TempHandler tempHandler;


    @Bean
    public DirectExchange intelliboxExchange() {
        return new DirectExchange(exchangeName, true, false);
    }

    @Bean
    public TopicExchange intelliboxTopicExchange() {
        return new TopicExchange(topicExchangeName, true, false);
    }

    //*发送模板，可根据实际情况更改*//*
    @Bean(name = "tempTemplate")
    public RabbitTemplate tempTemplate() {
        RabbitTemplate r = new RabbitTemplate(rabbitConnectionFactory);
        r.setExchange(topicExchangeName);
        r.setRoutingKey(tempRoutingkey);
        r.setConnectionFactory(rabbitConnectionFactory);
        r.setMessageConverter(tempSendConverter);
        return r;
    }

    @Bean
    public MessageListenerAdapter tempListenerAdapter() {
        MessageListenerAdapter terminalManageListenerAdapter =
                new MessageListenerAdapter(tempHandler);
        terminalManageListenerAdapter.setMessageConverter(tempReceiveConverter);
        terminalManageListenerAdapter.setDefaultListenerMethod("handleMessage");
        return terminalManageListenerAdapter;
    }

    @Bean
    public SimpleMessageListenerContainer terminalManageListenerContainer() {
        SimpleMessageListenerContainer listenerContainer =
                new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(rabbitConnectionFactory);
        listenerContainer.setQueueNames(tempQuequeName);
        listenerContainer.setConcurrentConsumers(10);
        listenerContainer.setMessageListener(tempListenerAdapter());
        listenerContainer.setAutoStartup(true);
        return listenerContainer;
    }

    */

}
