package main;

import manager.ManagerClassRoom;
import manager.ManagerStudent;
import model.ClassRoom;
import model.Student;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ManagerStudent managerStudent = new ManagerStudent();
    static ManagerClassRoom managerClassRoom = new ManagerClassRoom();
    static String name = "";
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("MENU:");
            System.out.println("1. ACT-Student");
            System.out.println("2. ACT-ClassRoom");
            System.out.println("_______________");
            System.out.println("0. Exit");
            System.out.println("Enter Choice ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    name = "Student";
                    actionStudent();
                    break;
                case 2:
                    name = "ClassRoom";
                    actionClassRoom();
                    break;
            }
        } while (choice != 0);
    }
    public static void actionStudent() {
        int choice=-1;
        do {
          action(name);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerStudent.display();
                    break;
                case 2:
                    System.out.println("Enter ID Want Find :");
                    managerStudent.display(Integer.parseInt(scanner.nextLine()));
                    break;
                case 3:
                    System.out.println("Enter Name Want Find : ");
                    managerStudent.display(scanner.nextLine());
                    break;
                case 4:
                    System.out.println( managerStudent.add(scanner));
                    System.out.println("Add Student Successful ");
                    System.out.println("--------------------------");
                    break;
                case 5:
                    managerStudent.edit(scanner);
                    break;
                case 6:
                    managerStudent.delete(scanner);
                    break;
            }
        } while (choice != 0);
    }
    public static void actionClassRoom() {
        int choice;
        do {
           action(name);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerClassRoom.display();
                    break;
                case 2:
                    System.out.println("Enter Find ClassRoom By ID :");
                    managerClassRoom.display(Integer.parseInt(scanner.nextLine()));
                    break;
                case 3:
                    System.out.println("Enter Name ClassRom");
                    managerClassRoom.display(scanner.nextLine());
                    break;
                case 4:
                    managerClassRoom.add(scanner);
                    break;
                case 5:
                    managerClassRoom.edit(scanner);
                    break;
                case 6:
                    managerClassRoom.delete(scanner);
                    break;
            }
        } while (choice != 0);
    }

    public static void action(String s) {
            System.out.println("MENU");
            System.out.println("1. Show List " + s);
            System.out.println("2. Show List " + s + " By Id");
            System.out.println("3. Show List " + s + " By Name");
            System.out.println("4. add " + s);
            System.out.println("5. edit " + s + " By Id:");
            System.out.println("6. delete " + s+ " By Id:");
            System.out.println("_______________");
            System.out.println("0. Back MENU:");

            System.out.println("Enter Choice");

    }
}
