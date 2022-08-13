import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); //연산의 개수
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 : Collections.reverseOrder()
		
		for(int n = 0; n < N; ++n) {
			int x = Integer.parseInt(br.readLine()); //정수
			if(x == 0) {
				if(pq.isEmpty()) sb.append(0 + "\n");
				else sb.append(pq.poll() + "\n");
			}else pq.offer(x);
		}
		
		System.out.print(sb);
	}
	
}
