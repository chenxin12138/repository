package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonLisener implements ActionListener {
    private Choose loginUi;
    private GameMap gm;
    public ButtonLisener(Choose loginUI){
        this.loginUi=loginUI;
    }
    public ButtonLisener(GameMap gm){
        this.gm=gm;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("单机版")){
            GameMap gm=new GameMap();
            gm.initUI();
            //loginUi.dispose();
        }
        else if(e.getActionCommand().equals("开始新游戏")){

            gm.Reset();
            gm.repaint();
            gm.ChangeTurn();

        }
        else if(e.getActionCommand().equals("悔棋")){
            Chessmove chessmove=gm.chessmoves.get(gm.chessmoves.size()-1);
            System.out.println(chessmove.x+" "+chessmove.y);
            gm.chessmoves.remove(gm.chessmoves.size()-1);
            gm.board[chessmove.x][chessmove.y]=0;
            chessmove=gm.chessmoves.get(gm.chessmoves.size()-1);
            gm.chessmoves.remove(gm.chessmoves.size()-1);
            gm.board[chessmove.x][chessmove.y]=0;
            gm.repaint();
        }
        else if(e.getActionCommand().equals("认输")){
            if(gm.getTurn()==1)
                gm.PopUp("胜者","白棋胜");
            else {
                gm.PopUp("胜者","黑棋胜");
            }
        }
    }
}
