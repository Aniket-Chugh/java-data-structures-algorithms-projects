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
                    System.out.println("9. Mark Task as Pending");

                    System.out.println("\n----- Sorting -----");
                    System.out.println("10. Sort by Deadline");
                    System.out.println("12. Sort Alphabetically");

                    System.out.println("\n----- Statistics -----");
                    System.out.println("13. Show Total Tasks");
                    System.out.println("14. Show Completed Count");
                    System.out.println("15. Show Pending Count");

                    System.out.println("\n----- Undo / Redo -----");
                    System.out.println("16. Undo Last Operation");
                    System.out.println("17. Redo Last Operation");

                    System.out.println("\n----- File Operations -----");
                    System.out.println("18. Save Tasks");
                    System.out.println("19. Load Tasks");
                    System.out.println("20. Export Tasks");

                    System.out.println("\n----- Advanced -----");
                    System.out.println("21. Delete All Tasks");
                    System.out.println("22. Clear Completed Tasks");
                    System.out.println("23. Set Priority");
                    System.out.println("24. Change Deadline");
                    System.out.println("25. View Overdue Tasks");

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
                            int remChoice = sc.nextInt();
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

                                default:
                                    System.out.println("enter a valid input to remove");
                                    break;
                            }
                            break;

                        case 4:
                            System.out.println("Update Task");
                            break;

                        case 5:
                            System.out.println("Search Task");
                            break;

                        case 6:
                            System.out.println("View Completed Tasks");
                            break;

                        case 7:
                            System.out.println("View Pending Tasks");
                            break;

                        case 8:
                            System.out.println("Mark Task Completed");
                            break;

                        case 9:
                            System.out.println("Mark Task Pending");
                            break;

                        case 10:
                            System.out.println("Sort by Deadline");
                            break;

                        case 11:
                            System.out.println("Sort by Priority");
                            break;

                        case 12:
                            System.out.println("Sort Alphabetically");
                            break;

                        case 13:
                            System.out.println("Show Total Tasks");
                            break;

                        case 14:
                            System.out.println("Show Completed Count");
                            break;

                        case 15:
                            System.out.println("Show Pending Count");
                            break;

                        case 16:
                            System.out.println("Undo Last Operation");
                            break;

                        case 17:
                            System.out.println("Redo Last Operation");
                            break;

                        case 18:
                            System.out.println("Save Tasks");
                            break;

                        case 19:
                            System.out.println("Load Tasks");
                            break;

                        case 20:
                            System.out.println("Export Tasks");
                            break;

                        case 21:
                            System.out.println("Delete All Tasks");
                            break;

                        case 22:
                            System.out.println("Clear Completed Tasks");
                            break;

                        case 23:
                            System.out.println("Set Priority");
                            break;

                        case 24:
                            System.out.println("Change Deadline");
                            break;

                        case 25:
                            System.out.println("View Overdue Tasks");
                            break;

                    }

                    break;

                default:
                    System.out.println("Invalid Choice.");

            }
        }

        sc.close();
    }
}
