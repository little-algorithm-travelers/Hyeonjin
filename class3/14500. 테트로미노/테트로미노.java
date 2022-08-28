import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, max, paper[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //세로 크기
		M = Integer.parseInt(st.nextToken()); //가로 크기
		paper = new int[N][M];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; ++j)
				paper[i][j] = Integer.parseInt(st.nextToken()); //종이의 쓰여진 숫자
		}
		
		for(int i = 0; i < N; ++i) {
			visited = new boolean[N][M];
			for(int j = 0; j < M; ++j) {
				visited[i][j] = true;
				dfs(i, j, paper[i][j], 1); //경로 따라 값 찾기
				visited[i][j] = false;
				aroundSum(i, j); //특정 모양의 값 찾기
			}
		}
		
		System.out.print(max);
		
	}

	private static void aroundSum(int r, int c) {
		//왼상우, 상우하, 왼하우, 상왼하
		int[][] surR = {{0, -1, 0}, {-1, 0, 1}, {0, 1, 0}, {-1, 0, 1}};
		int[][] surC = {{-1, 0, 1}, {0, 1, 0}, {-1, 0, 1}, {0, -1, 0}};
		
		int sum = paper[r][c], tr = r, tc = c;
		for(int s = 0; s < 4; ++s) {
			sum = paper[r][c];
			boolean status = true;
			for(int t = 0; t < 3 && status; ++t) {
				tr = r + surR[s][t];
				tc = c + surC[s][t];
				if(tr >= 0 && tr < N && tc >= 0 && tc < M) sum += paper[tr][tc];
				else status = false;
			}
			if(max < sum && status) max = sum;
		}
		
	}

	private static void dfs(int r, int c, int sum, int cnt) {
		if(cnt == 4) {
			max = (sum > max) ? sum : max;
			return;
		}
		
		for(int d = 0; d < 4; ++d) {
			int tr = r + dr[d];
			int tc = c + dc[d];
			if(tr >= 0 && tr < N && tc >= 0 && tc < M && !visited[tr][tc]) {
				if(cnt+1 < 4 || (cnt+1 == 4 && sum+paper[tr][tc] > max)) {
					visited[tr][tc] = true;
					dfs(tr, tc, sum+paper[tr][tc], cnt+1);
					visited[tr][tc] = false;
				}
			}
		}
	}
	
}