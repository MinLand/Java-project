import java.util.Scanner;
import java.util.Stack;

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

public class Postfix {
	
    private static Stack<Character> stack;
    private static Stack<Double> theStack;
    private static Scanner in;

    //Method Name       : infixToPostfix()
    //Parameters        : to convert a character string
    //Return value(S)   : postfix expression string
    //Throws            : InvalidCharacterException  Invalid string exception
    //Description       : The class is designed to transfer the infix expression into postfix expression.

    public static StringBuffer infixToPostfix(StringBuffer infix)throws InvalidCharacterException 
    {
        stack = new Stack<Character>();
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < infix.length(); i++) 
        {
            Character temp = infix.charAt(i);
            if (!temp.equals('(') && !temp.equals(')') && !temp.equals('+')
                    && !temp.equals('-') && !temp.equals('*')
                    && !temp.equals('/') && !temp.equals('%')
                    && !temp.equals(' ') && !(temp <= '9' && temp >= '0')) 
            {

                throw new InvalidCharacterException(temp);
            }

            if (temp.equals('+') || temp.equals('-')) 
            {
                if (stack.isEmpty() || stack.peek().equals(Character.valueOf('('))) 
                {
                    stack.push(temp);
                }else 
                {
                    while (!stack.isEmpty() && (stack.peek().equals('*') 
                    		|| stack.peek().equals('/') || stack.peek().equals('+') 
                    		|| stack.peek().equals('-') || stack.peek().equals('%'))) 
                    {
                        s.append(stack.peek());
                        stack.pop();
                    }
                    stack.push(temp);
                }
            } else if (temp == '*' || temp == '/' || temp == '%') 
            {
                if (stack.isEmpty() || stack.peek().equals('+')
                        || stack.peek().equals('-') || stack.peek().equals('(')) 
                {
                    stack.push(temp);
                } else 
                {
                    while (!stack.isEmpty()
                            && (stack.peek().equals('*')
                                || stack.peek().equals('/') || stack.peek()
                                .equals('%'))) 
                    {
                        s.append(stack.peek());
                        stack.pop();
                    }
                    stack.push(temp);
                }
            } else if (temp == '(') 
            {
                stack.push(temp);
            } else if (temp == ')') 
            {
                Character test = ' ';
                while (!(test = stack.pop()).equals('(')) 
                {
                    s.append(test);
                }
            } else 
            {
                s.append(temp);
            }
        }
        if (!stack.isEmpty()) 
        {
            while (!stack.isEmpty()) 
            {
                s.append(stack.peek());
                stack.pop();
            }
        }
        return s;
    }

    //Method Name       : evaluatePost()
    //Parameters        : postfix expression
    //Return value(S)   : double inetAns
    //Description       : The class is designed to evaluate postfix expression.
    public static double evaluatePost(StringBuffer postfix) 
    {
        theStack = new Stack<Double>(); 
        char ch;
        int j;
        Double num1, num2, interAns;
        for (j = 0; j < postfix.length(); j++) 
        {
            ch = postfix.charAt(j);

            if (ch == ' ') 
            {
                continue;
            } else if (ch >= '0' && ch <= '9') 
            {
                theStack.push((double) (ch - '0'));
            } else {
                num2 = theStack.pop();
                num1 = theStack.pop();
                switch (ch) 
                {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    case '%':
                        interAns = num1 % num2;
                        break;
                    default:
                        interAns = 0.0;
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop();
        return interAns;
    }
    
    public static void main(String[] args) 
    {
        while (true) 
        {
            in = new Scanner(System.in);
            String input;
            StringBuffer infix;
            System.out.print("Enter infix expression: ");
            input = in.nextLine();
            infix = new StringBuffer(input);
            StringBuffer postfix = new StringBuffer();
            try 
            {
                postfix = infixToPostfix(infix);
                System.out.println("The postfix expression is:" + postfix );
                Double result = evaluatePost(postfix);
                System.out.println("The expression evaluates to: " + result );
                System.out.println("");
            } catch (InvalidCharacterException e) 
            {
                System.out.println(e);
            }
        }
    }
    

}
