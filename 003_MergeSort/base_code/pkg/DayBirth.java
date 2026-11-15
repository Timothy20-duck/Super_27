package pkg;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;


public class DayBirth {
	private int year;
	private int month;
	private int day;
	private String gender;
	private int births;


	public DayBirth(int year, int month,int day, String gender,int births) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.gender = gender;
		this.births = births;
	}

	public static ArrayList<DayBirth> readCSV(String filename)
		throws IOException {

			ArrayList<DayBirth> data = new ArrayList<>();
			Scanner scanner = new Scanner(new File(filename));

			scanner.nextLine();

			while(scanner.hasNextLine()) {
				
				String line = scanner.nextLine();

				String[] values = line.split(",");
				if (values[2].equals("null")){
					continue;
				}

				int year = Integer.parseInt(values[0]);
				int month = Integer.parseInt(values[1]);
				int day = Integer.parseInt(values[2]);
				String gender = values[3];

				// System.out.println("Reading row" + line);
				// System.out.println("Births value:" + values[4]); 
				int births = Integer.parseInt(values[4]);

				DayBirth obj = new DayBirth(year, month, day, gender, births);

				data.add(obj);
			}

			scanner.close();

			return data;
		}

	public int getYear(){
		return year;
	}

	public int getMonth(){
		return month;
	}	

	public int getDay(){
		return day;
	}
	
	public String getGender() {
		return gender;
	}

	public int getBirths() {
		return births;
	}
}
