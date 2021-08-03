import java.util.Scanner;
import java.io.*;

public class EvaluateExpression
{
	public static void main(String[] args) throws IOException
	{
		double value;
		
		LinkedList list = new LinkedList();
		
		String variable, input = "value.txt";
		
		Scanner scan = new Scanner(new File(input));
		
		//read value.txt and populate list
		while (scan.hasNext())
		{
			variable = scan.next();
			value = scan.nextDouble();
			Valuedata data = new Valuedata(variable, value);
			list.insertBack(data);
			data = null;
		}
		
		double result = find(list.getHead(), "b");	//Should return 5.2
		System.out.println(result);
		
		result = find(list.getHead(), "a");	//Should return 3.6
		System.out.println(result);
		
		//Phase 2 quiz 6
		//In this work we will evaluate postfix expression usually we will convert in fix expression (a+b)*c into postfix (ab+c*) the we will use stackto evaluate the postfix expression this is the application for a calc ab+c* when you see a find its value and push to top of stack
		//step 1: stack 3.6 (top) 
		//step 2: find value of b and push onto top of stack 
		//step 3: when you see operator like + you will pop off 2 numbers on the stack apply operator and push results back onto stack (5.2 + 3.6 = 8.8(top))
		//step 4: push c on top of stack 2.0 (top) 8.8 (below)
		//step 5: pop off the two numbers multiply together then push result back onto stack (17.6(top))

		String file = "expression.txt";
		Scanner scan3 = new Scanner(new File(file));
		String expression = scan3.next();
		ObjectStack stk = new ObjectStack();
		double a, b, answer = 0;
		//process each symbol
		//two types: characters and operators
		for (int i = 0; i < expression.length(); ++i)
		{
			if (expression.charAt(i) == '-')
			{
				b = (double) stk.pop();
				a = (double) stk.pop();
				answer = a - b;
				stk.push(answer);
			}
			else if (expression.charAt(i) == '+')
			{
				try 
				{
				b = (double) stk.pop();
				a = (double) stk.pop();
				answer = a + b;
				stk.push(answer);
				}
				catch (EmptyStackException e)
				{
					System.out.println(e);
				}
			}
			else if (expression.charAt(i) == '*')
			{
				b = (double) stk.pop();
				a = (double) stk.pop();
				answer = a * b;
				stk.push(answer);
			}
			else if (expression.charAt(i) == '/')
			{
				b = (double) stk.pop();
				a = (double) stk.pop();
				answer = a / b;
				stk.push(answer);
			}
			else
			{
				//otherwise it is variable name
				//find value and push onto stack
				double val;
				val = find(list.getHead(), expression.substring(i, i + 1));
				stk.push(val);
			}
		}
		//pop off final result on the stack, which is result of postfix notation
		System.out.println(stk.pop());
		
		//Just so Eclipse stops yelling at me
		scan.close();
		scan3.close();
	}
	
	//Given variable name return its value
	public static double find(LinkedListNode head, String s)
	{
		/*My answer*/
		String target = (((Valuedata)head.getData()).getVariable());
		
		while (!target.contentEquals(s))
		{
			head = head.getNext();
			target = (((Valuedata)head.getData()).getVariable());
		}
		if (target.contentEquals(s))
		{
			double data = (((Valuedata)head.getData()).getValue());
			return data;
		}
		else			
		{
			System.out.println("Error: target could not be found");
			return 0;
		}
		/*Right answer*/
		/*LinkedListNode current = new LinkedListNode(head);
		
		while (current != null)
		{
			Valuedata data = (Valuedata)current.getData();
			if (data.getVariable().equals(s))
			{
				return data.getValue();
			}
			current = current.getNext();
		}
		return 0;*/	
	}
}