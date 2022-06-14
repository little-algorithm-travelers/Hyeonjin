import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String num = br.readLine();
			if(num.equals("0")) break; //0일 경우 stop
			
			int front = 0, back = num.length()-1;
			if(checkNum(num, front, back)) sb.append("yes" + "\n");
			else sb.append("no" + "\n");
		}
		System.out.print(sb);
	}

	private static boolean checkNum(String num, int front, int back) {
		if(front >= back) return true; //모두 확인하여 팰린드롬수인 경우
		else {
			if(num.charAt(front) == num.charAt(back)) //같은 숫자일 경우
				return checkNum(num, front+1, back-1);
			else return false; //다른 숫자일 경우
		}
	}

}
