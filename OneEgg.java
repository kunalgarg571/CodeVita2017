package cp;

import java.util.Scanner;

public class OneEgg {
public static void main(String []args) {
	Scanner cin =new Scanner(System.in);
	int no_classes=cin.nextInt();
	int ordered_eggs=cin.nextInt();
	int total_eggs=0;
	boolean flag=false;
	int no_eggs[]=new int[no_classes];
	int temp[]=new int[no_classes];
	int delivered_eggs[]=new int[no_classes];
	for(int i=0;i<no_classes;i++) {
		no_eggs[i]=cin.nextInt();
		temp[i]=no_eggs[i];
		total_eggs=total_eggs+no_eggs[i];
	}
	if(total_eggs>ordered_eggs)
		flag=true;
	
	int remain_eggs=ordered_eggs;
		for(int i=0;i<no_classes;i++) {
			int max=temp[0];
			int index=0;
			for(int j=1;j<no_classes;j++) {
				if(temp[j]>max) {
					max=temp[j];
					index=j;
				}
			}
			if(flag){
				if(remain_eggs>max) {
					delivered_eggs[index]=max;
					temp[index]=-1;
					remain_eggs=remain_eggs-max;
				}
				else
					delivered_eggs[index]=remain_eggs;
			}
			else{
				delivered_eggs[index]=max;
				temp[index]=0;
				remain_eggs=remain_eggs-max;
				if(i==no_classes-1)
					delivered_eggs[index]=max-1;
				}	
			}
		
		if(flag)
			System.out.println("thank you, your order for "+ordered_eggs+" eggs are accepted");
		else
			System.out.println("Sorry, we can supply only "+(total_eggs-1)+" eggs");
		
		for(int i=0;i<no_classes;i++) 
			System.out.println(no_eggs[i]+"   "+delivered_eggs[i]+"   "+(no_eggs[i]-delivered_eggs[i]));
		
		cin.close();
	}
}