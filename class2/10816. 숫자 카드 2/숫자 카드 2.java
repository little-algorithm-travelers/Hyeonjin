import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static HashMap<Integer, Integer> map = new HashMap<>(); //숫자, 갯수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //상근이가 가지고 있는 카드 수
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int n = 0; n < N; ++n) {
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) map.replace(num, map.get(num)+1);
			else map.put(num, 1);
		}
		
		int M = Integer.parseInt(br.readLine()); //몇개인지 구해야 할 카드 수
		st = new StringTokenizer(br.readLine(), " ");

		for(int m = 0; m < M; ++m) {
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) sb.append(map.get(num) + " ");
			else sb.append(0 + " ");
		}

		System.out.print(sb);
		
	}

}
