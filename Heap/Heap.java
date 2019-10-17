import java.util.*;
class Heap
{
	static int n;
	void heapify(int arr[],int i)
	{
		int f=2*i+1;
		int s=2*i+2;
		int max=i;
		if(f<n && arr[f]>arr[i])
			max=f;
		if(s<n && arr[s]>arr[max])
			max=s;
		if(max!=i)
		{
			int temp=arr[i];
			arr[i]=arr[max];
			arr[max]=temp;
			heapify(arr,max);
		}		
	}
	
	void minheapify(int arr[],int i)
	{
		int f=2*i+1;
		int s=2*i+2;
		int min=i;
		if(f<n && arr[f]<arr[i])
			min=f;
		if(s<n && arr[s]<arr[min])
			min=s;
		if(min!=i)
		{
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
			minheapify(arr,min);
		}	
	}
	
	void deleteMax(int arr[])
	{
		arr[0]=arr[n-1];
		n--;
		heapify(arr,0);
	}
	
	void deleteMin(int arr[])
	{
		arr[0]=arr[n-1];
		n--;
		minheapify(arr,0);
	}
	
	void sortHeap(int arr[])
	{
		int sz=n;
		while(n>1)
		{
			int temp=arr[0];
			arr[0]=arr[n-1];
			arr[n-1]=temp;
			n--;
			heapify(arr,0);
		}
		n=sz;
	}
	
	void sortminHeap(int arr[])
	{
		int sz=n;
		while(n>1)
		{
			int temp=arr[0];
			arr[0]=arr[n-1];
			arr[n-1]=temp;
			n--;
			minheapify(arr,0);
		}
		n=sz;
	}
		
	void insertHeapify(int arr[],int i)
	{
		int p;
		if(i%2==0)
			p=(i/2)-1;
		else
			p=i/2;
		int max=p;
		if(p>=0 && arr[i]>arr[p])
			max=i;
		if(max!=p)
		{
			int temp=arr[p];
			arr[p]=arr[i];
			arr[i]=temp;
			insertHeapify(arr,p);
		}		
	}
	
	void insert(int arr[],int in)
	{
		arr[n++]=in;
		insertHeapify(arr,n-1);
	}
	
	void mininsertHeapify(int arr[],int i)
	{
		int p;
		if(i%2==0)
			p=(i/2)-1;
		else
			p=i/2;
		int min=p;
		if(p>=0 && arr[i]<arr[p])
			min=i;
		if(min!=p)
		{
			int temp=arr[p];
			arr[p]=arr[i];
			arr[i]=temp;
			mininsertHeapify(arr,p);
		}		
	}
	
	void mininsert(int arr[],int in)
	{
		arr[n++]=in;
		mininsertHeapify(arr,n-1);
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		Heap h=new Heap();
		int arr[]=new int[100];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		/*for(int i=(n/2)-1;i>=0;i--)
			h.minheapify(arr,i);

		h.deleteMin(arr);

		h.sortminHeap(arr);
		System.out.println("Enter the element to insert");
		int in=sc.nextInt();
		h.mininsert(arr,in);
		System.out.println();
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);*/
	}
}