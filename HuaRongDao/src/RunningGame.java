import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

//RunningGame类来完成游戏的界面初始化，拖动过程的完成等功能
class RunningGame extends JFrame implements ActionListener,MouseListener,MouseMotionListener{
	People p[]=new People[10];//申明人物数组
	
	int x0,y0,primary_x,primary_y;//用于拖动过程的变量
	int x,y,a,b,w,h,direction;//用于拖动过程的变量
	
	static int number=1;//表示当前关卡
	static int seconds=0;//表示所用时间
	static int steps=0;//表示所用步数
	Timer time;
	JLabel label1;//界面上显示所用时间
	JLabel label2;//界面上显示所用步数
	
	JMenuBar menubar;
	JMenu menu1,menu2,menu3;
	JMenuItem item0,item1,item2,item3;//菜单项
	JMenuItem item4,item5,item6,item7,item8;//菜单项
	
	JPanel panel,panel2;//容纳组件panel，出口标志panel2
	
	/*游戏界面初始化
	 * 参数lx和ly用来确定界面显示位置
	 */
	RunningGame(int lx,int ly)
	{	
		//窗体初始化
		super("三国华容道");
		super.setLayout(null);
		super.setBounds(lx, ly, 415, 585);
		super.setResizable(false);
		
		//实例化计时器
		time=new Timer(1000,this);
		
		//面板容器初始化
		panel=new JPanel();
		panel.setBounds(0, 0, 400, 500);
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		super.add(panel);
			
		//出口标志初始化
		panel2=new JPanel();
		panel2.setBounds(100,500,200,20);
		panel2.setBackground(Color.BLACK);
		super.add(panel2);
			
		//菜单的初始化
		menubar=new JMenuBar();
		menu1=new JMenu("关卡选项");
		menu2=new JMenu("计时选项");
		menu3=new JMenu("帮助");
		item0=new JMenuItem("重新开始");
		item0.addActionListener(this);
		item1=new JMenuItem("第一关");
		item1.addActionListener(this);
		item2=new JMenuItem("第二关");
		item2.addActionListener(this);
		item3=new JMenuItem("第三关");
		item3.addActionListener(this);
		item4=new JMenuItem("开始");
		item4.addActionListener(this);
		item5=new JMenuItem("停止");
		item5.addActionListener(this);
		item6=new JMenuItem("继续");
		item6.addActionListener(this);
		item7=new JMenuItem("查看操作帮助");
		item7.addActionListener(this);
		item8=new JMenuItem("关于游戏");
		item8.addActionListener(this);
		menu1.add(item0);
		menu1.addSeparator();
		menu1.add(item1);
		menu1.addSeparator();
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(item3);
		menu2.add(item4);
		menu2.addSeparator();
		menu2.add(item5);
		menu2.addSeparator();
		menu2.add(item6);
		menu3.add(item7);
		menu3.addSeparator();
		menu3.add(item8);
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
			
		//用于在界面显示所用时间
		label1=new JLabel("     已用时：0s");
		label1.setForeground(Color.RED);
			
		//用于在界面上显示所用步数
		label2=new JLabel("            所走步数：0步");
		label2.setForeground(Color.RED);
		
		//载入到菜单项上
		menubar.add(label2);
		menubar.add(label1);
			
		//添加菜单条
		super.setJMenuBar(menubar);
			
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
		validate();
	}
	
	//第一关
	public void init1()
	{
		p[0]=new People(0,"曹操",100,0,200,200);
		p[1]=new People(1,"关羽",100,200,200,100);
		p[2]=new People(2,"张飞",0, 300,100,200);
		p[3]=new People(3,"黄忠",100,300,100,200);
		p[4]=new People(4,"马超",200, 300,100,200);
		p[5]=new People(5,"赵云",300, 200,100,200);
		p[6]=new People(6,"卒",0, 0,100,100);
		p[7]=new People(7,"卒",300,0,100,100);
		p[8]=new People(8,"卒",0,200,100,100);
		p[9]=new People(9,"卒",300,100,100,100);
		
		//进行人物装载工作
		for(int i=0;i<=9;i++)
		{
			panel.add(p[i]);
				
			//给人物组件加上鼠标动作事件监听器
			p[i].addMouseListener(this);
			p[i].addMouseMotionListener(this);
		}
			
	}
	
	//第二关
	public void init2()
	{
		p[0]=new People(0,"曹操",100,0,200,200);
		p[1]=new People(1,"关羽",100,200,200,100);
		p[2]=new People(2,"张飞",0, 0,100,200);
		p[3]=new People(3,"黄忠",0,200,100,200);
		p[4]=new People(4,"马超",300, 0,100,200);
		p[5]=new People(5,"赵云",300, 200,100,200);
		p[6]=new People(6,"卒",0, 400,100,100);
		p[7]=new People(7,"卒",100,300,100,100);
		p[8]=new People(8,"卒",200,300,100,100);
		p[9]=new People(9,"卒",300,400,100,100);
		
		for(int i=0;i<=9;i++)
		{
			panel.add(p[i]);
			p[i].addMouseListener(this);
			p[i].addMouseMotionListener(this);
		}
			
	}
	
	public void init3()
	{
		p[0]=new People(0,"曹操",200,300,200,200);
		p[1]=new People(1,"关羽",200,200,200,100);
		p[2]=new People(2,"张飞",100,0,100,200);
		p[3]=new People(3,"黄忠",0,0,100,200);
		p[4]=new People(4,"马超",200,0,100,200);
		p[5]=new People(5,"赵云",0,300,100,200);
		p[6]=new People(6,"卒",300,0,100,100);
		p[7]=new People(7,"卒",300,100,100,100);
		p[8]=new People(8,"卒",0,200,100,100);
		p[9]=new People(9,"卒",100,200,100,100);
		
		for(int i=0;i<=9;i++)
		{
			panel.add(p[i]);
			p[i].addMouseListener(this);
			p[i].addMouseMotionListener(this);
		}
			
	}

	public void mousePressed(MouseEvent e) {
		People pr=(People)e.getSource();
		
		//鼠标按下时在组件中的位置
		x0=e.getX();
		y0=e.getY();
		
		//组件最初的位置
		primary_x=pr.getBounds().x;
		primary_y=pr.getBounds().y;
		
		//组件的宽度与高度
		w=pr.getBounds().width;
		h=pr.getBounds().height;
	}
	
	public void mouseDragged(MouseEvent e) {
		People pr=(People)e.getSource();
		
		//此刻鼠标在组件中的位置
		a=e.getX();
		b=e.getY();
		
		//此刻组件在面板中的位置
		x=pr.getBounds().x;
		y=pr.getBounds().y;
		
		//计算横纵坐标相对于初始坐标的偏移量
		int x_x=Math.abs((primary_x+x0)-(a+x));//横坐标偏移量
		int y_y=Math.abs((primary_y+y0)-(b+y));//纵坐标偏移量
		
		//通过两个坐标偏移量的正负、大小来确定相对于初始位置的移动方向
		//1为朝上，2为朝下，3为朝左，4为朝右
		if((primary_y+y0)-(b+y)>0)
		{
			if(x_x==0||x_x/y_y<1)
				direction=1;
			else if((primary_x+x0)-(a+x)>0)
				direction=3;
			else direction=4;
		}
		else if(y_y==0)
		{
			if((primary_x+x0)-(a+x)>0)
				direction=3;
			else direction=4;
		}
		else
		{
			if(x_x==0||x_x/y_y<1)
				direction=2;
			else if((primary_x+x0)-(a+x)>0)
				direction=3;
			else direction=4;
		}
		
		//对应移动方向所作出的响应
		switch(direction) {
			case 1:
			{
				my_setlocation(pr,primary_x, y+b-y0);
				break;
			}
			case 2:
			{
				my_setlocation(pr,primary_x, y+b-y0);
				break;
			}
			case 3:
			{
				my_setlocation(pr,a+x-x0, primary_y);
				break;
			}
			case 4:
			{
				my_setlocation(pr,a+x-x0, primary_y);
				break;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		People pr=(People)e.getSource();
		
		//鼠标释放时组件的位置
		x=pr.getBounds().x;
		y=pr.getBounds().y;
		
		//调整组件的最终位置
		if(direction==1) //向上调整
		{
			x=x/100*100;
			y=y/100*100;
		}
		else if(direction==2)//向下调整
		{
			x=x/100*100;
			y=(y+h)/100;
			if((y+h)%100!=0) 
				y=y+1;
			y=y*100-h;
		}
		else if(direction==3)//向左调整
		{
			x=x/100*100;
			y=y/100*100;
		}
		else //向右调整
		{
			x=(x+w)/100;
			if((x+w)%100!=0)
				x=x+1;
			x=x*100-w;
			y=y/100*100;
		}
		
		//判断组件的最终位置是否符合实际
		int flag=1;
		Rectangle temp=pr.getBounds();
		temp.setLocation(x, y);
		for(int i=0;i<=9;i++)
		{
			Rectangle pr2=p[i].getBounds();
			if(temp.intersects(pr2)&&pr.id!=i||x<0||x+w>400||y<0||y+h>500)
			{
				flag=0;
				break;
			}
		}
		
		//符合的情况
		if(flag==1)
		{
			pr.setLocation(x,y);
			if(x!=primary_x||y!=primary_y)
				RunningGame.steps++;
			label2.setText("            所走步数："+RunningGame.steps+"步");
			if(pr.name=="曹操"&&x==100&&y==300)//如果胜利，给出反馈信息
			{
				time.stop();//计时器停止走动
				new success();//给出反馈信息
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}

	//对此刻组件的位置进行判断，如果合格则显示，否则操作无响应
	public void my_setlocation(People pr,int x,int y){
		int flag=1;
		Rectangle temp=pr.getBounds();
		temp.setLocation(x, y);
		for(int i=0;i<=9;i++)
		{
			Rectangle pr2=p[i].getBounds();
			if(temp.intersects(pr2)&&pr.id!=i||y<0||y+h>500||x<0||x+w>400)
			{
				flag=0;
				break;
			}
		}
		if(flag==1)
			pr.setLocation(x, y);
	}
	
	//初始化关卡，参数k为关卡序号
 	public void useinit(int k) {
		switch(k) {
			case 1:
			{
				init1();
				break;
			}
			case 2:
			{
				init2();
				break;
			}
			case 3:
			{
				init3();
				break;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		//计时器响应事件
		if(e.getSource()==time) {
			RunningGame.seconds++;
			label1.setText("     已用时："+RunningGame.seconds+"s");
		}
		//非计时器响应事件
		else {
			//“重新开始”响应事件
			if(e.getSource()==item0)
			{	
				RunningGame.steps=0;
				RunningGame.seconds=0;
				label2.setText("            所走步数：0步");
				panel.removeAll();
				panel.repaint();
				useinit(RunningGame.number);//再现当前关卡的界面
			}
			
			//“第一关”响应事件
			if(e.getSource()==item1)
			{
				if(RunningGame.number!=1)
				{
					RunningGame.steps=0;
					RunningGame.number=1;
					RunningGame.seconds=0;
					label2.setText("            所走步数：0步");
					panel.removeAll();
					panel.repaint();
					useinit(RunningGame.number);//显示第一关的界面
				}
			}
			
			//“第二关”响应事件
			if(e.getSource()==item2)
			{
				if(RunningGame.number!=2)
				{
					RunningGame.steps=0;
					RunningGame.number=2;
					RunningGame.seconds=0;
					label2.setText("            所走步数：0步");
					panel.removeAll();
					panel.repaint();
					useinit(RunningGame.number);//显示第二关的界面
				}
			}
			
			//“第三关”响应事件
			if(e.getSource()==item3)
			{
				if(RunningGame.number!=3)
				{
					RunningGame.steps=0;
					RunningGame.number=3;
					RunningGame.seconds=0;
					label2.setText("            所走步数：0步");
					panel.removeAll();
					panel.repaint();
					useinit(RunningGame.number);//显示第三关的界面
				}
			}
			
			//计时器“开始”响应事件
			if(e.getSource()==item4) {
				RunningGame.seconds=0;
				time.start();
			}
			
			//计时器“停止”响应事件
			if(e.getSource()==item5) {
				time.stop();
			}
			
			//计时器“继续”响应事件
			if(e.getSource()==item6) {
				time.restart();
			}
			
			//“查看操作帮助”响应事件
			if(e.getSource()==item7) {
				new information();//创建无名对象来显示帮助信息
			}
		
			//“关于游戏”响应事件
			if(e.getSource()==item8) {
				new aboutGame();//创建无名对象来显示信息
			}
		}
	}
}