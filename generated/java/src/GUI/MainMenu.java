package GUI;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;

import Jarmo.Game;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;

@SuppressWarnings("serial")

/**
 * 
 * Contem todos os menus de jogo 
 */
public class MainMenu extends JFrame {
	
	private JPanel contentPane;
	private JPanel buttonpanel;
	GameGraphics game;
	JButton btnStart;
	Game engine;
	public static void main(String[] args) {
		MainMenu frame = new MainMenu();
		frame.setVisible(true);
		frame.setResizable(false);
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		engine = new Game();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 423,510);
		contentPane = new JPanel();
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		buttonpanel = new JPanel();
		buttonpanel.setBounds(0, 450, 418, 25);
		contentPane.add(buttonpanel);
		buttonpanel.setLayout(new GridLayout(1, 3, 0, 0));
		buttonpanel.requestFocus();
		game = new GameGraphics(engine , this);
		game.setBorder(null);
		game.setBounds(0, 0, 420, 450);
		contentPane.add(game);
		game.setVisible(true);
		btnStart = new JButton("Start");
		buttonpanel.add(btnStart);
		
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ((JOptionPane.showConfirmDialog(rootPane, "Are you sure?",
						"Play", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
					game.Start();

				}

			}

		});

		JButton btnExit = new JButton("Exit ");
		buttonpanel.add(btnExit);
		
		
//		lblJogadorAtual = new JLabel("Jogador Atual : " + engine.getCurrentPlayer().getNumber());
//		getContentPane().add(lblJogadorAtual);
//		
//		lblNumeroDePecas = new JLabel("Numero de pecas fora : " + engine.getCurrentPlayer().getPiecesOut());
//		getContentPane().add(lblNumeroDePecas);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}

		});
		

	}

	/**
	 * Volta a mostrar o ecra inicial (redimensiona a janela e mostra a imagem)
	 * 
	 */
	public void showBackground() {
		getContentPane().add(buttonpanel);
		buttonpanel.setVisible(true);
		buttonpanel.requestFocus();
	}


	public void restart() {
		
		getContentPane().removeAll();
		getContentPane().add(buttonpanel);
		getContentPane().add(game);
		
	}
}
