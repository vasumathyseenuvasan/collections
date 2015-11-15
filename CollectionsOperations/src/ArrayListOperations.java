import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.awt.im.InputContext;
import java.io.*;


public class ArrayListOperations {
	
	private List<String> nameList = new ArrayList<String>();
	
	public void addElement(String element)
	{
		nameList.add(element);
	}

	public void traverseElement()
	{
	 System.out.println("Printing the list by for loop");
	 for(String names:nameList)
		 System.out.println(names+ ",");
	 
	 System.out.println("Printing the list using Iterator");
	 Iterator<String> itr = nameList.iterator();
	 while(itr.hasNext())
	 {
		 System.out.println(itr.next());
	 }
	 
	 System.out.println("Printing using List Iterator");
	 ListIterator<String> listItr= nameList.listIterator();
	 
	 System.out.println("Printing in forward direction");
	 while(listItr.hasNext())
	 {
		System.out.println(listItr.next());
	 }
	 
	 System.out.println("Printing in backward direction");
	 while(listItr.hasPrevious())
	 {
		System.out.println(listItr.previous()); 
	 }
	 
	}
	
	public void removeElement(String element)
	{
		nameList.remove(element);
	}
	
	public void replaceElement(String elementToBeReplaced,String elementToReplace)
	{
//		if(nameList.indexOf(elementToBeReplaced) != -1)
//			nameList.set(nameList.indexOf(elementToBeReplaced), elementToReplace);
//		else
//			System.out.println("Element not found");
		
		ListIterator<String> listItr = nameList.listIterator();
		while(listItr.hasNext())
		{
			if(listItr.next().equals(elementToBeReplaced))
			listItr.set(elementToReplace);
		}
	}
	
	public void findIndex(String element)
	{
		for(String names:nameList)
		{
			if(names.equalsIgnoreCase(element))
			{
				System.out.println("Index of the specified elee"+nameList.indexOf(element));
			}
		}
	}
	
	public void removeAllRetainAll()
	{
		System.out.println("remove all and retain all sample");
		List<String> remove = new ArrayList<String>(Arrays.asList("vasu","mathy","krish"));
		System.out.println(nameList+"remove all"+remove);
		nameList.removeAll(remove);
		System.out.println("Final List"+nameList);
		
		remove = new ArrayList<String>(Arrays.asList("vasu","mathy","krish", "kalyani"));
		List<String> retain = new ArrayList<String>(Arrays.asList("vasu","mathy","krish"));
		System.out.println(remove+"retain all"+retain);
		remove.retainAll(retain);
		System.out.println("Final List" + remove);
		;
	}
	
	//public static void main(String args[])
	public void arrayListOperations()
	{
			
		System.out.println("Array List Operations");
		System.out.println("Enter Array  list elements");
			
		ArrayListOperations objArrayListOperations = new ArrayListOperations();
		
		String isContinueOption;
		Scanner scanArrayList = new Scanner(System.in);
		String arrayListElements = scanArrayList.nextLine();
		
		String[] arrayElements = arrayListElements.split(" ");
		
		for(String str: arrayElements)
		{
			addElement(str);
		}
		
		String choice;
		String element="";
		Scanner inputChoice;
		Scanner scan;
		
		do
		{
		System.out.println("Enter your choice. 1. add 2. delete 3. print list 4.Find the index 5. replace an element"
				+"/n"+"6.removeAll_and_retainAll_Sample");
		
		inputChoice = new Scanner(System.in);
		choice = inputChoice.next();
						
		if(choice.equals("1") || choice.equals("2") || choice.equals("4") 
				|| choice.equals("5"))
		{
			System.out.println("Enter the element");
			inputChoice = new Scanner(System.in);
			element = inputChoice.next();	
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
			findIndex(element);
		}
		else if(choice.equals("5"))
		{
			System.out.println("Enter the element to replace");
			inputChoice = new Scanner(System.in);
			replaceElement(element,inputChoice.next());
		}
		else if(choice.equals("6"))
		{
			removeAllRetainAll();
		}
		else
		{
			System.out.println("Enter a valid choice");
		}
		System.out.println("Do you want to continue? Yes or no");
		inputChoice = new Scanner(System.in);
		isContinueOption = inputChoice.next();
		}while(isContinueOption.equalsIgnoreCase("yes"));
	}
}
