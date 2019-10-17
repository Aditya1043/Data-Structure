package LinkList;
public class SinglyLinkedList<E extends Comparable<E>>
{
  //---------------- nested Node class ----------------
  /**
   * Node of a singly linked list, which stores a reference to its
   * element and to the subsequent node in the list (or null if this
   * is the last node).
   */

  private static class Node<E>
  {
    /** The element stored at this node */
    private E element;            // reference to the element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next;         // reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) 
    {
		element=e;
		next=n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() 
    { 
		return element;
    }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() 
    {
		return next;
    }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) 
    { 
		next=n;
    }
  } //----------- end of nested Node class -----------


  // instance variables of the SinglyLinkedList
  /** The head node of the list */

  private Node<E> head = null;               // head node of the list (or null if empty)

  /** The last node of the list */
  private Node<E> tail = null;               // last node of the list (or null if empty)


  /** Number of nodes in the list */
  private int size = 0;                      // number of nodes in the list


  /** Constructs an initially empty list. */
  public SinglyLinkedList() { }              // constructs an initially empty list


  // access methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() 
  {  
	return size;
  }


  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty()  { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list
   * @return element at the front of the list (or null if empty)
   */
  public E first()
  {
	if(isEmpty())
	   return null;
    return head.getElement();// returns (but does not remove) the first element
  }

  /**
   * Returns (but does not remove) the last element of the list.
   * @return element at the end of the list (or null if empty)
   */
  public E last() 
  {              // returns (but does not remove) the last element
	if(isEmpty())
		  return null;
    return tail.getElement();
  }

  // update methods
  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) 
  {    // adds element e to the front of the list
	if(head!=null)
	{
		Node<E> n=new Node<E>(e,head);
		head=n;
	}
	else
	{
		Node<E> n=new Node<E>(e,null);
		tail=head;
	}
	size++;
  }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) 
  {                 // adds element e to the end of the list
	Node<E> n=new Node<E>(e,null);
	if(tail==null)
		head=n;
	else
		tail.setNext(n);
	tail=n;
	size++;
  }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() 
  {
	if(isEmpty())
		return null;
	E temp=head.getElement();			// removes and returns the first element
    head=head.getNext();
	size--;
	return temp;
  }
  
  public E removeLast() 
  {
	if(isEmpty())
		return null;
	if(head==tail)
	{
		E temp=head.getElement();
		head=null;
		tail=null;
		size--;
		return temp;
	}
	E temp=tail.getElement();
	Node<E> walk=head;			// removes and returns the first element
	while(walk.getNext()!=tail)
		walk=walk.getNext();
	walk.setNext(null);
	tail=walk;
	size--;
	return temp;
  }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() 
  {
	String s="";
	Node temp=head;
	while(temp!=null)
	{
		s=s+String.valueOf(temp.getElement())+" ";
		temp=temp.getNext();
	}
	return s;
  }
  
  public void merge(SinglyLinkedList<E> second)
  {
	  Node<E> ptr1=head;
	  Node<E> ptr2=second.head;
	  Node<E> prev1=null;
	  Node<E> next2=ptr2.getNext();
	  while(ptr1!=null && ptr2!=null)
	  {
		  if((ptr1.getElement().compareTo(ptr2.getElement()))>0)
		  {
			  if(prev1==null)
			  {
				  head=ptr2;
				  ptr2.setNext(ptr1);
			  }
			  else
			  {
				  ptr2.setNext(ptr1);
				  prev1.setNext(ptr2);
			  }
			  prev1=ptr2;
			  ptr2=next2;
			  next2=ptr2.getNext();
			  size++;
		  }
		  else
		  {
			  prev1=ptr1;
			  ptr1=ptr1.getNext();
		  }
	  }
	  if(ptr2!=null)
	  {
		  prev1.setNext(ptr2);
		  while(prev1.getNext()!=null)
		  {
			  size++;
			  prev1=prev1.getNext();
		  }
		  tail=prev1;
	  }
  }
  
  public void insert(int position,E e)
  {
	  if(position>size+1||position<1)
		  System.out.println("invalid position");
	  else if(position==1)
		  addFirst(e);
	  else if(position==size+1)
		  addLast(e);
	  else
	  {
		  Node<E> temp=head;
		  for(int i=2;i<position;i++)
		  {
			  temp=temp.getNext();
		  }
		  Node<E> temp1=new Node<>(e,temp.getNext());
		  temp.setNext(temp1);
		  size++;
	  }
  }
  
  public void delete(int position)
  {
	  if(position>size||position<1)
		  System.out.println("invalid position");
	  else if(position==1)
		  removeFirst();
	  else if(position==size+1)
		  removeLast();
	  else
	  {
		  Node<E> temp=head;
		  for(int i=2;i<position;i++)
		  {
			  temp=temp.getNext();
		  }
		  temp.setNext(temp.getNext().getNext());
		  size--;
	  }
  }
  
  public int search(E e)
  {
	  Node<E> temp=head;
	  int i=1;
	  while(temp!=null)
	  {
		  if(temp.getElement()==e)
		  {
			  return i;
		  }
		  i++;
		  temp=temp.getNext();
	  }
	  return -1;
  }
  
  public E mergePoint(SinglyLinkedList<E> sec)
  {
	  Node<E> ptr=head;
	  Node<E> ptr1=sec.head;
	  int diff=sec.size-size;
	  if(diff>0)
	  {
		  for(int i=0;i<diff;i++)
		  {
			  ptr1=ptr1.getNext();
		  }
	  }
	  else
	  {
		  for(int i=0;i<-diff;i++)
		  {
			  ptr=ptr.getNext();
		  }
	  }
	  while(ptr!=null)
	  {
		if(ptr==ptr1)
		{
			return ptr.getElement();
		}	
		ptr1=ptr1.getNext();
		ptr=ptr.getNext();
	  }
	  return null;
  }
  
  public void createmergepoint(SinglyLinkedList<E> sec)
  {
	  Node<E> f=head;
	  Node<E> s=sec.head;
	  while(f.getNext()!=null)
	  {
		  f=f.getNext();
		  s=s.getNext();
	  }
	  f.setNext(s.getNext());
	  size=sec.size();
	  tail=sec.tail;
  }
  
  public void reverse()
  {
	  Node<E> curr=head;
	  Node<E> next=curr.getNext();
	  Node<E> nnext=next.getNext();
	  curr.setNext(null);
	  while(nnext!=null)
	  {
		next.setNext(curr);
		curr=next;
		next=nnext;
		nnext=next.getNext();
	  }
	  next.setNext(curr);
	  tail=head;
	  head=next;
  }
  
  public E loopstartpoint()
  {
	  if(head==null || head.getNext()==null)
		  return null;
	  Node<E> slow=head.getNext();
	  Node<E> fast=head.getNext().getNext();
	  while(fast!=null && fast.getNext()!=null)
	  {
		  if(slow==fast)
		  {
			  break;
		  }
		  slow=slow.getNext();
		  fast=fast.getNext().getNext();
	  }
	  if(slow!=fast)
		  return null;
	  slow=head;
	  while(slow!=fast)
	  {
		  fast=fast.getNext();
		  slow=slow.getNext();
	  }
	  return slow.getElement();
  }
  
  public void createloop()
  {
	  Node<E> temp=head;
	  temp=temp.getNext().getNext().getNext();
	  tail.setNext(temp);
  }
}
