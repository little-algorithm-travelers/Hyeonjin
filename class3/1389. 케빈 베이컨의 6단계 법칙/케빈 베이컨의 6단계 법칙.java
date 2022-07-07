import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, matrix[][], min = Integer.MAX_VALUE, num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //유저 수
		int M = Integer.parseInt(st.nextToken()); //친구관계 수
		matrix = new int[N+1][N+1];
		
		for(int m = 0; m < M; ++m) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			matrix[a][b] = matrix[b][a] = 1;
		}
		
		for(int n = 1; n <= N; ++n)
			findRelationShip(n); //친구관계 찾기
		
		System.out.print(num);
	}
	
	private static void findRelationShip(int n) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[] visited = new boolean[N+1];
		queue.offer(new int[] {n, 0});
		visited[n] = true;
		
		int sum = 0;
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int user = info[0], cnt = info[1];
			sum += cnt;
			
			for(int i = 1; i <= N; ++i) {
				if(user != i && matrix[user][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.offer(new int[] {i, cnt+1});
				}
			}
		}
		
		if(min > sum) {
			min = sum;
			num = n;
		}else if(min == sum)
			num = (num > n) ? n : num;
	}
	
}
