//Name     : Minjie Fan
//Class    : CSCI 1620
//Program #    : Postfix
//Due Date : Aug 13th 2015
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

public class Stack<E> {
    private LinkedList<E> list;
    //Method Name       : Stack()
    //Parameters        : None
    //Return value(S)   : None
    //Description       : This is the constructor of MyStack
  
    public Stack()
    {
        list = new LinkedList<E>();
    }
    
    //Method Name       : Stack()
    //Parameters        : item  Afferent type; name  stack name
    //Return value(S)   : 
    //Description       : This is the constructor of MyStatck.
 
    public Stack(String name)
    {
        list = new LinkedList<E>(name);
    }
    
    //Method Name       : Push()
    //Parameters        : E item
    //Return value(S)   : None
    //Description       : The class is designed to push stack.

    public void push(E item)
    {
        list.insertAtFront(item);
    }
    
    //Method Name       : pop()
    //Parameters        : None
    //Return value(S)   : E o
    //Description       : The class is designed to pop stack.
 
    public E pop()
    {
        E o = list.get(0);
        list.findAndRemove(o);
        return o;
    }
    
    //Method Name       : lengthIs()
    //Parameters        : None
    //Return value(S)   : the length of stack
    //Description       : The class is designed to calculate the length of stack.

    public int lengthIs()
    {
        return list.lengthIs();
    }
    
    //Method Name       : peek()
    //Parameters        : None
    //Return value(S)   : peeked item
    //Description       : The class is designed to peek the stack item, but not pop out.

    public E peek()
    {
        return list.get(0);
    }
    
    //Method Name       : print()
    //Parameters        : None
    //Return value(S)   : None
    //Description       : The class is designed to print the information of stack.

    public void print()
    {
        list.print();
    }
    
    //Method Name       : isEmpty()
    //Parameters        : None
    //Return value(S)   : Boolean list.isEmpty()
    //Description       : The class is designed to judge whether the stack is empty.
    
    public Boolean isEmpty()
    {
        return list.isEmpty();
    }

}
