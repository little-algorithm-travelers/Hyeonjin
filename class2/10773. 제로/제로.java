import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int k = 0; k < K; ++k) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) stack.pop();
			else stack.push(n);
		}
		
		int sum = 0;
		while(!stack.isEmpty())
			sum += stack.pop();
		System.out.print(sum);
	}

}