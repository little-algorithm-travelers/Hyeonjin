import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] idea = new int[11];
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		idea[1] = 1;
		for(int i = 2; i <= 10; ++i)
			perm(0, i);
		
		for(int t = 0; t < T; ++t) {
			int n = Integer.parseInt(br.readLine());
			sb.append(idea[n] + "\n");
		}
		
		System.out.print(sb);
	}
	
	private static void perm(int sum, int num) { //방법 찾기
		if(sum > num) return; //구하려는 수보다 큰 경우
		if(sum == num) { //구하려는 수인 경우
			++idea[num]; //방법 1 증가
			return;
		}

		for(int i = 1; i <= 3; ++i) //1~3 숫자 더하기
			perm(sum+i, num);
	}
	
}
