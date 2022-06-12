import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int a = scr.nextInt();
		int b = scr.nextInt();
		System.out.print((a+b) + "\n" + (a-b) + "\n" + (a*b) + "\n" + (a/b) + "\n" + (a%b));
		scr.close();
	}

}
