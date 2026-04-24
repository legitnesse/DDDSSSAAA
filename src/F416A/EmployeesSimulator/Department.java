package F416A.EmployeesSimulator;

import java.util.LinkedList;

public class Department 
{
    private String name;
    private LinkedList<Person> people;

    public Department(String name)
    {
        this.name = name;
        people = new LinkedList<>();
    }

    public void addPerson(Person newPerson)
    {
        for(Person p : people)
        {
            p.incrementSalary();
        }
        people.add(newPerson);
        newPerson.setDepartment(this);
        newPerson.setSalary(40000);
    }
    public void removePerson(Person oldPerson)
    {
        people.remove(oldPerson);
        for(Person p : people)
        {
            p.decrementSalary();
            if(p.getSalary() < 40000)
            {
                p.setSalary(40000);
            }
        }
    }
    
    //These are 2 more basic implementations that allow the subclass UnemployedDepartment to access the LinkedList<Person> people.
    public void addPersonToPeople(Person newPerson)
    {
        people.add(newPerson);
        newPerson.setDepartment(this);
        newPerson.setSalary(40000); 
    }
    public void removePersonFromPeople(Person personToBeRemoved)
    {
        people.remove(personToBeRemoved);
    }
    public void printPayroll()
    {
        for(Person p : people)
        {
            System.out.println(p.getName() + ": $" + p.getSalary());
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
