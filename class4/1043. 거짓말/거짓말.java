import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static Queue<Integer> queue;
	static ArrayList<ArrayList<Integer>> party;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); //사람 수
		M = Integer.parseInt(st.nextToken()); //파티 수
		
		queue = new LinkedList<>();
		st = new StringTokenizer(br.readLine(), " ");
		int know_true = Integer.parseInt(st.nextToken()); //이미 진실 아는 사람 수
		for(int i = 0; i < know_true; ++i)
			queue.offer(Integer.parseInt(st.nextToken())); //이미 진실 아는 사람

		party = new ArrayList<>(); //파티 참석 정보
		for(int m = 0; m < M; ++m) {
			ArrayList<Integer> temp = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");
			int count = Integer.parseInt(st.nextToken());

			for(int c = 0; c < count; ++c)
				temp.add(Integer.parseInt(st.nextToken())); //참석자들 번호
			party.add(temp);
		}

		ans = M;
		bfs();
		System.out.print(ans);

	}
	private static void bfs() {
		
		boolean[] check = new boolean[M];
		while(!queue.isEmpty()) {
			int true_know = queue.poll();
			
			for(int m = 0; m < M; ++m) {
				if(!check[m] && party.get(m).contains(true_know)) { //거짓말 불가 파티인 경우
					for(int i = 0; i <party.get(m).size(); ++i) { //해당 파티로 진실 알게된 사람 정보 구하기
						if(true_know != party.get(m).get(i) && !queue.contains(party.get(m).get(i)))
							queue.add(party.get(m).get(i));
					}
					check[m] = true;
					--ans;
				}
			}
			
		}
		
	}
	
}