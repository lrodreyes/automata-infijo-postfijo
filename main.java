package compilador_ab;
import java.util.Arrays;

import javax.swing.*;
public class main
{
	public static void main (String args[])
	{
		while(true)
		{
			char arreglo[]; //ARREGLO DE CARACTERES
			boolean v=true; //INDICA SI LA CADENA ES CORRECTA O INCORRECTA
			int x=0,y=0; //LLEVAR EL CONTROL DE LA MATRIZ
			char caracter;
			int grafo[][]= //GRAFO CON LAS DIRECCIONES//LA TERCERA COLUMNA REPRESENTA CUALQUIER COSA DIFERENTE DE 'A' O 'B'//50 REPRESENTA UN ERROR
				{
					  ///a b  !=
						{0,1,50},
						{1,2,50},
						{2,3,50},
						{3,50,50},
				};

			String cadena=JOptionPane.showInputDialog("Ingresa la operacion");
			arreglo=new char[cadena.length()];
			arreglo=cadena.toCharArray();

			//FOR PARA RECORRER EL ARREGLO DE CARACTERES
			for(int i=0;i<arreglo.length;i++)//MIENTRAS AUN NO HAYA RECORRIDO TODO EL ARREGLO Y LOS CARACTERES SEAN CORRECTOS
			{
				caracter=arreglo[i]; //OBTENEMOS EL PRIMER CARACTER
                                String c = "" + caracter; // CONVERTIMOS CARACTER A STRING PARA PODER INSERTAR EN UNA PILA

				if(caracter=='0'||caracter=='1'||caracter=='2'||caracter=='3'||caracter=='4'||caracter=='5'||caracter=='6'||caracter=='7'||caracter=='8'||caracter=='9')
				{
                                    y=0;

				}
				else if(caracter=='*' || caracter=='+' || caracter=='-')
				{
					y=1;
				}

				else
				{
					y=2;
				}

				x=grafo[x][y]; //OBTENEMOS LA NUEVA DIRECCION

				if(x==50)//SI LA NUEVA DIRECCION CONTIENE UN 50=ERROR
				{
					v=false;
					break;
				}
			}

			if(v==true && x==3) //SI NO SE ENCONTRO NINGUN ERROR Y SE LLEGO AL ESTADO 3
			{
				JOptionPane.showMessageDialog(null, "LA OPERACION ES CORRECTA");
				postfija conversor=new postfija();
				String postfija[]=conversor.convertir(cadena);

                 JOptionPane.showMessageDialog(null, "LA OPERACION ES CORRECTA \nPostfija: "+ Arrays.toString(postfija));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "LA OPERACION ES INCORRECTA");
			}
		}
	}

}
