import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] num = new int[10001];
		int N = Integer.parseInt(br.readLine());
		for(int n = 0; n < N; ++n) {
			int idx = Integer.parseInt(br.readLine());
			++num[idx];
		}
		
		for(int i = 0; i < 10001; ++i) {
			if(num[i] != 0) {
				for(int j = 0; j < num[i]; ++j)
					sb.append(i + "\n");
			}
		}
		System.out.print(sb);
	}

}
