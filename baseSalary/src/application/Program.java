package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");
		
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();
		System.out.print("How many contracts to this worker? : ");
		int n = sc.nextInt();

		Worker w1 = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(departmentName));
		
		for(int i=0 ; i<n ; i++) {
			System.out.println("Enter contract #" + (i+1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			sc.nextLine();
			String date = sc.nextLine();
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			Integer hours = sc.nextInt();
			HourContract c = new HourContract(sdf.parse(date), valuePerHour, hours);
			w1.addContract(c);
		}
		
		System.out.print("\n\nEnter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf1.parse(monthAndYear));
		Integer year = cal.get(Calendar.YEAR);
		Integer month = cal.get(Calendar.MONTH)+1;
		
		System.out.println("Name: " + w1.getName());
		System.out.println("Department: " + w1.getDepartment());
		
		Double income = w1.income(year, month);
		
		System.out.println("Income for " + monthAndYear + ": $" + String.format("%.2f", income));
		
/*		System.out.println(year);
		System.out.println(month);
*/		
		sc.close();
	}
}
