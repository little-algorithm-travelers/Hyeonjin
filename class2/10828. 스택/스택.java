import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine()); //명령의 수
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int n = 0; n < N; ++n) {
			st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			
			switch(order) {
				case "push": stack.push(Integer.parseInt(st.nextToken())); break;
				case "pop": 
					if(stack.isEmpty()) sb.append(-1 + "\n");
					else sb.append(stack.pop() + "\n");
					break;
				case "size": sb.append(stack.size() + "\n"); break;
				case "empty":
					if(stack.isEmpty()) sb.append(1 + "\n");
					else sb.append(0 + "\n");
					break;
				case "top":
					if(stack.isEmpty()) sb.append(-1 + "\n");
					else sb.append(stack.peek() + "\n");
					break;
			}
		}
		
		System.out.print(sb);
	}

}
