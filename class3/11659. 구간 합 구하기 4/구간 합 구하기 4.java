import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, num[], totalSum[];
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //수의 개수
		int M = Integer.parseInt(st.nextToken()); //합 구할 횟수
		num = new int[N+1]; //숫자 배열(시작 위치:1)
		totalSum = new int[N+1]; // 1위치부터 특정 위치까지의 합 배열
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; ++i) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int m = 0; m < M; ++m) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			if(totalSum[j] == 0) sum(j);
			sb.append((totalSum[j] - totalSum[i-1]) + "\n"); //구간 합 = (0~j위치 까지 합) - (0~i-1위치 까지 합)
		}

		System.out.print(sb);
		
	}
	
	private static void sum(int j) {
		for(int n = 1; n <= j; ++n)
			totalSum[n] = num[n] + totalSum[n-1];
	}

}
