import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ForeJFrame extends JFrame implements MouseListener{
	ImageIcon img; //申明变量来存储背景图片
	JLabel imgLabel; //用来装载背景图片
	JLabel lb1,lb2,lb3;
	JLayeredPane panel;
	int x1,y1,x2,y2,x3,y3;//用来保存按钮的初始位置
	
	ForeJFrame(){
		
		//窗体初始化
		super("三国华容道");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		super.setBounds(300, 0, 415, 585); 
		super.setVisible(true);
		
		//分层面板初始化
		panel=new JLayeredPane();
		panel.setBounds(0,0,415,585);
		panel.setLayout(null);
		super.add(panel);
		
		//设置背景
		img=new ImageIcon("resourse\\场景.jpg");//背景图片   
		imgLabel=new JLabel(img);//将背景图放在标签里。       
		imgLabel.setBounds(0,0,415, 585);//设置背景标签的位置   
		
		//界面按钮初始化
		//创建“开始游戏”按钮
		lb1=new JLabel("开始游戏");//创建标签
		lb1.setBounds(160, 250, 90, 30);
		lb1.setFont(new Font("楷体",Font.BOLD,20));
		lb1.setForeground(Color.CYAN);//设置前景
		lb1.addMouseListener(this);//添加鼠标事件监听器
		
		//创建“退出游戏”按钮
		lb2=new JLabel("退出游戏");
		lb2.setBounds(160, 310, 90, 30);
		lb2.setFont(new Font("楷体",Font.BOLD,20));
		lb2.setForeground(Color.CYAN);
		lb2.addMouseListener(this);
		
		//创建“寻求帮助”按钮
		lb3=new JLabel("寻求帮助");
		lb3.setBounds(160, 370, 90, 30);
		lb3.setFont(new Font("楷体",Font.BOLD,20));
		lb3.setForeground(Color.CYAN);
		lb3.addMouseListener(this);
		
		//将按钮添加到面板上
		panel.add(lb1,JLayeredPane.DRAG_LAYER);
		panel.add(lb2,JLayeredPane.DRAG_LAYER);
		panel.add(lb3,JLayeredPane.DRAG_LAYER);
		panel.add(imgLabel, JLayeredPane.DRAG_LAYER);
	}
	
	//通过下面俩个方法来交互信息
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==lb1) {
			JLabel lb=(JLabel)e.getSource();
			x1=lb.getBounds().x;
			y1=lb.getBounds().y;
			lb.setLocation(x1+2, y1-2);
			lb.setForeground(Color.green);
		}
		if(e.getSource()==lb2) {
			JLabel lb=(JLabel)e.getSource();
			x2=lb.getBounds().x;
			y2=lb.getBounds().y;
			lb.setLocation(x2+2, y2-2);
			lb.setForeground(Color.green);
		}
		if(e.getSource()==lb3) {
			JLabel lb=(JLabel)e.getSource();
			x3=lb.getBounds().x;
			y3=lb.getBounds().y;
			lb.setLocation(x3+2, y3-2);
			lb.setForeground(Color.green);
		}
	}
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==lb1) {
			JLabel lb=(JLabel)e.getSource();
			lb.setLocation(x1, y1);
			lb.setForeground(Color.cyan);
		}
		if(e.getSource()==lb2) {
			JLabel lb=(JLabel)e.getSource();
			lb.setLocation(x2, y2);
			lb.setForeground(Color.cyan);
		}
		if(e.getSource()==lb3) {
			JLabel lb=(JLabel)e.getSource();
			lb.setLocation(x3, y3);
			lb.setForeground(Color.cyan);
		}
	}
	
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==lb1) {
			JLabel lb=(JLabel)e.getSource();
			lb.setLocation(x1, y1);
			lb.setForeground(Color.cyan);
		}
		if(e.getSource()==lb2) {
			JLabel lb=(JLabel)e.getSource();
			lb.setLocation(x2, y2);
			lb.setForeground(Color.cyan);
		}
		if(e.getSource()==lb3) {
			JLabel lb=(JLabel)e.getSource();
			lb.setLocation(x3, y3);
			lb.setForeground(Color.cyan);
		}
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {
		if(e.getSource()==lb1)
		{
			super.dispose();
		
			//定义HuaRongDao类对象，调用第一关初始化函数
			RunningGame h=new RunningGame(this.getBounds().x,this.getBounds().y);
			h.init1();
		}
		if(e.getSource()==lb2)
		{
			super.dispose();
		}
		if(e.getSource()==lb3)
		{
			new ForeInformation();
		}
	}

}