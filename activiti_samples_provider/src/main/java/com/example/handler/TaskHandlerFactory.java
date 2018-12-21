package com.example.handler;

import com.example.SpringUtils;
import com.example.constant.ProcessOperator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanzt
 * @date 2018/12/20 10:07
 * @describe
 */
@Component("taskHandlerFactory")
public class TaskHandlerFactory {

    private static Map<String, String> handlers = new HashMap<String, String>();

    static {
        handlers.put(ProcessOperator.AGREE.getValue(), "completeTaskHandler");
        handlers.put(ProcessOperator.DISAGREE.getValue(), "endProcessTaskHandler");
        handlers.put(ProcessOperator.REJECT_BACK.getValue(), "prevProcessTaskHandler");
        handlers.put(ProcessOperator.REJECT_FIRST.getValue(), "startProcessTaskHandler");
        handlers.put(ProcessOperator.END.getValue(), "endProcessTaskHandler");
        handlers.put(ProcessOperator.JUMP.getValue(),"jumpAppointTaskHandler");
    }

    public  TaskHandler getTaskHanlder(String opertor) {
        if (!handlers.containsKey(opertor)) {
            return null;
        }
        return SpringUtils.getBean(handlers.get(opertor), TaskHandler.class);
    }
}
