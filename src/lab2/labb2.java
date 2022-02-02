package lab2;
import java.io.*;



public class labb2 {

	  static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	   static String questionToUser = "You have the following options :\n"
				+ "End : type 'end'\nLoad from file : type 'load' followed by filename\n"
				+ "Save to file : type 'save' followed by filename\nAdd another word : type the word\n"
				+ "List reduced content : type '1'\nList full content : type '2'\n"
				+ "Remove multiple occurences : type '3'\nSort : type '4'\nList occurences : type '5'\nYour choice : ";
	public static void main(String[] args) throws IOException {
		System.out.println(questionToUser);
		File myFile;
		
		
		boolean end = false;
		while(!end) {
			String choice = consoleintput(questionToUser);
			
			switch(choice) {
			case "load": 
				myFile = new File(choice);
				if (myFile.exists()) {
					System.out.println("File exists");
				}
				
				
			}
		}
		
		
	}
	
	public static String consoleintput(String input) throws IOException {
		try {
		String text = consoleReader.readLine();
		return input + text;
		} catch(Exception e) {
			return "";
		}
	}
	
}






//String text = consoleReader.readLine();
//int choice = Integer.parseInt(text);
//switch(choice)
//{
//case 1:
	//System.out.println("yes");		
//}

//String text = "C:\\Users\\DAS\\Downloads\\Lab2 (2)\\Text.txt";
//File file = new File(text);
//FileReader fr = new FileReader(file);