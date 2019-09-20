package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameMap extends JPanel implements Image {
    public int [][]board=new int[15][15];//存放棋盘落子
    private int turn=0 ;//记录轮走方 1为玩家一，2位玩家二
    public int []lastmove=new int[2];//记录最后一步位置
    public ArrayList<Chessmove> chessmoves=new ArrayList<Chessmove>();//记录每一步棋子位置



    public void initUI(){
        //初始化一个界面,并设置标题大小等属性
        Reset();
        JFrame jf=new JFrame();
        jf.setTitle("五子棋");
        jf.setSize(UIWIDTH,UIHIGHTH);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());//设置顶级容器JFrame为框架布局
        //实现左边的界面，把GoBangframe的对象添加到框架布局的中间部分
        //已经有一个GameMap对象了，表示当前类的对象是this
        this.setBackground(Color.WHITE);//设置下棋界面的颜色
        //这里的话直接把左边的画板添加上去，指明是在框架布局的中间版块
        jf.add(this,BorderLayout.CENTER);//添加到框架布局的中间部分
        JPanel jp=new JPanel();
        jp.setPreferredSize(dim1);//因采用了布局管理，不适用setsize，设置大小
        jf.add(jp,BorderLayout.EAST);//添加到框架布局的东边部分
        jp.setLayout(new FlowLayout());//设置JPanel为流式布局

        //用户信息
        String[] userMessage={"pic","昵称：尘心","性别：男","等级：新手"};
        JLabel[] user =new JLabel[4];
        //设置用户头像的大小
        USERPICTURE.setImage(USERPICTURE.getImage().getScaledInstance(dim3.width, dim3.height, java.awt.Image.SCALE_DEFAULT ));
        user[0]=new JLabel(USERPICTURE);
        //设置Lable的大小
        Dimension dim5=new Dimension(dim3.width,dim3.height+20);
        user[0].setPreferredSize(dim5);
        jp.add(user[0]);

        for(int i=1;i<4;i++){
            user[i]=new JLabel(userMessage[i]);
            user[i].setPreferredSize(dim2);
            /*
             *利用setFont来设置TextField文本框输入信息的字体大小
             *textx1.setFont(new Font(Font.DIALOG,Font.PLAIN,30));
             */
            user[i].setFont(new Font(Font.MONOSPACED,Font.ITALIC,20));
            jp.add(user[i]);
        }
        String []button_name={"开始新游戏","悔棋","认输"};
        JButton []buttons=new JButton[3];
        ImageIcon []BackGroundPictures={STARTBUTTON,BACKBUTTON,LOSEBUTTON};
        for (int i = 0; i < 3; i++) {
            BackGroundPictures[i].setImage(BackGroundPictures[i].getImage().getScaledInstance(dim4.width+20, dim4.height, java.awt.Image.SCALE_DEFAULT));
            buttons[i]=new JButton(button_name[i],BackGroundPictures[i]);
            buttons[i].setPreferredSize(dim4);
            jp.add(buttons[i]);
        }
        ButtonLisener bu=new ButtonLisener(this);
        for (int i = 0; i < 3; i++) {
            buttons[i].addActionListener(bu);
        }
        FrameListener fl=new FrameListener(this);
        this.addMouseListener(fl);
        jf.setVisible(true);

    }

    //重写重绘方法
    public void paint(Graphics g){
        super.paint(g);
        System.out.println(111111);
        //引用图片
        g.drawImage(CHESSBOARD, 0, 0,this.getWidth(), this.getHeight(), this);
       //绘制棋盘
        g.setColor(Color.BLACK);
        for (int i = 0; i < 15; i++) {
            g.drawLine(X,Y+SIZE*i,X+SIZE*14,Y+SIZE*i);
        }
        for (int i = 0; i < 15; i++) {
            g.drawLine(X+SIZE*i,Y,X+SIZE*i,Y+SIZE*14);
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if(board[i][j]==1){
                    int count_ai_x=i*SIZE+X;
                    int count_ai_y=j*SIZE+Y;
                    g.setColor(Color.BLACK);
                    g.fillOval(count_ai_x-15,count_ai_y-15,30,30);
                }
                else if(board[i][j]==2){
                    int count_ai_x=i*SIZE+X;
                    int count_ai_y=j*SIZE+Y;
                    g.setColor(Color.WHITE);
                    g.fillOval(count_ai_x-15,count_ai_y-15,30,30);
                    if(i==lastmove[0]&&j==lastmove[1]){
                        g.setColor(Color.RED);
                        g.drawRect(count_ai_x-15,count_ai_y-15,30,30);
                    }
                }
            }
        }

    }

    public int getTurn(){
        return turn;
    }

    public void ChangeTurn(){
        if (turn==1)
            turn=2;
        else
            turn=1;
    }


    public void Reset(){
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j]=0;
            }
        }
        turn=0;
    }


    public void PopUp(String top,String result) {
        JOptionPane jo=new JOptionPane();
        jo.showMessageDialog(null, result, top, JOptionPane.PLAIN_MESSAGE);
    }
}
