
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
public class AnimacionInicio extends Thread{
    private JLabel eti;
    private Inicio i;
    AnimacionInicio(JLabel eti,Inicio i){
        this.eti=eti;
        this.i=i;
    }
    
    public void run(){
        int c1=0,c2=0;
        while(true){
            try{
               sleep((int) (1000));
               c1=i.getb1().getLocation().y;
               c2=i.getb2().getLocation().y;
               if(c1<i.barrera().getLocation().y-10 && c2<i.barrera().getLocation().y-10){
                   eti.setLocation((int) eti.getLocation().x,eti.getLocation().y+20);
                   i.repaint();
                   
               }else{
                   System.out.println("LLego");
                  if(c1>i.gettitulo().getLocation().y+10 && c2>i.gettitulo().getLocation().y+10){
                   eti.setLocation((int) eti.getLocation().x,eti.getLocation().y-20);
                   i.repaint();
                   System.out.println("LLego 2");
                  }
               }
            }catch(InterruptedException e){
                JOptionPane.showMessageDialog(null,"Hay un error en la ejecucion del hilo");
            }
            
        }
    }
}
