import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] zero, one;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; ++t) {
			int N = Integer.parseInt(br.readLine());
			zero = new int[N+1];
			one = new int[N+1];
			if(N <= 0) zero[0] = 1;
			else zero[0] = one[1] = 1;
			fibo(N);
			sb.append(zero[N] + " " + one[N] + "\n");
		}
		System.out.print(sb);
	}
	
	private static void fibo(int N) {
		for(int n = 2; n <= N; ++n) {
			zero[n] = zero[n-1] + zero[n-2];
			one[n] = one[n-1] + one[n-2];
		}
	}

}
