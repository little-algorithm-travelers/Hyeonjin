import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.print(findMod(A, B));
	}
	private static long findMod(long a, long b) {
		if(b == 1) return a % C;
		
		long temp = findMod(a, b/2);
		
		if(b % 2 == 0)  return temp * temp % C; //짝수일 경우
		else return (a % C) * (temp * temp % C) % C; //홀수 일 경우
	}
	
}