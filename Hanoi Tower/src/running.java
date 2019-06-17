import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class running extends JFrame implements ActionListener{
	/**
	 * This program uses JLayeredPane to make the background,columns and
	 * plates appear normally.
	 */
	private static final long serialVersionUID = 1L;
	JLayeredPane pane;
	int size1=0,size2=0,size3=0;//the number of plates on three columns
	int state1,state2;//number of steps required to complete the process
	int store[][]=new int[3][9];//record the serial number of plates on each column
	int step[][]=new int[512][2];//store how each step moves
	int direction=1;//indicate the moving direction of the plate
	int number;//total number of plates to be moved
	JLabel plate[]=new JLabel[9];//represents nine plates
	
	Timer time;
	JTextField text;
	JButton jb;
	
	/*These two functions are used to pre-record the plates' 
	 * movement path and the total number of times they moves.
	 */
	public void getStep(int size,int i,int j,int k) {
		if(size==1)
			move(i,j);
		else
		{
			getStep(size-1,i,k,j);                          
			move(i,j);                       
			getStep(size-1,k,j,i);                 
		}
	}
	public void move(int i,int j)
	{
		state1++;
		step[state1][0]=i;
		step[state1][1]=j;
	}
	
	
	running(){
		super("汉诺塔演示");
		super.setBounds(300, 100, 600, 500);
		super.setVisible(true);
		super.setResizable(false);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(null);
		
		//Temporary variables
		JLabel base1,base2,base3,column1,column2,column3;
		JLabel imglabel,information;
		ImageIcon img1,img2,img3;
		
		information=new JLabel("汉诺塔层数：");
		information.setBounds(20, 10, 130, 30);
		information.setFont(new Font("楷体",Font.BOLD,20));
		information.setForeground(Color.ORANGE);
		text=new JTextField();
		text.setBounds(150, 10, 130, 30);
		jb=new JButton("确定");
		jb.setBounds(290, 10, 70, 30);
		jb.addActionListener(this);
		
		//Loading the required resources
		img1 = new ImageIcon("resourse\\base.jpg");
		img2=new ImageIcon("resourse\\column.jpg");
		img3=new ImageIcon("resourse\\bgf.jpg");
		
		//Component placement
		base1=new JLabel(img1);
		base1.setBounds(20, 430, 170, 20);
		column1=new JLabel(img2);
		column1.setBounds(100, 130, 10, 300);
		base2=new JLabel(img1);
		base2.setBounds(210, 430, 170, 20);
		column2=new JLabel(img2);
		column2.setBounds(290, 130, 10, 300);
		base3=new JLabel(img1);
		base3.setBounds(410, 430, 170, 20);
		column3=new JLabel(img2);
		column3.setBounds(490, 130, 10, 300);
		
		imglabel=new JLabel(img3);     
		imglabel.setBounds(0,50,img3.getIconWidth(), img3.getIconHeight());
		
		pane=new JLayeredPane();
		pane.setBounds(0, 0, 600, 500);
		add(pane);//The position of this statement is immovable
		
		pane.add(information,JLayeredPane.MODAL_LAYER);
		pane.add(text,JLayeredPane.MODAL_LAYER);
		pane.add(jb,JLayeredPane.MODAL_LAYER);
		pane.add(imglabel, JLayeredPane.DEFAULT_LAYER);
		pane.add(base1, JLayeredPane.MODAL_LAYER);
		pane.add(base2, JLayeredPane.MODAL_LAYER);
		pane.add(base3, JLayeredPane.MODAL_LAYER);
		pane.add(column1, JLayeredPane.MODAL_LAYER);
		pane.add(column2, JLayeredPane.MODAL_LAYER);
		pane.add(column3, JLayeredPane.MODAL_LAYER);
	
		super.validate();
		time=new Timer(20,this);
		initPlate();
	}
	
	public void initPlate() {
		plate[0]=new JLabel(new ImageIcon("resourse\\1.jpg"));
		plate[1]=new JLabel(new ImageIcon("resourse\\2.jpg"));
		plate[2]=new JLabel(new ImageIcon("resourse\\3.jpg"));
		plate[3]=new JLabel(new ImageIcon("resourse\\4.jpg"));
		plate[4]=new JLabel(new ImageIcon("resourse\\5.jpg"));
		plate[5]=new JLabel(new ImageIcon("resourse\\6.jpg"));
		plate[6]=new JLabel(new ImageIcon("resourse\\7.jpg"));
		plate[7]=new JLabel(new ImageIcon("resourse\\8.jpg"));
		plate[8]=new JLabel(new ImageIcon("resourse\\9.jpg"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb)
		{
			number=Integer.parseInt(text.getText());
			if(number>9||number<=0)
				text.setText("请输入1到9的数字");
			else
			{
				//Interface refresh and reset
				for(int i=0;i<9;i++)
					pane.remove(plate[i]);
				pane.repaint();
				
				//plates placement
				for(int i=1;i<=number;i++) {
					plate[9-i].setBounds(90-7*(9-i),410-20*(i-1),150-15*(i-1),20);
					pane.add(plate[9-i], JLayeredPane.DRAG_LAYER);
					store[0][i-1]=9-i;
				}
				size1=number;
				size2=size3=0;
				pane.validate();
				state1=0;
				getStep(number,1,2,3);
				state2=1;
				time.start();
			}
		}
		if(e.getSource()==time) {
			if(state2>state1)
			{
				text.setText(number+"个盘子总共需要"+state1+"步");
				time.stop();
			}
			else 
			{
				int x,y;//Upper-left coordinates of the current plate
				JLabel lb;//定义简单对象来简化下面
				int id;//Current plate serial number
				
				if(step[state2][0]==1)
				{
					lb=plate[store[0][size1-1]];
					id=store[0][size1-1];
				}
				else if(step[state2][0]==2)
				{
					lb=plate[store[1][size2-1]];
					id=store[1][size2-1];
				}
				else 
				{
					lb=plate[store[2][size3-1]];
					id=store[2][size3-1];
				}
				x=lb.getBounds().x;
				y=lb.getBounds().y;
				
				switch (direction){
					case 1://up
						y=y-20;
						if(y<=110)
							direction=(step[state2][1]-step[state2][0]>0?3:2);
						lb.setLocation(x, y);
						break;
					case 2://left
						if(step[state2][1]==1) {
							x=x-20;
							if(x<90-7*id) {
								x=90-7*id;
								direction=4;
							}
							lb.setLocation(x, y);
						}
						if(step[state2][1]==2) {
							x=x-20;
							if(x<280-7*id) {
								x=280-7*id;
								direction=4;
							}
							lb.setLocation(x, y);
						}
						break;
					case 3://right
						if(step[state2][1]==2) {
							x=x+20;
							if(x>280-7*id) {
								x=280-7*id;
								direction=4;
							}
							lb.setLocation(x, y);
						}
						if(step[state2][1]==3) {
							x=x+20;
							if(x>480-7*id) {
								x=480-7*id;
								direction=4;
							}
							lb.setLocation(x, y);
						}
						break;
					case 4://down
						int size;
						if(step[state2][1]==1) 
							size=size1;
						else if(step[state2][1]==2)
							size=size2;
						else
							size=size3;
						y=y+20;
						if(y>=410-size*20)
						{
							direction=1;
							if(step[state2][1]==1) {
								store[0][size1]=id;
								size1++;
							}
							else if(step[state2][1]==2) {
								store[1][size2]=id;
								size2++;
							}
							else {
								store[2][size3]=id;
								size3++;
							}
							if(step[state2][0]==1)
								size1--;
							else if(step[state2][0]==2)
								size2--;
							else
								size3--;
							state2++;
						}
						lb.setLocation(x, y);
						break;
				}
			}
		}
	}
}
