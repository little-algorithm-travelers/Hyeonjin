import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, time = Integer.MAX_VALUE;
	static int[] check = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //수빈이의 위치
		K = Integer.parseInt(st.nextToken()); //동생의 위치
		
		findMinTime(); //가장 빠른 시간 찾기
		System.out.print(time);
	}
	
	private static void findMinTime() {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] num = new int[100001];
		queue.offer(new int[] {N, 0});
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int now = info[0], t = info[1];
			
			if(now == K) {
				time = Math.min(time, t);
				break;
			}
			
			for(int i = 0; i < 3; ++i) {
				int move = (i == 0) ? now + 1 : (i == 1) ? now - 1 : now * 2;
				if( move >= 0 && move <= 100000 && (num[move] == 0 || (num[move] != 0 && t+1 < num[move]))) {
					num[move] = t+1;
					queue.offer(new int[] {move, t+1});
				}
			}
		}
		
	}
	
}
