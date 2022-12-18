package model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double point;
    private ClassRoom classRoom;

    public Student(int id, String name, int age, String gender, String address, double point, ClassRoom classRoom) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.point = point;
        this.classRoom = classRoom;
    }

    public Student(String name, int age, String gender, String address, double point, ClassRoom classRoom) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.point = point;
        this.classRoom = classRoom;
    }

    public Student(int id,String name, int age, String gender, String address, ClassRoom classRoom) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.classRoom = classRoom;
        this.point = -1.0;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", point=" + point +
                ", classRoom=" + classRoom +
                '}';
    }

    public void display() {
        System.out.printf("%-5s%-10s%-10s%-10s%-10s%-15s%s",
                this.id,this.name, this.age, this.gender, this.address, this.point, this.classRoom + "\n");


    }
}
