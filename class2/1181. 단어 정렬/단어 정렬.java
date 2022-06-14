import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Alpha implements Comparable<Alpha> {

	String word;
	int len;
	
	public Alpha(String word) {
		this.word = word;
		this.len = word.length();
	}
	
	@Override
	public int compareTo(Alpha alpha) {
		if(this.len == alpha.len) { //길이가 같으면 사전 순으로
			int i = 0;
			for(; i < this.len; ++i)
				if(this.word.charAt(i) != alpha.word.charAt(i)) break;
			return this.word.charAt(i) - alpha.word.charAt(i);
			//return this.word.compareTo(alpha.word); -- string에서도 compareTo() 함수 존재
		}else return this.len - alpha.len; //길이가 짧은 것부터
	}
	
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Alpha> list = new ArrayList<Alpha>();
		
		int N = Integer.parseInt(br.readLine());
		for(int n = 0; n < N; ++n) {
			String word = br.readLine();
			if(!contain(list, word)) list.add(new Alpha(word)); //중복단어 X
		}
		
		Collections.sort(list); //정렬
		for(int i = 0; i < list.size(); ++i)
			sb.append(list.get(i).word + "\n");
		System.out.print(sb);
	}

	private static boolean contain(ArrayList<Alpha> list, String word) {
		for(int i = 0; i < list.size(); ++i)
			if(list.get(i).word.equals(word)) return true; //이미 있는 단어일 경우
		return false;
	}

}
