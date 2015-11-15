import java.util.Scanner;


public class CollectionsMain {

	public static void main (String args[])
	{
		String isContinue="";
		
		do
		{
			System.out.println("Choose the one of the Collections to explore it");
			System.out.println("1. ArrayList 2. LinkedList 3. HashSet 4. TreeSet 5.HashMap");
					
			Scanner scan = new Scanner(System.in);
			String userChoice = scan.next();
			
			
		switch(userChoice)
		{
		case "1":
		ArrayListOperations objArrayListOperations = new ArrayListOperations();
		objArrayListOperations.arrayListOperations();
	    break;
		case "2":
		LinkedListOperations objLinkedListOperations = new LinkedListOperations();
		objLinkedListOperations.linkedListOperations();
		break;
		case "3":
		HashSetOperations objHashSetOperations = new HashSetOperations();
		objHashSetOperations.hashSetOperations();
		break;
		case "4":
			TreeSetOperations objTreeSetOperations = new TreeSetOperations();
			objTreeSetOperations.treeSetOperations();
			break;
		case "5":
			HashMapOperations objHashMapOperations = new HashMapOperations();
			objHashMapOperations.hashMapOperations(); 
			break;
		default:
			System.out.println("Enter valid Collection number");
			break;
		}
		System.out.println("Do you want to continue exploring the collections? Enter 'Yes' or 'No'");
		scan = new Scanner(System.in);
		isContinue = scan.next();
		}while(isContinue.equalsIgnoreCase("yes"));
		//scan.close();
		System.exit(0);
	}
	
}
