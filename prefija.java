package compilador_ab;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class prefija
{
	String convertir(String cadena)
	{
		Stack < String > pila_operadores = new Stack < String > ();
		Stack < String > pila_prefija = new Stack < String > ();
		Queue<String> colaoperandos=new LinkedList();
		String prefija="";
		String [] arreglo=cadena.split("(\\+|\\-|x)");
		for(int i=arreglo.length-1; i>=0;i--)//analizar arreglo
		{
			String elemento=arreglo[i];//obtenemos el ultimo elemento del arreglo
			
			if(elemento.equals("+")||elemento.equals("-")||elemento.equals("*"))// si es un operador
			{	
				pila_operadores.push(elemento);//lo metemos a la pila de operadores
			}	
			else //si es un operando 
			{
				colaoperandos.add(elemento); //lo metemos a la cola de operandos
			}
			
			if(colaoperandos.size()==2)//si ya hay dos operandos en la cola
			{
				while(colaoperandos.isEmpty()!=true)// mientras tenga elementos
				{
					pila_prefija.push(colaoperandos.poll());//sacamos los elementos de la cola de operandos y los guardamos en la pila final
					
				}
				pila_prefija.push(pila_operadores.pop());//metemos el elemento en la cima de la pila de operadores a la pila final
			}
		}
		while(pila_prefija.isEmpty()!=true)
		{
			prefija+=pila_prefija.pop();
		}
		
		return prefija;
	}

}
