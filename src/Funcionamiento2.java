
import static java.lang.Thread.sleep;
import javax.swing.JLabel;
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
public class Funcionamiento2 extends Thread{
private JLabel eti;
    private carreraEntrenamiento i;
    Funcionamiento2(JLabel eti,carreraEntrenamiento i){
        this.eti=eti;
        this.i=i;
    }
    
    public void run(){
        int c1=0,c2=0,c3=0;
        while(true){
            
            try{
               sleep((int) (Math.random() * 1000));
               c1=i.getO1().getLocation().x;
               c2=i.getO2().getLocation().x;
               c3=i.getO3().getLocation().x;
               if(c1<i.getMeta().getLocation().x-10 && c2<i.getMeta().getLocation().x-10 && c3<i.getMeta().getLocation().x-10){
                   eti.setLocation((int) (eti.getLocation().x + Math.random() + 10),eti.getLocation().y);
                   i.repaint();
               }else{
                   Cronometro2.estaFuncionando=false;
                   Cronometro2.hilo=null;
                   CronometrajeCarrera.lminutos.setText("00");
           CronometrajeCarrera.lsegundos.setText("00");
           CronometrajeCarrera.lmilisegundos.setText("000");
                   carreraEntrenamiento.otra.setEnabled(true);
                   carreraEntrenamiento.marca.setEnabled(false);
                   break;
               }
            }catch(InterruptedException e){
                JOptionPane.showMessageDialog(null,"Hay un error en la ejecucion del hilo");
            }
            if(eti.getLocation().x>=i.getMeta().getLocation().x-10){
                if(c1>c2 && c1>c3){
                    JOptionPane.showMessageDialog(null,"Gano Spirit");
                }else{
                    if(c2>c1 && c2>c3){
                        JOptionPane.showMessageDialog(null, "Gano Zeus");
                    }else{
                        if(c3>c2 && c3>c1){
                        JOptionPane.showMessageDialog(null,"Gano Tornado");
                        }else{
                            JOptionPane.showMessageDialog(null,"Empate");
                        }
                    }
                }
            }
        }
   
    }
    }
