package F205;

public class QuizJankArray 
{
    private int[] data;
    private int size;

    public void add(int input)
    {
        if(size == data.length)
        {
            int[] temp = new int[data.length];
            for(int i = 0; i < data.length; i++)
            {
                temp[i] = data[i];
            }
            data = new int[data.length * 2];
            for(int i = 0; i < temp.length; i++)
            {
                data[i] = temp[i];
            }
        }
        data[size] = input;
        size++;
    }
}
