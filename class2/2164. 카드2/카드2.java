import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //카드 수
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int n = 1; n <= N; ++n)
			queue.offer(n);
		
		while(queue.size() != 1) {
			queue.poll(); //맨 위의 카드 버리기
			queue.offer(queue.poll()); //다음 카드 뒤로 옮기기
		}
		
		System.out.print(queue.peek());
	}

}
