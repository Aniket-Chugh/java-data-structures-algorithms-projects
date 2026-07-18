package manager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// following Separation of Concerns (SoC) , good in oop , thanks to me hehe

import model.TaskDetail;

public class TaskManager {
    private List<TaskDetail> tasks = new ArrayList<>();

    public void setTask(TaskDetail task) {

        tasks.add(task);
    }

    public List<TaskDetail> showTasks() {
        return tasks;
    }

    private boolean isValidIndex(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid index.");
            return false;
        }
        return true;
    }

    public void removeAlTasks() {

        tasks.clear();

    }

    public void removeByName(String name) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskName().equalsIgnoreCase(name)) {
                tasks.remove(i);
                i--;
            }
        }
    }

    public void removeByIndex(int index) {

        if (!isValidIndex(index)) {
            return;
        }

        tasks.remove(index);

    }

    public void setTaskNameViaManager(int index, String name) {
        if (!isValidIndex(index)) {
            return;
        }
        tasks.get(index).setTaskName(name);
    }

    public void setTaskDescViaManager(int index, String desc) {
        if (!isValidIndex(index)) {
            return;
        }
        tasks.get(index).setTaskDesc(desc);

    }

    public void setTaskDeadlineViaManager(int index, LocalDate dueDate) {
        if (!isValidIndex(index)) {
            return;
        }

        tasks.get(index).setDeadline(dueDate);
    }

    public void searchTask(String taskName) {
        boolean found = false;
        for (TaskDetail task : tasks) {

            if (task.getTaskName().equalsIgnoreCase(taskName)) {

                System.out.println("Task Name  : " + task.getTaskName());
                System.out.println("Description: " + task.getTaskDesc());
                System.out.println("Deadline   : " + task.getDeadline());
                System.out.println("Completed  : " + task.isCompleted());
                System.out.println("-------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No task found with name: " + taskName);
        }
    }

    public void viewCompletedTask() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        boolean found = false;

        System.out.println("===== Completed Tasks =====");

        for (TaskDetail task : tasks) {

            if (task.isCompleted()) {

                System.out.println("Task Name  : " + task.getTaskName());
                System.out.println("Description: " + task.getTaskDesc());
                System.out.println("Deadline   : " + task.getDeadline());
                System.out.println("-------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No completed tasks found.");
        }
    }

    public void viewPendingTask() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        boolean found = false;

        System.out.println("===== Pending Tasks =====");

        for (TaskDetail task : tasks) {

            if (!task.isCompleted()) {

                System.out.println("Task Name  : " + task.getTaskName());
                System.out.println("Description: " + task.getTaskDesc());
                System.out.println("Deadline   : " + task.getDeadline());
                System.out.println("-------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No Pending tasks found.");
        }
    }

    public void markTaskCompleted(int index) {
        if (!isValidIndex(index)) {
            return;
        }

        tasks.get(index).setCompleted(true);

        System.out.println("your task is completed finally");

    }

    

}
