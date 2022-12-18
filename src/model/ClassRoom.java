package model;

public class ClassRoom {
    private int id;
    private String className;
    private String schoolName;

    public ClassRoom(int id, String className, String schoolName) {
        this.id = id;
        this.className = className;
        this.schoolName = schoolName;
    }

    public ClassRoom() {
        this.id=1;
        this.className="C10";
        this.schoolName="CodeGym-MyDinh";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "{ id=" + id +
                ", className='" + className + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';

}
    public void display(){
        System.out.printf("%-5s%-10s%s",
                this.id, this.className, this.schoolName+ "\n");
    }
}
