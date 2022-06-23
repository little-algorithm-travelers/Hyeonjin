import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N, number[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		
		double sum = 0;
		for(int i = 0; i < N; ++i) {
			number[i] = Integer.parseInt(br.readLine());
			sum += number[i];
		}
		
		Arrays.sort(number); //오름차순 정렬
		
		sb.append(Math.round(sum / N) + "\n"); //산술 평균
		sb.append(number[N/2] + "\n"); //중앙값
		sb.append(findMode() + "\n"); //최빈값
		sb.append(number[N-1] - number[0]); //범위
		System.out.print(sb);
	}
	
	private static int findMode() {
		int lastIndex = 0, max = 0, num = 0;
		boolean second = false;
		for(int i = 0; i < N; i = lastIndex) {
			lastIndex = findLastIndex(i);
			
			if(lastIndex - i > max) {
				max = lastIndex - i;
				num = number[i];
				second = false;
			}else if(lastIndex - i == max && !second) {
				num = number[i];
				second = true;
			}
		}
		return num;
	}

	private static int findLastIndex(int start) {
		int idx = start + 1;
		for(; idx < N; ++idx)
			if(number[start] != number[idx]) break;
		return idx;
	}

}
