import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //과목의 개수
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] score = new int[N];
		double max = 0;
		for(int n = 0; n < N; ++n) {
			score[n] = Integer.parseInt(st.nextToken());
			max = Math.max(max, score[n]);
		}

		double sum = 0;
		for(int n = 0; n < N; ++n)
			sum += score[n] / max * 100;
		System.out.print(sum / N);
	}

}
