/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;


/**
 *
 * @author Cc3sar
 */
public class ManejoArchivos {
    private Scanner entrada;
    private String id;
    File ficherodeposito= new File ("dbBus.txt");
    public ManejoArchivos ()//objeto para enviar los datos a esta clase
    { 
    }

    public void existearchivo()//metodo para hacer la base de datos
    {
        try
        {
            if (ficherodeposito.exists())//saber si existe el archivo de texto
            {
                System.out.println("la base de datos ya existe");
            }
            else
            {
                ficherodeposito.createNewFile();
                System.out.println("base de datos creada");
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void asignardatos(String id2, String nombre2)
    {
        id = id2;               
        String nombre = nombre2;           
        try
        {
            BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficherodeposito,true)));//no se para que sirve
            Fescribe.write(id+"    " + nombre + "    "); //guarda en la base de datos los archivos                            //utf8 es un tipo de formato
            Fescribe.write("\n");//para el salto de linea    
            System.out.println("Asiento reservado exitosamente...");
            Fescribe.close();//cerrar el fichero y que los datos se queden escritos
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void mostrararchivos()
    {
        try
        {
            FileReader fr=new FileReader("dbBus.txt");
            BufferedReader br=new BufferedReader(fr);
            String cadena;
            while((cadena=br.readLine())!=null) //cuando el la siguiente linea leida no haya nada significa que termino de leer los datos del archivo
            {
                System.out.println(""+cadena); 
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void buscarregistro(String id2)
    {
        String usuario=id2;
        try
        {
            BufferedReader leer=new BufferedReader(new FileReader ("dbBus.txt"));
            String linea="";
            while((linea=leer.readLine())!=null)
            {
                if (linea.indexOf(usuario)!=-1)
                {
                    System.out.println("se encontro el registro: "+linea);
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public String reserva(String codigo) {
        String columna="s";
        
        char[] rChar = codigo.toCharArray();
        String parte1 = Character.toString(rChar[0]);
        int parte2 = Integer.parseInt(String.valueOf(rChar[1]));
        
        if(parte2 >= 1 && parte2 <= 7) {
            switch(parte1) {
                case "A":
                    columna = "A";
                    break;

                case "B":
                    columna = "B";
                    break;

                case "C":
                    columna = "C";
                    break;

                case "D":
                    columna = "D";
                    break;

                default:
                    columna = "err";
            }
        }
        
        return columna;
    }
    
    public String aDisponible(String[][] asientos, int nAsiento) {
        String respuesta;
        if(asientos[nAsiento][1].equals("n")){
            respuesta = "Asiento no disponible, elija un asiento vacio";
        } else {
            respuesta = "d";
        }
        return respuesta;
    }
}
