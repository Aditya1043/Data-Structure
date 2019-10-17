import java.util.*;
class Median
{
	static int minv=0,maxv=0;
	void heapify(int arr[],int i)
	{
		int f=2*i+1;
		int s=2*i+2;
		int max=i;
		if(f<maxv && arr[f]>arr[i])
			max=f;
		if(s<maxv && arr[s]>arr[max])
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
		if(f<minv && arr[f]<arr[i])
			min=f;
		if(s<minv && arr[s]<arr[min])
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
		arr[0]=arr[maxv-1];
		maxv--;
		heapify(arr,0);
	}
	
	void deleteMin(int arr[])
	{
		arr[0]=arr[minv-1];
		minv--;
		minheapify(arr,0);
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
		arr[maxv++]=in;
		insertHeapify(arr,maxv-1);
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
		arr[minv++]=in;
		mininsertHeapify(arr,minv-1);
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n;
		n=sc.nextInt();
		Median h=new Median();
		int minarr[]=new int[100];
		int maxarr[]=new int[100];
		maxarr[maxv++]=sc.nextInt();
		System.out.println(maxarr[0]);
		for(int i=1;i<n;i++)
		{
			int temp=sc.nextInt();
			if(temp<=maxarr[0])
			{
				h.insert(maxarr,temp);
			}
			else
			{
				h.mininsert(minarr,temp);
			}
			if(maxv-minv>1)
			{
				h.mininsert(minarr,maxarr[0]);
				h.deleteMax(maxarr);
			}
			else if(minv-maxv>1)
			{
				h.insert(maxarr,minarr[0]);
				h.deleteMin(minarr);
			}
			if(maxv>minv)
				System.out.println(maxarr[0]);
			else if(minv>maxv)
				System.out.println(minarr[0]);
			else
				System.out.println((minarr[0]+maxarr[0])/2);
		}

			
	}
}