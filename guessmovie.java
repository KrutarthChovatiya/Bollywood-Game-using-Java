import java.util.*;
import java.io.*;
import java.lang.StringBuilder;
public class guessmovie 
{
	public static void main(String a[]) throws Exception
	{
		
		int i=0,j=0,k=0,count=5,dcount=0,fcount=0,point=0;
		File f1=new File("movie2.txt");
		Scanner sf=new Scanner(f1);
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		int randno=rand.nextInt(20);
		String moname=null;
		String cguess=new String();
		for(i=0;i<randno;i++)
		{
			moname=sf.nextLine();
		}
		//System.out.println(moname);
		for(i=0;i<moname.length();i++)
		{
			if(moname.charAt(i)==' ')
				cguess+=' ';
			else if(moname.charAt(i)=='a' ||moname.charAt(i)=='e' ||moname.charAt(i)=='i' ||moname.charAt(i)=='o' ||moname.charAt(i)=='u')
				cguess+=moname.charAt(i);
			else
				cguess+='_';
			/*else
			{
				int randno2=rand.nextInt(50);
				if(randno2%2==0)
				{
					cguess+='_';
				}
				else
					cguess+=moname.charAt(i);
			
			}*/
		}
		System.out.println("You have to Guess : "+cguess+"\nTotal Length : "+cguess.length());
		StringBuilder sb=new StringBuilder(cguess);
		for(i=0;i<cguess.length();i++)
		{
			if(cguess.charAt(i)=='_')
				dcount++;
		}
		//System.out.println(dcount);
		for(i=0;i<200;i++)
		{
			if(dcount==0)
			{
				break;
			}
			if(count==0)
			{
				break;
			}
			else if(fcount==dcount)
				break;
			//System.out.println("\nEnter position = ");
			//int p=sc.nextInt();
			System.out.print("Enter char = ");
			char ch2=sc.next().charAt(0);
			for(k=0;k<moname.length();k++)
			{
				if(moname.equals(sb))
				{
					break;
				}
				if(moname.charAt(k)==ch2)
				{
					if(moname.charAt(k)=='a' ||moname.charAt(k)=='e' ||moname.charAt(k)=='i' ||moname.charAt(k)=='o' ||moname.charAt(k)=='u')
					{
						point=2;
						break;
					}
					fcount++;
					//System.out.println("You guessed right\nMOVE ON NOW");
					sb.deleteCharAt(k);
					sb.insert(k,ch2);
					point=1;
					//System.out.println(fcount+" Space Filled "+(dcount-fcount)+" left");
				}
				/*else
				{
				//	System.out.println("Try again");
					count++;
				//	System.out.println("NOW only "+(5-count)+" chances lefts");
				}*/
			}
			if(point==1)
			{
				dcount=0;
				for(j=0;j<moname.length();j++)
				{
					if(sb.charAt(j)=='_')
						dcount++;
				}
				point=0;
				//fcount++;
				System.out.println("You guessed right\nMOVE ON NOW");
				//System.out.println(fcount+" Space Filled "+(dcount-fcount)+" left");
			}
			else if(point==0)
			{
				count--;
				System.out.println("Try again");
				System.out.println("NOW only "+(count)+" chances lefts");
			}
			else if(point==2)
			{
				point=0;
				System.out.println("You have entered vowel only Please Try Again !!");
			}
			System.out.println("Your Movie Name : "+sb);
			System.out.println("Blank Left : "+dcount);
		}
		if(count==0)
		{
			System.out.println("\n !! You lose !! :P ");
			System.out.println("Your movie name was  : "+moname);
		}
		else if(dcount==0)
		{
			System.out.println("\nYou Win the Game");
			System.exit(0);
		}
	}
}
