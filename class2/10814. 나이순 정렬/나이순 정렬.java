import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {

	int age;
	String name;
	int join;
	
	public Person(int age, String name, int join) {
		this.age = age;
		this.name = name;
		this.join = join;
	}
	
	@Override
	public int compareTo(Person p) {
		if(this.age == p.age) return this.join - p.join;
		else return this.age - p.age;
	}
	
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine()); //회원의 수
		
		ArrayList<Person> list = new ArrayList<>();
		for(int n = 0; n < N; ++n) {
			st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Person(age, name, n));
		}
		
		Collections.sort(list);
		for(int n = 0; n < N; ++n)
			sb.append(list.get(n).age + " " + list.get(n).name + "\n");
		
		System.out.print(sb);

	}

}
