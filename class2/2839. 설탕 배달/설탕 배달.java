import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //설탕 무게
		
		int[] count = new int[N+1];
		Arrays.fill(count, -1); //-1로 초기화
		if(N < 5) count[3] = 1;
		else count[3] = count[5] = 1;
		
		for(int n = 6; n <= N; ++n) {
			if(count[n-3] != -1 && count[n-5] != -1) count[n] = Math.min(count[n-3], count[n-5]) + 1;
			else if(count[n-3] != -1) count[n] = count[n-3] + 1;
			else if(count[n-5] != -1) count[n] = count[n-5] + 1;
		}
		
		System.out.print(count[N]);
	}

}
