import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); //크기
		map = new char[N][N];
		
		for(int n = 0; n < N; ++n)
			map[n] = br.readLine().toCharArray();

		for(int t = 0; t < 2; ++t) {
			visited = new boolean[N][N];
			int count = 0;
			for(int r = 0; r < N; ++r) {
				for(int c = 0; c < N; ++c) {
					if(!visited[r][c]) {
						findArea(r, c, t);
						++count;
					}
				}
			}
			sb.append(count + " ");
		}
		
		System.out.print(sb);
	}
	
	private static void findArea(int r, int c, int status) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int i = info[0], j = info[1];
			
			for(int d = 0; d < 4; ++d) {
				int tr = i + dr[d];
				int tc = j + dc[d];
				if(tr >= 0 && tr < N && tc >= 0 && tc < N && !visited[tr][tc]) {
					if(status == 0 && map[i][j] == map[tr][tc]) { //적록색약 X
						visited[tr][tc] = true;
						queue.offer(new int[] {tr, tc});
					}else if(status == 1) { //적록색약 O
						if((map[i][j] == 'B' && map[i][j] == map[tr][tc]) ||
						   (map[i][j] != 'B' && map[tr][tc] != 'B')) { //파란색끼리 또는 빨강-초록끼리인 경우
							visited[tr][tc] = true;
							queue.offer(new int[] {tr, tc});
						}
					}
				}
			}
		}
	}
	
}
