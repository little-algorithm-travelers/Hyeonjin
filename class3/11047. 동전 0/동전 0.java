import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //동전 종류
		int K = Integer.parseInt(st.nextToken()); //가치의 합
		int[] A = new int[N]; //가치 배열
		
		for(int i = 0; i < N; ++i)
			A[i] = Integer.parseInt(br.readLine()); //각각의 동전 가치
		
		int min = 0; //동전 개수
		for(int i = N-1; i >= 0 && K > 0; --i) {
			if(A[i] > K) continue;
			min += K / A[i];
			K %= A[i];
		}
		
		System.out.print(min);

	}
	
}
