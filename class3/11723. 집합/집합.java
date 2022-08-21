import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int M = Integer.parseInt(br.readLine()); //연산의 수
		int[] numx = new int[21]; //1~20 (1 : 있음, 0 : 없음)
		
		for(int m = 0; m < M; ++m) {
			st = new StringTokenizer(br.readLine(), " ");
			if(st.countTokens() == 1) {
				switch(st.nextToken()) {
					case "all" : Arrays.fill(numx, 1); break; //1~20까지 모두 존재
					case "empty" : Arrays.fill(numx, 0); break; //공집합
				}
			}else {
				String order = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				switch(order) {
					case "add" : numx[x] = 1; break;
					case "remove" : numx[x] = 0; break;
					case "check" : sb.append(numx[x] + "\n"); break;
					case "toggle" : numx[x] = (numx[x] == 0) ? 1 : 0; break;
				}
			}
		}

		System.out.print(sb);
		
	}

}
