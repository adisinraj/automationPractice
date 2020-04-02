package com.persistent.basics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */

    public static String solve(int n, int k) {
    	if(n==k||k<1||k>26||n<k)return "NONE";
    	
    	checkAssorted(5,2);
    	checkDiverse();
		return null;
    // Write your code here

    }

	private static void checkDiverse() {
		// TODO Auto-generated method stub
		
	}

	private static void checkAssorted(int n, int k) {
		ArrayList listofchar = new ArrayList<>();
		
		
	}

}

public class DiverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                String res = Result.solve(n, k);

                bufferedWriter.write(res);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
