import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ForeJFrame extends JFrame implements MouseListener{
	ImageIcon img; //�����������洢����ͼƬ
	JLabel imgLabel; //����װ�ر���ͼƬ
	JLabel lb1,lb2,lb3;
	JLayeredPane panel;
	int x1,y1,x2,y2,x3,y3;//�������水ť�ĳ�ʼλ��
	
	ForeJFrame(){
		
		//�����ʼ��
		super("�������ݵ�");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		super.setBounds(300, 0, 415, 585); 
		super.setVisible(true);
		
		//�ֲ�����ʼ��
		panel=new JLayeredPane();
		panel.setBounds(0,0,415,585);
		panel.setLayout(null);
		super.add(panel);
		
		//���ñ���
		img=new ImageIcon("resourse\\����.jpg");//����ͼƬ   
		imgLabel=new JLabel(img);//������ͼ���ڱ�ǩ�       
		imgLabel.setBounds(0,0,415, 585);//���ñ�����ǩ��λ��   
		
		//���水ť��ʼ��
		//��������ʼ��Ϸ����ť
		lb1=new JLabel("��ʼ��Ϸ");//������ǩ
		lb1.setBounds(160, 250, 90, 30);
		lb1.setFont(new Font("����",Font.BOLD,20));
		lb1.setForeground(Color.CYAN);//����ǰ��
		lb1.addMouseListener(this);//�������¼�������
		
		//�������˳���Ϸ����ť
		lb2=new JLabel("�˳���Ϸ");
		lb2.setBounds(160, 310, 90, 30);
		lb2.setFont(new Font("����",Font.BOLD,20));
		lb2.setForeground(Color.CYAN);
		lb2.addMouseListener(this);
		
		//������Ѱ���������ť
		lb3=new JLabel("Ѱ�����");
		lb3.setBounds(160, 370, 90, 30);
		lb3.setFont(new Font("����",Font.BOLD,20));
		lb3.setForeground(Color.CYAN);
		lb3.addMouseListener(this);
		
		//����ť��ӵ������
		panel.add(lb1,JLayeredPane.DRAG_LAYER);
		panel.add(lb2,JLayeredPane.DRAG_LAYER);
		panel.add(lb3,JLayeredPane.DRAG_LAYER);
		panel.add(imgLabel, JLayeredPane.DRAG_LAYER);
	}
	
	//ͨ����������������������Ϣ
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
		
			//����HuaRongDao����󣬵��õ�һ�س�ʼ������
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