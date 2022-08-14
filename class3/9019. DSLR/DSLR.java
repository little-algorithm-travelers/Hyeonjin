import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int A, B;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for(int t = 0; t < T; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			sb.append(findOrderList() + "\n");
		}
		
		System.out.print(sb);
	}
	
	private static String findOrderList() { //명령어 찾기
		Queue<Integer> queue = new LinkedList<>();
		String[] orders = new String[10000];
		boolean[] visited = new boolean[10000];
		orders[A] = "";
		visited[A] = true;
		queue.offer(A);
		String[] list = {"D", "S", "L", "R"};
		
		while(!queue.isEmpty() && !visited[B]) {
			int num = queue.poll();
			int t = 0;
			
			for(int l = 0; l < 4; ++l) {
				switch(l) {
				case 0 :
					t = (2 * num) % 10000; //D : n을 두 배로 변경
					break;
				case 1 :
					t = (num == 0) ? 9999 : num - 1; //S : n -> n-1(n이 0일 경우 9999)
					break;
				case 2 :
					t = (num%1000)*10 + (num/1000); //L : left 이동
					break;
				case 3 :
					t = (num%10)*1000 + (num/10); //R : right 이동
					break;
				}
				
				if(!visited[t]) {
					orders[t] = orders[num] + list[l];
					visited[t] = true;
					queue.offer(t);
				}
			}
		}
		
		return orders[B];
	}
	
}
