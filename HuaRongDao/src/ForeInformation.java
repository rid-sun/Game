import javax.swing.JDialog;
import javax.swing.JOptionPane;

//定义ForeInformation类来实现进入游戏界面前的提示
class ForeInformation extends JDialog{
	public ForeInformation() {
		JOptionPane.showMessageDialog(null, "请进入游戏后点击帮助获取操作规则，谢谢合作。祝愉快！", "游戏前提示",JOptionPane.INFORMATION_MESSAGE);
		setVisible(true);
		setBounds(60,60,300,300);
		dispose();//销毁空白窗体
	}
}
