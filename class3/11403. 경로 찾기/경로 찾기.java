import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, graph[][];
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); //정점의 개수
		graph = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; ++j)
				graph[i][j] = Integer.parseInt(st.nextToken()); //가중치 없는 방향 그래프
		}
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(graph[i][j] == 0) findRoot(i, j); //0인 경우 방향찾기
				sb.append(graph[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}

	private static void findRoot(int start, int end) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		boolean[] visited = new boolean[N];
		boolean find = false;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(now == end && visited[now]) { //visited[now] : [0,0] 과 같이 자기자신 루트 찾는 경우 대비
				find = true;
				break;
			}
			
			for(int next = 0; next < N; ++next) {
				if(!visited[next] && graph[now][next] == 1) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
		
		if(find) graph[start][end] = 1;
	}
	
}
