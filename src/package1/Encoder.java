package package1;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Encoder {
	LocalTime currentTime = LocalTime.now();
	int timeSum = currentTime.getHour() + currentTime.getMinute() + currentTime.getSecond();
	Character[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public String Encode(String ah) {
		String outut= "";
		String uppercase_Input = ah.toUpperCase();
		for (int i = 0;i < uppercase_Input.length(); i++){
			for(int j = 0;j< alphabet.length; j++) {
		    if(uppercase_Input.charAt(i) == alphabet[j]) {
		    	outut+=(alphabet[(j + timeSum)%26]);
		    	}
		    	}
			}
		return outut;
	}
	public int Decode() {
		return 0;
	}
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String input = scanner.nextLine();
	
	Encoder Encodel = new Encoder();
	
	System.out.print(Encodel.Encode(input));
	scanner.close();
}
}

