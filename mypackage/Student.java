package mypackage;
public class Student {
    private String name;
    private String id;
    private int age;

    public Student(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void infostudent() {
        System.out.println("Name: " + name + ", ID: " + id + ", Age: " + age);
    }
}
