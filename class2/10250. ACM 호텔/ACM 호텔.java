
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken()); //층 수
			int W = Integer.parseInt(st.nextToken()); //방 수
			int N = Integer.parseInt(st.nextToken()); //N번째 손님
			
			int r = (int)Math.ceil((double)N / (double)H); //방 번호
			int f = (N%H == 0) ? H : N%H; //층 번호
			System.out.println(f * 100 + r);
		}
	}

}
