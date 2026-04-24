package F416A.EmployeesSimulator;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesSimulator 
{
    private ArrayList<Person> people;
    private ArrayList<Department> departments;
    
    //unemployedDepartment could have been the first element of departments but it is more convenient to access this way.
    private UnemployedDepartment unemployedDepartment;

    public EmployeesSimulator()
    {
        people = new ArrayList<>();
        departments = new ArrayList<>();
        unemployedDepartment = new UnemployedDepartment();
    }

    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        while(processInput(scanner)){}
    }
    public boolean processInput(Scanner scanner)
    {
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("create"))
        {
            System.out.println("Enter the name of the new department.");
            String departmentName = scanner.nextLine();
            createDepartment(new Department(departmentName));
            System.out.println(departmentName + " Department created.");
        }
        else if(input.equalsIgnoreCase("recruit"))
        {
            System.out.println("Enter the name of the new recruit.");
            String personName = scanner.nextLine();
            Person p = new Person(personName);
            recruitPerson(p);
            System.out.println(personName + " recruited.");
        }
        else if(input.equalsIgnoreCase("assign"))
        {
            System.out.println("Enter the name of the person.");
            String personName = scanner.nextLine();
            Person p = getPerson(personName);
            if(p == null)
            {
                System.out.println("Please enter a valid name next time.");
            }
            else
            {
                System.out.println("Enter the name of the department.");
                String departmentName = scanner.nextLine();
                Department d = getDepartment(departmentName);
                if(d == null)
                {
                    System.out.println("Please enter a valid department next time.");
                }
                else
                {
                    assignPersonToDepartment(p, d);
                    System.out.println(personName + " assigned to " + departmentName + " Department.");
                }
            }
        }
        else if(input.equalsIgnoreCase("remove"))
        {
            System.out.println("Enter the name of the person");
            String personName = scanner.nextLine();
            Person p = getPerson(personName);
            if(p == null)
            {
                System.out.println("Please enter a valid name next time.");
            }
            else
            {
                removePersonFromDepartment(p);
                System.out.println(personName + " removed from their department.");
            }
            
        }
        else if(input.equalsIgnoreCase("print"))
        {
            printPayrolls();
        }
        else if(input.equalsIgnoreCase("salary"))
        {
            System.out.println("Enter the name of the person.");
            String personName = scanner.nextLine();
            Person p = getPerson(personName);
            if(p == null)
            {
                System.out.println("Please enter a valid name next time.");
            }
            else
            {
                printSalaryOfPerson(p);
            }
            
        }
        else if(input.equalsIgnoreCase("exit"))
        {
            System.out.println("Simulation complete.");
            return false;
        }
        return true;
    }

    public void createDepartment(Department d)
    {
        departments.add(d);
    }
    public void recruitPerson(Person p)
    {
        people.add(p);
        unemployedDepartment.addPerson(p);
    }
    
    public void assignPersonToDepartment(Person p, Department d)
    {
        Department oldDepartment = p.getDepartment();
        oldDepartment.removePerson(p);
        d.addPerson(p);
    }
    public void removePersonFromDepartment(Person p)
    {
        Department oldDepartment = p.getDepartment();
        oldDepartment.removePerson(p);
        unemployedDepartment.addPerson(p);
    }
    public void printPayrolls()
    {
        for(Department d : departments)
        {
            System.out.println("Department: " + d.getName());
            d.printPayroll();
        }
        System.out.println("Unemployed:");
        unemployedDepartment.printPayroll();
    }
    public void printSalaryOfPerson(Person p)
    {
        System.out.println(p.getName() + ": $" + p.getSalary());
    }

    public Person getPerson(String name)
    {
        for(Person p : people)
        {
            if(p.getName().equalsIgnoreCase(name))
            {
                return p;
            }
        }
        return null;
    }
    public Department getDepartment(String name)
    {
        for(Department d : departments)
        {
            if(d.getName().equalsIgnoreCase(name))
            {
                return d;
            }
        }
        return null;
    }

    public static void main(String[] args) 
    {
        EmployeesSimulator es = new EmployeesSimulator();
        es.run();
    }
}
