import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int line = 1, num = 1;
		
		while(num < N) {
			num += 6 * line++;
		}
		System.out.print(line);
	}
	
}
