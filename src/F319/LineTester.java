package F319;

public class LineTester 
{
    public static void main(String[] args) 
    {
        Line line = new Line();
        line.add(new Person("First", false));
        line.print();
        line.add(new Person("Second", true));
        line.print();
        line.poll();
        line.print();

        Line priorityLine = new Line();
        priorityLine.addByPriority(new Person("First", false));
        priorityLine.print();
        priorityLine.addByPriority(new Person("Second", false));
        priorityLine.print();
        priorityLine.addByPriority(new Person("Third", true));
        priorityLine.print();
    }
}
