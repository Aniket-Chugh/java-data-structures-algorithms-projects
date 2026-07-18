package model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import manager.TaskManager;

public class Tasks {

    private final Scanner sc;

    private final TaskManager tm;

    public Tasks(Scanner sc, TaskManager tm) {
        this.sc = sc;
        this.tm = tm;

    }

    public void addTasks() {

        try {

            System.out.print("Enter task name: ");
            String taskName = sc.nextLine();

            System.out.print("Enter task description: ");
            String taskDesc = sc.nextLine();

            System.out.print("Deadline (yyyy-MM-dd): ");
            LocalDate taskDeadline = LocalDate.parse(sc.nextLine());

            System.out.print("Is task completed? (true/false): ");
            boolean completed = sc.nextBoolean();
            sc.nextLine();

            TaskDetail task = new TaskDetail(
                    taskName,
                    taskDesc,
                    taskDeadline,
                    completed);

            tm.setTask(task);

            System.out.println("\n========== Task Added Successfully ==========");
            System.out.println("Task Name       : " + task.getTaskName());
            System.out.println("Description     : " + task.getTaskDesc());
            System.out.println("Deadline        : " + task.getDeadline());
            System.out.println("Completed       : " + task.isCompleted());
            System.out.println("=============================================\n");

        } catch (InputMismatchException e) {

            System.out.println("Invalid Input.");

        } catch (DateTimeParseException e) {

            System.out.println("Invalid date format. Please use yyyy-MM-dd.");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

    }

    public void viewTasks() {
        List<TaskDetail> viewTask = tm.showTasks();
        if (tm.showTasks().isEmpty()) {
            System.out.println("No tasks found!");
        } else {
            for (TaskDetail task : viewTask) {
                System.out.println("There are " + viewTask.size() + " tasks.");
                System.out.println("Task Name       : " + task.getTaskName());
                System.out.println("Description     : " + task.getTaskDesc());
                System.out.println("Deadline        : " + task.getDeadline());
                System.out.println("Completed       : " + task.isCompleted());
                System.out.println("--------------------------------------");
            }
        }

    }

    public void removeAllTasks() {
        if (tm.showTasks().isEmpty()) {

            System.out.println("First add something bro ! then i will delete!");

        } else {

            tm.removeAlTasks();
        }
    }

    public void removeByName() {
        String name = sc.next();
        if (name.isBlank()) {
            System.out.println("Enter a valid name.");
            return;
        } else {
            tm.removeByName(name);
        }

    }

    public void removeByIndex() {
        int index = sc.nextInt();
        tm.removeByIndex(index);
    }

    

}
