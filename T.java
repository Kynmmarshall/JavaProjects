package fold;
public class T {
    private String name;
    private String id;
    private int age;

    public T(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void infostudent() {
        System.out.println("Name: " + name + ", ID: " + id + ", Age: " + age);
    }
}