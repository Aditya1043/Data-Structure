class CountWords
{
	static int countWords(String s)
	{
		int inword=0;
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==' ')
			{
				inword=0;
			}
			else if(inword==0)
			{
				count++;
				inword=1;
			}
		}
		return count;
	}
	public static void main(String args[])
	{
		String str = "    One   two       three four five"; 
        System.out.println(countWords(str));
	}
}