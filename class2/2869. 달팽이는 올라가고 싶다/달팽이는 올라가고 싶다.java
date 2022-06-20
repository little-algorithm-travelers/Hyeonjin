import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static double A, B, V;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Double.parseDouble(st.nextToken()); //올라가는 거리
		B = Double.parseDouble(st.nextToken()); //미끄러진 거리
		V = Double.parseDouble(st.nextToken()); //높이
		
		int day = (int) Math.ceil((V - B) / (A - B)); // A * day - B * (day - 1) = (A - B) * day + B >= V
		System.out.print(day);
	}
	
}
