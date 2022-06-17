import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<Integer>();
		StringTokenizer st = null;
		for(int n = 0; n < N; ++n) {
			st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			
			switch(order) {
				case "push_front" : 
					deque.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case "push_back" : 
					deque.addLast(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front" : 
					if(deque.isEmpty()) sb.append(-1 + "\n");
					else sb.append(deque.pollFirst() + "\n");
					break;
				case "pop_back" : 
					if(deque.isEmpty()) sb.append(-1 + "\n");
					else sb.append(deque.pollLast() + "\n");
					break;
				case "size" :
					sb.append(deque.size() + "\n");
					break;
				case "empty" :
					if(deque.isEmpty()) sb.append(1 + "\n");
					else sb.append(0 + "\n");
					break;
				case "front" : 
					if(deque.isEmpty()) sb.append(-1 + "\n");
					else sb.append(deque.peekFirst() + "\n");
					break;
				case "back" : 
					if(deque.isEmpty()) sb.append(-1 + "\n");
					else sb.append(deque.peekLast() + "\n");
					break;
			}
		}
		
		System.out.print(sb);
	}

}
