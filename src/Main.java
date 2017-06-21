import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Random;

public class Main {

	Random rand = new Random();
	public static void main(String[] args) {
		char[] digits = new char[10];
		long [] primes = PrimePageScraper.scrapePrimePage();
		try {
			FileReader fileReader = new FileReader(new File("e.2mil.txt"));
			Reader reader = new BufferedReader(fileReader);
			reader.read(digits);
			long primeFound = 0;
			int numberPosition = 0;
			while (primeFound == 0){
				shiftCharArray(digits);
				reader.read(digits,digits.length-1, 1);
				long testNumber = charArrayToLong(digits);
				for (long prime:primes){
					if (prime==testNumber){
						primeFound=prime;
					}
				}
				numberPosition++;
			}
			System.out.println(primeFound);
			System.out.println(numberPosition);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	protected static void shiftCharArray(char[] digits){
		System.arraycopy(digits, 1, digits, 0, digits.length-1);
	}
	
	protected static long charArrayToLong(char []digits) throws NumberFormatException
	{
		long result = 0;
		for (int i = 0; i < digits.length; i++)
		{
			long digit = (long)digits[i] - (long)'0';
			result *= 10;
			result += digit;
		}
		return result;
	}

}
