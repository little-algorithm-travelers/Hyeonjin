import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int K;
	static long N, len[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		K = Integer.parseInt(st.nextToken()); //오영식이 가지고 있는 랜선 개수
		N = Long.parseLong(st.nextToken()); // 필요한 랜선 개수
		
		len = new long[K];
		for(int k = 0; k < K; ++k)
			len[k] = Long.parseLong(br.readLine()); //각 랜선 길이
		
		Arrays.sort(len); //오름차순 정렬
		System.out.print(findMax());
	}
	
	private static long findMax() { //랜선 최대 길이 구하기
		long min = 1, max = len[K-1], ans = 0; //최소 길이 : 1, 최대 길이 : len[K-1]
		
		while(min <= max) {
			long mid = (max + min) / 2, count = 0; //만들 수 있는 랜선 개수
			for(int i = 0; i < K; ++i)
				count += len[i] / mid;

			if(count < N) max = mid - 1;
			else {
				min = mid + 1;
				ans = Math.max(ans, mid);
			}
		}
		return ans;
	}
	
}