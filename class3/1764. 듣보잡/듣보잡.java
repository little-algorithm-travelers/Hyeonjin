import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); //듣도 못한 사람 수
		int M = Integer.parseInt(st.nextToken()); //보도 못한 사람 수
		
		HashSet<String> set = new HashSet<>(); //듣도 못한 사람 리스트
		ArrayList<String> result = new ArrayList<>(); //듣도 보도 못한 사람 리스트
		
		for(int n = 0; n < N; ++n) //듣도 못한 사람 목록
			set.add(br.readLine());
		
		for(int m = 0; m < M; ++m) { //보도 못한 사람 목록
			String name = br.readLine();
			if(set.contains(name)) result.add(name); //겹칠 경우 추가
			//HashSet의 contains : O(1) - map기반, ArrayList의 contains : O(n) - indexOf 기반
		}
		
		Collections.sort(result);
		sb.append(result.size() + "\n");
		for(int i = 0; i < result.size(); ++i)
			sb.append(result.get(i) + "\n");
		
		System.out.print(sb);
	}	
}
