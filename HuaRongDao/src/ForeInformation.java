import javax.swing.JDialog;
import javax.swing.JOptionPane;

//����ForeInformation����ʵ�ֽ�����Ϸ����ǰ����ʾ
class ForeInformation extends JDialog{
	public ForeInformation() {
		JOptionPane.showMessageDialog(null, "�������Ϸ����������ȡ��������лл������ף��죡", "��Ϸǰ��ʾ",JOptionPane.INFORMATION_MESSAGE);
		setVisible(true);
		setBounds(60,60,300,300);
		dispose();//���ٿհ״���
	}
}
