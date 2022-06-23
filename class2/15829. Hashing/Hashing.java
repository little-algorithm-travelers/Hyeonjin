import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray(); //알파벳 배열
		
		long res = 0, r = 1, M = 1234567891; //res = 결과값 
		for(int i = 0; i < L; ++i) {
			res += (ch[i] - 'a' + 1) * r % M; //a * r % M
			r = r * 31 % M;
		}
		System.out.print(res % M); //res 값이 M에 나눠질 수 있으므로
	}

}
