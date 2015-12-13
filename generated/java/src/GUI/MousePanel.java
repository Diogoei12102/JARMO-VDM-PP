package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Jarmo2.Game;
import Jarmo2.Position;

@SuppressWarnings("serial")
public class MousePanel extends JPanel {
	int number;
	Game engine;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public MousePanel(int pos, Game engine, GameGraphics game) {
		number = pos;
		game.click_counter = 0;
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Position p = (Position) engine.getBoard().get(number);
				if (game.click_counter == 0 && p.getOccupied() != engine.getCurrentPlayer().getNumber())
					JOptionPane.showMessageDialog(null, "Choose one of your Pieces");
				else if (game.click_counter == 1) {
					game.click_counter = 0;
					if (engine.movePiece((Position) engine.getBoard().get(game.lastclick),
							(Position) engine.getBoard().get(number))) {
						game.drawAll(game.g2d);
						game.repaint();

					} else {
						System.out.println("movimento invalido");
						JOptionPane.showMessageDialog(null, "Movimento Invalido");
					}
				} else
					game.click_counter++;
				game.lastclick = number;
				int currentPlayer = engine.getCurrentPlayer().getNumber().intValue();
				int piecesOut = engine.getCurrentPlayer().getPiecesOut().intValue();
				int piecesFinal = engine.getCurrentPlayer().getPiecesFinal().intValue();
				if (currentPlayer == 1 && piecesOut > 0 && piecesOut < piecesFinal) {
					for (int i = 0; i < 5; i++) {
						Position temp = (Position) engine.getBoard().get(i);
						if ((int) temp.getOccupied() == 0) {
							JOptionPane.showMessageDialog(null, "O jogador"
									+ (int) engine.getCurrentPlayer().getNumber() + "tem de repor uma peca");
						}
					}
				} else if (currentPlayer == 2 && piecesOut > 0 && piecesOut < piecesFinal) {
					for (int i = 20; i < 25; i++) {
						Position temp = (Position) engine.getBoard().get(i);
						if ((int) temp.getOccupied() == 0) {
							JOptionPane.showMessageDialog(null, "O jogador"
									+ (int) engine.getCurrentPlayer().getNumber() + "tem de repor uma peca");
						}
					}
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

	}
}
