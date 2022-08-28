import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //저장된 사이트 주소의 수
		M = Integer.parseInt(st.nextToken()); //비밀번호 찾으려는 사이트 주소의 수
		
		HashMap<String, String> map = new HashMap<>(); //사이트-비밀번호 저장할 hashMap
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			String site = st.nextToken();
			String password = st.nextToken();
			map.put(site, password); //키 : 사이트 주소, 값 : 비밀번호
		}
		
		for(int i = 0; i < M; ++i)
			sb.append(map.get(br.readLine()) + "\n"); //키(사이트 주소) 기준으로 비밀번호 찾기
		
		System.out.print(sb);
		
	}

}