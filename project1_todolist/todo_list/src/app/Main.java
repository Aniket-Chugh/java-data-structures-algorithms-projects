package app;

import java.util.Currency;
import java.util.Scanner;

import manager.TaskManager;
import model.Tasks;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskManager tm = new TaskManager();
        boolean running = true;
        // this is called dependency injection;
        Tasks Crud_task = new Tasks(sc, tm);

        while (running) {

            System.out.println("0. Exit");
            System.out.println("1. Show Menu");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 0:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                case 1:
                    System.out.println("\n========================================");
                    System.out.println("          TASK MANAGER");
                    System.out.println("========================================");

                    System.out.println("0. Exit");

                    System.out.println("\n----- CRUD -----");
                    System.out.println("1. View Tasks");
                    System.out.println("2. Add Task");
                    System.out.println("3. Remove Task");
                    System.out.println("4. Update Task");

                    System.out.println("\n----- Searching & Filtering -----");
                    System.out.println("5. Search Task");
                    System.out.println("6. View Completed Tasks");
                    System.out.println("7. View Pending Tasks");

                    System.out.println("\n----- Status Operations -----");
                    System.out.println("8. Mark Task as Completed");
                    System.out.println("9.Mark Task as Completed");

                    System.out.println("\n----- Sorting -----");
                    System.out.println("10. Sort by Deadline");
                    System.out.println("11. Sort Alphabetically");

                    System.out.println("\n----- Undo / Redo -----");
                    System.out.println("12. Undo Last Operation");
                    System.out.println("13. Redo Last Operation");

                    System.out.println("\n----- Advanced -----");
                    System.out.println("14. Clear Completed Tasks");
                    System.out.println("15. View Overdue Tasks");

                    System.out.print("\nEnter your choice from Menu: ");

                    int Menuchoice = sc.nextInt();
                    sc.nextLine();

                    switch (Menuchoice) {
                        case 0:
                            running = false;
                            System.out.println("Exiting...");
                            break;
                        case 1:
                            Crud_task.viewTasks();
                            break;
                        case 2:
                            Crud_task.addTasks();
                            break;

                        case 3:
                            System.out.println("1. Remove all Tasks");
                            System.out.println("2. Remove tasks that name is");
                            System.out.println("3. Remove Task that is on this index");
                            System.out.println("4. Exit from this menu");
                            int remChoice = sc.nextInt();
                            sc.nextLine();
                            switch (remChoice) {
                                case 1:
                                    Crud_task.removeAllTasks();
                                    break;

                                case 2:
                                    Crud_task.removeByName();
                                    break;

                                case 3:
                                    Crud_task.removeByIndex();
                                    break;

                                case 4:
                                    break;

                                default:
                                    System.out.println("enter a valid input to remove");
                                    break;
                            }
                            break;

                        case 4:
                            System.out.println("Update Task");
                            Crud_task.updateByIndex();
                            break;

                        case 5:
                            System.out.println("Search Task");
                            Crud_task.searchTask();
                            break;

                        case 6:
                            System.out.println("View Completed Tasks");
                            Crud_task.viewCompletedTask();
                            break;

                        case 7:
                            System.out.println("View Pending Tasks");
                            Crud_task.viewPendingTask();
                            break;

                        case 8:
                            System.out.println("Mark Task Completed");
                            Crud_task.markTaskCompleted();
                            break;

                        case 9:
                            System.out.println("Mark Task Completed");
                            Crud_task.markTaskCompleted();
                            break;

                        case 10:
                            System.out.println("Sort by Deadline");
                            Crud_task.sortByDeadline();
                            break;

                        case 11:
                            System.out.println("Sort Alphabetically");
                            Crud_task.sortByAlphabets();
                            break;

                        case 12:
                            System.out.println("Undo Last Operation");
                            break;

                        case 13:
                            System.out.println("Redo Last Operation");
                            break;

                        case 14:
                            System.out.println("Show Pending Count");
                            break;

                        case 15:
                            System.out.println("Undo Last Operation");
                            break;

                        case 16:
                            System.out.println("Redo Last Operation");
                            break;

                        case 17:
                            System.out.println("Clear all completed tasks");
                            break;

                        case 18:
                            System.out.println("View Overdue Tasks");
                            break;

                    }

                    break;

                default:
                    System.out.println("Bro cant you see there are only 2 options , dumb ! Invalid Choice.");

            }
        }

        sc.close();
    }
}
