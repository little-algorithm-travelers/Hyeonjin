import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, tree[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //나무의 수
		M = Integer.parseInt(st.nextToken()); // 가져가려는 나무의 길이
		
		tree = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; ++i)
			tree[i] = Integer.parseInt(st.nextToken()); //각 나무의 길이
		
		Arrays.sort(tree); //오름차순 정렬
		System.out.print(findMax());
	}
	
	private static int findMax() { //나무 최대 길이 구하기
		int min = 0, max = tree[N-1];
		
		while(min < max) {
			int mid = (max + min) / 2;
			long len = 0;
			for(int i = 0; i < N; ++i)
				len += (tree[i] - mid) < 0 ? 0 : tree[i] - mid;
			
			if(len < M) max = mid;
			else min = mid + 1;
		}
		return min - 1;
	}
	
}