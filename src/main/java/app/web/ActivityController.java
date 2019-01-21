package app.web;

import app.service.Api;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author joker
 * @date 2019/1/21 10:41
 */
@RestController
@RequestMapping(path = "/activity")
public class ActivityController {

    @Autowired
    private Api api;

    @GetMapping(path = "/startLeaveActivity")
    public String  taskId(){
        return api.startActivityDemo();
    }

    @GetMapping(path = "/getToDo")
    public List<Task> getTodo(){
        return api.getToDo();
    }

}
