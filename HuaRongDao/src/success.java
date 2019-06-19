import javax.swing.JDialog;
import javax.swing.JOptionPane;

//定义success类来反馈成功信息
class success extends JDialog{
	public success() {
		JOptionPane.showMessageDialog(null, "少侠智力通天，用时仅"+RunningGame.seconds+"s，步数仅为"+RunningGame.steps+"步，想必以后必成大器！", "恭喜成功通关", JOptionPane.PLAIN_MESSAGE);
		setVisible(true);
		setBounds(60,60,300,300);
		dispose();//销毁空白窗体
	}
}