import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	// 클래스별 옷가지수에 1을 더해서 입지 않은 경우까지 고려
	// 그리고 각 클래스별 경우의 수을 곱해주고 아무것도 입지 않은 경우를 빼줌
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		HashMap<String, Integer> map = new HashMap<>(); //의상 정보 map
		
		for(int t = 0; t < T; ++t) {
			int N = Integer.parseInt(br.readLine());
			map.clear();
			
			for(int n = 0; n < N; ++n) {
				st = new StringTokenizer(br.readLine(), " ");
				String name = st.nextToken();
				String type = st.nextToken();
				
				if(!map.containsKey(type)) map.put(type, 1); //의상 타입 갯수
				else map.replace(type, map.get(type)+1);
			}

			int res = 1;
			for(String key : map.keySet())
				res *= (map.get(key)+1); //해당 의상 입지 않는 경우도 포함(+1)
			res -= 1; //아무것도 입지 않은 경우 제외
			sb.append(res + "\n");			
		}
		
		System.out.print(sb);
	}
	
}
