
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bernardo SJ
 */
public class metodosHilo {
  static String concatenado="";
    static String cadena="";
    public static String concatenarConsola="";
    synchronized void leerarchivo(String archivo){
        try{
          Thread.sleep(500);
           try{
               String cadena;
               FileReader ob1=new FileReader(archivo);
               BufferedReader ob2=new BufferedReader(ob1);
               cadena=ob2.readLine();
               ob2.close();
               concatenado+=cadena+"\n";
           }catch(Exception e){
               System.out.println("No se puede leer el archivo "+e);
           }
        }catch(InterruptedException e){
            System.out.println("Algo ocurre con el hilo"); 
        }
        concatenarConsola+="El archivo "+archivo+" fue leido con exito\n";
       ejerciciosclase.consola.setText(concatenarConsola);
      
    }
    
    synchronized void ciclo1(Thread hilo){
        concatenarConsola+="¿Estas en ejecución?\n";
        ejerciciosclase.consola.setText(concatenarConsola);
        for(int i=1;i<=15;i++){
            
               
            if(hilo.isAlive()){
                 concatenarConsola+="Estoy en ejecución en la iteración "+i+"\n";
                ejerciciosclase.consola.setText(concatenarConsola);
            }else{
                concatenarConsola+="No estoy en ejecución\n";
                ejerciciosclase.consola.setText(concatenarConsola);
            }
             
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(metodosHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        concatenarConsola+="Termino la ejecución en (Hilo2)\n";
        ejerciciosclase.consola.setText(concatenarConsola);
        
    }
    
    synchronized void ciclo2(Thread hilo){
     
        concatenarConsola+="Mi prioridad es de "+hilo.getPriority()+"\n";
        ejerciciosclase.consola.setText(concatenarConsola);
        for(int i=1;i<=15;i++){   
               concatenarConsola+="Iteración "+i+"\n"; 
               ejerciciosclase.consola.setText(concatenarConsola);
             try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(metodosHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        concatenarConsola+="Termino la ejecución en (Hilo3)\n";
        ejerciciosclase.consola.setText(concatenarConsola);
      
    }
    
    synchronized void imprimeArchivo(){
       
        concatenarConsola+="Lo leido en el archivo fue :"+concatenado+"\n";
        concatenarConsola+="Termino (Hilo1 E Hilo4)\n";
        ejerciciosclase.consola.setText(concatenarConsola);
        
    }
    
    synchronized void principal(){
        
        metodosHilo.concatenarConsola+="Inicia el proceso main"+"\n";
            
            for(int i=1;i<=5;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ejerciciosclase.class.getName()).log(Level.SEVERE, null, ex);
                }
                metodosHilo.concatenarConsola+="Hilo "+i+"\n";
                ejerciciosclase.consola.setText(metodosHilo.concatenarConsola);
                
            }
            metodosHilo.concatenarConsola+="Terminan las acciones principales del programa";
            ejerciciosclase.consola.setText(metodosHilo.concatenarConsola); 
    }
  
}
