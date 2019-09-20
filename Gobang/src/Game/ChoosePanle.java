package Game;

import javax.swing.*;
import java.awt.*;

public class ChoosePanle extends JPanel implements Image {
   public ChoosePanle(){
       JPanel jp=new JPanel();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //引用图片
        g.drawImage(LOGINPICTURE, 0, 0,this.getWidth(), this.getHeight(), this);
        //System.out.println(11111);
    }
}
