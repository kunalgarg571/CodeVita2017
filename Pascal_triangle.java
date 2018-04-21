package cp;
import java.util.Arrays;
import java.util.Scanner;
public class Pascal_triangle {
	public static void main(String []args) {
		Scanner cin=new Scanner(System.in);
		int noIntegers=cin.nextInt();
		int intVal[]=new int[noIntegers];
		for(int i=0;i<noIntegers;i++) {
			intVal[i]=cin.nextInt();
		}
		Arrays.sort(intVal);
		int temp[]=new int[6];
		for(int i=(noIntegers-6),j=0;i<noIntegers;i++,j++) {
			temp[j]=intVal[i];
		}
		int finalarr[]=new int[6];
		finalarr[0]=temp[1];
		finalarr[1]=temp[3];
		finalarr[2]=temp[4];
		finalarr[3]=temp[5];
		finalarr[4]=temp[2];
		finalarr[5]=temp[0];
		for(int i=0;i<4;i++) {
			for(int j=0;j<5-i;j++)
			temp[j]=finalarr[j]+finalarr[j+1];
			for(int k=0;k<5-i;k++) {
				finalarr[k]=temp[k];
			}
		}
		System.out.println(temp[0]*temp[1]);
		cin.close();
	}
}