import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TextToCSVGenerator {
	public static void main(String args[]){
		try {
			BufferedReader r  = new BufferedReader(new FileReader("/Users/mchandramohan/Downloads/movies.txt"));
			FileWriter fileWriter = new FileWriter("/Users/mchandramohan/Downloads/moviestext.txt");

			long count = 0, finalCount = 1000000;
			while(count<=finalCount){
				Movie m = new Movie();
				String line;
				while((line = r.readLine())!=null && !line.trim().equals("")){
					String[] lineTokens = line.split(":");
					String key = lineTokens[0];
					String value = "";
					if(lineTokens.length > 1)
					value = lineTokens[1];
					if(lineTokens.length > 2){
						int token = 2;
						while(token <= lineTokens.length-1){
							value += lineTokens[token];
							++token;
						}
					}
					//value = lineTokens[1];
					if(key.equals("product/productId")){
						m.setProductId(value);
					}else if(key.equals("review/userId")){
						m.setReviewId(value);
					}else if(key.equals("review/profileName")){
						m.setName(value);
					}else if(key.equals("review/helpfulness")){
						m.setHelpfulNess(value);
					}else if(key.equals("review/score")){
						m.setScore(value);
					}else if(key.equals("review/time")){
						m.setTime(value);
					}else if(key.equals("review/summary")){
						m.setSummary(value);
					}else if(key.equals("review/text")){
						value = value.replaceAll(",", " ");
						//value.replace(,' ');
						m.setReviewText(value);
					}
				}
				fileWriter.write(m.toString());
				fileWriter.write("\n");
				++count;
				System.out.println(count);
			}
			r.close();
			fileWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
