package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.overture.codegen.runtime.VDMSeq;

import Jarmo.Game;
import Jarmo.Position;
import javax.swing.JLabel;

/**
 * 
 * Classe onde o tabuleiro é desenhado e que recebe os inputs do jogador
 */
public class GameGraphics extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image blackPiece;
	private Image whitePiece;
	private Image background;
	private Image initialBackground;
	int imageWidth;
	private int imageHeight;
	int lastclick;
	JLabel lblPlayer;
	JLabel lblPiecesOut;
	Graphics2D g2d;
	Game engine;
	MainMenu mainmenu;
	Timer timer;
	int click_counter;
	private boolean started = false;

	/**
	 * Create the panel.
	 */
	public GameGraphics(Game engine, MainMenu mainmenu) {
		this.engine = engine;
		this.mainmenu = mainmenu;
		setFocusable(true);
		setDoubleBuffered(true);
		setLayout(null);

		
		loadSprites();

		imageWidth = this.getWidth() / 5;
		imageHeight = (this.getHeight() - 30) / 5;

	}

	private void loadSprites() {

		try {
			blackPiece = ImageIO.read(MainMenu.class.getResource("items/black.png"));
			whitePiece = ImageIO.read(MainMenu.class.getResource("items/white.png"));
			background = ImageIO.read(MainMenu.class.getResource("items/background.jpg"));
			initialBackground = ImageIO.read(MainMenu.class.getResource("items/inicialBackground.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Start() {
		started = true;
		lblPlayer = new JLabel("Jogador: " + engine.getCurrentPlayer().getNumber());
		lblPlayer.setBounds(130, 430, 100, 16);
		add(lblPlayer);
		lblPiecesOut = new JLabel("Pecas fora: " + engine.getCurrentPlayer().getPiecesOut());
		lblPiecesOut.setBounds(230, 430, 100, 16);
		add(lblPiecesOut);
		engine = new Game();
		setVisible(true);
		requestFocus();
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g2d = (Graphics2D) g;
		if (started)
			drawAll(g2d);
		else
			drawInitialBackground(g2d);
	}

	void drawAll(Graphics2D g2d) {
		lblPlayer.setText("Jogador: " + engine.getCurrentPlayer().getNumber());
		lblPiecesOut.setText("Pecas fora: " + engine.getCurrentPlayer().getPiecesOut());
		mainmenu.getContentPane().removeAll();

		drawBackground(g2d);
		imageWidth = this.getWidth() / 5;
		imageHeight = (this.getHeight() - 30) / 5;
		VDMSeq board = engine.getBoard();
		int size = board.size();
		mainmenu.getContentPane().removeAll();
		mainmenu.showBackground();

		for (int i = 0; i < size; i++) {
			// criar panels para clicar

			Position position = (Position) board.get(i);
			Number occupied = position.getOccupied();
			Number posC = position.getPosC(), posL = position.getPosL();
			addPanel(i, posC.intValue(), posL.intValue());
			if (occupied.intValue() == (int) 1) {
				drawWhite(g2d, posC.intValue(), posL.intValue());

			}

			if (occupied.intValue() == (int) 2) {
				drawBlack(g2d, posC.intValue(), posL.intValue());

			}
		}
		mainmenu.getContentPane().add(this);
	}

	private void addPanel(int pos, int posC, int posL) {
		// System.out.println(pos + " " + posC + " " + posL);

		MousePanel panel = new MousePanel(pos, engine, this);
		int dx = imageWidth * posC;
		int dy = imageHeight * posL;
		panel.setBounds(dx, dy, imageWidth, imageHeight);
		mainmenu.getContentPane().add(panel);

	}

	private void drawInitialBackground(Graphics2D g2d) {

		g2d.drawImage(initialBackground, 0, 0, this.getWidth(), this.getHeight(), 0, 0,
				initialBackground.getWidth(null), initialBackground.getHeight(null), null);
	}

	private void drawBackground(Graphics2D g2d) {

		g2d.drawImage(background, 0, 0, this.getWidth(), this.getHeight() - 30, 0, 0, background.getWidth(null),
				background.getHeight(null), null);
	}

	private void drawWhite(Graphics2D g2d, int x, int y) {

		int dx, dy;
		dx = imageWidth * x;
		dy = imageHeight * y;

		g2d.drawImage(whitePiece, dx, dy, dx + imageWidth, dy + imageHeight, 0, 0, whitePiece.getWidth(null),
				whitePiece.getHeight(null), null);
	}

	private void drawBlack(Graphics2D g2d, int x, int y) {

		int dx, dy;
		dx = imageWidth * x;
		dy = imageHeight * y;

		g2d.drawImage(blackPiece, dx, dy, dx + imageWidth, dy + imageHeight, 0, 0, blackPiece.getWidth(null),
				blackPiece.getHeight(null), null);
	}
}
