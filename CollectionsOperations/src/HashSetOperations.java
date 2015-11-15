import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class HashSetOperations {

	private Set<String> hashSet = new HashSet<String>();
	
	public void hashSetOperations()
	{
		System.out.println("Hash Set Operations");
		System.out.println("Enter Hash Set elements");
		
		String isContinueOption;
		Scanner scanHashSet = new Scanner(System.in);
		String hashSetElements = scanHashSet.nextLine();
		
		String[] arrhashSetElements = hashSetElements.split(" ");
		
		for(String str:arrhashSetElements)
		{
			addElement(str);
		}
		
		Scanner inputChoice;
		String choice;
		String element="";
		List<String> hashSetArrayList = new ArrayList<String>();
		
		do
		{
		System.out.println("Enter your choice. 1. add an element 2. Hash Set from an existing arrayList 3. delete 4. Iterate and Print 5. Set Size 6.Sort the set");
//		8. peek (retrieve first element) 8. poll (retrieve and remove first element)"
//				+ "\n" +"9. pop (pops as in stack) 10. push (as in stack) 11. 
		inputChoice = new Scanner(System.in);
		choice = inputChoice.next();
				
		if(choice.equals("1") || choice.equals("3"))
		{
			System.out.println("Enter the element");
			inputChoice = new Scanner(System.in);
			element = inputChoice.next();	
		}
		
		switch(choice)
		{
		case "1":
			if(!addElement(element))
				System.out.println("Same element cannot be inserted twice");
			break;
		case "2":
			System.out.println("Enter Array List elements");
			
			Scanner scanArrayList = new Scanner(System.in);
			String arrayListElements = scanArrayList.next();
			
			String[] arrHashSetElements = arrayListElements.split(" ");
			hashSetArrayList = Arrays.asList(arrHashSetElements);
			createHashSetFromCollections(hashSetArrayList);
			break;
		case "3":
			if(!deleteElement(element))
				System.out.println("No such element is present");
			break;
		case "4":
			traverseList();
			break;
		case "5":
			listSize();
			break;
		case "6":
			sortSet();
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

	public void sortSet() {
		// TODO Auto-generated method stub
		Set<String> sortedSet = new TreeSet<String>(hashSet);
		
		Iterator<String> itr = sortedSet.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

	public void listSize() {
		// TODO Auto-generated method stub
		hashSet.size();
	}

	public void traverseList() {
		// TODO Auto-generated method stub
		Iterator<String> itr = hashSet.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

	public boolean deleteElement(String element) {
		// TODO Auto-generated method stub
		return(hashSet.remove(element));
	}

	public void createHashSetFromCollections(List<String> hashSetArrayList) {
		// TODO Auto-generated method stub
		Set<String> newHashSet = new HashSet<String>(hashSetArrayList);
		System.out.println("New HashSet is:");
		
		for(String obj: newHashSet)
		{
			System.out.println(obj);
		}
	}

	public boolean addElement(String element) {
		// TODO Auto-generated method stub
		
		return(hashSet.add(element));
	}

}
