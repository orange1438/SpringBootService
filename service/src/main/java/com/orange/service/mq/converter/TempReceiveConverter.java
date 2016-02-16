package com.orange.service.mq.converter;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.stereotype.Component;
/*Proto格式消息，请根据实际情况更改*/
//import com.suweia.protobuf.TerminalStateProtoBuf;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/16 0016.
 * 目前我想不到哪儿用，暂时写上
 */
@Component("tempReceiveConverter")
public class TempReceiveConverter extends AbstractMessageConverter  {
    @Override
    protected Message createMessage(Object o, MessageProperties messageProperties) {
        /*请根据实际情况，更改*/
        /*
        TerminalStateProtoBuf.TerminalState terminalState = (TerminalStateProtoBuf.TerminalState) o;
        byte[] byteArray = terminalState.toByteArray();
        */
        byte[] byteArray = new byte[]{};//更改代码后，请删除这行
        return new Message(byteArray, messageProperties);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        /*请根据实际情况，更改*/
        /*
        TerminalStateProtoBuf.TerminalState terminalState =  null;
        try {
            terminalState = TerminalStateProtoBuf.TerminalState.parseFrom(message.getBody());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
        return terminalState;
        */
        return null; //更改代码后，请删除这行
    }
}
