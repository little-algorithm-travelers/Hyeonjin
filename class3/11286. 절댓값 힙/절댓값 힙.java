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
		
		PriorityQueue<Integer> plus = new PriorityQueue<>(); //양수
		PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder()); //음수
		
		for(int i = 0; i < N; ++i) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) { //절대값 가장 작은 값 출력 및 제거
				if(plus.isEmpty() && minus.isEmpty()) sb.append(0 + "\n"); //두 우선순위 큐 모두 정수가 없는 경우
				else {
					if(plus.isEmpty()) sb.append(minus.remove() + "\n"); //음수만 있는 경우
					else if(minus.isEmpty()) sb.append(plus.remove() + "\n"); //양수만 있는 경우
					else {
						int m = Math.abs(minus.peek());
						int p = Math.abs(plus.peek());
						if(m <= p) sb.append(minus.remove() + "\n"); //절대값이 같거나 음수 절대값이 더 작은 경우
						else sb.append(plus.remove() + "\n"); //양수 절대값이 작은 경우
					}
				}
			}else { //정수 삽입
				if(x < 0) minus.add(x);
				else plus.add(x);
			}
		}
		
		System.out.print(sb);
	}
	
}
