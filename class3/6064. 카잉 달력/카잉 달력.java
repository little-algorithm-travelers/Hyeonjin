import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for(int t = 0; t < T; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken()); //4개의 정수
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			//x는 고정, y를 변화시키면서 찾기
			int year = x % (M+1); //x == M일 수 있기 때문에 M+1로 나눔!
			int ty = (M <= N) ? x : x % N; //M이 더 큰 수인 경우도 고려!
			for(int i = 0; i < N; ++i) { //마지막 해가 아닐때까지 수행				
				int temp = ty % N == 0 ? N : ty % N; //M번째 후 ty에 해당하는 숫자 찾기
				if(temp == y) break; //찾던 해라면 break
				ty = temp + M;
				year += M; //M번째 해 후에 x값은 변화X
			}
			if(year > lcn(M, N)) sb.append(-1 + "\n"); //마지막 해를 넘는 경우
			else sb.append(year +"\n");
		}
		System.out.print(sb);
	}

	private static int lcn(int m, int n) { //최소공배수
		return (m * n) / gcf(m, n); // (두 수의 곱) / 최대공약수 = 최소공배수
	}

	private static int gcf(int m, int n) { //최대공약수
		if(n == 0) return m;
		else return gcf(n, m%n);
	}
	
}
