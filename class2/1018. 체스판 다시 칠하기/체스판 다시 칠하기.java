import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min = Integer.MAX_VALUE;
	static int map[][];
	static int[] dr = {1, 0}; //하, 우
	static int[] dc = {0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //세로
		M = Integer.parseInt(st.nextToken()); //가로
		
		map = new int[N][M];
		for(int i = 0; i < N; ++i) {
			char[] ch = br.readLine().toCharArray();
			for(int j = 0; j < M; ++j) {
				if(ch[j] == 'B') map[i][j] = 0; //B : 0
				else map[i][j] = 1; //W : 1
			}
		}
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(i + 7 < N && j + 7 < M) {
					int ch = (map[i][j] == 0) ? 1 : 0;
					int min1 = findMin(i, i+7, j, j+7, map[i][j]);
					int min2 = findMin(i, i+7, j, j+7, ch);
					
					min = Math.min(min, Math.min(min1, min2));
				}
			}
		}
		
		System.out.print(min);
	}
	
	private static int findMin(int sr, int fr, int sc, int fc, int character) {
		int count = (map[sr][sc] == character) ? 0 : 1;
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		visited[sr][sc] = true;
		queue.offer(new int[] {sr, sc, character});
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int r = info[0], c = info[1], ch = info[2];
			
			if(min < count) break;
			
			for(int d = 0; d < 2; ++d) {
				int tr = r + dr[d];
				int tc = c + dc[d];
				
				if(tr >= sr && tr <= fr && tc >= sc && tc <= fc && !visited[tr][tc]) {
					visited[tr][tc] = true;
					if(ch != map[tr][tc]) queue.offer(new int[] {tr, tc, map[tr][tc]});
					else {
						queue.offer(new int[] {tr, tc, (ch == 0) ? 1 : 0});
						++count;
					}
				}
			}
		}
		return count;
	}
	
}