import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, number[], now = 100; // now : 현재 보고있는 번호
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine()); //이동하려고 하는 채널 번호
		int M = Integer.parseInt(br.readLine()); //고장난 버튼 개수
		
		number = new int[10]; //0 ~ 9
		if(M > 0) st = new StringTokenizer(br.readLine(), " ");
		for(int m = 0; m < M; ++m)
			number[Integer.parseInt(st.nextToken())] = 1; //0: 정상 번호, 1: 고장난 번호
		
		if(M == 10) System.out.print(Math.abs(N - now)); //모든 버튼 고장인 경우
		else if(N == now) System.out.print(0); //현재 보고있는 번호
		else if(checkChannel(N)) System.out.print(Math.min(Math.abs(now - N), countNum(N))); //가능한 번호인 경우
		else findChannel(); //다른 번호에서 + 또는 - 해야하는 경우
	}
	
	private static boolean checkChannel(int channelNum) { //채널 번호 확인
		if(channelNum == now) return true; //현재 보고있는 채널 번호인 경우
		else if(channelNum == 0) return number[channelNum] == 1 ? false : true;
		else {
			boolean check = true;			
			int num = channelNum;
			while(num != 0) {
				int ch = num % 10;
				if(number[ch] == 1) { //고장난 번호인 경우
					check = false;
					break;
				}
				num /= 10;
			}
			return check;
		}
	}

	private static void findChannel() { //가능한 채널 번호 찾기
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {N, 0});
		int res = 0;
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int channel = info[0], count = info[1]; //확인할 채널 번호, 넘긴 횟수
			
			if(checkChannel(channel)) { //채널 확인
				res = Math.min(Math.abs(now - N), count + countNum(channel));
				break;
			}
			
			if(0 < channel && channel < N) queue.offer(new int[] {channel-1, count+1}); //N보다 작은 번호에서 시작
			else if(N < channel) queue.offer(new int[] {channel+1, count+1}); //N보다 큰 번호에서 시작
			else if(channel == N) { //찾고 있는 번호일 경우
				if(channel-1 >= 0) queue.offer(new int[] {channel-1, count+1});
				queue.offer(new int[] {channel+1, count+1});
			}
		}
		
		System.out.print(res);
	}

	private static int countNum(int channel) { //자릿수 찾기
		int count = 0;
		if(channel == now) count = 0;
		else if(channel == 0) count = 1;
		else {
			while(channel != 0) {
				++count;
				channel /= 10;
			}
		}
		return count;
	}
	
}
