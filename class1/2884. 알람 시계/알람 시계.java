import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int hour = scr.nextInt();
		int minute = scr.nextInt();
		
		if(minute >= 45) minute -= 45;
		else {
			if(hour == 0) hour = 23;
			else hour -= 1;
			minute = minute + 60 - 45;
		}
		System.out.print(hour + " " + minute);
		scr.close();
	}

}
