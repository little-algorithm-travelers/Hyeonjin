import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {

	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point p) {
		if(this.y == p.y) return this.x - p.x;
		else return this.y - p.y;
	}
	
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine()); //점의 개수
		
		StringTokenizer st = null;
		ArrayList<Point> list = new ArrayList<>();
		for(int n = 0; n < N; ++n) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Point(x, y));
		}
		
		Collections.sort(list);
		for(int n = 0; n < N; ++n)
			System.out.println(list.get(n).x + " " + list.get(n).y);
		
	}

}
