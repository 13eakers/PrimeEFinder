import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class PrimePageScraper {

	final static String PAGE_URL = "http://primes.utm.edu/curios/index.php?start=10&stop=10";
	
	public static long[] scrapePrimePage(){
		ArrayList<Long> primes = new ArrayList<Long>();
		try {
			URL page = new URL(PAGE_URL);
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(page.openStream()));
	        StringBuilder builder = new StringBuilder();
	        String inputLine;
	        while ((inputLine = in.readLine()) != null){
	        	int primeIndex = inputLine.indexOf("title=\"prime\"");
	            if (primeIndex!=-1){
	            	String rawPrime = inputLine.substring(primeIndex+14, primeIndex+24);
	            	if (rawPrime.matches("[\\d]+")){
	            		primes.add(Long.parseLong(rawPrime));
	            	}
	            }
	        }
	        System.out.println(primes);
	        in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long [] returnPrimes = new long[primes.size()];
		for (int i = 0; i < primes.size(); i++){
			returnPrimes[i] = primes.get(i);
		}
		return returnPrimes;
	}

}
