import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //계단의 개수
		int[] stair = new int[N]; //계단 점수 배열
		for(int n = 0; n < N; ++n)
			stair[n] = Integer.parseInt(br.readLine());
		int[][] point = new int[N][2]; //점수 정보
		int[] step = new int[N]; //한 칸 관련된 연속 정보
		
		//0 : 1칸 오름, 1: 2칸 오름
		point[0][0] = stair[0]; //첫 번째 계단
		step[0] = 1;
		if(N >= 2) { //N이 2 이상인 경우
			point[1][0] = point[0][0] + stair[1]; //두 번째 계단(1칸 오름)
			point[1][1] = stair[1]; //두 번째 계단(2칸 오름)
			step[1] = 2;			
		}
		
		for(int n = 2; n < N; ++n) {
			//1칸 관련
			if(step[n-1] < 2) {
				point[n][0] = (point[n-1][0] > point[n-1][1]) ? point[n-1][0] + stair[n] : point[n-1][1] + stair[n];
				step[n] = ++step[n-1];
			}else {
				point[n][0] = point[n-1][1] + stair[n];
				step[n] = 2;
			}
			point[n][1] = Math.max(point[n-2][0], point[n-2][1]) + stair[n]; //2칸 관련
		}
		
		System.out.print(Math.max(point[N-1][0], point[N-1][1]));
	}
	
}
