import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, board[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //사다리의 수
		M = Integer.parseInt(st.nextToken()); //뱀의 수
		board = new int[11][11]; //10 * 10 크기의 게임
		
		for(int n = 0; n < N; ++n) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x/10][x%10] = y; //행 : 10의 자리, 열 : 1의 자리
		}
		
		for(int m = 0; m < M; ++m) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			board[u/10][u%10] = v; //행 : 10의 자리, 열 : 1의 자리
		}
		
		System.out.print(findMinMove());
	}
	
	private static int findMinMove() { //100번 도착 위한 주사위 던진 최솟값 구하기
		int min = Integer.MAX_VALUE;
		Queue<int[]> queue = new LinkedList<int[]>();
		int[][] moveCnt = new int[11][11];
		queue.offer(new int[] {0, 1, 0});
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int r = info[0], c = info[1], move = info[2];

			if(r == 10 && c == 0) { //100에 도착한 경우
				min = (min > move) ? move : min;
				continue;
			}
			
			if(move >= min) continue; //현재 주사위 횟수가 현 최솟값보다 큰 경우 stop

			for(int i = 1; i <= 6; ++i) { //주사위 숫자 1~6
				int tr = r;
				int tc = c;
				if(tc+i >= 10) {
					++tr;
					tc +=(i - 10);
				}else tc += i;
				
				if(tr*10 + tc > 100 || (moveCnt[tr][tc] > 0 && moveCnt[tr][tc] <= move+1)) continue; //100번 넘은 경우 stop
				else if(board[tr][tc] == 0) {
					moveCnt[tr][tc] = move+1;
					queue.offer(new int[] {tr, tc, move+1});
				}
				else {
					moveCnt[tr][tc] = move+1;
					int newPosition = board[tr][tc]; //사다리 또는 뱀이 있는 위치임으로 이동
					moveCnt[newPosition/10][newPosition%10] = move+1;
					queue.offer(new int[] {newPosition/10, newPosition%10, move+1});						
				}
				
			}
		}
		
		return min;
	}

}