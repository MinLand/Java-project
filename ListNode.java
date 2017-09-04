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
public class ListNode<E> {
	private E data;
	private ListNode<E> nextNode;
      
    //Method Name       : ListNode()
    //Parameters        : E d
    //Return value(S)   : None
    //Description       : This is the constructor.
     
    public ListNode(E d) 
    {
    	data = d;
    	nextNode = null;
    }
    
    //Method Name       : ListNode()
    //Parameters        : E d, ListNode<E> node
    //Return value(S)   : None
    //Description       : This is the constructor.
    
    public ListNode(E d, ListNode<E> node)
    {
    	data = d;
    	nextNode = node;
    }
          
    //Method Name       : setData(
    //Parameters        : E d
    //Return value(S)   : None
    //Description       : The class sets the data.
          
    public void setData(E d) 
    {
    	data = d;
    }
    
    //Method Name       : getData() 
    //Parameters        : None
    //Return value(S)   : E data
    //Description       : The class gets the data.
    public E getData() 
    {
    	return data;
    }
    
    //Method Name       : setNext()
    //Parameters        : ListNode<E> next
    //Return value(S)   : None
    //Description       : This class sets the value of ListNote.
    public void setNext(ListNode<E> next)
    {
    	nextNode = next;
    }
          
    //Method Name       : getNext()
    //Parameters        : None
    //Return value(S)   : ListNode<E>
    //Description       : This class gets the next node.
    
    public ListNode<E> getNext() 
    {
    	return this.nextNode;
    }
}
