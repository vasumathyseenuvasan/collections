import java.util.*;
import java.lang.*;


public class LinkedListOperations {

	private LinkedList<String> linkedList = new LinkedList<String>();

	  
	public void linkedListOperations()
	{
		System.out.println("Linked List Operations");
		System.out.println("Enter Linked list elements");
		
		LinkedListOperations objLinkedList =new LinkedListOperations();
		
		String isContinueOption;
		Scanner scanArrayList = new Scanner(System.in);
		String linkedListElements = scanArrayList.nextLine();
		
		String[] arrLinkedListElements = linkedListElements.split(" ");
		
		for(String str:arrLinkedListElements)
		{
			linkedList.add(str);
		}
				
		Scanner inputChoice;
		String choice;
		Scanner inputElement; 
		String element="";
		
		do
		{
		System.out.println("Enter your choice. 1. add 2. delete 3. print list 4. iterate in reverse order");
//		8. peek (retrieve first element) 8. poll (retrieve and remove first element)"
//				+ "\n" +"9. pop (pops as in stack) 10. push (as in stack) 11. 
		inputChoice = new Scanner(System.in);
		choice = inputChoice.next();
				
		if(choice.equals("1") || choice.equals("2"))
		{
			System.out.println("Enter the element");
			inputElement = new Scanner(System.in);
			element = inputElement.next();	
		}
		
		if(choice.equals("1"))
		{
			addElement(element);
		}
		else if(choice.equals("2"))
		{
			removeElement(element);
		}
		else if(choice.equals("3"))
		{
			traverseElement();
		}
		else if(choice.equals("4"))
		{
			iterateInReverseOrder();
		}
		else
		{
			System.out.println("Enter a valid choice");
		}
		System.out.println("Do you want to continue? Yes or no");
		Scanner isContinue = new Scanner(System.in);
		isContinueOption = isContinue.next();
		}while(isContinueOption.equalsIgnoreCase("yes"));
	}

	public void iterateInReverseOrder() {
		// TODO Auto-generated method stub
		System.out.println("list in reverse order using descendingIterator iterator");
		Iterator itr = linkedList.descendingIterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

	public void traverseElement() {
		// TODO Auto-generated method stub
		System.out.println("list as it is");
		for(String obj: linkedList)
		{
			System.out.println(obj);
		}
		System.out.println("list in reverse order");
		Collections.reverse(linkedList);
		for(String obj: linkedList)
		{
			System.out.println(obj);
		}
	}

	public void removeElement(String element) {
		// TODO Auto-generated method stub
		System.out.println("Removing elements by different methods");
		linkedList.remove(element + "is removed using remove()");
		traverseElement();
		linkedList.poll();
		System.out.println("head removed using poll()");
		traverseElement();
		linkedList.pop();
		System.out.println("head removed using pop()");
		traverseElement();
	}

	public void addElement(String element) {
		// TODO Auto-generated method stub
		System.out.println("Added element at last");
		linkedList.addLast(element + "last");
	   	//linkedList.add("Added Last"); - will also add the element to the end
		System.out.println("Added element at first");
		linkedList.addFirst("first" + element);
		System.out.println("Add element as in Stack push (adding at last)");
		linkedList.push(element + "pushed");
		traverseElement();		
	}
}
