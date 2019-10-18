import java.util.*;
class Node
{
	int data;
	Node next;
	Node()
	{
		next=null;
	}
	Node(int d,Node n)
	{
		data=d;
		next=n;
	}
}
class HashNode
{
	int key;
	Node head;
	HashNode()
	{
		head=null;
	}
}
class HashTable
{
	HashNode hn[]=new HashNode[10];
	void insert(int key,int n)
	{
		if(hn[key]==null)
		{
			hn[key]=new HashNode();
			hn[key].head=new Node(n,null);
			hn[key].key=key;
		}
		else
		{
			Node temp=hn[key].head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=new Node(n,null);
		}
	}
	void printList(Node n)
	{
		while(n!=null)
		{
			System.out.println(n.data);
			n=n.next;
		}
	}
	void printHash()
	{
		for(int i=0;i<10;i++)
		{
			if(hn[i]!=null)
			{
				System.out.println("i - "+hn[i].key);
				printList(hn[i].head);
			}
		}
	}
	public static void main(String args[])
	{
		HashTable HT=new HashTable();
		HT.insert(0,100);
		HT.insert(0,50);
		HT.insert(4,44);
		HT.insert(9,19);
		HT.insert(4,34);
		HT.insert(3,1043);
		HT.insert(1,111);
		HT.insert(3,13);
		HT.insert(1,1);
		HT.printHash();
	}
}