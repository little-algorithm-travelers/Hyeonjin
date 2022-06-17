import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int n = 0, num = 666;
		while(true) {
			if(findNum(num)) ++n;
			if(n == N) break;
			++num;
		}
		System.out.print(num);
	}

	private static boolean findNum(int num) {
		int cnt = 0;
		while(num != 0) {
			if(cnt >= 3) break;
			if(num % 10 == 6) ++cnt;
			else cnt = 0; //연속이 아니면 0으로 초기화
			num /= 10;
		}
		
		if(cnt >= 3) return true;
		else return false;
	}
	
}
