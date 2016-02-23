package mazegame.utils;

import java.io.*;
import java.io.IOException;

/*A Utility class used for loading and reading text files*/
public class Utils {
	
	private static BufferedReader br;
	public static boolean close = false;
	
	public static String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine())!=null && close == false)
				builder.append(line + "\n");
			br.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		return builder.toString();
	}
	
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}
		catch(NumberFormatException nfe){
			nfe.printStackTrace();
			return 0;
		}
	}
	public static void closeFile(){
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
