package F331A;

import java.util.ArrayList;

public class BinaryTreeTester 
{
    public static void main(String[] args) 
    {
        BinaryTree<Integer> hey = new BinaryTree<>();
        hey.add(5);
        hey.add(3);
        hey.add(6);
        ArrayList<Integer> list = hey.getInOrder();
        for(int i: list)
        {
            System.out.println(i);
        }
        list = hey.getPreOrder();
        for(int i: list)
        {
            System.out.println(i);
        }
        list = hey.getPostOrder();
        for(int i: list)
        {
            System.out.println(i);
        }
        System.out.println(hey.contains(2));
    }
    
}
