import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			int a = scr.nextInt();
			int b = scr.nextInt();
			if(a == 0 && b == 0) break;
			sb.append(a+b + "\n");
		}
		System.out.print(sb);
		scr.close();
	}

}
