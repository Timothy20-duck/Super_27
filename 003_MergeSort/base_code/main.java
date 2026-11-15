import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;
import java.io.*;
import java.util.*;.
import java.io.IOException;



class main {
	static final long createdNano = System.nanoTime();

	public static void main(String args[]) throws IOException {
		System.out.println("E");
		
		ArrayList<DayBirth> data = DayBirth.readCSV("births.csv");

		System.out.println("Total records: " + data.size());

		for (DayBirth obj : data) {
			System.out.println(
				obj.getYear() + "," +
				obj.getMonth() + "," +
				obj.getDay() + "," +
				obj.getGender() + "," +
				obj.getBirths()
			);
		} 


		// long start = System.nanoTime();
		// long finish = System.nanoTime();
		
		// System.out.println("Created: " + createdNano);
		
		// int [] times = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
		// int [] nums = new int[100];


		// System.out.println("-------------------Test-------------------");
		// System.out.println("");
		// for(int i : times){
		// 	System.out.println("Interval: " + i);
			
		// 	nums = new int[i];
		// 	start = System.nanoTime();

		// 	//  Put your method between these two comments

		// 	// mergeSort(nums);

		// 	finish = System.nanoTime();
		// 	System.out.println("Started: " + start);
		// 	System.out.println("Finished: " + finish);
		// 	System.out.println("Duration: " + (finish-start));
		// 	System.out.println("");
		// }
	}

	
	public static void mergeSort(int [] nums){
		int length = nums.length;
		if (length <= 1) return;

		int middle = length / 2; // 9/2 = 4.5 => 4
		int [] leftArray = new int[middle];
		int [] rightArray = new int[length - middle];

		int j = 0;

		for (int i = 0; i < length; i++){
			if (i < middle){
				leftArray[i] = nums[i];
			} else {
				rightArray[j] = nums[i];
				j++;
			}
		}
	
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, nums);
	}

	private static void merge(int [] leftArray, int [] rightArray, int [] array){
		int leftSize = array.length / 2;
		int rightSize = array.length - leftSize;
		int i = 0;
		int l = 0;
		int r = 0;

		while (l < leftSize && r < rightSize){
			if(leftArray[l] < rightArray[r]){
				array[i] = leftArray[l];
				i++;
				l++;
			}
			else{
				array[i] = rightArray[r];
				i++;
				r++;
			}
		}

		while(l < leftSize){
			array[i] = leftArray[l];
			i++;
			l++;
		}

		while(r < rightSize){
			array[i] = rightArray[r];
			i++;
			r++;
		}
	}
	
	
}
