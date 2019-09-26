import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
//Examole for magic number 142857
	public static void main(String[] args) {
		Main main = new Main();
		int number = main.getNumber();
		int numberLenght = String.valueOf(number).length();
		boolean magic = false;
		for (int i = 1; i <= numberLenght; i++) {
			int result = main.multiplyNumber(number, i);
			magic = main.compareNumbers(number, result);
		}

		if (magic) {
			System.out.println("It's magic!");
		} else {
			System.out.println("It's not magic.");
		}
	}

	//Gets integer type number, checks for correct input
	int getNumber() {
		Scanner input = new Scanner(System.in);
		System.out.println("Hello! Input a number:");
		int number = 0;
		boolean pass = true;
		//Cycle lasts until correct number format will be given
		while (pass) {
			try {
				number = input.nextInt();
				pass = false;
			} catch (InputMismatchException ex) {
				System.out.println("Wrong number format. Please enter valid number (i.e. 5; 6665; 1545428):");
				input.next();
			}
		}
		input.close();
		return number;
	}

	//Result of number and digits count multiplication
	int multiplyNumber(int number, int multiplier) {
		int result = 0;
		result = number * multiplier;
		return result;
	}

	//Check multiplied numbers digits and given number digits
	boolean compareNumbers(int number, int multipliedResult) {
		boolean magic = false;
		String numberString = Integer.toString(number);
		String resultString = Integer.toString(multipliedResult);
		String numArr[] = numberString.split("");
		String resultArr[] = resultString.split("");
		//Checks if given number and mulitplied number have same digits amount
		if (numArr.length == resultArr.length) {
			for (String i : resultArr) {
				if (numberString.contains(i)) {
					magic = true;
				} else {
					magic = false;
					break;
				}
			}
		}
		return magic;
	}

}
