import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = scr.nextInt();
		
		for(int t = 0; t < T; ++t) {
			int k = scr.nextInt(); //층
			int n = scr.nextInt(); //호
			int[][] house = new int[k+1][n+1]; //각각 집에 사는 사람 수
			
			for(int b = 1; b <= n; ++b) house[0][b] = b; //가장 아래층 초기화

			for(int a = 1; a <= k; ++a)
				for(int b = 1; b <= n; ++b) {
					if(b == 1) house[a][b] = house[a-1][b];
					else house[a][b] = house[a][b-1] + house[a-1][b];
				}
			
			sb.append(house[k][n] + "\n");
		}
		
		System.out.print(sb);
		scr.close();
		
	}

}
