import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int n = 1; n <= N; ++n)
			list.add(n);
		findK(list);
	}

	private static void findK(ArrayList<Integer> list) {
		int pos = -1;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!list.isEmpty()) {
			pos += K;
			while(pos >= list.size()) pos -= list.size();
			sb.append(list.get(pos) + ", ");
			list.remove(pos--);
		}
		sb.replace(sb.length()-2, sb.length(), ">");
		System.out.print(sb);
	}

}
