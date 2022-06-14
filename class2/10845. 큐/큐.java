import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine()); //명령의 수
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		for(int n = 0; n < N; ++n) {
			st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			
			switch(order) {
				case "push": queue.offer(Integer.parseInt(st.nextToken())); break;
				case "pop": 
					if(queue.isEmpty()) sb.append(-1 + "\n");
					else sb.append(queue.poll() + "\n");
					break;
				case "size": sb.append(queue.size() + "\n"); break;
				case "empty":
					if(queue.isEmpty()) sb.append(1 + "\n");
					else sb.append(0 + "\n");
					break;
				case "front":
					if(queue.isEmpty()) sb.append(-1 + "\n");
					else sb.append(queue.getFirst() + "\n");
					break;
				case "back":
					if(queue.isEmpty()) sb.append(-1 + "\n");
					else sb.append(queue.getLast() + "\n");
					break;
			}
		}
		
		System.out.print(sb);
	}

}
