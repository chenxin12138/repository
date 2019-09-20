package Game;

import javax.swing.*;
import java.awt.*;

public interface Image {
    ////定义与棋盘数据相关的接口，保存棋盘的起点，格子大小，行数列数等信息
    int X=170;
    int Y=20;
    int SIZE=50;
    int UIWIDTH=1265;
    int UIHIGHTH=785;
    int MESSAGEWIDTH=240;//设置右边信息栏的宽度
    java.awt.Image CHESSBOARD= new ImageIcon("image\\ChessBoard.jpg").getImage();	//这里不能用ImageIcon
    java.awt.Image MESSAGEPICTURE= new ImageIcon("image\\MessagePictrue.jpg").getImage();	//这里不能用ImageIcon
    java.awt.Image LOGINPICTURE= new ImageIcon("image\\LoginPicture.jpg").getImage();	//这里不能用ImageIcon
    java.awt.Image LOGINPICTURE2= new ImageIcon("image\\LoginPicture2.jpg").getImage();	//这里不能用ImageIcon
    ImageIcon LOGINBUTTON = new ImageIcon("image\\LoginButton.png");
    ImageIcon STARTBUTTON = new ImageIcon("image\\StartButton.png");
    ImageIcon BACKBUTTON = new ImageIcon("image\\BackButton.png");
    ImageIcon LOSEBUTTON = new ImageIcon("image\\LoseButton.png");
    ImageIcon USERPICTURE = new ImageIcon("image\\UserPicture.jpg");
    Dimension dim1=new Dimension(MESSAGEWIDTH,0);//设置右边信息栏的大小
    Dimension dim2=new Dimension(145,40);//设置登录按钮组件的大小
    Dimension dim3=new Dimension(120,120);//设置头像组件的大小
    Dimension dim4=new Dimension(140,45);//设置右边按钮组件的大小

}
