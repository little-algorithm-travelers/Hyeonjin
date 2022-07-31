import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dh = {0, 0, 0, 0, -1, 1}; //위 아래 상자
	static int[] dm = {-1, 1, 0, 0, 0, 0}; //상 하 좌 우 위 아래
	static int[] dn = {0, 0, -1, 1, 0, 0};
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int[][][] tomato;
	static int M, N, H, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //가로 칸 수
		M = Integer.parseInt(st.nextToken()); //세로 칸 수
		H = Integer.parseInt(st.nextToken()); //상자 수
		
		tomato = new int[H][M][N]; //토마토가 든 상자
		C = 0; //익은 토마토이거나 토마토가 들어있지 않은 칸 수
		
		for(int h = 0; h < H; ++h) {
			for(int m = 0; m < M; ++m) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int n = 0; n < N; ++n) {
					tomato[h][m][n] = Integer.parseInt(st.nextToken());
					if(tomato[h][m][n] != 0) ++C;
					if(tomato[h][m][n] == 1) queue.offer(new int[] {h, m, n, 0});
				}
			}
		}
		System.out.println(C == H*M*N ? 0 : findMinDay()); //안익은 토마토가 없는 경우
	}
	
	private static int findMinDay() { //토마토 익는 최소 날짜
		int day = 0;
		while(!queue.isEmpty()) {
			int[] t = queue.poll();
			int h = t[0], m = t[1], n = t[2], d = t[3];
			if(d > day) day = d;
			
			for(int i = 0; i < 6; ++i) {
				int th = h + dh[i];
				int tm = m + dm[i];
				int tn = n + dn[i];
				//범위 내에 있으며 안익은 토마토일 경우
				if(th >= 0 && th < H && tm >= 0 && tm < M && tn >= 0 && tn < N && tomato[th][tm][tn] == 0) {
					queue.offer(new int[] {th, tm, tn, d + 1});
					tomato[th][tm][tn] = 1;
					++C;
				}
			}
		}

		return (C == H*M*N) ? day: -1; //모두 익을 경우 최소 날짜, 모두 익지 못할 경우 -1 리턴
	}
	
}
