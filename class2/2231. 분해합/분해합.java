import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int min = N;
		
		for(int i = N; i >= 0; --i)
			if(findMin(i)) min = Math.min(min, i);
		
		if(min == N) System.out.print(0);
		else System.out.print(min);
	}
	
	private static boolean findMin(int num) {
		int sum = num;
		while(num != 0) {
			sum += num % 10;
			if(sum > N) break;
			num /= 10;
		}
		
		if(sum == N) return true;
		else return false;
	}

}
