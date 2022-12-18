package manager;

import model.ClassRoom;
import model.Crud;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerClassRoom implements Crud<ClassRoom> {
    public ArrayList<ClassRoom> listClassRoom = new ArrayList<>();

    public ManagerClassRoom() {
        listClassRoom.add(new ClassRoom(1, "C09", "CodeGym MyDinh"));
        listClassRoom.add(new ClassRoom(2, "C10", "CodeGym ThanhHoa"));
        listClassRoom.add(new ClassRoom(3, "C11", "CodeGym HaiDuong"));

    }

    public void showView() {
        System.out.printf("%-5s%-10s%s",
                "ID", "Class", "School\n");
        System.out.println("--------------------------------");
    }

    @Override
    public void display() {
        showView();
        for (ClassRoom c :
                listClassRoom) {
            c.display();
        }
    }

    @Override
    public void display(String name) {
        boolean flag = false;
        showView();
        for (ClassRoom classRoom : listClassRoom) {
            if (name.equals(classRoom.getClassName())) {
                classRoom.display();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No Find ClassRoom By name " + "'" + name + "'");
        }
        System.out.println("----------------------------");
    }

    @Override
    public void display(int id) {
        boolean flag = false;
        showView();
        for (ClassRoom classRoom :
                listClassRoom) {
            if (id == classRoom.getId()) {
                classRoom.display();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No Find ClassRoom By Id :" + "'" + id + "'");
        }
        System.out.println("----------------------------");
    }

    @Override
    public ClassRoom create(Scanner scanner) {
        System.out.println("Create New ClassRoom:");
        ClassRoom classRoom;
        System.out.println("Enter Name ClassRoom :");
        String nameClass = scanner.nextLine();

        System.out.println("Enter Name School:");
        String nameSchool = scanner.nextLine();

        classRoom = new ClassRoom(listClassRoom.size() + 1, nameClass, nameSchool);
        return classRoom;
    }

    @Override
    public ClassRoom add(Scanner scanner) {
        ClassRoom classRoom;
        classRoom = create(scanner);
        listClassRoom.add(classRoom);
        return classRoom;
    }

    @Override
    public void edit(Scanner scanner) {
        display();
        System.out.println("Enter Id Want Edit ClassRoom :");
        int id = Integer.parseInt(scanner.nextLine());
        for (ClassRoom classroom :
                listClassRoom) {
            if (id == classroom.getId()) {
                System.out.println("Edit ClassRoom\n" + classroom);
                System.out.print("Name Class : " + classroom.getClassName() + " Edit ---> ");
                classroom.setClassName(scanner.nextLine());
                System.out.print("Name School : " + classroom.getSchoolName() + " Edit ---> ");
                classroom.setSchoolName(scanner.nextLine());
                System.out.println("after Edit ClassRoom\n " + classroom);
            }
        }
    }

    @Override
    public void delete(Scanner scanner) {
        display();
        System.out.println("---------------------------------");
        int choice;
        do {
            System.out.println("Enter delete ClassRoom By ID:");
            System.out.print("Enter ID Want Delete : ");
            int id = Integer.parseInt(scanner.nextLine());
            if (id > listClassRoom.size() || id < 0) {
                System.out.println(" ID No in listClassRoom :");
            } else {
                ClassRoom classRoom;
                classRoom = listClassRoom.get(id - 1);
                listClassRoom.remove(id - 1);
                System.out.println("-------------------------------");
                System.out.println("Successful Delete :");
                classRoom.display();
            }
            System.out.println("---------------------------------");
            System.out.println("Enter #0 delete By ID : ");
            System.out.println("Enter 0. Back MENU:");
            choice = Integer.parseInt(scanner.nextLine());
        } while (choice != 0);
    }
}
