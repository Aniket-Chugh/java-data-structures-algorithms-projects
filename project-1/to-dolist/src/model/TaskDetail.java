package model;

import java.time.LocalDate;

public class TaskDetail {

    private String taskName;
    private String taskDesc;
    private LocalDate deadline;
    private boolean completed;

    public TaskDetail(String taskName, String taskDesc,
            LocalDate deadline, boolean completed) {

        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.deadline = deadline;
        this.completed = completed;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
