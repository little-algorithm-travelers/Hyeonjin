import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int a = scr.nextInt();
		int b = scr.nextInt();
		String cmd;
		
		if(a < b) {
			cmd = "<";
		}else if(a > b) {
			cmd = ">";
		}else {
			cmd = "==";
		}
		System.out.print(cmd);
		
		scr.close();
	}

}
