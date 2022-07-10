import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); //포켓몬 개수
		int M = Integer.parseInt(st.nextToken()); //문제 수
		
		HashMap<Integer, String> pocketMonByIndex = new HashMap<>(); //포켓몬 도감
		HashMap<String, Integer> pocketMonByName = new HashMap<>(); //포켓몬 도감
		for(int n = 1; n <= N; ++n) {
			String name = br.readLine();
			pocketMonByIndex.put(n, name);
			pocketMonByName.put(name, n);
		}
		
		for(int m = 0; m < M; ++m) {
			String quest = br.readLine();
			if(quest.charAt(0) - '0' < 10)
				sb.append(pocketMonByIndex.get(Integer.parseInt(quest)) + "\n"); //숫자
			else
				sb.append(pocketMonByName.get(quest) + "\n"); //문자
		}
		
		System.out.print(sb);
	}
	
}
