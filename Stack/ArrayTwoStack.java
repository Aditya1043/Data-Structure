public class ArrayTwoStack<E>
{
  private int CAPACITY=1000;

  private E[] data;   

  private int t1 = -1;                 
  private int t2 = CAPACITY;

  public ArrayTwoStack() 
  { 
	data= (E[]) new Object[CAPACITY];
  }

  public ArrayTwoStack(int capacity) {
	data = (E[]) new Object[capacity];
	CAPACITY=capacity;
	t2=capacity;
  }

  public int size1() { 
	return t1+1;
  }

  public int size2() { 
	return CAPACITY-t2;
  }
  
  public boolean isEmpty1() { return t1==-1; }

  public boolean isEmpty2() { return t2==CAPACITY; }
  
  public void push1(E e)
  {
	  if(t1+1==t2)
	  {
		  System.out.println("overflow");
		  return;
	  }
	  data[++t1]=e;
  }

  public void push2(E e)
  {
	  if(t2-1==t1)
	  {
		  System.out.println("overflow");
		  return;
	  }
	  data[--t2]=e;
  }
  
  public E top1() {
	  if(isEmpty1())
		 return null; 
	  return data[t1];
  }

  public E top2() {
	  if(isEmpty2())
		 return null; 
	  return data[t2];
  }
  
  public E pop1() {
	  if(isEmpty1())
	  {
		  System.out.println("underflow");
		  return null;
	  }
	  return data[t1--];
  }

  public E pop2() {
	  if(isEmpty2())
	  {
		  System.out.println("underflow");
		  return null;
	  }
	  return data[t2++];
  }

  public static void main(String[] args) {
    ArrayTwoStack<Integer> ts = new ArrayTwoStack<>(5);  // contents: ()
    ts.push1(5); 
	ts.push2(10); 
	ts.push2(15); 
	ts.push1(11); 
	ts.push2(7); 
	System.out.println("Popped element from" + 
					   " stack1 is " + ts.pop1()); 
	ts.push2(40); 
	System.out.println("Popped element from" + 
					 " stack2 is " + ts.pop2()); 
  }
}
