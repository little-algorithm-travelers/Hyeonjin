import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int min = Math.min(N, M), max = Math.max(N, M);
		
		while(true) {
			if(N%min == 0 && M%min == 0) break;
			--min;
		}
		
		while(true) {
			if(max%N == 0 && max%M == 0) break;
			max += Math.max(N, M);
		}
		
		System.out.print(min + "\n" + max);
	}

}
