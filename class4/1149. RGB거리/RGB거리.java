import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, colorCost[][], costSum[][], rgb = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); //집의 수
		colorCost = new int[N][3]; //각 집의 색 비용 (0 : 빨강, 1 : 초록, 2 : 파랑)
		costSum = new int[N][3]; // 각 집까지의 총 비용
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c = 0; c < 3; ++c)
				colorCost[i][c] = Integer.parseInt(st.nextToken()); //각 색 비용
		}
		
		//첫 번째 집까지의 비용 각각 넣기
		costSum[0][0] = colorCost[0][0];
		costSum[0][1] = colorCost[0][1];
		costSum[0][2] = colorCost[0][2];
		for(int n = 1; n < N; ++n) { //1~n번째 집까지의 각 총 비용 구하기
			costSum[n][0] = colorCost[n][0] + (costSum[n-1][1] > costSum[n-1][2] ? costSum[n-1][2] : costSum[n-1][1]);
			costSum[n][1] = colorCost[n][1] + (costSum[n-1][0] > costSum[n-1][2] ? costSum[n-1][2] : costSum[n-1][0]);
			costSum[n][2] = colorCost[n][2] + (costSum[n-1][0] > costSum[n-1][1] ? costSum[n-1][1] : costSum[n-1][0]);
		}
		
		for(int i = 0; i < 3; ++i)
			if(rgb > costSum[N-1][i]) rgb = costSum[N-1][i];
		System.out.print(rgb);
	}

}