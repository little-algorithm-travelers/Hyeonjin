import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Person {

	int weight;
	int height;
	
	public Person(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine()); //전체 사람 수
		
		ArrayList<Person> list = new ArrayList<Person>();
		for(int n = 0; n < N; ++n) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			list.add(new Person(w, h));
		}
		
		for(int i = 0; i < N; ++i) {
			int order = 1;
			Person person = list.get(i);
			for(int j = 0; j < N; ++j) {
				if(i == j) continue;
				Person next = list.get(j);
				if(person.weight < next.weight && person.height < next.height) ++order;
			}
			sb.append(order + " ");
		}
		
		System.out.print(sb);
	}

}
