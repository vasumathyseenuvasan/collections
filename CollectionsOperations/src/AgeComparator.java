import java.util.Comparator;


public class AgeComparator implements Comparator<Employee> {

	public int compare(Employee e1, Employee e2)
	{
		// Comparing age 
		// return e1.getAge() - e2.getAge();
		
		// Comparison of more than one field is allowed.
		// For Example, Compare by name first and then age. If two names are equal, then 
		//sort those objects by age.
		int nameComp = e1.getName().compareTo(e2.getName());
		if(nameComp == 0)
			return e1.getAge() - e2.getAge();
		else
			return nameComp;
	}
	
}
