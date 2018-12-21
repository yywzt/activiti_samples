package com.example.service.common;

import com.example.bo.ActivitiBo;
import org.activiti.bpmn.model.*;
import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("activityService")
public class ActivityService {

    @Autowired
    private RepositoryService repositoryService;

    public List<ActivitiBo> getActivitiList(String processDefId){
        BpmnModel model = repositoryService.getBpmnModel(processDefId);
        Collection<FlowElement> elements =  model.getMainProcess().getFlowElements();
        List<ActivitiBo> activitiList = new ArrayList<ActivitiBo>();
        if(elements!=null){
            for(FlowElement ele : elements){
                if(ele instanceof Task){
                    activitiList.add(new ActivitiBo(ele.getId(),ele.getName()));
                }
                if(ele instanceof StartEvent){
                    activitiList.add(new ActivitiBo(ele.getId(),ele.getName()));
                }
            }
        }
        return activitiList;
    }

    public List<ActivitiBo> getActivitiListNotMe(String processDefId,String activitiId){
        BpmnModel model = repositoryService.getBpmnModel(processDefId);
        Collection<FlowElement> elements =  model.getMainProcess().getFlowElements();
        List<ActivitiBo> activitiList = new ArrayList<ActivitiBo>();
        if(elements!=null){
            for(FlowElement ele : elements){
                if(ele instanceof Task){
                    if(activitiId.equals(ele.getId())) continue;
                    activitiList.add(new ActivitiBo(ele.getId(),ele.getName()));
                }
            }
        }
        return activitiList;
    }

    public ActivitiBo getActiviti(String processDefId,String activitId){
        BpmnModel model = repositoryService.getBpmnModel(processDefId);
        FlowElement element =  model.getMainProcess().getFlowElement(activitId);
        if(element!=null){
           return new ActivitiBo(element.getId(),element.getName());
        }
        return null;
    }

    public List<UserTask> getUserTaskList(String processDefId){
        BpmnModel model = repositoryService.getBpmnModel(processDefId);
        Collection<FlowElement> elements =  model.getMainProcess().getFlowElements();
        List<UserTask> userTaskList = new ArrayList<UserTask>();
        if(elements!=null){
            for(FlowElement ele : elements){
                if(ele instanceof UserTask){
                    userTaskList.add((UserTask)ele);
                }
            }
        }
        return userTaskList;
    }

    public StartEvent getStartEvent(String processDefId){
        BpmnModel model = repositoryService.getBpmnModel(processDefId);
        Collection<FlowElement> elements =  model.getMainProcess().getFlowElements();
        StartEvent result = null;
        if(elements!=null){
            for(FlowElement ele : elements){
                if(ele instanceof StartEvent){
                    result=(StartEvent)ele;
                    break;
                }
            }
        }
        return result;
    }

    public UserTask getUserTaskApprove(String processDefId){
        BpmnModel model = repositoryService.getBpmnModel(processDefId);
        Collection<FlowElement> elements =  model.getMainProcess().getFlowElements();
        UserTask result = null;
        if(elements!=null){
            for(FlowElement ele : elements){
                if(ele instanceof UserTask){
                    result=(UserTask)ele;
                    break;
                }
            }
        }
        return result;
    }

    public EndEvent getEndEvent(String processDefId){
        BpmnModel model =  repositoryService.getBpmnModel(processDefId);
        Collection<FlowElement> elements =  model.getMainProcess().getFlowElements();
        EndEvent result = null;
        if(elements!=null){
            for(FlowElement ele : elements){
                if(ele instanceof EndEvent){
                    result=(EndEvent)ele;
                    break;
                }
            }
        }
        return result;
    }

}
