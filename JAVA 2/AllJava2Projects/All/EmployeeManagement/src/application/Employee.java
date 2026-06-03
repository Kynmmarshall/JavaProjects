// Employee.java
package application;
public class Employee {
    private int id;
    private String name;
    private String position;
    private String email;
    private double salary;
    
    public Employee() {}
    
    public Employee(String name, String position, String email, double salary) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.salary = salary;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}