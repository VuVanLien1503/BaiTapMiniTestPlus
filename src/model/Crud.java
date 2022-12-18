package model;

import java.util.Scanner;

public interface Crud <E>{
    void display();
    void display(String name);
    void display(int id);
    E create(Scanner scanner);
    E add(Scanner scanner);
     void edit(Scanner scanner);
     void delete(Scanner scanner);


}
