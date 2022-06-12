import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		char[] ch = scr.next().toCharArray();
		int[] position = new int[26];
		Arrays.fill(position, -1);
		
		for(int i = 0; i < ch.length; ++i) {
			if(position[(int)(ch[i] - 97)] != -1) continue;
			position[(int)(ch[i] - 97)] = i;
		}
		for(int i = 0; i < position.length; ++i)
			sb.append(position[i] + " ");
		System.out.print(sb);
		scr.close();
	}

}
