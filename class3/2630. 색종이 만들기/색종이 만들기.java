import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, WHITE, BLUE, paper[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //한 변의 길이
		paper = new int[N][N]; //종이 정보
		
		StringTokenizer st = null;
		for(int n = 0; n < N; ++n) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int m = 0; m < N; ++m)
				paper[n][m] = Integer.parseInt(st.nextToken());
		}
		
		countPaper(0, 0, N, N, N); //하얀색과 파란색 종이 찾기
		System.out.print(WHITE + "\n" + BLUE);
	}
	
	private static void countPaper(int sr, int sc, int er, int ec, int n) {
		int sum = 0;
		boolean check = true;
		for(int r = sr; r < er && check; ++r) {
			for(int c = sc; c < ec && check; ++c) {
				sum += paper[r][c];
				if(paper[sr][sc] != paper[r][c]) {
					check = false;
					break;
				}
			}
		}
		
		if(check && sum == 0) ++WHITE; //전체 합이 0인 경우 하얀색 종이
		else if(check && sum == n * n) ++BLUE; //전체 합이 n*n인 경우 파란색 종이
		else { //하얀색 또는 파란색 종이가 아닌 경우
			countPaper(sr, sc, sr+n/2, sc+n/2, n/2); //1사분면
			countPaper(sr, sc+n/2, sr+n/2, ec, n/2); //2사분면
			countPaper(sr+n/2, sc, er, sc+n/2, n/2); //3사분면
			countPaper(sr+n/2, sc+n/2, er, ec, n/2); //4사분면
		}		
	}
	
}
