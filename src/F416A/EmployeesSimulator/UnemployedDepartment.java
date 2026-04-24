package F416A.EmployeesSimulator;

public class UnemployedDepartment extends Department
{
    public UnemployedDepartment()
    {
        super("Unemployed");
    }

    public void addPerson(Person p)
    {
        addPersonToPeople(p);
        p.setDepartment(this);
        p.setSalary(0);
    }
    public void removePerson(Person p)
    {
        removePersonFromPeople(p);
    }


}
