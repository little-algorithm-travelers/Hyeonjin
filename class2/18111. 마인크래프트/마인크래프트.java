import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ground[][], height = Integer.MAX_VALUE;
	static long B, time = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //세로
		M = Integer.parseInt(st.nextToken()); //가로
		B = Long.parseLong(st.nextToken()); //인벤터리 블록 수
		
		ground = new int[N][M]; //땅의 높이

		for(int n = 0; n < N; ++n) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int m = 0; m < M; ++m) {
				ground[n][m] = Integer.parseInt(st.nextToken());
				height = Math.min(height, ground[n][m]); //현 땅의 높이 중 최소 높이
			}
		}

		for(int h = height; h <= 256; ++h) //땅의 최대 높이 : 256
			findLowGround(h);
		
		System.out.print(time + " " + height);
	}
	
	private static void findLowGround(int h) {
		long makeTime = 0, land = B;
		boolean status = true;
		
		for(int n = 0; n < N && status; ++n) {
			for(int m = 0; m < M; ++m) {
				int dis = Math.abs(h - ground[n][m]); //현재 만들 높이와 땅의 차이
				
				if(h >= ground[n][m]) { //목표 높이가 더 크고 블록이 있는 경우
					makeTime += dis; //블록 올리기
					land -= dis;
				}else if(h < ground[n][m]) { //현재 땅의 높이가 더 큰 경우
					makeTime += dis * 2; //블록 제거
					land += dis;
				}
				
				if(time < makeTime){ //이미 시간을 초과한 경우
					status = false;
					break;
				}
			}
		}

		if(makeTime <= time && status && land >= 0) { //해당 높이를 만들 수 있으며 최소 시간을 구했거나 현 최소 시간과 같은 경우
			time = makeTime;
			if(height < h) height = h;
		}
		
	}

}
