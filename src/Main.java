import service.StudentManager;
import thread.AutoSaveTask;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManager manager =
                new StudentManager(sc);

        // Start background auto-save thread
        AutoSaveTask autoSaveTask =
                new AutoSaveTask(manager);

        Thread autoSaveThread =
                new Thread(autoSaveTask);

        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        boolean running = true;

        System.out.println("\n==============================================");
        System.out.println("       STUDENT MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("Auto-save is enabled every 60 seconds.");

        while (running) {

            printMenu();

            int choice;

            try {

                System.out.print("Enter your choice: ");

                choice =
                        Integer.parseInt(
                                sc.nextLine().trim()
                        );

            } catch (NumberFormatException e) {

                System.out.println(
                        "\nInvalid input! Please enter a number."
                );

                continue;
            }

            switch (choice) {

                case 1:
                    manager.addStudent();
                    break;
                
                case 2:
                    manager.addTeacher();
                    break;

                case 3:
                    manager.assignToTeacher();
                    break;
                
                case 4:
                    manager.removeFromTeacher();
                    break;

                case 5:
                    manager.viewStudents();
                    break;

                case 6:
                    manager.viewTeachers();
                    break;

                case 7:
                    manager.searchById();
                    break;

                case 8:
                    manager.searchByName();
                    break;

                case 9:
                    manager.searchByCourse();
                    break;

                case 10:
                    manager.updateStudent();
                    break;

                case 11:
                    manager.updateTeacher();
                    break;

                case 12:
                    manager.deleteStudent();
                    break;
                    
                case 13:
                    manager.deleteTeacher();
                    break;

                case 14:
                    manager.displayStatistics();
                    break;

                case 15:
                    manager.displayTopStudents();
                    break;

                case 16:
                    manager.sortStudents();
                    break;

                case 17:
                    manager.courseStatistics();
                    break;

                case 18:
                    manager.saveToFile();
                    System.out.println(
                            "Data saved successfully."
                    );
                    break;

                case 19:

                    manager.saveToFile();

                    autoSaveTask.stopTask();

                    running = false;

                    System.out.println(
                            "\n=============================================="
                    );
                    System.out.println(
                            "Data saved successfully."
                    );
                    System.out.println(
                            "Thank you for using Student Management System!"
                    );
                    System.out.println(
                            "=============================================="
                    );

                    break;

                default:
                    System.out.println(
                            "Invalid choice! Please select 1-19."
                    );
            }
        }

        sc.close();
    }

    private static void printMenu() {

        System.out.println("\n");
        System.out.println("==============================================");
        System.out.println("          STUDENT MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("1.  Add Student");
        System.out.println("2.  Add Teacher");
        System.out.println("3.  Assign Student to Teacher");
        System.out.println("4.  Remove Student from Teacher");
        System.out.println("5.  View All Students");
        System.out.println("6.  View All Teachers");
        System.out.println("7.  Search Student by ID");
        System.out.println("8.  Search Student by Name");
        System.out.println("9.  Search Students by Course");
        System.out.println("10.  Update Student");
        System.out.println("11.  Update Teacher");
        System.out.println("12.  Delete Student");
        System.out.println("13.  Delete Teacher");
        System.out.println("14.  Display Statistics");
        System.out.println("15.  Display Top Performing Students");
        System.out.println("16. Sort Students");
        System.out.println("17. Course-wise Student Count");
        System.out.println("18. Save Data");
        System.out.println("19. Exit");
        System.out.println("==============================================");
    }
}