import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		int sum = 0;
		for(int n = 0; n < N; ++n)
			sum += ch[n] - '0';
		System.out.print(sum);
	}

}
