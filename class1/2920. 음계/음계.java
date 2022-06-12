import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int[] num = new int[8];
		for(int i = 0; i < 8; ++i)
			num[i] = scr.nextInt();
		
		int status = -1; //0 : up, 1 : down, 2 : mix
		for(int i = 0; i < 7; ++i) {
			if(i == 0) status = (num[i] < num[i+1]) ? 0 : 1;
			else {
				if(status == 0 && num[i] < num[i+1] || status == 1 && num[i] > num[i+1]) continue;
				else {
					status = 2;
					break;
				}
			}
		}
		switch(status) {
			case 0 :
				System.out.print("ascending");
				break;
			case 1 :
				System.out.print("descending");
				break;
			case 2 :
				System.out.print("mixed");
				break;
		}
		scr.close();
	}

}
