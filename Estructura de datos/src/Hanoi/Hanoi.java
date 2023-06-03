package Hanoi;

import java.util.Scanner;
import java.util.Stack;

public class Hanoi 
{
	static Stack<Integer> a=new Stack<>(),
			b=new Stack<>(), c=new Stack<>();
	static int cont=0;
	public static void main (String[]args)
	{
		Scanner teclado = new Scanner (System.in);
		int discos;
		System.out.println("Cuantos discos deseas?");
		discos=teclado.nextInt();
		for (int i=discos;i>0;i--)
		{
			a.push(i);
		}
		show(a,b,c);
		hanoi(a,b,c,discos);
		System.out.println("Estado final de las torres de hanoi :");
		show(a,b,c);
		System.out.println("Total de movimientos es: "+cont);
	}
	
	public static void hanoi(Stack a, Stack b, Stack c,int n)
	{
		if (n==1)
			move(a,b);
		else
		{
			hanoi(a,c,b,-1);
			move(a,b);
			hanoi(c,b,a,-1);
		}
	}
	
	public static void move (Stack a, Stack b)
	{
		b.push(a.pop());
	}
	
	public static void show(Stack a, Stack b, Stack c)
	{
		Stack Aux_a=new Stack<>();
        Stack Aux_c=new Stack<>();
        Stack Aux_b=new Stack<>();

        Object x;
        while (!a.empty())
        {   
          x=a.pop();
          Aux_a.push(x);
          System.out.println(x.toString());
        }
        while (!Aux_a.empty())
        {   
           x=Aux_a.pop();
           a.push(x);
        }

        Object y;
        while (!b.empty())
        {   
          y=b.pop();
          Aux_b.push(y);
          System.out.println(y.toString());
        }
        while (!Aux_b.empty())
        {   
          y=Aux_b.pop();
          b.push(y);
        }

        Object z;
        while (!c.empty())
        {   
          z=c.pop();
          Aux_c.push(z);
          System.out.println(z.toString());
        }
        while (!Aux_c.empty())
        {   
          z=Aux_c.pop();
          c.push(z);
        }
	}
}
