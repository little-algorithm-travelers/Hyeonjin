import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] formula = br.readLine().split("-");
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < formula.length; ++i) {
			String[] smallFormula = formula[i].split("\\+"); // +로 하면 에러 발생 => \\+로 하면 해결!
			int sum = 0;
			for(int j = 0; j < smallFormula.length; ++j)
				sum += Integer.parseInt(smallFormula[j]);
			list.add(sum);
		}
		
		int res = 0;
		for(int i = 0; i < list.size(); ++i) {
			if(i == 0) res = list.get(i);
			else res -= list.get(i);
		}
		
		System.out.print(res);
	}
	
}
