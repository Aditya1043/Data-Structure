import java.util.*;
class LRS
{
	static String lrs(String s)
	{
		int n=s.length();
		SuffixArray sa=new SuffixArray(s);
		String lrs="";
		for(int i=1;i<n;i++)
		{
			int l=sa.lcp(i);
			if(l>lrs.length())
			{
				lrs=s.substring(sa.index(i),sa.index(i)+l);
			}
		}
		return lrs;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println(lrs(s));
	}
}