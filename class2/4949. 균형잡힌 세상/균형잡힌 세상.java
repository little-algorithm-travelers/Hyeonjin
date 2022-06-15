import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		
		while(true) {
			stack.clear();
			char[] ch = br.readLine().toCharArray();
			if(ch.length == 1 && ch[0] == '.') break;
			
			boolean check = true;
			for(int i = 0; i < ch.length; ++i) {
				if(ch[i] == '(' || ch[i] == '[') stack.push(ch[i]);
				else if(ch[i] == ')' || ch[i] == ']') {
					if(!stack.isEmpty() && (stack.peek() == '(' && ch[i] == ')' || stack.peek() == '[' && ch[i] == ']'))
						stack.pop();
					else {
						check = false;
						break;
					}
				}
			}
			
			if(!check || !stack.isEmpty()) sb.append("no" + "\n");
			else sb.append("yes" + "\n");
		}
		
		System.out.print(sb);
	}

}
