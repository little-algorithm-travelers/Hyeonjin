import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] size = new long[n+1]; //1~n 크기
		size[1] = 1;
		if(n >= 2) size[2] = 3;
		
		//1-1, 2-3, 3-5, 4-11, 5-21, 6-43, 7-85, 8-171, ...
		//size[n] = size[n-1] + 2*size[n-2]
		for(int i = 3; i <= n; ++i)
			size[i] = (size[i-1] + 2 * size[i-2]) % 10007;
		
		System.out.print( size[n] );
	}

}