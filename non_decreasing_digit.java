package cp;
import java.util.Scanner;
public class non_decreasing_digit {
	static Scanner cin=new Scanner(System.in);
	static int index=0;
	static String s =cin.nextLine();
	static char temp[]=s.toCharArray();
	public static void main(String []args) {
		for(int i=0;i<s.length()-1;i++)
			if(temp[i+1]<temp[i]) {
				isSorted(s.length(),i);
				break;
			}
		String res=new String(temp);
		System.out.println(res);
		cin.close();
	}
	static void isSorted(int k,int i){
		for(int j=k-1;j>i;j--) {
			temp[j]='9';
			}
		temp[i]=(char)((int)(temp[i])-1);
		if(i!=0 && temp[i]<temp[i-1]) {
			isSorted(i+1,i-1);
		}
	}
}