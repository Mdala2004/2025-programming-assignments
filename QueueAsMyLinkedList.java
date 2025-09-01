
public class QueueAsMyLinkedList<E> {
    MyLinkedList<E> theQueue;
    public QueueAsMyLinkedList()
    {
        theQueue = new MyLinkedList<>();
    }

    public void enqueue(E newElement)
    {
        theQueue.append(newElement);
    }

    public E dequeue()
    {
        E temp = null;
        boolean isDone = false;
        temp = theQueue.getFirst();
        if (temp != null)
        {
            isDone = theQueue.delete(temp);
        }
        if (isDone)
        {
            return temp;
        }else{
            return null;
        }
    }

    public int size(){
        return theQueue.size();
    }

    public void priorityInclusion(E newEl){
        //For each inclusion, check whether the person in the list is of higher priority
        theQueue.prepend(newEl);
    }

    public boolean isEmpty(){
        return theQueue.isEmpty();
    }

    public E peekQueue(){
        return theQueue.getFirst();
    }

    public void clearQueue(){
        theQueue.clear();
    }

    public boolean inQueue(E patient){
        return theQueue.contains(patient);
    }
    
    @Override
    public String toString()
    {
        return theQueue.toString();
    }
}