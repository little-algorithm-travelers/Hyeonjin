import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		int[] alpha = new int[26]; // A ~ Z
		for(int i = 0; i < str.length(); ++i)
			++alpha[str.charAt(i) - 65];
		
		int maxCnt = -1;
		char maxCharacter = '?';
		
		for(int i = 0; i < alpha.length; ++i) {
			if(maxCnt < alpha[i]) {
				maxCnt = alpha[i];
				maxCharacter = (char)(i + 65);
			}else if(maxCnt == alpha[i]) maxCharacter = '?';
		}
		
		System.out.print(maxCharacter);
		
	}

}
