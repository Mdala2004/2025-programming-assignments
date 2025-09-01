public class MyLinkedList<E>  {
  private Node<E> head, tail;
 
  public MyLinkedList() {
     head = null;
	 tail = null;
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (head == null) {
      return null;
    }
    else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (head==null) {
      return null;
    }
    else {
      return tail.element;
    }
  }

  /** Add an element to the beginning of the list */
  public void prepend(E e) {
    Node<E> newNode = new Node<>(e); // Create a new node
    newNode.next = head; // link the new node with the head
    head = newNode; // head points to the new node
   
    if (tail == null) // the new node is the only node in list
      tail = head;
  }

  /** Add an element to the end of the list */
  public void append(E item) {
    
	Node<E> newNode = new Node<>(item); // Create a new for element e

    if (head == null) {
      head = tail = newNode; // The new node is the only node in list
    }
    else {
      tail.next = newNode; // Link the new with the last node
      tail = newNode; // tail now points to the last node
    }
  }

  
  /** Remove the head node and
   *  return the object that is contained in the removed node. */
  public E removeFirst() {
    if (head == null) {
      return null;
    }
    else {
      E temp = head.element;
      head = head.next;
      if (head == null) {
        tail = null;
      }
      return temp;
    }
  }


 


public boolean delete(E item)
   {
	   Node<E> ptr = head;
	   Node<E> prvPtr = null;
	   while (ptr != null && !ptr.element.equals(item))//Need to change this for type safety(test patient doesn't work at all)
	   {
		   prvPtr=ptr;
		   ptr=ptr.next;
	   }
	   if (ptr == null)//item not found
		   return false;
	   if (ptr==head) // item is first element
		   head= head.next;
	   else // general case
		   prvPtr.next=ptr.next;
	   if (ptr==tail)// last element
		   tail=prvPtr;
	   return true;
   }
 
  public String toString() {
    String result = "[";

    Node<E> ptr = head;
    for (ptr= head;ptr!=null; ptr=ptr.next) 
	{
		 result = result +  ptr.element.toString();     
		 if (ptr.next != null)
             result = result + ","; // add commas but not to the final 1   
	}
    result += "]"; // Insert the closing ] in the string
    return result;
  }


  public void clear() {
     head = tail = null;
  }


  private static class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
      this.element = element;
	  next = null;
    }
  }

  //Answers for Question 1
  public int size(){//We need to count the nodes in the list, then return that number
    Node<E> current = head;
    int counter = 0;

    //General case
    while(current != null){
      counter++;
      current = current.next;
    }

    return counter;
  }

  public boolean isEmpty(){
    if(head == null){
      System.out.println("List is empty.");
      return true;
    }

    return false;
  }

  public boolean contains(E patient){
    Node<E> current = head;
    boolean isPresent = false;

    //general case
    while(current != null){
      if(current.element.equals(patient)){
        isPresent = true;
        break;
      }
      else{
        current = current.next;
      }
    }

    return isPresent;
  }
   
} // end myLinkedList class
