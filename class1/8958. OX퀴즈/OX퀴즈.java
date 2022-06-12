import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; ++t) {
			char[] ch = br.readLine().toCharArray();
			int total = 0, score = 0;
			for(int i = 0; i < ch.length; ++i) {
				if(ch[i] == 'X') {
					score = 0;
					continue;
				}
				total += ++score;
			}
			sb.append(total + "\n");
		}
		
		System.out.print(sb);
	}

}
