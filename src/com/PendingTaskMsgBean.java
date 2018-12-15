/**
 * 
 */
package com;

/**
 * @author fandong
 * @date 2018年12月10日 下午2:14:23 
 * @desc 待办任务消息对象
 */
public class PendingTaskMsgBean {

    //任务id
    private String taskId ;
    //任务标题，即申请名称
    private String title ;
    //流程类型
    private String processsType ;
    //操作名称
    private String typeName ;
    
    public PendingTaskMsgBean() {
    }
    
    public PendingTaskMsgBean(String taskId, String title, String processsType) {
        super();
        this.taskId = taskId;
        this.title = title;
        this.processsType = processsType;
    }
    
    public String getTaskId() {
        return taskId;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getProcesssType() {
        return processsType;
    }
    public void setProcesssType(String processsType) {
        this.processsType = processsType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
}
