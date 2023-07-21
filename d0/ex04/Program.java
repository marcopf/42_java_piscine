import java.util.Scanner;

public class Program {
	public static int maxVal(int [] arr){
		int temp;

		temp = arr[0];
		for (int i = 1; i < arr.length; i++){
			if (arr[i] > temp)
				temp = arr[i];
		}
		return (temp);
	}
	public static char [] realloc(char []arr){
		char []newArr = new char [arr.length + 1];
		for (int i = 0; i < arr.length; i++){
			newArr[i] = arr[i];
		}
		return (newArr);
	}
	public static boolean isIn(char[]arr, char c){
		for (int i = 0; i < arr.length; i++){
			if (arr[i] == c)
				return true;
		}
		return false;
	}
	public static char [] fillArr(char [] arr){
		char []myArr = new char[1];

		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < myArr.length; j++){
				if (!isIn(myArr, arr[i])){
					if (i == 0){
						myArr[0] = arr[i];
					}
					else{
						myArr = realloc(myArr);
						myArr[myArr.length - 1] = arr[i];
					}
				}
			}

		}
		return (myArr);
	}
	public static void main(String [] str1){
		Scanner sc = new Scanner(System.in);
		String str;
		String mat[] = new String[1];
		char val[];

		str = sc.nextLine();
		mat[0] = new String(fillArr(str.toCharArray()));
		int counter[] = new int[mat[0].length()];
		for (int i = 0; i < counter.length; i++){
			counter[i] = 0;
		}
		for (int i = 0; i < str.toCharArray().length; i++){
			for (int j = 0; j < mat[0].length(); j++){
				if (str.toCharArray()[i] == mat[0].toCharArray()[j]){
					counter[j]++;
				}
			}
		}
		char []str_or = new char[mat[0].length()];
		str_or = mat[0].toCharArray();
		for(int i = 0; i < counter.length; i++) {
			boolean flag = false;
			for(int j = 0; j < counter.length-1; j++) {
			//Se l' elemento j e maggiore del successivo allora
			//scambiamo i valori
				if(counter[j] < counter[j + 1]) {
					int k = counter[j];
					char c =str_or[j];
					counter[j] = counter[j + 1];
					str_or[j] = str_or[j+1];
					counter[j+1] = k;
					str_or[j+1] = c;
					flag=true; //Lo setto a true per indicare che é avvenuto uno scambio
				}
			}
			if(!flag) break; //Se flag=false allora vuol dire che nell' ultima iterazione
		}
		int y = maxVal(counter) / 4;
		for (int i = 0; i <= y; i++){
			for (int j = 0; j < str_or.length && j < 10; j++){
				if (i >= y - (counter[j] / 4) + 1)
					System.out.print("#	");
				else if (i == ((y - (counter[j] / 4)))){
					System.out.print(counter[j]);
					System.out.print("	");
				}
				else{
					System.out.print(" ");
					System.out.print("	");				
				}
			}
			System.out.print("\n");
		}
		for (int i = 0; i < counter.length && i < 10; i++){
			System.out.print(str_or[i]);
			System.out.print("	");
		}
	}	
}
