import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static LinkedList<Integer> queue = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; ++t) {
			queue.clear();
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); //문서의 개수
			M = Integer.parseInt(st.nextToken()); //궁금한 문서 번호
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int n = 0; n < N; ++n)
				queue.offer(Integer.parseInt(st.nextToken()));
			
			sb.append(findPrintNum() + "\n"); //프린트 순서 찾기
		}
		
		System.out.print(sb);
	}
	
	private static int findPrintNum() {
		int print = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll(); //현재 프린트 할 문서 중요도
			boolean ok = true;
			
			for(int i = 0; i < queue.size(); ++i) {
				if(now < queue.get(i)) { //뒤의 중요도가 큰 경우
					ok = false;
					break;
				}
			}
			
			if(ok) {
				++print;
				if(M == 0) break;
				else --M;
			}else {
				queue.offer(now); //뒤로 이동
				if(M == 0) M = queue.size() - 1;
				else --M;
			}
		}
		
		return print;
	}

}
