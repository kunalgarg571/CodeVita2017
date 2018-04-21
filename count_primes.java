package cp;

import java.util.Scanner;
import java.lang.Math;

public class count_primes{
	static int prime_arr[]=new int[78498]; 
	static int count=2;
	static int last_p=3;
	static boolean is_prime(int num){
		boolean flag=false;            //Flag TRUE,IF NOt divisible by previous primes
		int temp=(int)Math.sqrt(num);  //temp checking for numbers less than sqrt(num)
		if(num==0 || num==1) {
			return false;
		}
		if(num==2|| num==3 ) {
			return true;
		}
		for(int i=0;i<count;i++) {
			if(temp<prime_arr[i]) {    //loop TErmination
			break;
			}
			if(num%prime_arr[i]==0)   //divisible by previous primes
			{
				return false;
			}
			else {
				flag=true;
			}
		}
		if(flag) {                     	//Not divisible by PP
			last_p=num;
			prime_arr[count]=last_p;   	//Adding new primes to array..
			count++;
			return true;
		}
		return false;
	}
	static int find(int number) {		// number of primes from 1 to number  
		int num=last_p+2;
		int i=0;
				if(prime_arr[count-1]<=number) { //pre-calculated or not
				while(num<=number) {			//if not then finding
					is_prime(num);
					num=num+2;
					}
				}
					for(i=0;prime_arr[i]<=number;i++){ //counting primes from i to number
						if(prime_arr[i]==0) {
							return i;
						}
					}
		return i;
	}
	public static void main(String []args)
	{
		int test_case;
		prime_arr[0]=2;
		prime_arr[1]=3;
		int pointer_result=0;
		Scanner cin=new Scanner(System.in);
		test_case=cin.nextInt();
		int result[]=new int[test_case];
		while(test_case!=0) {
			int res=0;				//actual Result
			int l=cin.nextInt();    //Starting point
			int r=cin.nextInt();	//Ending point
			int cp[]=new int[r-l+1];//array to stores no of primes from 1 to N
			cp[0]=find(l);			//no of primes from 1 to Starting number
			if(is_prime(cp[0])) {
				res++;		
			}	
			int j=1;
			for(int i=l+1;i<=r;i++) {	//calculating cp of next number using previous result 
				if(is_prime(i)) {
					cp[j]=cp[j-1]+1;
				}
				else {
					cp[j]=cp[j-1];
				}
				if(is_prime(cp[j])) {
					res++;
				}
				//System.out.println("cp of "+(j+1)+ cp[j]);
				j++;
			}
			result[pointer_result++]=res;
			test_case--;
		}
		for(int i=0;i<pointer_result;i++) {
			System.out.println(result[i]);
		}
		cin.close();
	}
}