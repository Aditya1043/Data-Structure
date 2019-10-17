import java.util.*;
import javafx.util.*; 
class Btree
{
	class Node
	{
		Node(int e,Node l,Node r)
		{
			data=e;
			left=l;
			right=r;
		}
		int data;
		Node left;
		Node right;
		Node getRight()
		{
			return right;
		}
		void setRight(Node n)
		{
			this.right=n;
		}
		Node getLeft()
		{
			return left;
		}
		void setLeft(Node n)
		{
			this.left=n;
		}
		int getData()
		{
			return this.data;
		}
		void setData(int data)
		{
			this.data=data;
		}
	}
	private Node root=null;
	Node getRoot()
	{
		return root;
	}
	void printPreOrder(Node n)
	{
		if(n!=null)
		{
			System.out.println(n.data);
			printPreOrder(n.left);
			printPreOrder(n.right);
		}
	}
	void printPostOrder(Node n)
	{
		if(n!=null)
		{
			printPostOrder(n.left);
			printPostOrder(n.right);
			System.out.println(n.data);
		}
	}
	void printInOrder(Node n)
	{
		if(n!=null)
		{
			printInOrder(n.left);
			System.out.println(n.data);
			printInOrder(n.right);
		}
	}
	void insert(int e)
	{
		Node n=new Node(e,null,null);
		Node temp=root;
		if(root==null)
			root=n;
		else
		{
			while(temp!=null)
			{
				if(e>temp.getData())
				{
					if(temp.getRight()==null)
					{
						temp.setRight(n);
						break;
					}
					temp=temp.getRight();
				}
				else
				{
					if(temp.getLeft()==null)
					{
						temp.setLeft(n);
						break;
					}
					temp=temp.getLeft();
				}
			}
		}
	}
	void pathSum(Node n,int sum)
	{
		if(n==null)
			return;
		else
		{
			if(n.getRight()==null && n.getLeft()==null)
			{
				sum+=n.getData();
				System.out.println(sum);
				return;
			}
			else
			{
				
				sum+=n.getData();
				pathSum(n.getLeft(),sum);
				pathSum(n.getRight(),sum);
			}
		}
	}
    int maxLength(Node n)
	{
		if(n==null)
			return 0;
		else
		{
			int ld=maxLength(n.getLeft());
			int rd=maxLength(n.getRight());
			if(ld>rd)
				return ld+1;
			else
				return rd+1;
		}
	}
	boolean printPath(Node node,int sum)
	{
		if(sum==0)
			return true;
		if(node==null)
			return false;
		boolean left=printPath(node.getLeft(),sum-node.getData());
		boolean right=printPath(node.getRight(),sum-node.getData());
		if(left||right)
			System.out.println(node.getData());
		return left||right;
	}
	int elementsOfMaxPath(Node n)
	{
		if(n==null)
			return 0;
		else
		{
			int ld=elementsOfMaxPath(n.getLeft());
			int rd=elementsOfMaxPath(n.getRight());
			if(ld>rd)
				return ld+n.data;
			else
				return rd+n.data;
		}
	}
	void levelOrder(Node n)
	{
		if(n==null)
			return;
		Queue<Node> queue = new LinkedList<Node>(); 
		queue.add(n);
		while(!queue.isEmpty())
		{
			Node temp=queue.poll();
			System.out.println(temp.data);
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
	}
	void intraversalStack(Node n)
	{
		if(n==null)
			return;
		Stack<Node> stack = new Stack<Node>();
		while(n!=null || !stack.isEmpty())
		{
			while(n!=null)
			{
				stack.push(n);
				n=n.getLeft();
			}
			n=stack.pop();
			System.out.println(n.getData());
			n=n.getRight();
		}
	}
	void pretraversalStack(Node n)
	{
		if(n==null)
			return;
		Stack<Node> stack = new Stack<Node>();
		stack.push(n);
		while(!stack.isEmpty())
		{
			Node temp=stack.pop();
			System.out.println(temp.getData());
			if(temp.getRight()!=null)
				stack.push(temp.getRight());
			if(temp.getLeft()!=null)
				stack.push(temp.getLeft());
		}
	}
	void posttraversalStack(Node n)
	{
		if(n==null)
			return;
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(n);
		while(!s1.isEmpty())
		{
			Node temp=s1.pop();
			s2.push(temp);
			if(temp.getLeft()!=null)
				s1.push(temp.getLeft());
			if(temp.getRight()!=null)
				s1.push(temp.getRight());
		}
		while(!s2.isEmpty())
		{
			Node temp=s2.pop();
			System.out.println(temp.getData());
		}
	}
	void spiralLevel(Node n)
	{
		if(n==null)
			return;
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(n);
		while(!s1.isEmpty() || !s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				Node temp=s1.pop();
				System.out.println(temp.getData());
				if(temp.getRight()!=null)
					s2.push(temp.getRight());
				if(temp.getLeft()!=null)
					s2.push(temp.getLeft());
			}
			while(!s2.isEmpty())
			{
				Node temp=s2.pop();
				System.out.println(temp.getData());
				if(temp.getLeft()!=null)
					s1.push(temp.getLeft());
				if(temp.getRight()!=null)
					s1.push(temp.getRight());
			}
		}
	}
	void reverseLevel(Node n)
	{
		if(n==null)
			return;
		Stack<Node> s1 = new Stack<Node>();
		Queue<Node> Q = new LinkedList();
		Q.add(n);
		while(!Q.isEmpty())
		{
			Node temp=Q.remove();
			s1.push(temp);
			if(temp.getRight()!=null)
				Q.add(temp.getRight());
			if(temp.getLeft()!=null)
				Q.add(temp.getLeft());
		}
		while(!s1.isEmpty())
		{
			Node temp=s1.pop();
			System.out.println(temp.getData());
		}
	}
	void leftToRight(Node n,int h)
	{
		if(n==null)
			return;
		if(h==1)
			System.out.println(n.getData());
		else if(h>1)
		{
			leftToRight(n.getLeft(),h-1);
			leftToRight(n.getRight(),h-1);
		}
	}
	void rightToLeft(Node n,int h)
	{
		if(n==null)
			return;
		if(h==1)
			System.out.println(n.getData());
		else if(h>1)
		{
			rightToLeft(n.getRight(),h-1);
			rightToLeft(n.getLeft(),h-1);
		}
	}
	void reverseSpiralLevel(Node n,int h)
	{
		int flag=0;
		for(int i=h;i>=1;i--)
		{
			if(flag==0)
			{
				leftToRight(n,i);
				flag=1;
			}
			else
			{
				rightToLeft(n,i);
				flag=0;
			}
		}
	}
	void printVertical(Node n)
	{
		if(n==null)
			return;
		Queue<Pair<Node,Integer>> q=new LinkedList<Pair<Node,Integer>>(); 
		SortedMap<Integer,LinkedList<Integer>> m=new TreeMap<Integer,LinkedList<Integer>>();
		int hd=0;
		q.add(new Pair<Node,Integer> (n,hd));
		while(!q.isEmpty())
		{
			Pair<Node,Integer> p=q.remove();
			hd=p.getValue();
			Node temp=p.getKey();
			if(!m.containsKey(hd))
			{
				LinkedList<Integer> z=new LinkedList<Integer>(); 
				z.add(temp.getData());
				m.put(hd,z);
			}
			else
			{
				m.get(hd).add(temp.getData());
			}
			if(temp.getLeft()!=null)
				q.add(new Pair<Node,Integer> (temp.getLeft(),hd-1));
			if(temp.getRight()!=null)
				q.add(new Pair<Node,Integer> (temp.getRight(),hd+1));
		}
		System.out.println("Vertical Order");
		for(Map.Entry<Integer,LinkedList<Integer>> me:m.entrySet())
		{
			//System.out.println(me.getKey());
			LinkedList<Integer> z=me.getValue();
			ListIterator list_Iter = z.listIterator(); 
			while(list_Iter.hasNext()) 
			{ 
				System.out.println(list_Iter.next()); 
			} 
		}
		System.out.println("Top View");
		for(Map.Entry<Integer,LinkedList<Integer>> me:m.entrySet())
		{
			System.out.println(me.getValue().getFirst()); 
		}
		System.out.println("Bottom View");
		for(Map.Entry<Integer,LinkedList<Integer>> me:m.entrySet())
		{
			System.out.println(me.getValue().getLast());
		}
	}
	boolean checkBST(Node n,Node l,Node r)
	{
		if(n==null)
			return true;
		if(l!=null && n.getData()<=l.getData())
			return false;
		if(r!=null && n.getData()>=r.getData())
			return false;
		return checkBST(n.getLeft(),l,n) && checkBST(n.getRight(),n,r);
	}
	int diameter(Node n)
	{
		if(n==null)
			return 0;
		int lh=maxLength(n.getLeft());
		int rh=maxLength(n.getRight());
		
		int ld=diameter(n.getLeft());
		int rd=diameter(n.getRight());
		
		int a=Math.max(lh+rh+1,Math.max(ld,rd));
		
		return a;
	}
	Node concatenate(Node l,Node r)
	{
		if(l==null)
			return r;
		if(r==null)
			return l;
		
		Node leftLast=l.getLeft();
		Node rightLast=r.getLeft();
		
		leftLast.setRight(r);
		r.setLeft(leftLast);
		
		l.setLeft(rightLast);
		rightLast.setRight(l);
		return l;
	}
	Node treeToCDLL(Node n)
	{
		if(n==null)
			return null;
		Node l=treeToCDLL(n.getLeft());
		Node r=treeToCDLL(n.getRight());
		
		n.setLeft(n);
		n.setRight(n);
		
		return concatenate(concatenate(l,n),r);
	}
	void print(Node head)
	{
		Node itr=head;
		do
		{
			System.out.println(head.getData());
			head=head.getRight();
		}
		while(itr!=head);
	}
	Node lowestAncestor(Node n,int n1,int n2)
	{
		if(n==null)
			return null;
		if(n.getData()==n1 || n.getData()==n2)
			return n;
		Node a=lowestAncestor(n.getLeft(),n1,n2);
		Node b=lowestAncestor(n.getRight(),n1,n2);
		
		if(a!=null && b!=null)
			return n;
		
		if(a!=null)
			return a;
		if(b!=null)
			return b;
		return null;
	}
	void printNode(Node temp)
	{
		System.out.println(temp.getData());
	}
	void deleteTree(Node n)
	{
		if(n==null)
			return;
		
		deleteTree(n.getLeft());
		deleteTree(n.getRight());
		System.out.println(n.getData());
		n=null;
	}
	int minValue(Node n)
	{
		int temp=0;
		while(n!=null)
		{
			temp=n.getData();
			n=n.getLeft();	
		}
		return temp;
	}
	Node deleteNode(Node n,int d)
	{
		if(n==null)
			return null;
		if(d>n.getData())
			n.setRight(deleteNode(n.getRight(),d));
		else if(d<n.getData())
			n.setLeft(deleteNode(n.getLeft(),d));
		else
		{
			if(n.getLeft()==null)
				return n.getRight();
			else if(n.getRight()==null)
				return n.getLeft();
			n.setData(minValue(n.getRight()));
			n.setRight(deleteNode(n.getRight(),n.getData()));
		}
		return n;
	}
	Node mirrorImage(Node n)
	{
		if(n==null)
			return null;
		Node l=mirrorImage(n.getLeft());
		Node r=mirrorImage(n.getRight());
		
		n.setLeft(r);
		n.setRight(l);
		
		return n;
	}
	boolean checkMirror(Node n,Node n1)
	{
		if(n==null && n1==null)
			return true;
		if(n==null || n1==null)
			return false;
		
		return n.getData()==n1.getData() && checkMirror(n.getLeft(),n1.getRight()) && checkMirror(n.getRight(),n1.getLeft());
	}
	int nodeIndex=0;
	Node buildTree(int in[],int pre[],int s,int e)
	{
		if(s>e)
			return null;
		Node temp=new Node(pre[nodeIndex++],null,null);
		
		if(s==e)
			return temp;
		
		int ind=searchIndex(in,s,e,temp.getData());
		
		temp.setLeft(buildTree(in,pre,s,ind-1));
		temp.setRight(buildTree(in,pre,ind+1,e));
		
		return temp;
	}
	int searchIndex(int in[],int s,int e,int value)
	{
		int i;
		for(i=s;i<=e;i++)
			if(in[i]==value)
				return i;
		return i;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Btree b=new Btree();
		/*Btree b1=new Btree();
		b1.insert(10);
		b1.insert(2);
		b1.insert(3);
		b1.insert(4);
		b1.insert(5);
		b.insert(10);
		b.insert(15);
		b.insert(3);
		b.insert(1);
		b.insert(5);
		b.insert(2);*/
		/*b.insert(100);
		b.insert(90);
		b.insert(95);
		b.insert(94);
		b.insert(96);
		b.insert(97);
		b.insert(80);
		b.insert(85);
		b.insert(75);
		b.insert(70);
		b.insert(101);*/
		//b.printInOrder(b.getRoot());
		//b.printPostOrder(b.getRoot());
		//b.printPreOrder(b.getRoot());
		//b.pathSum(b.getRoot(),0);
		//System.out.println(b.maxLength(b.getRoot()));
		/*int max=b.elementsOfMaxPath(b.getRoot());
		System.out.println("MAX SUM IS "+max);
		b.printPath(b.getRoot(),max);*/
		//b.levelOrder(b.getRoot());
		//b.intraversalStack(b.getRoot());
		//b.pretraversalStack(b.getRoot());
		//b.posttraversalStack(b.getRoot());
		//b.spiralLevel(b.getRoot());
		//b.reverseLevel(b.getRoot());
		/*int height=b.maxLength(b.getRoot());
		b.reverseSpiralLevel(b.getRoot(),height);*/
		//b.printVertical(b.getRoot());
		/*if(b.checkBST(b.getRoot(),null,null))
			System.out.println("Yes");
		else
			System.out.println("No");*/
		//System.out.println(b.diameter(b.getRoot()));
		/*Node temp=b.lowestAncestor(b.getRoot(),94,101);
		b.printNode(temp);*/
		/*Node head=b.treeToCDLL(b.getRoot());
		b.print(head);*/
		//b.deleteTree(b.getRoot());
		/*b.deleteNode(b.getRoot(),95);
		b.printInOrder(b.getRoot());*/
		/*b.mirrorImage(b.getRoot());
		b.printInOrder(b.getRoot());*/
		/*if(b.checkMirror(b.getRoot(),b1.getRoot()))
			System.out.println("Yes");
		else
			System.out.println("No");*/
        /*int in[] = new int[] { 4, 2, 5, 1, 6, 3 }; 
        int pre[] = new int[] { 1, 2, 4, 5, 3, 6 };
		int len = in.length; 
        Node root=b.buildTree(in, pre, 0, len - 1); 
        b.printInOrder(root);*/
	}
}