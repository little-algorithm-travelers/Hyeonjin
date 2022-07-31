import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for(int t = 0; t < T; ++t) {
			char[] p = br.readLine().toCharArray(); //명령어 배열
			int n = Integer.parseInt(br.readLine()); //배열에 들어있는 수의 개수
			int[] lang = new int[n]; //언어 후보 배열
			String tempStr = br.readLine();
			String[] str = tempStr.substring(1, tempStr.length()-1).split(","); // , 기준으로 나누기
			
			for(int i = 0; i < n; ++i) lang[i] = Integer.parseInt(str[i]);

	        //인덱스를 활용해서 새로운 언어 만들기
			int countD = 0, start = 0, last = n-1, num = n; //num : 현재 들어있는 숫자 갯수
			for(int i = 0; i < p.length; ++i) {
				if(p[i] == 'D') { // D : 버리기
					++countD;
					--num;
					if(start <= last) ++start;
					else --start;
				}else { // R : 뒤집기
					int temp = start;
					start = last;
					last = temp;
				}
			}

				if(countD > n) sb.append("error\n");
				else {
					sb.append("[");
					if(num > 0) { //들어있는 숫자가 있는 경우
						if(start <= last) {
							for(int i = start; i <= last; ++i)
								sb.append(lang[i] + ",");
						}
						else {
							for(int i = start; i >= last; --i)
								sb.append(lang[i] + ",");
						}
						sb.delete(sb.length()-1, sb.length());
					}
					sb.append("]\n");
				}
		}
		System.out.print(sb);
	}
	
}
