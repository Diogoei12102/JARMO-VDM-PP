package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Jarmo.Game;
import Jarmo.Position;

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
				
				
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Position p = (Position) engine.getBoard().get(number);
				if(engine.getRestore()){
					if(!engine.restorePiece(p)){
						JOptionPane.showMessageDialog(null, "Não é possivel repor uma peça na posiçao selecionada");
					}
					else
					game.drawAll(game.g2d);
					game.repaint();

				}
				else
				if (game.click_counter == 0 && p.getOccupied() != engine.getCurrentPlayer().getNumber())
					JOptionPane.showMessageDialog(null, "Choose one of your Pieces");
				else if (game.click_counter == 1) {
					game.click_counter = 0;
					if (engine.movePiece((Position) engine.getBoard().get(game.lastclick),
							(Position) engine.getBoard().get(number))) {
						if(engine.getRestore()){
							JOptionPane.showMessageDialog(null, "O jogador " + engine.getCurrentPlayer().getNumber() + "tem de repor uma peca");
						}
						game.drawAll(game.g2d);
						game.repaint();

					} else {
						System.out.println("movimento invalido");
						JOptionPane.showMessageDialog(null, "Movimento Invalido");
					}
				} else
					game.click_counter++;
				game.lastclick = number;

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
