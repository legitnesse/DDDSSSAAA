package F205;

public class QuizJankArrayTester 
{
    public static void main(String[] args) {
        QuizJankArray JA = new QuizJankArray();
        for(int i = 0; i < 20; i++)
        {
            JA.add(i);
            JA.print();
            JA.getSize();
        }
    }
}
