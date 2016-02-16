package com.orange.service.mq.impl;

import com.orange.service.mq.IMqService;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/16 0016.
 */
@Service
public class MqService implements IMqService {

    /*发送消息模板，可根据实际情况更改*/
   /* @Autowired
    @Qualifier("tempTemplate")
    RabbitTemplate tempTemplate;*/

    /*发送消息到队列的方法，其中TerminalStateProtoBuf是proto格式的消息，根据实际情况更改*/
    /*
    @Override
    public void reportTerminalState(String restaurantId,TerminalStateProtoBuf.TerminalState.StateType stateType) {
        try {
            TerminalStateProtoBuf.TerminalState.Builder builder = TerminalStateProtoBuf.TerminalState.newBuilder();
            builder.setRestaurantId(restaurantId);
            builder.setState(stateType);
            tempTemplate.convertAndSend(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getCause());
        }
    }
    */
}
