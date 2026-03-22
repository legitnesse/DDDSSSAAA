package F319;

public class Line 
{
    private CircularDoublyLinkedList<Person> people;
    
    public Line()
    {
        people = new CircularDoublyLinkedList<>();
    }

    public void add(Person person)
    {
        people.addLast(person);
    }
    public void addByPriority(Person person)
    {
        if(person.getValue())
        {
            people.addFirst(person);
        }
        else
        {
            people.addLast(person);
        }
    }

    public boolean insert(int index, Person person)
    {
        if(index < 0 || index >= people.size())
        {
            return false;
        }
        people.add(index, person);
        return true;
    }

    public Person peek()
    {
        return people.getFirst();
    }

    public Person poll()
    {
        if(people.size() == 0)
        {
            return null;
        }
        else
        {
            Person personToBeReturned = people.removeFirst();
            return personToBeReturned;
        }
    }

    public boolean find(Person person)
    {
        return people.contains(person);
    }

    public void print()
    {
       for(Person p : people)
       {
            System.out.print("|" + p.getName());
       }
       System.out.print("|\n");
    }
}
