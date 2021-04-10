/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Lista.DoubleLinked;
import domain.Persona;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Josue
 */
public class clsData {
     public void data() {
       
        /*La variable (al) trae los valores de la base de datos*/
        PersonaDao s =  new PersonaDao();
         DoubleLinked<String>dl = new DoubleLinked<String>();
        List<Persona>personas = s.seleccinar();
         System.out.println("==================Lista de objetos===============");
        for(Persona persona: personas){
            System.out.println(persona.getId()+"->"+persona.getNombre());
        }
         System.out.println("===================================================");
        System.out.println("============REPRODUCIENDO........==================");
         System.out.println("===================================================");
        Random r = new Random();
        int cantidad = 1;
        String nombres="";
        for(int i=0;i<cantidad;i++){
            int nVeces = r.nextInt(personas.size());
            nombres = personas.get(nVeces).toString();
            System.out.println((i+1)+"->"+nombres );
        }
         System.out.println("==========End reproductor=========================");
        System.out.println("=================================================");
        Scanner entrada = new Scanner (System.in); 
        System.out.println("Quieres crear tu lista?");
        String resp = entrada.nextLine();
       
        if(resp!=""){
           
            Scanner sn = new Scanner(System.in);
            System.out.println("==============================================");
            System.out.println("Deseas agregar elementos al inico = i, final = f ");
            String respuesta= sn.nextLine();
            switch(respuesta){
                case "i":
                    for(int i=0;i<2;i++){
                    System.out.println("Ingresa el nombre que deseas agregar....");
                    String dato = sn.nextLine();

                    dl.addFirst(dato);//agregamos lo datos 
                    }
                    
                    System.out.println("Deseas cambiar la posicion de un elemento (SI), ingresa el nombre!!");
                    String nuevo= sn.nextLine();
                    System.out.println("Ingresa el indice en el que quieres ingresarlo!!");
                    int indice = Integer.parseInt(sn.nextLine());
                    dl.add(nuevo, indice);
                   
                    
                    
                    break;
                case "f":
                    for(int i=0;i<2;i++){
                    System.out.println("Ingresa el nombre que deseas agregar....");
                    String dato = sn.nextLine();

                    dl.addLast(dato);//agregamos lo datos 
                    }
                      
                    System.out.println("Deseas cambiar la posicion de un elemento (SI), ingresa el nombre!!");
                    String n= sn.nextLine();
                    System.out.println("Ingresa el indice en el que quieres ingresarlo!!");
                    int i = Integer.parseInt(sn.nextLine());
                    dl.add(n, i);
                    
                    System.out.println("Deseas remover algun elemento indica el numero");
                    int  num = Integer.parseInt(sn.nextLine());
                    dl.remove(num);
                    break;
                
                default:System.out.println("no se encontro la respuesta...");
            }
           
              while(dl.isEmpty()==false){
                System.out.println(dl.getFirst());
                
                 dl.removeFirst();
            }
        }
    }

  
}
