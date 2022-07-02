import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		findVisitedCnt(0, r, c, (int)Math.pow(2, N)); //몇 번째 방문인지 찾기
		
	}
	
	private static void findVisitedCnt(int sum, int r, int c, int N) {
		int line = N / 2;
		
		if(line == 1) {
			if(r < line) {
				if(c < line) System.out.print(sum); //1사분면
				else System.out.print(sum + 1); //2사분면
			}else {
				if(c < line) System.out.print(sum + 2); //3사분면
				else System.out.print(sum + 3); //4사분면
			}
		}else {
			if(r < line) { //1,2사분면
				if(c < line) findVisitedCnt(sum, r, c, N/2); //1사분면
				else findVisitedCnt(sum + line * line, r, c - line, N/2); //2사분면
			}else { //3,4사분면
				if(c < line) findVisitedCnt(sum + 2 * line * line, r - line, c, N/2); //3사분면
				else findVisitedCnt(sum + 3 * line * line, r - line, c - line, N/2); //4사분면
			}
		}
		
	}
	
}
