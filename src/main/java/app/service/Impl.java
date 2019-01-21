package app.service;

import org.activiti.engine.task.Task;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author joker
 * @date 2019/1/21 10:46
 */
@Service("activityService")
public class Impl implements Api{

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;


    @Autowired
    private RepositoryService repositoryService;


    @Override
    public String startActivityDemo() {
         // 启动流程  并提交申请
        try {
            System.out.println("method startActivityDemo begin....");
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("student","zhangsan");
            System.out.println( "调用流程存储服务，查询部署数量："
                    + repositoryService.createDeploymentQuery().count());
            ExecutionEntity pi =(ExecutionEntity) runtimeService.startProcessInstanceByKey("leave", map);//流程图id，业务表id
            System.out.println("流程启动成功，流程id:"+pi.getId());
            return "流程启动成功，流程的id 是"+pi.getId();
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }


//
//流程启动
//        ExecutionEntity pi1 = (ExecutionEntity) runtimeService.startProcessInstanceByKey("myProcess_1",map);
//        String processId = pi1.getId();


        // 获取taskId


//
//        // 代办
//        List<Task> resultTask = taskService.createTaskQuery().processDefinitionKey("leave").taskCandidateOrAssigned("lisi").list();
//
//        taskService.complete(resultTask.get(0).getId(), map);//完成第一步申请
//       // 已完成
////        List<HistoricProcessInstance> hisProInstance = historyService.createHistoricProcessInstanceQuery()
////                .processDefinitionKey("leave").startedBy("zhangsan").finished()
////                .orderByProcessInstanceEndTime().desc().list();
//
//        List<HistoricTaskInstance> hisProInstance = historyService.createHistoricTaskInstanceQuery()
//                .processDefinitionKey("leave").taskAssignee("zhangsan")
//               .list();
//
//        return false;

    }

    @Override
    public List<Task> getToDo() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("student","zhangsan");
        List<Task> resultTask =taskService.createTaskQuery().processDefinitionKey("leave").taskCandidateGroup("Headmaster").list();
        return resultTask;
    }
}
