//Name     : Minjie Fan
//Class    : CSCI 1620
//Program #: 5
//Due Date : 8/7/2015
//
//Honor Pledge :  On my honor as a student of the University of Nebraska at Omaha, I have neither given nor received unauthorized help on this homework assignment.
//
//NAME     : Minjie Fan
//NUID     : 738
//EMAIL    : mfan@unomaha.edu
//
//Partners : none
//
//Description  :This program is designed to have the user enter an infix expression. It will then convert the infix to postfix, and evaluate the postfix expression.

public class LinkedList<E> {

    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private Integer numElements;
    private String name;
    
    //Method Name       : LinkedList() 
    //Parameters        : None
    //Return value(S)   : None
    //Description       : This is the constructor.
    public LinkedList() 
    {
    	this.name = "list";
    	this.firstNode = null;
    	this.lastNode = null;
    	this.numElements = 0;
    }
  
    //Method Name       : LinkedList()
    //Parameters        : String listName
    //Return value(S)   : None
    //Description       : This is the constructor.
  
    public LinkedList(String listName) 
    {
    	this.name = listName;
    	this.firstNode = null;
    	this.lastNode = null;
    	this.numElements = 0;
    }

    //Method Name       : insertAtFront()
    //Parameters        : E item
    //Return value(S)   : None
    //Description       : the class insert the front.

    public void insertAtFront(E item) 
    {
    	if (isEmpty())
    		firstNode = lastNode = new ListNode<E>(item);
    	else
    		firstNode = new ListNode<E>(item, firstNode);
    	numElements++;
    }

    //Method Name       : insertAtBack()
    //Parameters        : E item
    //Return value(S)   : None
    //Description       : the class insert the back.

    public void insertAtBack(E item) 
    {
    	if (isEmpty())
    		firstNode = lastNode = new ListNode<E>(item);
    	else
    	{
    		lastNode.setNext(new ListNode<E>(item));
    		lastNode = lastNode.getNext();
    	}
    	numElements++;
    }

    //Method Name       : removeFromFront()
    //Parameters        : None
    //Return value(S)   : E
    //Description       : the class removes the first element of the list.
  
    public E removeFromFront() throws EmptyListException
    {
    	E removeItem = null;
    	if (isEmpty())
    		throw new EmptyListException(name);

    	removeItem = firstNode.getData();

    	if (firstNode.equals(lastNode))
    		firstNode = lastNode = null;
    	else
    		firstNode = firstNode.getNext();
    	numElements--;
    	return removeItem;
    }		
  
    //Method Name       : removeFromBack()
    //Parameters        : None
    //Return value(S)   : E 
    //Description       : this class remove the last element of the list.
  
    public E removeFromBack() throws EmptyListException
    {
    	E removeItem = null;

    	if (isEmpty())
    		throw new EmptyListException(name);

    	removeItem = lastNode.getData();

    	if (firstNode.equals(lastNode))
    		firstNode = lastNode = null;
    	else 
    	{
    		ListNode<E> current = firstNode;
          
    		while (current.getNext() != lastNode) 
    		{
    			current = current.getNext();
    		}

    		lastNode = current;
    		current.setNext(null);
    	}
    	numElements--;
    	return removeItem;
    }
  
    //Method Name       : remove()
    //Parameters        : Integer index
    //Return value(S)   : None
    //Description       : this class remove a element.
  
    public void remove(Integer index) throws EmptyListException, IndexOutOfBoundsException 
    {
    	if(isEmpty())
    	{
    		throw new EmptyListException(name);
    	}
    	if (index < 0 || index >= numElements) 
    	{
    		throw new IndexOutOfBoundsException(name);
    	}
    	ListNode<E> temp = firstNode;

    	if(index == 0)
    	{
    		removeFromFront();
    		return;
    	}

    	for (int i = 0; i < index-1; i++) 
    	{
    		temp = temp.getNext();
    	}

    	temp.setNext(temp.getNext().getNext());
    	numElements--;
    }
    
    //Method Name       : get()
    //Parameters        : Integer index
    //Return value(S)   : E
    //Description       : this class gets a element.
  
    public E get(Integer index) throws EmptyListException,IndexOutOfBoundsException 
  	{
      	if(isEmpty())
      	{
          	throw new EmptyListException(name);
      	}
      	if (index < 1 || index >= numElements) 
      	{
          	throw new IndexOutOfBoundsException(name);
      	}
      	
      	ListNode<E> temp = firstNode;
      	
      	for (int i = 0; i < index; i++) 
      	{	
          	temp = temp.getNext();
      	}
      	return temp.getData();
  	}
  
    //Method Name       : findAndRemove()
    //Parameters        : E item
    //Return value(S)   : Boolean
    //Description       : this class finds the element and remove.
  
  	public Boolean findAndRemove(E item) throws EmptyListException 
  	{
      	if(isEmpty())
      	{
          	throw new EmptyListException(name);
      	}
      	Integer index = findItem(item);
      	if (index == -1) 
      	{
          	return false;
      	}
      	this.remove(index);
      	return true;

  	}
  
    //Method Name       : findItem()
    //Parameters        : E item
    //Return value(S)   : Integer
    //Description       : this class finds the index of the element.
  
  	public Integer findItem(E item) 
  	{
      	ListNode<E> temp = firstNode;

      	for (int i = 0; i < numElements; i++) 
      	{
          	if (item.equals(temp.getData())) 
          	{
              	return i;
          	}
          	temp = temp.getNext();
      	}
      	return -1;
  	}
  
    //Method Name       : lengthIs() 
    //Parameters        : None
    //Return value(S)   : Integer
    //Description       : the class gets the length
  
  	public Integer lengthIs() 
  	{
      	return numElements;
  	}
  
    //Method Name       : clear() 
    //Parameters        : None
    //Return value(S)   : None
    //Description       : this class remove the list.
  
  	public void clear() 
  	{
      	this.firstNode = this.lastNode = null;
      	this.numElements = 0;
  	}
  
    //Method Name       : print() 
    //Parameters        : None
    //Return value(S)   : None
    //Description       : this class prints the list.
  
  	public void print() 
  	{
  		if (isEmpty()) 
  		{
  			System.out.println("Empty " + name);
  			return;
  		}
  		System.out.print("The list " + name + " is:");
  		ListNode<E> current = firstNode;

  		while (current != null) 
  		{
  			System.out.print(" ");
            System.out.print(current.getData().toString() + "");
          	current = current.getNext();
      	}
      	System.out.println("");
  	}

  
    //Method Name       : isEmpty()
    //Parameters        : None
    //Return value(S)   : Boolean
    //Description       : this class judges whether the list is empty.
  
  	public Boolean isEmpty() 
  	{
  		return firstNode == null;
  	}

    

}
