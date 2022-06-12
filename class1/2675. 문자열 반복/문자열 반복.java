import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; ++t) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			char[] c = st.nextToken().toCharArray();
			
			for(int i = 0; i < c.length; ++i) {
				for(int r = 0; r < R; ++r)
					sb.append(c[i]);
			}
			System.out.println(sb);
		}

	}

}
