import javax.swing.JDialog;
import javax.swing.JOptionPane;

//����aboutGame����ʵ�ְ����˵�����ʾ
class aboutGame extends JDialog{
	public aboutGame() {
		JOptionPane.showMessageDialog(null, "������Ϊrid-sun��д��ת����ע��������лл����!", null,JOptionPane.INFORMATION_MESSAGE);
		setVisible(true);
		setBounds(60,60,300,300);
		dispose();//���ٿհ״���
	}
}
