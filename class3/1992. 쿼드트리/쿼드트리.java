import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] quadTree;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //영상의 크기
		quadTree = new int[N][N];
		for(int n = 0; n < N; ++n) {
			char[] ch = br.readLine().toCharArray(); //영상 정보
			for(int m = 0; m < N; ++m)
				quadTree[n][m] = ch[m] - '0';
		}

		findQuadTree(0, 0, N, N, N); //영상 압축 결과 찾기
		System.out.print(sb);
	}
	
	private static void findQuadTree(int sr, int sc, int er, int ec, int n) {
		int sum = 0;
		boolean check = true;
		for(int r = sr; r < er && check; ++r) {
			for(int c = sc; c < ec && check; ++c) {
				sum += quadTree[r][c];
				if(quadTree[sr][sc] != quadTree[r][c]) {
					check = false;
					break;
				}
			}
		}
		
		if(check && (sum == 0 || sum == n * n)) sb.append(quadTree[sr][sc]); //같은 수로 이뤄진 영상인 경우
		else {
			sb.append("(");
			findQuadTree(sr, sc, sr+n/2, sc+n/2, n/2); //1사분면
			findQuadTree(sr, sc+n/2, sr+n/2, ec, n/2); //2사분면
			findQuadTree(sr+n/2, sc, er, sc+n/2, n/2); //3사분면
			findQuadTree(sr+n/2, sc+n/2, er, ec, n/2); //4사분면
			sb.append(")");
		}		
	}
	
}
