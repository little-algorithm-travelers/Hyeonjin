import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, zero[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		zero = new int[N+1];
		factorial(1, 1);
		System.out.print(zero[N]);
	}

	private static void factorial(int n, int s) {
		if(n > N) return;
		s *= n;

		char[] temp = Integer.toString(s).toCharArray();
		int next = 0, count = 0;
		for(int i = temp.length-1; i >= 0; --i) {
			int num = temp[i] - '0';
			if(num != 0) {
				int cnt = 0;
				for(int j = i; j >= 0 && cnt < 4; --j) {
					next = (temp[j] - '0') * (int)Math.pow(10, cnt) + next;
					++cnt;
				}
				break;
			}
			++count;				
		}
		zero[n] = zero[n-1] + count;
		factorial(n+1, next);
	}
	
}
