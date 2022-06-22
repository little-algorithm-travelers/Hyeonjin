import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, num[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; ++i)
			num[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(num); //오름차순 정렬
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int m = 0; m < M; ++m) {
			if(findNum(Integer.parseInt(st.nextToken()))) sb.append(1 + " ");
			else sb.append(0 + " ");
		}
		
		System.out.print(sb);
	}
	
	private static boolean findNum(int n) {
		int min = 0;
		int max = N;
		
		while(min < max) {
			int index = (max + min) / 2;
			if(num[index] == n) return true;
			else {
				if(num[index] > n) max = index;
				else min = index + 1;
			}
		}
		
		return false;
	}

}
