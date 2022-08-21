import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, graph[][];
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		M = Integer.parseInt(st.nextToken()); //간선의 개수
		graph = new int[N+1][N+1];
		
		for(int m = 0; m < M; ++m) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken()); //양 끝점 u, v
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = 1;//가중치 없는 방향 없은 그래프
		}
		
		visited = new boolean[N+1];
		int res = 0;
		for(int n = 1; n <= N; ++n) {
			if(!visited[n]) { //아직 방문하지 않은 정점인 경우
				findRoot(n);
				++res; //연결 요소 +1
			}
		}
		System.out.print(res);
	}
	
	private static void findRoot(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		visited[n] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next = 1; next <= N; ++next) {
				if(!visited[next] && graph[now][next] == 1) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
		
	}
	
}