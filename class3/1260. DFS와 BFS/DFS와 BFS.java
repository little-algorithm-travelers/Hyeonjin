import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, map[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 개수
		int V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호
		
		map = new int[N+1][N+1]; //정점 번호는 1번부터 시작
		
		for(int m = 0; m < M; ++m) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = map[end][start] = 1;
		}
		
		dfs(V, new boolean[N+1]);
		sb.append("\n");
		bfs(V);
		System.out.print(sb);
	}
	
	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		queue.offer(v);
		visited[v] = true; //시작 번호
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now + " ");
			
			for(int n = 1; n <= N; ++n) {
				if(map[now][n] == 1 && !visited[n]) {
					visited[n] = true;
					queue.offer(n);
				}
			}
		}
	}

	private static void dfs(int now, boolean[] visited) {
		sb.append(now + " ");
		visited[now] = true;
		
		for(int n = 1; n <= N; ++n) {
			if(map[now][n] == 1 && !visited[n]) {
				dfs(n, visited);
			}
		}
	}

}
