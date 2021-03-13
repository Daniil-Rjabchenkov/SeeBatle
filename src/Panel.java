import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {
	Game game;
	Timer tm;

	Panel() {
		game = new Game();
		setLayout(null);
		JButton nGame = new JButton("Новая игра");
		nGame.setBounds(500, 700, 200, 50);
		add(nGame);
		nGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game = new Game();
				repaint();
			}
		});
		add(nGame);
		JButton endGame = new JButton("Конец игры");
		endGame.setBounds(1300, 700, 200, 50);
		add(endGame);
		endGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		add(endGame);
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		game.computerField.paintField(g);
		game.playerField.paintField(g);
	}
}