
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bernardo SJ
 */
public class Cronometro implements Runnable{
    public static Thread hilo;
    public static boolean estaFuncionando;
    Cronometro(){
        hilo=new Thread(this);
        estaFuncionando=true;
        hilo.start();
    }
    int min2,seg2,mil2;
    public void run(){
       String min="",seg="",mil="";
       min2=0;
      seg2=0;
      mil2=0;
       while(estaFuncionando){
           try{
              Thread.sleep(4); 
           }catch(InterruptedException e){
               System.out.println("Hay un error con el cronometro");
           }
           mil2+=4;
           if(mil2==1000){
               mil2=0;
               seg2+=1;
               if(seg2==60){
                   seg2=0;
                   min2++;
               }
           }
           
           if(min2<10){
               min="0"+min2;
           }else{
               min=""+min2;
           }
           
           if(seg2<10){
              seg="0"+seg2; 
           }else{
               seg=""+seg2;
           }
           
           if(mil2<10){
               mil="00"+mil2;
           }else{
               if(mil2<100){
                  mil="0"+mil2;
               }else{
                   mil=""+mil2;
               }
           }
           CronometroGrafica.lminutos.setText(min);
           CronometroGrafica.lsegundos.setText(seg);
           CronometroGrafica.lmilisegundos.setText(mil);
       }
       
           CronometroGrafica.lminutos.setText("00");
           CronometroGrafica.lsegundos.setText("00");
           CronometroGrafica.lmilisegundos.setText("000");
           CronometroGrafica.pausar.setText("Pausar");
    }
   
   
    
    public void pausar(){
        if(CronometroGrafica.pausar.getText().equals("Pausar")){
        if(hilo.isAlive()){
           hilo.suspend();
           CronometroGrafica.pausar.setText("Reanudar");
           CronometroGrafica.vuelta.setEnabled(false);
        CronometroGrafica.detener.setEnabled(true);
        CronometroGrafica.pausar.setEnabled(true);
        CronometroGrafica.iniciar.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null,"No se esta ejecutando el hilo");
        }
        }else{
            hilo.resume();
            CronometroGrafica.pausar.setText("Pausar");
            
           CronometroGrafica.vuelta.setEnabled(true);
        CronometroGrafica.detener.setEnabled(true);
        CronometroGrafica.pausar.setEnabled(true);
        CronometroGrafica.iniciar.setEnabled(false);
        }
    }
    public static String concatenar="";
    public void calculaDiferencia(){
        if(CronometroGrafica.diferenciaMil.isEmpty() && CronometroGrafica.diferenciaSeg.isEmpty()
           && CronometroGrafica.diferenciaMin.isEmpty()){
           CronometroGrafica.diferenciaMil.add(mil2);
           CronometroGrafica.diferenciaSeg.add(seg2);
           CronometroGrafica.diferenciaMin.add(min2);
           concatenar+="Vuelta #"+CronometroGrafica.contadorVueltas+" "+CronometroGrafica.diferenciaMin.get(0)+"."+
                   CronometroGrafica.diferenciaSeg.get(0)+"."+CronometroGrafica.diferenciaMil.get(0)+
                   "   "+CronometroGrafica.diferenciaMin.get(0)+"."+
                   CronometroGrafica.diferenciaSeg.get(0)+"."+CronometroGrafica.diferenciaMil.get(0)+"\n";
        }else{
            final int difm=mil2;
            final int difs=seg2;
            final int difmi=min2;
            int difmil=difm-CronometroGrafica.diferenciaMil.get(CronometroGrafica.diferenciaMil.size()-1);
            int difseg=difs-CronometroGrafica.diferenciaSeg.get(CronometroGrafica.diferenciaSeg.size()-1);
            int difmin=difmi-CronometroGrafica.diferenciaMin.get(CronometroGrafica.diferenciaMin.size()-1);
            CronometroGrafica.diferenciaMil.add(difm);
           CronometroGrafica.diferenciaSeg.add(difs);
           CronometroGrafica.diferenciaMin.add(difmi);
            concatenar+="Vuelta #"+CronometroGrafica.contadorVueltas+" "+difmin+"."+
                   difseg+"."+difmil+
                   "   "+CronometroGrafica.diferenciaMin.get(CronometroGrafica.diferenciaMin.size()-1)+"."+
                   CronometroGrafica.diferenciaSeg.get(CronometroGrafica.diferenciaSeg.size()-1)+"."+CronometroGrafica.diferenciaMil.get(CronometroGrafica.diferenciaMil.size()-1)+"\n";
        }
        CronometroGrafica.areadetexto.setText(concatenar);
    }
}
