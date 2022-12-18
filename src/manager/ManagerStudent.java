package manager;

import model.ClassRoom;
import model.Crud;
import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerStudent implements Crud<Student> {

    ManagerClassRoom managerClassRoom = new ManagerClassRoom();
    public ArrayList<Student> listStudent = new ArrayList<>();

    public ManagerStudent() {
        listStudent.add(new Student(1, "Hoang", 22, "Male", "NamDinh", 88, managerClassRoom.listClassRoom.get(0)));
        listStudent.add(new Student(2, "Lien", 25, "Male", "HaiPhong", 77, managerClassRoom.listClassRoom.get(1)));
        listStudent.add(new Student(3, "Son", 22, "Male", "HaNoi", 66, managerClassRoom.listClassRoom.get(2)));
    }

    public void showView() {
        System.out.printf("%-5s%-10S%-10s%-10s%-10s%-15s%s",
                "ID", "NAME", "AGE", "GENDER", "ADDRESS", "POINT", "CLASSROOM\n");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");

    }

    public void lastView() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void display() {
        showView();
        for (Student student :
                listStudent) {
            student.display();
        }
        lastView();
    }

    @Override
    public void display(String name) {
        boolean flag = false;
        showView();
        for (Student student :
                listStudent) {
            if (name.equals(student.getName())) {
                student.display();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No Find ClassRoom By name " + "'" + name + "'");
        }
        lastView();
    }

    @Override
    public void display(int id) {
        boolean flag = false;
        showView();
        for (Student student :
                listStudent) {
            if (id == student.getId()) {
                student.display();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No Find ClassRoom By name " + "'" + id + "'");
        }
        lastView();
    }

    @Override
    public void edit(Scanner scanner) {
        boolean flag = false;
        Student students = null;
        display();
        System.out.println("Enter Id Want Edit ClassRoom :");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student student : listStudent) {
            if (id == student.getId()) {
                students = student;
                flag = true;
                System.out.println("Edit Student");
                showView();
                student.display();
                lastView();
                System.out.print("Name Student : " + student.getName() + " Edit ---> ");
                student.setName(scanner.nextLine());
                System.out.print("Age Student : " + student.getAge() + " Edit ---> ");
                student.setAge(Integer.parseInt(scanner.nextLine()));

                System.out.println("Gender Student : " + student.getGender() + " Edit ---> ");
                student.setGender(choiceGender(scanner));

                System.out.print("Address Student : " + student.getAddress() + " Edit ---> ");
                student.setAddress(scanner.nextLine());
                System.out.print("Point Student : " + student.getPoint() + " Edit ---> ");
                student.setPoint(Integer.parseInt(scanner.nextLine()));

                System.out.print("ClassRom :\n" + student.getClassRoom() + "\n" + " Edit ---> Choice ID ClassRoom \n");
                ClassRoom classRoom = choiceClass(scanner);
                student.setClassRoom(classRoom);
                break;
            }
        }
        if (flag) {
            System.out.println("after Edit Student\n " + students);
            lastView();
        } else {
            System.out.println("No Find Student By ID  " + id);
            lastView();
        }
    }

    @Override
    public void delete(Scanner scanner) {
        display();
        int choice;
        do {
            System.out.println("Enter delete ListStudent By ID:");
            System.out.print("Enter ID Want Delete : ");
            int id = Integer.parseInt(scanner.nextLine());
            if (id > listStudent.size() || id < 0) {
                System.out.println(" ID = " + id + " No in List Student :");
            } else {
                Student student = listStudent.get(id - 1);
                listStudent.remove(id - 1);
                display();
                System.out.println("Successful Delete\n-----------------------");
                student.display();

            }
            lastView();
            System.out.println("Enter #0 delete By ID : ");
            System.out.println("Enter 0. Back MENU:");
            choice = Integer.parseInt(scanner.nextLine());
        } while (choice != 0);
    }


    @Override
    public Student create(Scanner scanner) {
        System.out.println("Enter student Name:");
        String name = scanner.nextLine();
        System.out.println("Enter student Age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter student Gender:");
        String gender = choiceGender(scanner);
        System.out.println("Enter student address: ");
        String address = scanner.nextLine();
        double point = 0.0;
        if (choicePoint(scanner)) {
            System.out.println("Enter student Point:");
            point = Double.parseDouble(scanner.nextLine());
        }
        ClassRoom classRoom = choiceClass(scanner);
        if (point != 0.0) {
            return new Student(listStudent.size() + 1, name, age, gender, address, point, classRoom);
        } else {
            return new Student(listStudent.size() + 1, name, age, gender, address, classRoom);
        }
    }

    private String choiceGender(Scanner scanner) {
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Other");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                return "Male";
            case 2:
                return "Female";
            default:
                return "Other";
        }
    }

    private boolean choicePoint(Scanner scanner) {
        System.out.println("Enter Choice point Student:");
        System.out.println("1. Student Point ");
        System.out.println("2. No Point :");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                return true;
            case 2:
                return false;
        }
        return false;
    }

    private ClassRoom choiceClass(Scanner scanner) {
        System.out.println("List ClassRoom : ");
        managerClassRoom.display();
        System.out.println("--------------------------------");
        System.out.println("0.    Add  New  ClassRoom:");
        System.out.println("--------------------------------");
        System.out.println("Enter ID Choice ClassRoom");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        ClassRoom classRoom = null;

        for (ClassRoom c : managerClassRoom.listClassRoom) {
            if (c.getId() == id) {
                classRoom = c;
                flag = true;
                break;
            }
        }
        if (!flag) {
            classRoom = managerClassRoom.add(scanner);
            return classRoom;
        }

        return classRoom;

    }

    @Override
    public Student add(Scanner scanner) {
        Student student;
        student = create(scanner);
        listStudent.add(student);
        return student;
    }
}
