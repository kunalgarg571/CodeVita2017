package cp;
import java.util.Arrays;
import java.util.Scanner;
public class air_balloon {
	static double pi=3.14;
	public static void main(String [] args) {
		Scanner cin = new Scanner(System.in);
		int no_bal=cin.nextInt();
		double baloons[]=new double[no_bal];
		for(int i=0;i<no_bal;i++) {
			baloons[i]=cin.nextDouble();
		}
		int reduction=cin.nextInt(); 
		double total_vol=0.0;
		Arrays.sort(baloons);
		for(int i=0;i<no_bal;i++) {
			baloons[i]=(((double)4/3))*pi*baloons[i]*baloons[i]*baloons[i];
			for(int j=0;j<no_bal-i-1;j++) {
				baloons[i]=baloons[i]*(1-(double)reduction/100);
			}
			total_vol=total_vol+baloons[i];
		}
			System.out.printf("%.2f",total_vol);
		cin.close();
	}
}