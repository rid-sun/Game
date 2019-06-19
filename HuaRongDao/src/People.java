import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

//定义一个People类，对有关人物组件的一切相关信息进行封装
class People extends JButton {
	public int id,lx,ly,width,height;//人物组件的编号、大小和位置
	String name;//人物组件的名字
	
	//对人物组件进行初始化
	People(int iid,String s,int x,int y,int w,int h){
		super(s);
		name=s;
		id=iid;
		lx=x;
		ly=y;
		width=w;
		height=h;
		setBackground(Color.LIGHT_GRAY);//设置背景
		setForeground(Color.BLACK);//设置前景
		setFont(new Font("宋体", Font.BOLD, 22));//设置组件上的字体
		setBounds(x,y,w,h);//设置组件在面板中的位置
		
	}
	
	//给组件加上图片背景
	public void paint(Graphics g){
	    ImageIcon icon=new ImageIcon("resourse\\"+name+".jpg");
	    Image image=icon.getImage();
	    g.drawImage(image, 0, 0, null);
	}
}