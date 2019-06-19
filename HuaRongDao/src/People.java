import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

//����һ��People�࣬���й����������һ�������Ϣ���з�װ
class People extends JButton {
	public int id,lx,ly,width,height;//��������ı�š���С��λ��
	String name;//�������������
	
	//������������г�ʼ��
	People(int iid,String s,int x,int y,int w,int h){
		super(s);
		name=s;
		id=iid;
		lx=x;
		ly=y;
		width=w;
		height=h;
		setBackground(Color.LIGHT_GRAY);//���ñ���
		setForeground(Color.BLACK);//����ǰ��
		setFont(new Font("����", Font.BOLD, 22));//��������ϵ�����
		setBounds(x,y,w,h);//�������������е�λ��
		
	}
	
	//���������ͼƬ����
	public void paint(Graphics g){
	    ImageIcon icon=new ImageIcon("resourse\\"+name+".jpg");
	    Image image=icon.getImage();
	    g.drawImage(image, 0, 0, null);
	}
}