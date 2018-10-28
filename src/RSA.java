import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class RSA {

	public static void main(String[] args) {
		
		int p, q, n, z, d = 0, e;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the message");
		int message = scanner.nextInt();
		
		System.out.println("Enter the first prime number");
		p = scanner.nextInt();
		
		while(!isPrime(p)) {
			System.out.println(p + " is not a prime number, Enter the number again!");
			p = scanner.nextInt();
		}
			
		System.out.println("Enter the second prime number");
		q = scanner.nextInt();
		
		while(!isPrime(q)) {
			System.out.println(q + " is not a prime number, Enter the number again!");
			q = scanner.nextInt();
		}
			
		n = p * q;
		z = (p - 1)*(q - 1);
		
		System.out.println("P is assigned as: " + p);
		System.out.println("Q is assigned as: " + q);
		System.out.println("N is assigned as: " + n);
		System.out.println("PHI-N is assigned as: " + z);
		
		for(e = 2; e < z; e++) {
			if(gcd(e, z) == 1)
				break;
		}
		
		System.out.println("Value of e: " + e);
		
		for(int i = 0; i <= 9; i++) {
			int x = 1 + (z * i);
			if(x % e == 0) {
				d = x / e;
				break;
			}
		}
		
		double encryptedMessage = (Math.pow(message, e)) % n;
		double decryptedMessage = (Math.pow(encryptedMessage, e)) % n;
		
		System.out.println("Encrypted Message: " + encryptedMessage);
		System.out.println("Decrypted Message: " + decryptedMessage);
	
	}
	
	static int gcd(int e, int z) {
		if(e == 0)
			return z;
		else
			return gcd(z % e, e);
	}
	
	static boolean isPrime(int number) {
		
		int flag = 0;
		if(number == 1) 
			return true;
		
		for(int i = 2; i < number; i++) {
			if(number % i == 0) {
				flag = 0;
				break;
			}
			flag = 1;
		}
		
		if(flag == 1)
			return true;
		
		return false;
	}

}
