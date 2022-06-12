import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int first = scr.nextInt();
		int second = scr.nextInt();
		
		int temp1 = first, temp2 = second, ans = 0;
		while(temp1 != 0) {
			if(temp1 % 10 > temp2 % 10) {
				ans = first;
				break;
			}else if(temp1 % 10 < temp2 % 10) {
				ans = second;
				break;
			}else {
				temp1 /= 10;
				temp2 /= 10;
			}
		}
		
		int res = 0;
		for(int i = 2; i >= 0; --i) {
			res += (ans % 10) * Math.pow(10, i);
			ans /= 10;
		}
		System.out.print(res);
		scr.close();
	}

}
