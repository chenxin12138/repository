package Game;

import javafx.css.Size;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FrameListener implements MouseListener,Image {

    private GameMap gm;
    private ChessAI ai;
    private static int step=0;

    public FrameListener(GameMap gm){
        this.gm=gm;
        this.ai=new ChessAI();
    }

    //下棋
    @Override
    public void mouseClicked(MouseEvent e) {
        int x=e.getX();
        int y=e.getY();
        int count_x;
        int count_y;
        //计算交叉点
        if((x-X)%SIZE>(int)(SIZE/2)){
            count_x=X+SIZE*(int)((x-X)/SIZE+1);
        }
        else {
            count_x=X+SIZE*(int)((x-X)/SIZE);
        }
        if((y-Y)%SIZE>(int)(SIZE/2)){
            count_y=Y+SIZE*(int)((y-Y)/SIZE+1);
        }
        else {
            count_y=Y+SIZE*(int)((y-Y)/SIZE);
        }
        Graphics g=gm.getGraphics();
        int index_i=(count_x-X)/SIZE;
        int index_j=(count_y-Y)/SIZE;
        if((index_i<0)||(index_j<0)||(index_i>14)||(index_j>14))
            return ;
        if (gm.getTurn()==1){
            if(gm.board[index_i][index_j]!=0){
                gm.PopUp("错误提示","此处已经有棋子了，请下在其它地方");
            }
            else {
                //gm.repaint();
                g.fillOval(count_x-15,count_y-15,30,30);
                Chessmove chessmove=new Chessmove(index_i,index_j);
                gm.chessmoves.add(chessmove);
                gm.board[index_i][index_j]=gm.getTurn();
                step++;
                g.setColor(Color.RED);
                g.drawRect(count_x-15,count_y-15,30,30);
                if(ai.CheckWin(gm.board,gm.getTurn())) {
                    gm.PopUp("胜者", "胜者黑方");
                    gm.repaint();
                }
                else
                    gm.ChangeTurn();
            }
        }
        if(gm.getTurn()==2)
        {
            gm.repaint();
            int []bestmove=ai.FindBestmove(gm.board,gm.getTurn());
            System.out.println("AIx+AIy"+bestmove[0]+" "+bestmove[1]);
            g.setColor(Color.WHITE);
            int count_ai_x=bestmove[0]*SIZE+X;
            int count_ai_y=bestmove[1]*SIZE+Y;
            g.fillOval(count_ai_x-15,count_ai_y-15,30,30);
            Chessmove chessmove=new Chessmove(bestmove[0],bestmove[1]);
            gm.chessmoves.add(chessmove);
            System.out.println(11111);
            gm.board[bestmove[0]][bestmove[1]]=gm.getTurn();
            gm.lastmove=bestmove;
            step++;
            if(ai.CheckWin(gm.board,gm.getTurn())) {
                gm.PopUp("胜者", "胜者白方");
                gm.repaint();
                gm.Reset();
            }
            else
                gm.ChangeTurn();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
