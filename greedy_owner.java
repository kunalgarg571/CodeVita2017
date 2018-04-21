package cp;

import java.util.HashMap;
import java.util.Scanner;
public class greedy_owner {
public static void main(String []args) {
	Scanner cin=new Scanner(System.in);
	HashMap<Character,Integer> map=new HashMap<>();
	for(int i=0;i<=9;i++) {
		map.put((char)(65+i),i);
	}
	int total_sum=0;
	int temp_value=0;
	int no_rooms=cin.nextInt();          //NO OF ROOMS
	String arr[]=new String[no_rooms];   // READING OF EACH ROOMS
	
	for(int i=0;i<no_rooms;i++) {
		temp_value=0;	
		arr[i]=cin.next();
		char temp[]=arr[i].toCharArray();
		for(int j=0;j<6;j++) {
			if(temp[j]>69&&j<5) {
			if(map.get(temp[j+1])==9-map.get(temp[j])) {
				temp_value=temp_value*10+map.get(temp[j+1]);
			}
			else
				temp_value=temp_value*10+map.get(temp[j]);
			}
			else
			temp_value=temp_value*10+map.get(temp[j]);
		}
		total_sum=total_sum+temp_value;
		
	}
	int total_units=cin.nextInt();
	if(total_sum-total_units>0 ) {
		System.out.println("GREEDY");
		System.out.println(total_sum-total_units);
	}
	else {
		System.out.println("INNOCENT");
	}
	cin.close();
}
}
