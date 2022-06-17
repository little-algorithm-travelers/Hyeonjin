import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, card[], max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //카드 수
		M = Integer.parseInt(st.nextToken()); //기준 값
		
		card = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int n = 0; n < N; ++n)
			card[n] = Integer.parseInt(st.nextToken());

		combin(0, 0, 0);
		System.out.print(max);
	}
	
	//조합
	private static void combin(int sum, int idx, int cnt) {
		if(cnt == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = idx; i < N; ++i)
			if(sum+card[i] <= M) combin(sum+card[i], i+1, cnt+1); //해당 카드 선택
	}

}
