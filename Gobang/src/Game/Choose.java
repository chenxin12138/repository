package Game;

import javax.swing.*;

import java.awt.*;

public class Choose extends JFrame implements Image {
    //初始化登录界面
    public void initLogin(){

        ChoosePanle loginPanle=new ChoosePanle();
        this.setTitle("苏鑫越的游戏登录界面");
        this.setSize(UIWIDTH,UIHIGHTH);
        //设置窗口为正中心
        this.setLocationRelativeTo(null);
        //退出系统应用
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小不可变
        this.setResizable(false);
        //不设置布局
        this.setLayout(new BorderLayout());
        //进入游戏
        JButton buttonLogin=new JButton("单机版");
        buttonLogin.setBounds(550,500,dim2.width,dim2.height);
        ButtonLisener bu=new ButtonLisener(this);
        JButton buttonInternet=new JButton("网络对战");
        buttonInternet.setBounds(550,650,dim2.width,dim2.height);
        buttonLogin.addActionListener(bu);
        buttonInternet.addActionListener(bu);
        this.add(buttonLogin);
        this.add(buttonInternet);
        this.add(loginPanle);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Choose lg=new Choose();
        lg.initLogin();
    }
}
