package F331A;

import java.util.ArrayList;

public class BinaryTree<E extends Comparable<E>>
{
    private Node root;

    public BinaryTree()
    {
        root = null;
    }
    public void add(E e)
    {
        root = addHelper(root, e);
    }

    public Node addHelper(Node currentNode, E e)
    {
        if(currentNode == null)
        {
            currentNode = new Node();
            currentNode.data = e;
            currentNode.leftNode = null;
            currentNode.rightNode = null;
            return currentNode;
        }
        else
        {
            if(currentNode.data.compareTo(e) > 0)
            {
                currentNode.leftNode = addHelper(currentNode.leftNode, e);
            }
            else if(currentNode.data.compareTo(e) < 0)
            {
                currentNode.rightNode = addHelper(currentNode.rightNode, e);
            }
        }
        return currentNode;
    }

    public ArrayList<E> getInOrder()
    {
        ArrayList<E> list = new ArrayList<>();
        inOrderHelper(root, list);
        return list;
    }

    public void inOrderHelper(Node currentNode, ArrayList<E> list)
    {
        if(currentNode == null)
        {
            return;
        }
        else
        {
            inOrderHelper(currentNode.leftNode, list);
            list.add(currentNode.data);
            inOrderHelper(currentNode.rightNode, list);
        }
    }

    public ArrayList<E> getPreOrder()
    {
        ArrayList<E> list = new ArrayList<>();
        preOrderHelper(root, list);
        return list;
    }

    public void preOrderHelper(Node currentNode, ArrayList<E> list)
    {
        if(currentNode == null)
        {
            return;
        }
        else
        {
            list.add(currentNode.data);
            preOrderHelper(currentNode.leftNode, list);
            preOrderHelper(currentNode.rightNode, list);
        }
    }

    public ArrayList<E> getPostOrder()
    {
        ArrayList<E> list = new ArrayList<>();
        postOrderHelper(root, list);
        return list; 
    }

    public void postOrderHelper(Node currentNode, ArrayList<E> list)
    {
       if(currentNode == null)
        {
            return;
        }
        else
        {
            preOrderHelper(currentNode.leftNode, list);
            preOrderHelper(currentNode.rightNode, list);
            list.add(currentNode.data);
        } 
    }

    private class Node
    {
        public E data;
        public Node leftNode;
        public Node rightNode;
    }
}
