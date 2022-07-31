import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dm = {-1, 1, 0, 0}; //상 하 좌 우
	static int[] dn = {0, 0, -1, 1};
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int[][] tomato;
	static int M, N, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //가로 칸 수
		M = Integer.parseInt(st.nextToken()); //세로 칸 수
		
		tomato = new int[M][N]; //토마토가 든 상자
		C = 0; //익은 토마토이거나 토마토가 들어있지 않은 칸 수
		
		for(int m = 0; m < M; ++m) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int n = 0; n < N; ++n) {
				tomato[m][n] = Integer.parseInt(st.nextToken());
				if(tomato[m][n] != 0) ++C;
				if(tomato[m][n] == 1) queue.offer(new int[] {m, n, 0});
			}
		}
		System.out.println(C == M*N ? 0 : findMinDay()); //안익은 토마토가 없는 경우
	}
	
	private static int findMinDay() { //토마토 익는 최소 날짜
		int day = 0;
		while(!queue.isEmpty()) {
			int[] t = queue.poll();
			int m = t[0], n = t[1], d = t[2];
			if(d > day) day = d;
			
			for(int i = 0; i < 4; ++i) {
				int tm = m + dm[i];
				int tn = n + dn[i];
				//범위 내에 있으며 안익은 토마토일 경우
				if(tm >= 0 && tm < M && tn >= 0 && tn < N && tomato[tm][tn] == 0) {
					queue.offer(new int[] {tm, tn, d + 1});
					tomato[tm][tn] = 1;
					++C;
				}
			}
		}

		return (C == M*N) ? day: -1; //모두 익을 경우 최소 날짜, 모두 익지 못할 경우 -1 리턴
	}
	
}
