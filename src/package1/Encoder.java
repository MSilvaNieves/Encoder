package package1;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Encoder {
	static LocalTime currentTime = LocalTime.now();
	static int timeSum = 0;
	Character[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	//To do: Turn array into circular array
	public static LocalTime time() {
		return currentTime;
		
	} 
	public int check(int n) {
		if(n<0) {
		return check(n+26);
		}
		else {
			return n;
		}
	}
	public String Encode(String ah) {
		String outut= "";
		String uppercase_Input = ah.toUpperCase();
		timeSum = currentTime.getHour() + currentTime.getMinute() + currentTime.getSecond();
		for (int i = 0;i < uppercase_Input.length(); i++){
			for(int j = 0;j< alphabet.length; j++) {
		    if(uppercase_Input.charAt(i) == alphabet[j]) {
		    	outut+=(alphabet[(j + timeSum)%26]);
		    	}
		    	}
			}
		return outut + " " + time();
	}
	public String Decode(String oh) {
		String stuff[] = oh.split("[\\s\\:\\.]+");
		String pew = "";
		int decodeTimeSum = Integer.parseInt(stuff[1]) + Integer.parseInt(stuff[2]) + Integer.parseInt(stuff[3]);
		for (int i = 0;i < oh.length(); i++){
			for(int j = 0;j< alphabet.length; j++) {
				if(oh.charAt(i) == alphabet[j]) {
					if(j-decodeTimeSum<0){
						pew+=(alphabet[check(j-decodeTimeSum)]);
						}
					else {
					pew+=(alphabet[(j - decodeTimeSum)]);
					}
				}
			}								
		}
		return pew;
	}
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	Encoder Encodel = new Encoder();
	String stringInput;
	System.out.println("User options are:\n");
	System.out.println("[0] Encryption");
	System.out.println("[1] Decryption");
	System.out.println();
	
	int input = scanner.nextInt();
	
	if(input == 0) {
	System.out.println("What would you like to encrypt");
	stringInput = scanner.nextLine();
	stringInput = scanner.nextLine();
	System.out.print(Encodel.Encode(stringInput));
	scanner.close();
	}
	else{
	System.out.println("What would you like to decrypt");
	stringInput = scanner.nextLine();
	stringInput = scanner.nextLine();
	System.out.print(Encodel.Decode(stringInput));
	scanner.close();
	}
}
}

