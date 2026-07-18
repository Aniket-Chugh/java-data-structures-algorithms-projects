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

        if (viewTask.isEmpty()) {
            System.out.println("No tasks found!");
        } else {
            System.out.println("There are " + viewTask.size() + " tasks.");

            for (TaskDetail task : viewTask) {
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
        String name = sc.nextLine();
        if (name.isBlank()) {
            System.out.println("Enter a valid name Bro.");
            return;
        } else {
            tm.removeByName(name);
        }

    }

    public void removeByIndex() {
        int index = sc.nextInt();
        sc.nextLine();

        tm.removeByIndex(index);
    }

    public void updateByIndex() {
        int index = sc.nextInt() - 1;
        if (index < 0) {
            System.out.println("hey coder, this starts from 1");
        }
        sc.nextLine();

        System.out.println("1. You want to change the task Name?");
        System.out.println("2. You want to change the task Desc?");
        System.out.println("3. You want to change the task Deadine?");
        System.out.println("4. Exit from this menu");

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Task Name?");

                String taskName = sc.nextLine();

                tm.setTaskNameViaManager(index, taskName);
                break;
            case 2:
                System.out.println("Task Desc?");

                String taskDesc = sc.nextLine();
                tm.setTaskDescViaManager(index, taskDesc);
                break;
            case 3:
                System.out.println("Task new Deadline?");
                LocalDate taskDate = LocalDate.parse(sc.nextLine());
                tm.setTaskDeadlineViaManager(index, taskDate);
                break;

            case 4:
                return;

            default:
                System.out.println("bro wtf? cant select from these 3? " + "invalid input");
                break;
        }

    }

    public void searchTask() {
        System.out.println("Tell me the name of that task?");
        String taskName = sc.nextLine();
        if (taskName.isBlank()) {
            System.out.println("bro!? Invalid input");
            return;
        }
        tm.searchTask(taskName);
    }

    public void viewCompletedTask() {
        tm.viewCompletedTask();
    }

    public void viewPendingTask() {
        tm.viewPendingTask();
    }

}
