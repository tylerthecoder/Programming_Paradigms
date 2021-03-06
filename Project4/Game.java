import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame {
	Model model;
	Controller controller;
	View view;
	static int windowHeight;

	public Game() {
		model = new Model();
		controller = new GameController(model);
		view = new View(controller, model);
		windowHeight = 1000;
		this.setTitle("Mario");
		this.setSize(1600, windowHeight);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		view.addMouseListener(controller);
		this.addKeyListener(controller);
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.run();
	}

	public void run() {
		while (true) {
			controller.update();
			model.update();
			view.repaint();
			Toolkit.getDefaultToolkit().sync();

			try {
				Thread.sleep(40);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
