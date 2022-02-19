/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Scanner;

/**
 *
 * @author Cc3sar
 */
public class Bus {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String[][] asientosA = {{"A1", "y"}, {"A2", "y"}, {"A3", "y"}, {"A4", "y"}, {"A5", "y"}, {"A6", "y"}, {"A7", "y"}};
        String[][] asientosB = {{"B1", "y"}, {"B2", "y"}, {"B3", "y"}, {"B4", "y"}, {"B5", "y"}, {"B6", "y"}, {"B7", "y"}};
        String[][] asientosC = {{"C1", "y"}, {"C2", "y"}, {"C3", "y"}, {"C4", "y"}, {"C5", "y"}, {"C6", "y"}, {"C7", "y"}};
        String[][] asientosD = {{"D1", "y"}, {"D2", "y"}, {"D3", "y"}, {"D4", "y"}, {"D5", "y"}, {"D6", "y"}, {"D7", "y"}};
        int salir=1;
        
        ManejoArchivos objeto1 = new ManejoArchivos(); //puedo mandar los datos directo desde un metodo
        System.out.println("MENU");
        System.out.println("1. Crear archivo");
        System.out.println("2. Reservar Asiento");
        System.out.println("3. Ver pasajeros");
        System.out.println("4. Datos de un pasajero en especifico");
        System.out.println("5. Listar Asientos");
        System.out.println("Para salir presione 6");
        
        while(salir!=6) {
            try {
                System.out.println("=============================================================");
                System.out.println("Elija una opcion");
                salir=teclado.nextInt();
                
                if (salir==1) {
                    objeto1.existearchivo();
                } //crear el archivo si es que no esta creado
                
                if (salir==2){
                    System.out.println("Ingrese el codigo de asiento:");
                    String id=teclado.next();
                    System.out.println("Ingrese el nombre:");
                    String nombre=teclado.next();
                    String respuesta=objeto1.reserva(id);
                    String desocupado;
                    char[] rChar = id.toCharArray();
                    int nAsiento = (Integer.parseInt(String.valueOf(rChar[1])))-1; //Indice de la matriz
                    
                    switch(respuesta) {
                        case "A":
                            desocupado = objeto1.aDisponible(asientosA, nAsiento);
                            if(desocupado.equals("d")) {
                                asientosA[nAsiento][1] = "n";
                                objeto1.asignardatos(id,nombre);
                            } else {
                                System.out.println(desocupado);
                            }
                            break;
                            
                        case "B":
                            desocupado = objeto1.aDisponible(asientosB, nAsiento);
                            if(desocupado.equals("d")) {
                                asientosB[nAsiento][1] = "n";
                                objeto1.asignardatos(id,nombre);
                            } else {
                                System.out.println(desocupado);
                            }
                            break;
                            
                        case "C":
                            desocupado = objeto1.aDisponible(asientosC, nAsiento);
                            if(desocupado.equals("d")) {
                                asientosC[nAsiento][1] = "n";
                                objeto1.asignardatos(id,nombre);
                            } else {
                                System.out.println(desocupado);
                            }
                            break;
                            
                        case "D":
                            desocupado = objeto1.aDisponible(asientosD, nAsiento);
                            if(desocupado.equals("d")) {
                                asientosD[nAsiento][1] = "n";
                                objeto1.asignardatos(id,nombre);
                            } else {
                                System.out.println(desocupado);
                            }
                            break;
                        
                        default:
                            System.out.println("Ingrese un codigo valido");
                    }
                 }//dentro del parentesis le puedo enviar datos para que vaya guardando
                
                if (salir==3) {
                    objeto1.mostrararchivos();
                }//mostrar lo que hay dentro de un archivo
                
                if (salir==4){
                    System.out.println("Ingresa el codigo de asiento del pasajero:");
                    String id=teclado.next();
                    objeto1.buscarregistro(id);
                }
                if (salir==5){
                    for (int x=0; x < asientosA.length; x++) {
                        for (int y=0; y < asientosA[x].length; y++) {
                            System.out.print(" " + asientosA[x][y]);
                            if(y==1) {
                                System.out.print(" <= V ");
                            }
                        }
                        for (int y=0; y < asientosB[x].length; y++) {
                            System.out.print(" " + asientosB[x][y]);
                        }
                        for (int y=0; y < asientosC[x].length; y++) {
                            System.out.print(" " + asientosC[x][y]);
                        }
                        for (int y=0; y < asientosD[x].length; y++) {
                            System.out.print(" " + asientosD[x][y]);
                            if(y==1) {
                                System.out.print(" <= V ");
                            }
                        }
                        System.out.println("");
                    }
                }
            } 
            catch(Exception ex) {
                System.out.println("Opcion invalida");
                teclado.nextLine();
            }
            //limpiar un archivo
    }
    }
}
