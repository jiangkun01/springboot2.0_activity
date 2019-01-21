package app.service;

import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author joker
 * @date 2019/1/21 10:46
 */
public interface  Api {

    String startActivityDemo();

    List<Task> getToDo();

}
