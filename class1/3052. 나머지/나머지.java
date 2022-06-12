import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; ++i) {
			int num = scr.nextInt() % 42;
			if(!list.contains(num)) list.add(num);
		}
		System.out.print(list.size());
		scr.close();
	}

}
