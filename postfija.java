package compilador_ab;

public class postfija
{
	String cadena;
	int puntero1=0,puntero2=0,controlArreglo;
	String []arreglo=new String[7];
	String[] convertir(String cadena)
	{
		String postfija="";
		this.cadena=cadena;

		separar();

		for (controlArreglo=0;controlArreglo<7;controlArreglo++)
		{
			if(arreglo[controlArreglo].equals("+")==true||arreglo[controlArreglo].equals("-")==true||arreglo[controlArreglo].equals("*")==true)
			{
				if((arreglo[controlArreglo-1].equals("+")==true||arreglo[controlArreglo-1].equals("-")==true)&& (arreglo[controlArreglo].equals("*")==true))//si la posicion anterior es un operador y no es un *
				{
						interOperadores();
						moverDosOperadores();
				}
				else
				{
					moverSigOperando();
				}
			}
		}
		return arreglo;
	}

	void separar() //realiza un arreglo con los operandos y operadores separados
	{
		int cont_arreglo=0;
		String temporal="";
		for(int i =0;i<cadena.length();i++)
		{
			if(cadena.charAt(i)=='+'||cadena.charAt(i)=='*'||cadena.charAt(i)=='-')
			{
				arreglo[cont_arreglo]=temporal;//sera igual al numero que se haya acumulado en temporal
				cont_arreglo++;
				arreglo[cont_arreglo]=Character.toString(cadena.charAt(i));
				cont_arreglo++;
				temporal="";
			}
			else
			{
				temporal+=cadena.charAt(i);
			}
		}
		arreglo[cont_arreglo]=temporal;
	}

	void moverSigOperando()//mueve el operador despues del operando mas proximo
	{
		controlArreglo++;
		if(arreglo[controlArreglo].equals("+")==false||arreglo[controlArreglo].equals("-")==false||arreglo[controlArreglo].equals("*")==false)
		{
			String temporal=arreglo[controlArreglo-1];//guardamos el operador
			arreglo[controlArreglo-1]=arreglo[controlArreglo];
			arreglo[controlArreglo]=temporal;
		}
		else{//si es un numero avanzar a la sig posicion
			controlArreglo++;
		}
	}

	void interOperadores()//intercambia de lugar los operadores
	{
		String temporal=arreglo[controlArreglo-1];
		arreglo[controlArreglo-1]=arreglo[controlArreglo];
		arreglo[controlArreglo]=temporal;
		System.out.println("");
	}

	void moverDosOperadores()//mueve el operador actual y el anterior al sig operando
	{
		String operador1=arreglo[controlArreglo-1];
		String operador2=arreglo[controlArreglo];
		controlArreglo++;
		arreglo[controlArreglo-2]=arreglo[controlArreglo];
		arreglo[controlArreglo-1]=operador1;
		arreglo[controlArreglo]=operador2;
		System.out.println("");
	}
}
