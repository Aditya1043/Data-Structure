import java.util.*;
class BracketValidation
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
	    String s=sc.nextLine();
	    LinkedStack<Character> ls=new LinkedStack<>();
	    for(int i=0;i<s.length();i++)
	    {
			if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
			{
				ls.push(s.charAt(i));
		    }
			else
			{
				if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}')
				{
					if(ls.pop()==s.charAt(i))
					{
						System.out.println("NOT BALANCED");
						break;
					}
				}
			}
	    }
		if(ls.isEmpty())
			System.out.println("BALANCED");
		else
			System.out.println("NOT BALANCED");
	}
}