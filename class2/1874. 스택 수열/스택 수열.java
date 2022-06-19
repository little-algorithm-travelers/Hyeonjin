import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int number = 0;
		for(int n = 0; n < N; ++n) {
			int num = Integer.parseInt(br.readLine());
			
			number = pushNum(num, number); //숫자 push
			popNum(num); //숫자 pop
			
			if(number > N) break;
			
		}
		
		if(number <= N && stack.isEmpty()) System.out.print(sb);
		else System.out.print("NO");
		
	}
	
	private static int pushNum(int num, int n) {
		while(stack.isEmpty() || stack.peek() < num) {
			stack.push(++n);
			sb.append("+" + "\n");			
		}
		return n;
	}
	
	private static void popNum(int num) {
		while(!stack.isEmpty() && num <= stack.peek()) {
			stack.pop();
			sb.append("-" + "\n");			
		}
	}
	
}
