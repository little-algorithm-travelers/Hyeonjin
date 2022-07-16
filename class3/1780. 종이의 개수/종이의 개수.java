import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int minus, zero, plus;
	static int[][] paper;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //종이의 크기
		paper = new int[N][N]; //종이의 정보
		for(int r = 0; r < N; ++r) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c = 0; c < N; ++c)
				paper[r][c] = Integer.parseInt(st.nextToken());
		}
		
		findCount(0, 0, N); //종이 개수 찾기
		
		sb.append(minus + "\n" + zero + "\n" + plus);
		System.out.print(sb);
	}
	
	private static void findCount(int r, int c, int size) {
		boolean check = true;
		
		for(int i = r; i < r+size && check; ++i) {
			for(int j = c; j < c+size && check; ++j) {
				if(paper[i][j] != paper[r][c])
					check = false;
			}
		}
		
		if(check) { //같은 숫자로 채워진 종이
			if(paper[r][c] == 0) ++zero;
			else if(paper[r][c] == 1) ++plus;
			else ++minus;
		}else { //다른 숫자로 채워진 종이
			findCount(r, c, size/3); //왼쪽 위
			findCount(r, c+size/3, size/3); //가운데 위
			findCount(r, c+(size/3) * 2, size/3); //오른쪽 위
			findCount(r+size/3, c, size/3); //왼쪽 가운데
			findCount(r+size/3, c+size/3, size/3); //가운데 가운데
			findCount(r+size/3, c+(size/3) * 2, size/3); //오른쪽 가운데
			findCount(r+(size/3) * 2, c, size/3); //왼쪽 아래
			findCount(r+(size/3) * 2, c+size/3, size/3); //가운데 아래
			findCount(r+(size/3) * 2, c+(size/3) * 2, size/3); //오른쪽 아래
		}
		
	}	
}