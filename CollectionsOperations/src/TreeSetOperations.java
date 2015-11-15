import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class TreeSetOperations {

	//SortedSet interface provides additional functionalities like headSet subSet compared to Set interface
	SortedSet<Employee> treeSetSorted;
	TreeSet<Employee> treeSetOriginal;
	NavigableSet<Employee> treeSetNavigable;
	
	public void treeSetOperations()
	{
		System.out.println("TreeSet elements are:");
		
		Employee emp1 = new Employee("Vasu", 25, new Double(45000));
		Employee emp2 = new Employee("Krishna", 26, new Double(55000));
		Employee emp3 = new Employee("Kalyani", 25, new Double(650000));
		
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		
		treeSetSorted = new TreeSet<Employee>(employeeList);
		treeSetOriginal = new TreeSet<Employee>(employeeList);
		treeSetNavigable = new TreeSet<Employee>(employeeList);

		Iterator<Employee> itr = treeSetNavigable.iterator();
		while (itr.hasNext())
		{
			Employee emp = itr.next();
			
			System.out.println(emp.getName());
			System.out.println(emp.getAge());
			System.out.println(emp.getSalary());
		}
		
		Scanner inputChoice;
		String choice;
		String element="";
		String isContinueOption;
		
		do
		{
		System.out.println("Enter your choice. 1. add an employee 2. delete an employee 3. Iterate and Print "
				+ "4. View list of employee details organized based the given amount 5. View the leaset and most salaried employee"
				+ "6. Enter an employee name to check if he is in the list already");

		inputChoice = new Scanner(System.in);
		choice = inputChoice.next();
				
		switch(choice)
		{
		case "1":
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
			
			if(!addElement(emp))
				System.out.println("Same element cannot be inserted twice");
			break;
		case "2":
			
			System.out.println("Enter the Employee name");
			element = inputChoice.next();
			if(!deleteElement(element))
				System.out.println("No such element is present");
			break;
		case "3":
			traverseList();
			break;
		case "4":
			System.out.println("Enter the Salary Range");
			element = inputChoice.next();
			Employee empl = new Employee("",0,new Double(element));
			employeeOrganizedBySalary(empl);
			break;
		case "5":
			leasetAndMostSalariedEmployee();
			break;
		case "6":
			System.out.println("Enter the Employee name");
			element = inputChoice.next();		
			checkEmployeePresent(element);
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

	public void checkEmployeePresent(String element) {
		// TODO Auto-generated method stub
		Iterator<Employee> itr = treeSetNavigable.iterator();
		while (itr.hasNext())
		{
			Employee emp = itr.next();
			
			if(emp.getName().equalsIgnoreCase(element))
				System.out.println("employee already present");
		}	
	}

	public void employeeOrganizedBySalary(Employee emp) {
		// TODO Auto-generated method stub
		System.out.println("Employees with salary less than the amount entered");
		treeSetNavigable.headSet(emp);
		System.out.println("Employees with salary greater than or equal to the amount entered");
		treeSetNavigable.tailSet(emp);
	}

	public void leasetAndMostSalariedEmployee() {
		// TODO Auto-generated method stub
		System.out.println("Least Salaried Employee");
		treeSetNavigable.first();
		System.out.println("Most Salaried Employee");
		treeSetNavigable.last();
	}

	public void traverseList() {
		// TODO Auto-generated method stub
		System.out.println("List default sorted by TreeSet ");
		for (Employee emp: treeSetNavigable)
		{
			System.out.println(emp.getName());
			System.out.println(emp.getAge());
			System.out.println(emp.getSalary());
		}
		
		// Note: Changes to navigableSet will be reflected in the original Set
		System.out.println("Original List sorted in descending order using Navigable Set");
		
		NavigableSet<Employee> navigableSet = treeSetOriginal.descendingSet();
		
		for (Employee emp: navigableSet)
		{
			System.out.println(emp.getName());
			System.out.println(emp.getAge());
			System.out.println(emp.getSalary());
		}
		
		System.out.println("Deleting one employee from the descending set created");
		for (Employee emp:navigableSet)
		{
			navigableSet.remove(emp);
			break;
		}
		
		System.out.println("Original List altered because of descedingSet operation. But order"
				+ "of employees is preserved");
		
		for (Employee emp: treeSetOriginal)
		{
			System.out.println(emp.getName());
			System.out.println(emp.getAge());
			System.out.println(emp.getSalary());
		}
	}

	public boolean deleteElement(String empName) {
		// TODO Auto-generated method stub
		for (Employee emp:treeSetNavigable)
		{
			if(emp.getName().equalsIgnoreCase(empName))
			return(treeSetNavigable.remove(emp));	
		}
		
		return false;
	}

	public boolean addElement(Employee element) {
		// TODO Auto-generated method stub
		// Employees will be added provided they do not have the same salary amount
		//because we have implemented compareTo with "salary" attribute in Employee class.
		Iterator<Employee> itr = treeSetNavigable.iterator();
		while (itr.hasNext()	)
		{
			if(element.equals(itr.next()))
				System.out.println("employee already present");
			break;
		}
		return(treeSetNavigable.add(element));
	}
}
