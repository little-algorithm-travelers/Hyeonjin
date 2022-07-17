import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); //연산의 개수
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(); //우선순위 큐
		for(int n = 0; n < N; ++n) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(queue.size() == 0) sb.append(0 + "\n"); //빈 배열일 경우
				else sb.append(queue.poll() + "\n");
			}else queue.offer(x);
		}
		
		System.out.print(sb);
	}
}
