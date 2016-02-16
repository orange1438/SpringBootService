package com.orange.service.mq.handler;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/16 0016.
 */
@Component("tempHandler")
public class TempHandler {

    private Logger logger = Logger.getLogger(TempHandler.class);

    /*接收消息处理的方法，请根据实际情况更改*/
    /*
    public void handleMessage(TerminalManageProtoBuf.TerminalManage message) {
        logger.info("message->"+message);
        switch (message.getType()) {
            case TERMINAL_STATE: {
                String terminalId = message.getTerminalId();
                String state = message.getTerminalState();
                int status=0;
                try {
                    status=Integer.parseInt(state);
                }catch (NumberFormatException ex){
                    logger.warn("状态不是数字");
                    break;
                }
                terminalOnlineChange.setStatus(terminalId,status);
                break;
            }
            case RESET_STATE:{
                terminalOnlineChange.resetStatus();
                break;
            }

        }
    }
    */
    public void handleMessage(Object message) {}//根据实际情况修改代码后，删除这行
}
