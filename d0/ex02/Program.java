import java.util.Scanner;

public class Program{

	public static int digitSum(int num){
		int sum = 0;

		while (num > 0)
		{
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	public static boolean checkPrime(int inp){
		if (inp < 2){
			return false;
		}
		for (int i = 2; i <= inp / 2; i++){
			if (inp % i == 0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] str){
		Scanner sc = new Scanner(System.in);
		int inp;
		int counter = 0;

		do{
			System.out.print("-> ");
			while (!sc.hasNextInt())
			{
				System.out.println("insert Integer pls!");
				sc.nextLine();
				System.out.print("-> ");
			}
			inp = sc.nextInt();
			if (inp == 42){
				break ;
			}
			if (checkPrime(digitSum(inp)))
				counter++;
		}while(true);
		System.out.println("Count of coffee - request - " + counter);
	}
}