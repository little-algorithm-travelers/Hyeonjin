import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken()); //한수의 위치(x, y)
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken()); //오른쪽 위 꼭짓점(w, h)
		
		System.out.print(bfs(x, y, w, h));
	}

	private static int bfs(int x, int y, int w, int h) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[w+1][h+1];
		queue.offer(new int[] {x, y, 0});
		
		int move = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int r = info[0], c = info[1], m = info[2];
			
			if(move <= m) continue; //현재 최소 움직임보다 클 경우 X
			else if(r == 0 || c == 0 || r == w || c == h) { //경계일 경우
				move = Math.min(move, m);
				continue;
			}
			
			for(int d = 0; d < 4; ++d) {
				int tr = r + dr[d];
				int tc = c + dc[d];
				if(tr >= 0 && tr <= w && tc >= 0 && tc <= h && !visited[tr][tc]) {
					visited[tr][tc] = true;
					queue.offer(new int[] {tr, tc, m+1});
				}
			}
		}
		
		return move;
	}

}
