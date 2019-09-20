package Game;

import javax.swing.*;

public class Room extends JPanel {
    private static int room_number=1;
    public void initRoom(){
        JFrame jf=new JFrame();
        jf.setTitle("房间");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

}
