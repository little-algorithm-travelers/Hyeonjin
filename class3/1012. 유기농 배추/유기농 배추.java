import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int M, N, K, ground[][]; //가로, 세로, 위치 개수
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; ++t) {
			int count = 0;
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); //가로
			N = Integer.parseInt(st.nextToken()); //세로
			K = Integer.parseInt(st.nextToken()); //위치 개수
			
			ground = new int[M][N];
			for(int k = 0; k < K; ++k) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				ground[r][c] = 1;
			}
			
			visited = new boolean[M][N];
			for(int r = 0; r < M; ++r) {
				for(int c = 0; c < N; ++c) {
					if(ground[r][c] == 1 && !visited[r][c]) {
						++count;
						dfs(r, c);
					}
				}
			}
			
			sb.append(count + "\n");		
		}
		
		System.out.print(sb);
	}
	
	private static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d = 0; d < 4; ++d) {
			int tr = r + dr[d];
			int tc = c + dc[d];
			if(tr >= 0 && tr < M && tc >= 0 && tc < N && ground[tr][tc] == 1 && !visited[tr][tc])
				dfs(tr, tc);
		}
		
	}

}
