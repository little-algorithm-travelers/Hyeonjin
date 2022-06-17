import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int count = N;
		for(int n = 0; n < N; ++n) {
			int num = Integer.parseInt(st.nextToken());
			if(findPrimeNumber(num)) --count;
		}
		
		System.out.print(count);
	}

	private static boolean findPrimeNumber(int num) { //소수 판별
		if(num == 1) return true;
		else {
			int cnt = 1;
			for(int i = 2; i <= num; ++i) {
				if(num % i == 0) ++cnt;
				if(cnt > 2) break;
			}
			
			if(cnt > 2) return true;
			else return false;
		}
	}
	
}
