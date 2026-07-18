package manager;

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

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid index.");
            return;
        }

        tasks.remove(index);

    }

}
