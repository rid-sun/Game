import javax.swing.JDialog;
import javax.swing.JOptionPane;

//����success���������ɹ���Ϣ
class success extends JDialog{
	public success() {
		JOptionPane.showMessageDialog(null, "��������ͨ�죬��ʱ��"+RunningGame.seconds+"s��������Ϊ"+RunningGame.steps+"��������Ժ�سɴ�����", "��ϲ�ɹ�ͨ��", JOptionPane.PLAIN_MESSAGE);
		setVisible(true);
		setBounds(60,60,300,300);
		dispose();//���ٿհ״���
	}
}