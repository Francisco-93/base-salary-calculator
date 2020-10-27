package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private List<HourContract> hourContracts = new ArrayList<>();
	private Department department;
	
	public Worker() {
	}
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getHourContracts() {
		return hourContracts;
	}
	
	public void addContract(HourContract contract) {
		hourContracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		hourContracts.remove(contract);
	}
	
	public Double income (Integer year, Integer month) {
		for (HourContract hc : hourContracts) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(hc.getDate());
			int y = cal.get(Calendar.YEAR);
			int m = cal.get(Calendar.MONTH)+1;
			
			if(year == y && month == m) {
				baseSalary += hc.totalValue();
			}
		}
		return baseSalary;
	}	
		
}
