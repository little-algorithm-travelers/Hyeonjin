import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] min = new int[N+1];
		min[1] = 1;
		
		for(int i = 2; i <= N; ++i) {
			int m = 4; //최대 수는 4
			for(int j = 1; j*j <= i; ++j) //j*j를 더할 때 i를 구할 수 있는 이전 최소 개수
				m = Math.min(m, min[i-j*j]);
			min[i] = m + 1;
		}
		
		System.out.print(min[N]);
		
	}
	
}