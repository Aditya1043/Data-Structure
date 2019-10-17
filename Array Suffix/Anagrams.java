import java.util.*;
class Anagrams
{
	class Suffix
	{
		String text;
		int index;
		Suffix(String s,int i)
		{
			text=s;
			index=i;
		}
	}
	static class compStr implements Comparator<Suffix> { 
        public int compare(Suffix a, Suffix b) 
        { 
            return a.text.compareTo(b.text); 
        } 
    } 
	Suffix suff[];
	Anagrams(String s[])
	{
		int n=s.length;
		suff=new Suffix[n];
		for(int i=0;i<n;i++)
		{
			char temp[] = s[i].toCharArray(); 
			Arrays.sort(temp);
			suff[i]=new Suffix(new String(temp),i);
		}
		Arrays.sort(suff,new compStr());
		for(int i=0;i<n;i++)
			System.out.println(s[suff[i].index]);
	}
	public static void main(String args[])
	{
		String dic[] = { "cat", "dog", "tac", "god", "act" }; 
		Anagrams a=new Anagrams(dic);
	}
}