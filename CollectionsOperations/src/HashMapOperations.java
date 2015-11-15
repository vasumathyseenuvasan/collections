import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HashMapOperations {

	private String department;
	Map<String,List<Employee>> deptMap =  new HashMap<String,List<Employee>>();

	public void hashMapOperations()
	{
		System.out.println("Below is the list of departments and details of the employee"
				+ "working under each department");
				
		Employee emp1 = new Employee("vasu", 48, 66000.647);
		Employee emp2 = new Employee("mathy", 40, 67000.567);
	    Employee emp3 = new Employee("Krishna", 30, 96000.00);
	    Employee emp4 = new Employee("prashanth", 35, 976000.457);
	    Employee emp5 = new Employee("Kalyani", 40, 79000.00);
	    Employee emp6 = new Employee("parulkar", 50, 69000.00);
	    
	    List<Employee> salesDeptList = new ArrayList<Employee>();
	    List<Employee> ITDeptList = new ArrayList<Employee>();
	    List<Employee> manufacturingDeptList = new ArrayList<Employee>();
	    
	    salesDeptList.add(emp1);
	    salesDeptList.add(emp2);
	    ITDeptList.add(emp3);
	    ITDeptList.add(emp4);
	    manufacturingDeptList.add(emp5);
	    manufacturingDeptList.add(emp6);
	    
		deptMap.put("SALES", salesDeptList);
		deptMap.put("IT", ITDeptList);
		deptMap.put("MANUFACTURING", manufacturingDeptList);
		
		for (String dept: deptMap.keySet())
		{
			if(deptMap.get(dept) != null)
			{	
				List<Employee> emp = new ArrayList<Employee>(deptMap.get(dept));
				System.out.println("Employee details (Name, Age, Salary) under deparment of " + dept);
				
				for(Employee employee: emp)
				{
					System.out.println(employee.getName() + "," + employee.getAge() + ","
				    + employee.getSalary());
				}
			}
		}
		
		Scanner inputChoice;
		String choice;
		String element="";
		String isContinueOption;
		String deptToBeAdded;
		List<Employee> empList = new ArrayList<Employee>();
		
		do
		{
		System.out.println("Enter your choice. 1. add a department 2. delete a department 3. Iterate and Print "
				+ "4. Search an employee and fire");

		inputChoice = new Scanner(System.in);
		choice = inputChoice.next();
				
		switch(choice)
		{
		case "1":
			
			System.out.println("Enter the department name");
			deptToBeAdded = inputChoice.next();

			while(deptMap.containsKey(deptToBeAdded))
			{
				System.out.println("Department already present. Enter another department");
				deptToBeAdded = inputChoice.next();				
			}
						
			do
			{
			Employee emp = new Employee();
			System.out.println("Enter the Employee name");
			element = inputChoice.next();
			emp.setName(element);
			System.out.println("Enter the Employee Age");
			element = inputChoice.next();
			emp.setAge(Integer.parseInt(element));
			System.out.println("Enter the Employee Salary");
			element = inputChoice.next();
			emp.setSalary(new Double(element));
			empList.add(emp);
			System.out.println("Do you want to add another employee to the depatment 1.Yes 2.No");
			choice = inputChoice.next();
			}while(choice.equalsIgnoreCase("yes"));
			
			addElement(deptToBeAdded,empList);
			empList.clear();
			break;
		case "2":
			
			System.out.println("Enter the Department name");
			element = inputChoice.next();
			if(deleteElement(element) == null)
				System.out.println("No such element is present");
			break;
		case "3":
			traverseMap();
			break;
		case "4":
			System.out.println("Enter the employee name");
			element = inputChoice.next();
			fireEmployee(element);
			break;
		default:
			System.out.println("Enter valid input");
			break;
		}
		
		System.out.println("Do you want to continue? Yes or no");
		Scanner isContinue = new Scanner(System.in);
		isContinueOption = isContinue.next();
		}while(isContinueOption.equalsIgnoreCase("yes"));

	}

	public void fireEmployee(String element) {
		// TODO Auto-generated method stub
		Collection<List<Employee>> itrMapValues = deptMap.values(); 
		
		for(List<Employee> employeeList:itrMapValues)
		{
			Iterator<Employee> itr = employeeList.iterator();
			while(itr.hasNext())
			{
				Employee emp = itr.next();
				if(emp.getName().equals(emp.getName()))
				{
						employeeList.remove(emp);
						System.out.println("Employee fired");						
						return;
				}
			}
		}
		System.out.println("No such employee is working under the department");
		return;
	}

	public void traverseMap() {
		// TODO Auto-generated method stub
		System.out.println("Department and employee details");
		for(Map.Entry<String, List<Employee>> e: deptMap.entrySet())
		{
			System.out.println(e.getKey());
			printEmployees(e.getValue());
		}
	}
	
	public void printEmployees(List<Employee> empList)
	{
		for(Employee emp:empList)
		{
			System.out.println(emp.getName() + "," + emp.getAge() + "," + emp.getSalary());
		}
	}

	public Object deleteElement(String element) {
		// TODO Auto-generated method stub
		return deptMap.remove(element);
	}

	public void addElement(String deptToBeAdded, List<Employee> empList) {
		// TODO Auto-generated method stub
			deptMap.put(deptToBeAdded, empList);
	}

}