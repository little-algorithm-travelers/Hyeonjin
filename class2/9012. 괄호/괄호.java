import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack = new Stack<Character>();
		for(int t = 0; t < T; ++t) {
			stack.clear();
			char[] ch = br.readLine().toCharArray();
			boolean check = true;
			
			for(int c = 0; c < ch.length; ++c) {
				if(ch[c] == '(') stack.push('(');
				else {
					if(!stack.isEmpty()) stack.pop();
					else {
						check = false;
						break;
					}
				}
			}
			if(!stack.isEmpty() || check == false) sb.append("NO" + "\n");
			else sb.append("YES" + "\n");
		}
		
		System.out.print(sb);
	}

}
