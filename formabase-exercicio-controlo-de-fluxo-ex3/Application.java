
import java.util.Scanner;

public class Application 
{
	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("x: ");
		int x = input.nextInt();
		
		System.out.print("y: ");
		int y = input.nextInt();
		
		System.out.print("z: ");
		int z = input.nextInt();
		
		System.out.println();
		
		if(x > y)
		{
			if(x > z) // x--
			{
				if(y > z) // xyz
				{
					System.out.println("x > y > z");
				}
				else // xzy
				{
					System.out.println("x > z > y");
				}
			}
			else // zxy
			{
				System.out.println("z > x > y");
			}
		}
				
		if(y > z)
		{
			if(y > x) // y--
			{
				if(z > x) // yzx
				{
					System.out.println("y > z > x");
				}
				else // yxz
				{
					System.out.println("y > x > z");
				}
			}		
		}	
		else // z--
		{
			if(y > x) // zyx
			{
				System.out.println("z > y > x");
			}
		}	
	
		input.close();
	}
}
