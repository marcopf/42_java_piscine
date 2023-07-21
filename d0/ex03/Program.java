import java.util.Scanner;


public class Program {
	public static void main(String[] str){
		Scanner sc = new Scanner(System.in);
		int counter = 1;
		long arr = 0;
		long temp = 0;
		long val;
		int multiplier = 1;
		String inp;

		while (true)
		{
			inp = sc.nextLine();
			if (!inp.equals("Week " + counter) || counter > 18){
				System.err.println("illegalArgument");
				return ;
			}
			for (int i = 0; i < 5; i++){
				try{
					val = sc.nextInt();
				} catch (Exception e){
					System.err.println("illegalArgument");
					return ;
				}
				if (val < 1 || val > 9){
					System.err.println("illegalArgument");
					return ;
				}
				if (i == 0)
					temp = val;
				else if (val < temp)
					temp = val;
			}
			sc.nextLine();
			arr += multiplier * temp;
			multiplier *= 10;
			counter++;
			temp = 0;
		}
		System.out.println(arr);
		temp = 1;
		while (arr > 0)
		{
			val = arr % 10;
			System.out.print("Week ");
			System.out.print(temp++);
			System.out.print(" ");
			while (val-- > 0)
				System.out.print("=");
			System.out.println(">");
			arr /= 10;
		}
	}
}
