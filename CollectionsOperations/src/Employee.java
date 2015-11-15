import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Employee implements Comparable<Employee> {
	
	private String name;
	private int age;
	private Double salary;
	
	public Employee(String name, int age, Double salary) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public int compareTo(Employee e1)
	{
		// The below return statement sorts the objects correctly provided the
		//attribute ("age" in this case) is also an int (or at least
		//rounding the attribute's difference to an int does not make any significant difference).
		//return this.age - e1.age;
		
		// Below code is essential to sort the attributes (primitive type) precisely based on the decimal values 
		//return (int)((this.salary > e1.salary) ? 1 : (this.salary < e1.salary)?-1:0);
		
		// This work on Double (reference Types) without any of the manual comparison like the 
		//above double(primitive0 case
		return this.salary.compareTo(e1.salary);
	}
	
	// Equals should be inconsistent with CompareTo. Here salary should be unique for each employee to be added in the Set
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		if(obj instanceof Employee)
			return (((Employee)obj).getSalary() == this.getSalary());
		return false;
	}
	
	// Equals should be inconsistent with hashCode. Objects are said to be equal when the hashFunction generates same hashCode for both the objects
	// Hence use only "salary" attribute for generating hashCode
	@Override
	public int hashCode()
	{
		return (int) (31 * this.getSalary());
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Employee emp1 = new Employee("vasu", 48, 66000.457);
      Employee emp2 = new Employee();
      emp2.setName("krishna");
      emp2.setAge(26);
      emp2.setSalary(66000.456);
      Employee emp3 = new Employee("vasu", 40, 96000.457);
      
      List<Employee> employeeList = new ArrayList<Employee>();
      
      employeeList.add(emp1);
      employeeList.add(emp2);
      employeeList.add(emp3);
      
      // Sorting using a comparator
      Collections.sort(employeeList);
      
      System.out.println("Sorting using Comparator");
      for(Employee emp: employeeList)
    	  System.out.println(emp.name + ", " + emp.age +", " + emp.salary);
      
      // Sorting using a Comparable
      Collections.sort(employeeList, new Comparator<Employee>() {
    	  
    	  public int compare(Employee emp1, Employee emmp2)
    	  {
    		  return emp1.name.compareTo(emp2.name);
    	  }});
      System.out.println("Sorting by names using Comparable");
      for(Employee emp: employeeList)
    	  System.out.println(emp.name + ", " + emp.age +", " + emp.salary);
      
      // Sorting using Comparable implemented in other class
      Collections.sort(employeeList, new AgeComparator());
      System.out.println("Sorting by Age using Comparable implemented in other class");
      for(Employee emp: employeeList)
    	  System.out.println(emp.name + ", " + emp.age +", " + emp.salary);	  
	}

}
