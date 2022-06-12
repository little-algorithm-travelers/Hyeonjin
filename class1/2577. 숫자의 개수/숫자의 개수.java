import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[10];
		
		int res = 1;
		for(int i = 0; i < 3; ++i)
			res *= Integer.parseInt(br.readLine());
		
		while(res != 0) {
			++num[res % 10];
			res /= 10;
		}
		
		for(int i = 0; i < 10; ++i)
			System.out.println(num[i]);

	}

}
