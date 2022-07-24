import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, matrix[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix = new int[N+1][M+1];
		for(int n = 1; n <= N; ++n) {
			char[] ch = br.readLine().toCharArray();
			for(int m = 1; m <= M; ++m)
				matrix[n][m] = ch[m-1] - '0';
		}
		
		System.out.print(findMin());
	}
	
	private static int findMin() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {1, 1, 1});
		boolean[][] visited = new boolean[N+1][M+1];
		visited[1][1] = true;
		
		int count = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int r = info[0], c = info[1], cnt = info[2];
			
			if(r == N && c == M) {
				count = Math.min(count, cnt);
				break;
			}
			
			for(int d = 0; d < 4; ++d) {
				int tr = r + dr[d];
				int tc = c + dc[d];
				
				if(tr > 0 && tr <= N && tc > 0 && tc <= M && !visited[tr][tc] && matrix[tr][tc] == 1) {
					visited[tr][tc] = true;
					queue.offer(new int[] { tr, tc, cnt+1 });
				}
			}
		}
		
		return count;
		
	}	
}
