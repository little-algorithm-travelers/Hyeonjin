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
		N = Integer.parseInt(br.readLine()); //컴퓨터 수
		M = Integer.parseInt(br.readLine()); //연결된 컴퓨터 쌍의 수
		matrix = new int[N+1][N+1];
		
		StringTokenizer st = null;
		for(int m = 1; m <= M; ++m) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken()); //현재 웜 바이러스 걸린 컴퓨터
			int next = Integer.parseInt(st.nextToken()); //웜 바이러스 걸릴 컴퓨터
			matrix[start][next] = matrix[next][start] = 1; //컴퓨터 연결
		}
		
		System.out.print(countComputer());

	}
	
	private static int countComputer() { //웜 바이러스 걸린 컴퓨터 세기(1번 제외)
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		boolean[] virus = new boolean[N+1];
		virus[1] = true;
		
		int count = 0;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int n = 1; n <= N; ++n) {
				if(now != n && matrix[now][n] == 1 && !virus[n]) {
					virus[n] = true;
					queue.offer(n);
					++count;
				}
			}
		}
		
		return count;
	}
	
}
