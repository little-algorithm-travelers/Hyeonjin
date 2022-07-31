import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//DP이용 - 50점까지 맞았으나 나머지 50점은 타코드 참고(효율성을 위한 것인듯)
public class Main {
	
	static int N, M, result;
	static String S, find;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //I와 O의 개수 결정
		M = Integer.parseInt(br.readLine()); //문자열 S의 길이
		S = br.readLine();

		int[] checkCnt = new int[M];
		for(int i = 2; i < M; ++i) {
			if(i+1 >= M) break;
			String temp = S.substring(i-2, i+1);
			if(temp.equals("IOI")) checkCnt[i] = checkCnt[i-2]+1;
			if(checkCnt[i] >= N) ++result;
		}
		
		System.out.print(result);
	}
	
}
