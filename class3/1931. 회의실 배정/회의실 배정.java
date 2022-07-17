import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting> {
	
	int start;
	int end;
	
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting m) {
		int endDis = this.end - m.end;
		if(endDis != 0) return endDis;
		return this.start - m.start;
	}
	
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		Meeting[] meeting = new Meeting[N];
		for(int n = 0; n < N; ++n) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meeting[n] = new Meeting(start, end);
		}
		
		Arrays.sort(meeting);
		int count = 0, endTime = 0;
		for(int n = 0; n < N; ++n) {
			if(endTime <= meeting[n].start) {
				++count;
				endTime = meeting[n].end;
			}
		}
		
		System.out.print(count);
		
	}
	
}
