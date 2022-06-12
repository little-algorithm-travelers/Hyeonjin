import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int T = scr.nextInt();
		for(int t = 0; t < T; ++t) {
			int a = scr.nextInt();
			int b = scr.nextInt();
			System.out.println(a+b);
		}
		scr.close();
	}

}
