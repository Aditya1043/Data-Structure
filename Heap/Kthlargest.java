import java.util.*;
class Kthlargest
{
	static int n=0;
	
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
	
	void deleteMin(int arr[])
	{
		arr[0]=arr[n-1];
		n--;
		minheapify(arr,0);
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
		int ele=sc.nextInt();
		Kthlargest h=new Kthlargest();
		int arr[]=new int[100];
		System.out.println("Enter the value of k");
		int k=sc.nextInt();
		for(int i=0;i<ele;i++)
		{
			int temp=sc.nextInt();
			if(i<k-1)
			{
				h.mininsert(arr,temp);
				System.out.println("not having k elements");
			}
			else if(i==k-1)
			{
				h.mininsert(arr,temp);
				System.out.println(arr[0]);
			}
			else
			{
				if(temp<=arr[0])
					System.out.println(arr[0]);
				else
				{
					h.deleteMin(arr);
					h.mininsert(arr,temp);
					System.out.println(arr[0]);
				}
			}
		}
	}
}