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

//RunningGame���������Ϸ�Ľ����ʼ�����϶����̵���ɵȹ���
class RunningGame extends JFrame implements ActionListener,MouseListener,MouseMotionListener{
	People p[]=new People[10];//������������
	
	int x0,y0,primary_x,primary_y;//�����϶����̵ı���
	int x,y,a,b,w,h,direction;//�����϶����̵ı���
	
	static int number=1;//��ʾ��ǰ�ؿ�
	static int seconds=0;//��ʾ����ʱ��
	static int steps=0;//��ʾ���ò���
	Timer time;
	JLabel label1;//��������ʾ����ʱ��
	JLabel label2;//��������ʾ���ò���
	
	JMenuBar menubar;
	JMenu menu1,menu2,menu3;
	JMenuItem item0,item1,item2,item3;//�˵���
	JMenuItem item4,item5,item6,item7,item8;//�˵���
	
	JPanel panel,panel2;//�������panel�����ڱ�־panel2
	
	/*��Ϸ�����ʼ��
	 * ����lx��ly����ȷ��������ʾλ��
	 */
	RunningGame(int lx,int ly)
	{	
		//�����ʼ��
		super("�������ݵ�");
		super.setLayout(null);
		super.setBounds(lx, ly, 415, 585);
		super.setResizable(false);
		
		//ʵ������ʱ��
		time=new Timer(1000,this);
		
		//���������ʼ��
		panel=new JPanel();
		panel.setBounds(0, 0, 400, 500);
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		super.add(panel);
			
		//���ڱ�־��ʼ��
		panel2=new JPanel();
		panel2.setBounds(100,500,200,20);
		panel2.setBackground(Color.BLACK);
		super.add(panel2);
			
		//�˵��ĳ�ʼ��
		menubar=new JMenuBar();
		menu1=new JMenu("�ؿ�ѡ��");
		menu2=new JMenu("��ʱѡ��");
		menu3=new JMenu("����");
		item0=new JMenuItem("���¿�ʼ");
		item0.addActionListener(this);
		item1=new JMenuItem("��һ��");
		item1.addActionListener(this);
		item2=new JMenuItem("�ڶ���");
		item2.addActionListener(this);
		item3=new JMenuItem("������");
		item3.addActionListener(this);
		item4=new JMenuItem("��ʼ");
		item4.addActionListener(this);
		item5=new JMenuItem("ֹͣ");
		item5.addActionListener(this);
		item6=new JMenuItem("����");
		item6.addActionListener(this);
		item7=new JMenuItem("�鿴��������");
		item7.addActionListener(this);
		item8=new JMenuItem("������Ϸ");
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
			
		//�����ڽ�����ʾ����ʱ��
		label1=new JLabel("     ����ʱ��0s");
		label1.setForeground(Color.RED);
			
		//�����ڽ�������ʾ���ò���
		label2=new JLabel("            ���߲�����0��");
		label2.setForeground(Color.RED);
		
		//���뵽�˵�����
		menubar.add(label2);
		menubar.add(label1);
			
		//��Ӳ˵���
		super.setJMenuBar(menubar);
			
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
		validate();
	}
	
	//��һ��
	public void init1()
	{
		p[0]=new People(0,"�ܲ�",100,0,200,200);
		p[1]=new People(1,"����",100,200,200,100);
		p[2]=new People(2,"�ŷ�",0, 300,100,200);
		p[3]=new People(3,"����",100,300,100,200);
		p[4]=new People(4,"��",200, 300,100,200);
		p[5]=new People(5,"����",300, 200,100,200);
		p[6]=new People(6,"��",0, 0,100,100);
		p[7]=new People(7,"��",300,0,100,100);
		p[8]=new People(8,"��",0,200,100,100);
		p[9]=new People(9,"��",300,100,100,100);
		
		//��������װ�ع���
		for(int i=0;i<=9;i++)
		{
			panel.add(p[i]);
				
			//���������������궯���¼�������
			p[i].addMouseListener(this);
			p[i].addMouseMotionListener(this);
		}
			
	}
	
	//�ڶ���
	public void init2()
	{
		p[0]=new People(0,"�ܲ�",100,0,200,200);
		p[1]=new People(1,"����",100,200,200,100);
		p[2]=new People(2,"�ŷ�",0, 0,100,200);
		p[3]=new People(3,"����",0,200,100,200);
		p[4]=new People(4,"��",300, 0,100,200);
		p[5]=new People(5,"����",300, 200,100,200);
		p[6]=new People(6,"��",0, 400,100,100);
		p[7]=new People(7,"��",100,300,100,100);
		p[8]=new People(8,"��",200,300,100,100);
		p[9]=new People(9,"��",300,400,100,100);
		
		for(int i=0;i<=9;i++)
		{
			panel.add(p[i]);
			p[i].addMouseListener(this);
			p[i].addMouseMotionListener(this);
		}
			
	}
	
	public void init3()
	{
		p[0]=new People(0,"�ܲ�",200,300,200,200);
		p[1]=new People(1,"����",200,200,200,100);
		p[2]=new People(2,"�ŷ�",100,0,100,200);
		p[3]=new People(3,"����",0,0,100,200);
		p[4]=new People(4,"��",200,0,100,200);
		p[5]=new People(5,"����",0,300,100,200);
		p[6]=new People(6,"��",300,0,100,100);
		p[7]=new People(7,"��",300,100,100,100);
		p[8]=new People(8,"��",0,200,100,100);
		p[9]=new People(9,"��",100,200,100,100);
		
		for(int i=0;i<=9;i++)
		{
			panel.add(p[i]);
			p[i].addMouseListener(this);
			p[i].addMouseMotionListener(this);
		}
			
	}

	public void mousePressed(MouseEvent e) {
		People pr=(People)e.getSource();
		
		//��갴��ʱ������е�λ��
		x0=e.getX();
		y0=e.getY();
		
		//��������λ��
		primary_x=pr.getBounds().x;
		primary_y=pr.getBounds().y;
		
		//����Ŀ����߶�
		w=pr.getBounds().width;
		h=pr.getBounds().height;
	}
	
	public void mouseDragged(MouseEvent e) {
		People pr=(People)e.getSource();
		
		//�˿����������е�λ��
		a=e.getX();
		b=e.getY();
		
		//�˿����������е�λ��
		x=pr.getBounds().x;
		y=pr.getBounds().y;
		
		//���������������ڳ�ʼ�����ƫ����
		int x_x=Math.abs((primary_x+x0)-(a+x));//������ƫ����
		int y_y=Math.abs((primary_y+y0)-(b+y));//������ƫ����
		
		//ͨ����������ƫ��������������С��ȷ������ڳ�ʼλ�õ��ƶ�����
		//1Ϊ���ϣ�2Ϊ���£�3Ϊ����4Ϊ����
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
		
		//��Ӧ�ƶ���������������Ӧ
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
		
		//����ͷ�ʱ�����λ��
		x=pr.getBounds().x;
		y=pr.getBounds().y;
		
		//�������������λ��
		if(direction==1) //���ϵ���
		{
			x=x/100*100;
			y=y/100*100;
		}
		else if(direction==2)//���µ���
		{
			x=x/100*100;
			y=(y+h)/100;
			if((y+h)%100!=0) 
				y=y+1;
			y=y*100-h;
		}
		else if(direction==3)//�������
		{
			x=x/100*100;
			y=y/100*100;
		}
		else //���ҵ���
		{
			x=(x+w)/100;
			if((x+w)%100!=0)
				x=x+1;
			x=x*100-w;
			y=y/100*100;
		}
		
		//�ж����������λ���Ƿ����ʵ��
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
		
		//���ϵ����
		if(flag==1)
		{
			pr.setLocation(x,y);
			if(x!=primary_x||y!=primary_y)
				RunningGame.steps++;
			label2.setText("            ���߲�����"+RunningGame.steps+"��");
			if(pr.name=="�ܲ�"&&x==100&&y==300)//���ʤ��������������Ϣ
			{
				time.stop();//��ʱ��ֹͣ�߶�
				new success();//����������Ϣ
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}

	//�Դ˿������λ�ý����жϣ�����ϸ�����ʾ�������������Ӧ
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
	
	//��ʼ���ؿ�������kΪ�ؿ����
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
		//��ʱ����Ӧ�¼�
		if(e.getSource()==time) {
			RunningGame.seconds++;
			label1.setText("     ����ʱ��"+RunningGame.seconds+"s");
		}
		//�Ǽ�ʱ����Ӧ�¼�
		else {
			//�����¿�ʼ����Ӧ�¼�
			if(e.getSource()==item0)
			{	
				RunningGame.steps=0;
				RunningGame.seconds=0;
				label2.setText("            ���߲�����0��");
				panel.removeAll();
				panel.repaint();
				useinit(RunningGame.number);//���ֵ�ǰ�ؿ��Ľ���
			}
			
			//����һ�ء���Ӧ�¼�
			if(e.getSource()==item1)
			{
				if(RunningGame.number!=1)
				{
					RunningGame.steps=0;
					RunningGame.number=1;
					RunningGame.seconds=0;
					label2.setText("            ���߲�����0��");
					panel.removeAll();
					panel.repaint();
					useinit(RunningGame.number);//��ʾ��һ�صĽ���
				}
			}
			
			//���ڶ��ء���Ӧ�¼�
			if(e.getSource()==item2)
			{
				if(RunningGame.number!=2)
				{
					RunningGame.steps=0;
					RunningGame.number=2;
					RunningGame.seconds=0;
					label2.setText("            ���߲�����0��");
					panel.removeAll();
					panel.repaint();
					useinit(RunningGame.number);//��ʾ�ڶ��صĽ���
				}
			}
			
			//�������ء���Ӧ�¼�
			if(e.getSource()==item3)
			{
				if(RunningGame.number!=3)
				{
					RunningGame.steps=0;
					RunningGame.number=3;
					RunningGame.seconds=0;
					label2.setText("            ���߲�����0��");
					panel.removeAll();
					panel.repaint();
					useinit(RunningGame.number);//��ʾ�����صĽ���
				}
			}
			
			//��ʱ������ʼ����Ӧ�¼�
			if(e.getSource()==item4) {
				RunningGame.seconds=0;
				time.start();
			}
			
			//��ʱ����ֹͣ����Ӧ�¼�
			if(e.getSource()==item5) {
				time.stop();
			}
			
			//��ʱ������������Ӧ�¼�
			if(e.getSource()==item6) {
				time.restart();
			}
			
			//���鿴������������Ӧ�¼�
			if(e.getSource()==item7) {
				new information();//����������������ʾ������Ϣ
			}
		
			//��������Ϸ����Ӧ�¼�
			if(e.getSource()==item8) {
				new aboutGame();//����������������ʾ��Ϣ
			}
		}
	}
}