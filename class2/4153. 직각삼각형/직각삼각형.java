import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 0 && b == 0 && c == 0) break;
			int max = Math.max(a, Math.max(b, c));
			
			if(max == c) checkTriangle(max, a, b, sb);
			else if(max == b) checkTriangle(max, a, c, sb);
			else checkTriangle(max, b, c, sb);
		}
		
		System.out.print(sb);
	}

	private static void checkTriangle(int max, int n, int m, StringBuilder sb) {
		if(max*max == n*n+m*m) sb.append("right" + "\n");
		else sb.append("wrong" + "\n");
	}

}
