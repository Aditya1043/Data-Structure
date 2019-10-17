import java.util.*;
class SuffixArray
{
	class Suffix implements Comparable<Suffix>
	{
		String text;
		int index;
		Suffix(String s,int i)
		{
			text=s;
			index=i;
		}
		int length()
		{
			return text.length()-index;
		}
		char charAt(int i)
		{
			return text.charAt(index+i);
		}
		public int compareTo(Suffix sec)
		{
			if(this==sec)
				return 0;
			for(int i=0;i<this.length() && i<sec.length();i++)
			{
				if(this.charAt(i)<sec.charAt(i)) return -1;
				if(this.charAt(i)>sec.charAt(i)) return +1;
			}
			return this.length()-sec.length();
		}
	}
	Suffix suff[];
	SuffixArray(String s)
	{
		int n=s.length();
		suff=new Suffix[n];
		for(int i=0;i<n;i++)
			suff[i]=new Suffix(s,i);
		Arrays.sort(suff);
	}
	int lcp(int i)
	{
		if(i<0||i>=suff.length) throw new IllegalArgumentException();
		return lcpSuffix(suff[i],suff[i-1]);
	}
	int lcpSuffix(Suffix fir,Suffix sec)
	{
		int n=Math.min(fir.length(),sec.length());
		for(int i=0;i<n;i++)
			if(fir.charAt(i)!=sec.charAt(i)) return i;
		return n;
	}
	int index(int i)
	{
		 if(i<0||i>=suff.length) throw new IllegalArgumentException();
		 return suff[i].index;
	}
	/*public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		SuffixArray sa=new SuffixArray(s);
	}*/
}