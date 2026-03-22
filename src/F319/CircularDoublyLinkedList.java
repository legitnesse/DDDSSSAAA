package F319;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class CircularDoublyLinkedList<E> implements Iterable<E>
{
    private Node first;
    private Node last;
    private int size;

    public CircularDoublyLinkedList()
    {
        first = null;
        size = 0;
    }

    public void addLast(E element)
    {
        if(first == null)
        {
            first = new Node();
            last = first;
            first.data = element;
            first.nextNode = last;
            first.previousNode = last;
        }
        else
        {
            last.nextNode = new Node();
            last.nextNode.previousNode = last;
            last = last.nextNode;
            last.nextNode = first;
            first.previousNode = last; 
            last.data = element;
        }
        size++;
    }
    public void addFirst(E element)
    {
        if(first == null)
        {
            first = new Node();
            last = first;
            first.data = element;
            first.nextNode = last;
            first.previousNode = last;
        }
        else
        {
            first.previousNode = new Node();
            first.previousNode.nextNode = first;
            first = first.previousNode;
            first.previousNode = last;
            last.nextNode = first;
            first.data = element;
        }
        size++;
    }
    public void add(int index, E element)
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        else if(index == 0)
        {
            addFirst(element);
        }
        else if(index == size)
        {
            addLast(element);
        }
        else
        {
            Node currentNode = getNode(index);
            currentNode.previousNode.nextNode = new Node();
            currentNode.previousNode.nextNode.previousNode = currentNode.previousNode;
            currentNode.previousNode.nextNode.nextNode = currentNode;
            currentNode.previousNode = currentNode.previousNode.nextNode;
            currentNode.previousNode.data = element;        
            size++;
        }
    }
    public E getFirst()
    {
        return first.data;
    }
    public E getLast()
    {
        return last.data;
    }
    public E get(int index)
    {
        checkIndex(index);
        if(index == 0)
        {
            return getFirst();
        }
        else if(index == size - 1)
        {
            return getLast();
        }
        else
        {
            Node currentNode = getNode(index);
            return currentNode.data;
        }
    }
    public E removeFirst()
    {
        if(first == null)
        {
            throw new NoSuchElementException();
        }
        E oldData = first.data;
        if(size == 1)
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.nextNode;
            first.previousNode = last;
            last.nextNode = first;
        }
        
        size--;
        return oldData;
    }
    public E removeLast()
    {
        if(first == null)
        {
            throw new NoSuchElementException();
        }
        E oldData = last.data;
        if(size == 1)
        {
            first = null;
            last = null;
        }
        else
        {
            last = last.previousNode;
            last.nextNode = first;
            first.previousNode = last;
        }
        size--;
        return oldData;
    }
    public E remove(int index)
    {
        checkIndex(index);
        if(index == 0)
        {
            return removeFirst();
        }
        else if(index == size - 1)
        {
            return removeLast();
        }
        else
        {
            Node currentNode = getNode(index);
            E oldData = currentNode.data;
            currentNode.previousNode.nextNode = currentNode.nextNode;
            currentNode.nextNode.previousNode = currentNode.previousNode;
            size--;
            return oldData;
        }
    }
    public boolean removeFirstOccurence(E element)
    {
        Node currentNode = first;
        int currentIndex = 0;
        while(currentIndex != size && currentNode.data != element)
        {
            currentNode = currentNode.nextNode;
            currentIndex++;
        }
        if(currentIndex == size)
        {
            return false;
        }
        else
        {
            remove(currentIndex);
            return true;
        }
    }
    public boolean removeLastOccurence(E element)
    {
        Node currentNode = last;
        int currentIndex = size - 1;
        while(currentIndex != - 1 && currentNode.data != element)
        {
            currentNode = currentNode.previousNode;
            currentIndex--;
        }
        if(currentIndex == - 1)
        {
            return false;
        }
        else
        {
            remove(currentIndex);
            return true;
        }
    }
    public E set(int index, E element)
    {
        checkIndex(index);
        Node currentNode = getNode(index);
        currentNode.data = element;
        return currentNode.data;
    }
    public boolean contains(E element)
    {
        Node currentNode = first;
        while(currentNode.data != element && currentNode != last)
        {
            currentNode = currentNode.nextNode;
        }
        if(currentNode.data == element)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int size()
    {
        return size;
    }

    public void checkIndex(int index)
    {
        if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
    }
    public Node getNode(int index)
    {
        if(index < size / 2)
        {
            Node currentNode = first;
            int currentIndex = 0;
            while(currentIndex != index)
            {                
                currentNode = currentNode.nextNode;
                currentIndex++;
            }
            return currentNode;
        }
        else
        {
            Node currentNode = last;
            int currentIndex = size - 1;
            while(currentIndex != index)
            {                
                currentNode = currentNode.previousNode;
                currentIndex--;
            }
            return currentNode;
        }
    }

    @Override
    public Iterator<E> iterator()
    {
        return new CircularDoublyLinkedListIterator();
    }
    public ListIterator<E> listIterator()
    {
        return new CircularDoublyLinkedListIterator();
    }
    
    public class CircularDoublyLinkedListIterator implements ListIterator<E>
    {
        public Node newNode;
        public Node oldNode;
        public int nextIndex;
        public boolean isAfterMove;

        public CircularDoublyLinkedListIterator()
        {
            newNode = null;
            oldNode = null;
            isAfterMove = false;
        }
        
        public E next()
        {
            if(size == 0)
            {
                throw new NoSuchElementException();
            }
            oldNode = newNode;
            if(newNode == null)
            {
                newNode = first;
                nextIndex = 0;
            }
            else
            {
                newNode = newNode.nextNode;
                nextIndex++;
            }
            isAfterMove = true;
            return newNode.data;
        }
        public E previous()
        {
            if(size == 0)
            {
                throw new NoSuchElementException();
            }
            oldNode = newNode;
            if(newNode == null)
            {
                newNode = last;
                nextIndex = size - 1;
            }
            else
            {
                newNode = newNode.previousNode;
                nextIndex--;
                ensureIndex();

            }
            isAfterMove = true;
            return newNode.data;
        }
        public void add(E element)
        {
            if(!isAfterMove)
            {
                throw new IllegalStateException();
            }
            if(newNode == null)
            {
                addFirst(element);
                newNode = first;
                nextIndex = 0;
            }
            else
            {
                newNode.previousNode.nextNode = new Node();
                newNode.previousNode.nextNode.previousNode = newNode.previousNode;
                newNode.previousNode.nextNode.nextNode = newNode;
                newNode.previousNode = newNode.previousNode.nextNode;
                newNode.previousNode.data = element;
                if(newNode == first)
                {
                    first = newNode.previousNode;
                }
                size++;
                oldNode = null;
                nextIndex++;
                ensureIndex();
                isAfterMove = false;
            }
        }
        public void remove()
        {
            if(!isAfterMove)
            {
                throw new IllegalStateException();
            }
            if(size == 1)
            {
                first = null;
                last = null;
                newNode = null;
                oldNode = null;
                nextIndex = 0;
                size = 0;
                isAfterMove = false;
                return;
            }

            Node removedNode = newNode;
            removedNode.nextNode.previousNode = removedNode.previousNode;
            removedNode.previousNode.nextNode = removedNode.nextNode;

            if(removedNode == first)
            {
                first = removedNode.nextNode;
            }
            if(removedNode == last)
            {
                last = removedNode.previousNode;
            }

            newNode = oldNode;
            oldNode = null;
            size--;
            nextIndex--;
            if(size == 0)
            {
                nextIndex = 0;
            }
            else
            {
                ensureIndex();
            }
            isAfterMove = false;
        }
        public void set(E element)
        {
            if(!isAfterMove)
            {
                throw new IllegalStateException();
            }
            newNode.data = element;
        }
        public int nextIndex()
        {
            return nextIndex;
        }
        public int previousIndex()
        {
            if(size == 0)
            {
                return -1;
            }
            return Math.floorMod(nextIndex - 1, size);
        }
        public boolean hasNext()
        {
            if(newNode == null)
            {
                return first != null;
            }
            else
            {
                if(nextIndex + 1 == size)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
        }
        public boolean hasPrevious()
        {
            if(newNode == null)
            {
                return last != null;
            }
            else
            {
                if(newNode.previousNode == last)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
        }

        public void ensureIndex()
        {
            if(size != 0 &&(nextIndex < 0 || nextIndex > size))
            {
                nextIndex = Math.floorMod(nextIndex, size);
            }
        }
    }

    private class Node
    {
        public E data;
        public Node nextNode;
        public Node previousNode;
    }
}