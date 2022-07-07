import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[N+1];
		if(N == 2) count[2] = 1;
		else if(N > 2) count[2] = count[3] = 1;
		
		for(int n = 4; n <= N; ++n) {
			int min = Integer.MAX_VALUE;
			if(n % 3 == 0) min = (min > count[n/3]+1) ? count[n/3]+1 : min; //3으로 나눠지는 경우
			if(n % 2 == 0) min = (min > count[n/2]+1) ? count[n/2]+1 : min; //2로 나눠지는 경우
			min = (min > count[n-1]+1) ? count[n-1]+1 : min; //1을 뺀 경우
			count[n] = min;
		}
		
		System.out.print(count[N]);
	}
	
}
