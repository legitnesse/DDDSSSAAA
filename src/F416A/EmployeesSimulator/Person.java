package F416A.EmployeesSimulator;

public class Person 
{
    private String name;
    private Department department;
    private int salary;

    public Person(String name)
    {
        this.name = name;
        salary = 0;
    }

    public void incrementSalary()
    {
        salary += 5000;
    }
    public void decrementSalary()
    {
        salary -= 5000;
    }

    public String getName() 
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public Department getDepartment() 
    {
        return department;
    }
    public void setDepartment(Department department) 
    {
        this.department = department;
    }
    public int getSalary() 
    {
        return salary;
    }
    public void setSalary(int salary) 
    {
        this.salary = salary;
    }
}
