import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int M, N;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		for(int i = (M == 1) ? M+1 : M; i <= N; ++i)
			if(i == 2 || i % 2 != 0) findPrime(i); //소수 찾기
		
		System.out.print(sb);
	}
	
	private static void findPrime(int num) {
		int cnt = 2; //1과 자기 자신
		int limit = (int) ((num < 10) ? num - 1 : Math.sqrt(num)); //N의 양의 제곱근 이하의 수
		for(int n = 2; n <= limit; ++n) {
			if(num % n == 0) ++cnt;
			if(cnt > 2) break; //1과 자기 자신 이외의 숫자를 약수로 가질 경우
		}
		
		if(cnt <= 2) sb.append(num + "\n");	
	}

}
