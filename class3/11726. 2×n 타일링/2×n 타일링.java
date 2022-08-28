import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] size = new long[n+1]; //1~n 크기
		size[1] = 1;
		if(n >= 2) size[2] = 2;
		
		//1-1, 2-2, 3-3, 4-5, 5-8, 6-13, 7-21, 8-34, 9-55, ...
		//size[n] = size[n-1] + size[n-2];
		for(int i = 3; i <= n; ++i) 
			size[i] = (size[i-1] + size[i-2]) % 10007;
		
		System.out.print( size[n] );
	}

}