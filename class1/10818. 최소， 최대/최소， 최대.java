import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int N = scr.nextInt();
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int n = 0; n < N; ++n) {
			int num = scr.nextInt();
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		System.out.print(min + " " + max);
		scr.close();
	}

}
