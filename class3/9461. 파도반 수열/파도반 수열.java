import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[] P; //수열 P
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		P = new long[101]; //1 ≤ N ≤ 100
		//문제 조건에 등장
		P[1] = P[2] = P[3] = 1;
		P[4] = P[5] = 2;
		P[6] = 3;
		P[7] = 4;
		P[8] = 5;
		P[9] = 7;
		P[10] = 9;
		
		for(int t = 0; t < T; ++t) {
			int N = Integer.parseInt(br.readLine());
			if(P[N] == 0) findP(N);
			sb.append(P[N] + "\n");
		}
		System.out.print(sb);
	}
	
	private static long findP(int n) { // P(N) 찾기
		if(P[n] != 0) return P[n];
		return P[n] = findP(n-1) + findP(n-5);
	}
	
}
