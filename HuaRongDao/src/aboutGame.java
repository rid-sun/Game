import javax.swing.JDialog;
import javax.swing.JOptionPane;

//定义aboutGame类来实现帮助菜单的提示
class aboutGame extends JDialog{
	public aboutGame() {
		JOptionPane.showMessageDialog(null, "本程序为rid-sun编写，转载请注明出处。谢谢合作!", null,JOptionPane.INFORMATION_MESSAGE);
		setVisible(true);
		setBounds(60,60,300,300);
		dispose();//销毁空白窗体
	}
}
