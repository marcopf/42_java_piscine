import java.util.Scanner;

public class Program{
	public static void main(String[] str){
		Scanner sc = new Scanner(System.in);
		int inp;

		System.out.print("-> ");
		while (!sc.hasNextInt())
		{
			System.out.println("insert Integer pls!");
			sc.nextLine();
			System.out.print("-> ");
		}
		inp = sc.nextInt();
		if (inp < 2){
			System.err.println("IllegalArgument");
			return ;
		}
		for (int i = 2; i <= inp / 2; i++){
			if (inp % i == 0){
				System.out.println("false " + i);
				return ;
			}
		}
		System.out.println("True " + inp / 2);
	}
}