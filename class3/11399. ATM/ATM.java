import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //사람 수
		int[] P = new int[1001]; //돈 인출하는데 걸리는 시간
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; ++i) {
			int n = Integer.parseInt(st.nextToken());
			++P[n]; //돈이 인출하는 데 해당 초만큼 걸리는 사람들의 수
		}
		
		int count = 0; // 사람 수 셀 변수
		int min = 0, bf = 0; //최소 시간, 이전 사람의 필요한 시간
		
		for(int i = 1; i <= 1000; ++i) {
			if(P[i] == 0) continue;
			else if(count == N) break;
			else {
				for(int j = 0; j < P[i]; ++j) {
					min += i + bf;
					bf = i + bf;
				}
				count += P[i];
			}
		}
		
		System.out.println(min);
	}
	
}
