import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //좌표 수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Long[] x = new Long[N];
		for(int i = 0; i < N; ++i)
			x[i] = Long.parseLong(st.nextToken());
		
		HashSet<Long> hashSet = new HashSet<>(Arrays.asList(x)); //중복 수 제거
		Long[] newX = hashSet.toArray(new Long[0]);
		Arrays.sort(newX);

		HashMap<Long, Integer> map = new HashMap<>();
		for(int i = 0; i < newX.length; ++i)
			map.put(newX[i], i);
		
		for(int i = 0; i < N; ++i)
			sb.append(map.get(x[i]) + " ");
		
		System.out.print(sb);
	}

}