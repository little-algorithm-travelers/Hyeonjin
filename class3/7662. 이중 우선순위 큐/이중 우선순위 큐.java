import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	//PriorityQueue 사용 시 시간 초과 - (O(n)
	//TreeMap - 이진트리를 기반으로 한 Map 컬렉션(레드-블랙 트리)
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		for(int t = 0; t < T; ++t) {
			map.clear();
			int K = Integer.parseInt(br.readLine()); //연산의 개수
			
			for(int k = 0; k < K; ++k) {
				st = new StringTokenizer(br.readLine(), " ");
				String operator = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if("I".equals(operator)) //삽입
					map.put(num, map.getOrDefault(num, 0)+1);
				else { //삭제
					if(!map.isEmpty()) {
						int key = 0;
						if(num == -1) key = map.firstKey(); //최솟값 삭제
						else key = map.lastKey(); //최댓값 삭제
						
						if(map.get(key) == 1) map.remove(key); //해당 숫자 1개인 경우
						else map.put(key, map.get(key)-1);
					}
				}
			}
			
			if(map.isEmpty()) sb.append("EMPTY\n");
			else sb.append(map.lastKey() + " " + map.firstKey() + "\n");
		}
		
		System.out.print(sb);
	}
	
}
