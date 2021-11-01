/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bernardo SJ
 */
public class Cronometro2 implements Runnable{
     public static Thread hilo;
    public static boolean estaFuncionando;
    carreraEntrenamiento i;
    Cronometro2(carreraEntrenamiento i){
        hilo=new Thread(this);
        estaFuncionando=true;
        hilo.start();
        this.i=i;
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
           i.repaint();
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
          CronometrajeCarrera.lminutos.setText(min);
           CronometrajeCarrera.lsegundos.setText(seg);
           CronometrajeCarrera.lmilisegundos.setText(mil);
           
       }
       
           CronometrajeCarrera.lminutos.setText("00");
           CronometrajeCarrera.lsegundos.setText("00");
           CronometrajeCarrera.lmilisegundos.setText("000");
           
    }
    
    public void marcar(){
        final int difm=mil2;
            final int difs=seg2;
            final int difmi=min2;
            Object data[]={"Spirit",i.getO1().getLocation().x,difmi+"."+difs+"."+difm};
            Object data2[]={"Zeus",i.getO2().getLocation().x,difmi+"."+difs+"."+difm};
            Object data3[]={"Tornado",i.getO3().getLocation().x,difmi+"."+difs+"."+difm};
            CronometrajeCarrera.modeloTabla.addRow(data);
            CronometrajeCarrera.modeloTabla.addRow(data2);
            CronometrajeCarrera.modeloTabla.addRow(data3);
    }
}
