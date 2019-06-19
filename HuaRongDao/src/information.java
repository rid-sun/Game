import javax.swing.JDialog;
import javax.swing.JOptionPane;

//响应帮助信息
class information extends JDialog{
	public information() {
		JOptionPane.showMessageDialog(null, "本小游戏因作者能力较弱，所以您得遵循以下的规定才能"
				+ "顺利的进行游戏：\n"+"1.本游戏是通过拖动块来实现移动。因用鼠标操作，避免不了不精准，若它未达到您要求，烦请您再来一次。\n"
				+"2.本游戏与其他华容道一样，可随意方式随意速度拖动到目标位置。\n"
				+"3.本游戏有三关，可通过点击“关卡选项”来随意切换。\n"
				+"4.本游戏有可计时使用和不计时使用两种功能。可通过点击“计时选项”来使计时器开始、停止或继续工作模式。\n"
				+ "注意：点击开始会从零计时；每一次重新开始关卡或进入别的关卡，请点击开始来计时。\n望少侠玩的愉快开心", "帮助",JOptionPane.INFORMATION_MESSAGE);
		setVisible(true);
		setBounds(80,0,300,300);
		dispose();//销毁空白窗体
	}
}
