class Arraybst
{
	int arr[]=new int[1000];
	int root=0;
	void insert(int e)
	{
		if(arr[root]==0)
			arr[root]=e;
		else
		{
			while(arr[root]!=0)
			{
				if(e<arr[root])
				{
					root=2*root+1;
				}
				else
				{
					root=2*root+2;
				}
			}
			arr[root]=e;
			root=0;
		}
	}
	void setLeft(int data,int root)
	{
		if(arr[root]==0)
			return;
		int t=(root*2)+1;
		arr[t]=data;
	}
	void setRight(int data,int root)
	{
		if(arr[root]==0)
			return;
		int t=(root*2)+2;
		arr[t]=data;
	}
	public static void main(String args[])
	{
		Arraybst b=new Arraybst();
		b.insert(100);
		b.insert(90);
		b.insert(95);
		b.insert(94);
		b.insert(96);
		b.insert(97);
		b.insert(80);
		b.insert(85);
		b.insert(75);
		b.insert(70);
		b.insert(101);
		for(int i=0;i<1000;i++)
			if(b.arr[i]!=0)
				System.out.println(b.arr[i]+" "+i);
	}
}