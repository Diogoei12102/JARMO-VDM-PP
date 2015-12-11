package Jarmo;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class TestJarmo extends Tests {
    public TestJarmo() {
    }

    public void testBoard() {
        Game g = new Game();
        VDMSeq board = g.getBoard();
        IO.print("TESTE AO TABULEIRO INICIAL\n");
        IO.print("Linha Jogador 1\n");

        long toVar_6 = 5L;

        for (Long i = 1L; i <= toVar_6; i++) {
            IO.print("Posicao ocupada com ");
            IO.print(((Position) Utils.get(board, i)).getOccupied());
            IO.print(" ");
            super.assertTrue(Utils.equals(
                    ((Position) Utils.get(board, i)).getOccupied(), 1L));
        }

        IO.print("Linha Jogador 2\n");

        long toVar_7 = 25L;

        for (Long i = 21L; i <= toVar_7; i++) {
            IO.print("Posicao ocupada com ");
            IO.print(((Position) Utils.get(board, i)).getOccupied());
            IO.print(" ");
            super.assertTrue(Utils.equals(
                    ((Position) Utils.get(board, i)).getOccupied(), 2L));
        }

        IO.print("Linhas vazias\n");

        long toVar_8 = 20L;

        for (Long i = 6L; i <= toVar_8; i++) {
            IO.print("Posicao ocupada com ");
            IO.print(((Position) Utils.get(board, i)).getOccupied());
            IO.print(" ");
            super.assertTrue(Utils.equals(
                    ((Position) Utils.get(board, i)).getOccupied(), 0L));
        }
    }

    public void testMove() {
        Game g = new Game();
        VDMSeq board = g.getBoard();
        IO.print("TESTAR MOVIMENTO DE PECA\n");
        super.assertTrue(g.isMoveValid(((Position) Utils.get(board, 1L)),
                ((Position) Utils.get(board, 8L))));
        IO.print("TESTE MEXER PECA PARA UMA CASA VAZIA (Jogador 1) \n");
        IO.print("peca mexeu:");
        super.assertTrue(g.movePiece(((Position) Utils.get(board, 1L)),
                ((Position) Utils.get(board, 8L))));
        IO.print("posicao inicial do tabuleiro mudou:");
        super.assertTrue(Utils.equals(
                ((Position) Utils.get(board, 1L)).getOccupied(), 0L));
        IO.print("posicao final do tabuleiro mudou:");
        super.assertTrue(Utils.equals(
                ((Position) Utils.get(board, 8L)).getOccupied(), 1L));
        IO.print("jogador mudou para 2:");
        super.assertTrue(Utils.equals(g.getCurrentPlayer().getNumber(), 2L));
        IO.print("TESTE MEXER PECA PARA UMA CASA VAZIA (Jogador 2) \n");
        IO.print("peca mexeu:");
        super.assertTrue(g.movePiece(((Position) Utils.get(board, 24L)),
                ((Position) Utils.get(board, 15L))));
        IO.print("posicao inicial mudou:");
        super.assertTrue(Utils.equals(
                ((Position) Utils.get(board, 24L)).getOccupied(), 0L));
        IO.print("posicao final mudou:");
        super.assertTrue(Utils.equals(
                ((Position) Utils.get(board, 15L)).getOccupied(), 2L));
        IO.print("jogador mudou para 1:");
        super.assertTrue(Utils.equals(g.getCurrentPlayer().getNumber(), 1L));
        IO.print("TENTAR MOVER A PARTIR DE UMA POSICAO VAZIA (Jogador 1) \n");
        IO.print("peca mexeu:");
        super.assertTrue(g.movePiece(((Position) Utils.get(board, 1L)),
                ((Position) Utils.get(board, 12L))));
        IO.print("posicao inicial nao mudou:");
        super.assertTrue(Utils.equals(
                ((Position) Utils.get(board, 1L)).getOccupied(), 0L));
        IO.print("posicao final nao mudou:");
        super.assertTrue(Utils.equals(
                ((Position) Utils.get(board, 12L)).getOccupied(), 0L));
        IO.print("jogador mudou:");
        super.assertTrue(Utils.equals(g.getCurrentPlayer().getNumber(), 2L));
        IO.print("TENTAR MOVER PECA ADVERSARIO (Jogador 1) \n");
        IO.print("peca mexeu:");
        super.assertTrue(g.movePiece(((Position) Utils.get(board, 15L)),
                ((Position) Utils.get(board, 24L))));
        IO.print("posicao inicial nao mudou:");
        super.assertTrue(Utils.equals(
                ((Position) Utils.get(board, 15L)).getOccupied(), 2L));
        IO.print("posicao final nao mudou:");
        super.assertTrue(Utils.equals(
                ((Position) Utils.get(board, 24L)).getOccupied(), 0L));
        IO.print("jogador mudou:");
        super.assertTrue(Utils.equals(g.getCurrentPlayer().getNumber(), 2L));
        IO.print("TENTAR COMER PECA ADVERSARIO (Jogador 2) \n");
        IO.print("Jogador 1 para posicao vulneravel:");
        super.assertTrue(g.movePiece(((Position) Utils.get(board, 5L)),
                ((Position) Utils.get(board, 14L))));
        IO.print("peca mexeu:");
        super.assertTrue(g.movePiece(((Position) Utils.get(board, 25L)),
                ((Position) Utils.get(board, 14L))));
        IO.print("posicao inicial mudou:");
        super.assertTrue(Utils.equals(
                ((Position) Utils.get(board, 25L)).getOccupied(), 0L));
        IO.print("posicao final mudou:");
        super.assertTrue(Utils.equals(
                ((Position) Utils.get(board, 14L)).getOccupied(), 2L));
        IO.print("jogador mudou:");
        super.assertTrue(Utils.equals(g.getCurrentPlayer().getNumber(), 1L));
        IO.print("incrementou piecesOut do jogador 2:");
        super.assertTrue(Utils.equals(g.getCurrentPlayer().getPiecesOut(), 1L));
    }

    public void testEnd() {
        Game g = new Game();
        Position p1 = new Position(0L, 0L, 2L);
        Position p2 = new Position(0L, 1L, 2L);
        Position p3 = new Position(0L, 2L, 2L);
        Position p4 = new Position(0L, 3L, 0L);
        Position p5 = new Position(0L, 4L, 2L);
        Position p6 = new Position(1L, 0L, 1L);
        Position p7 = new Position(1L, 1L, 2L);
        Position p8 = new Position(1L, 2L, 0L);
        Position p9 = new Position(1L, 3L, 0L);
        Position p10 = new Position(1L, 4L, 0L);
        Position p11 = new Position(2L, 0L, 0L);
        Position p12 = new Position(2L, 1L, 0L);
        Position p13 = new Position(2L, 2L, 0L);
        Position p14 = new Position(2L, 3L, 0L);
        Position p15 = new Position(2L, 4L, 0L);
        Position p16 = new Position(3L, 0L, 0L);
        Position p17 = new Position(3L, 1L, 0L);
        Position p18 = new Position(3L, 2L, 0L);
        Position p19 = new Position(3L, 3L, 0L);
        Position p20 = new Position(3L, 4L, 0L);
        Position p21 = new Position(4L, 0L, 0L);
        Position p22 = new Position(4L, 1L, 0L);
        Position p23 = new Position(4L, 2L, 0L);
        Position p24 = new Position(4L, 3L, 0L);
        Position p25 = new Position(4L, 4L, 0L);
        p7.addValidMoves(SeqUtil.seq(p4));
        p6.addValidMoves(SeqUtil.seq(p13));
        g.setBoard(SeqUtil.seq(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11,
                p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23,
                p24, p25));
        IO.print("VERIFICAR SE JOGO TERMINA\n");
        IO.print("Elementos tabuleiro: \n");

        long toVar_9 = 25L;

        for (Long i = 1L; i <= toVar_9; i++) {
            IO.print("(");
            IO.print(((Position) Utils.get(g.getBoard(), i)).getPosL());
            IO.print(",");
            IO.print(((Position) Utils.get(g.getBoard(), i)).getPosC());
            IO.print(",");
            IO.print(((Position) Utils.get(g.getBoard(), i)).getOccupied());
            IO.print(")");

            if (Utils.equals(
                        ((Position) Utils.get(g.getBoard(), i)).getPosC(), 4L)) {
                IO.print("\n");
            }
        }

        g.changePlayer();
        g.getCurrentPlayer().addPiecesFinal();
        g.getCurrentPlayer().addPiecesFinal();
        g.getCurrentPlayer().addPiecesFinal();
        g.getCurrentPlayer().addPiecesFinal();
        IO.print("Jogador: ");
        IO.print(g.getCurrentPlayer().getPiecesFinal());
        IO.print("\n");
        IO.print("Verificar se termina (ainda ha jogadas possiveis): ");
        super.assertTrue(g.gameEnds());
        IO.print("Jogador 2 move peca para linha final: ");
        super.assertTrue(g.movePiece(p7, p4));
        IO.print("Verificar se termina (Jogador 1 ainda pode jogar): ");
        super.assertTrue(g.gameEnds());
        IO.print("Jogador 1 joga: ");
        super.assertTrue(g.movePiece(p6, p13));
        IO.print(
            "Verificar se termina (Jogador 2 tem todas as suas pecas na linha do oponente e nao pode efetuar mais jogadas): ");
        super.assertTrue(g.gameEnds());
    }

    public void testScore() {
        Game g = new Game();
        Position p1 = new Position(0L, 0L, 2L);
        Position p2 = new Position(0L, 1L, 2L);
        Position p3 = new Position(0L, 2L, 2L);
        Position p4 = new Position(0L, 3L, 0L);
        Position p5 = new Position(0L, 4L, 2L);
        Position p6 = new Position(1L, 0L, 1L);
        Position p7 = new Position(1L, 1L, 2L);
        Position p8 = new Position(1L, 2L, 0L);
        Position p9 = new Position(1L, 3L, 0L);
        Position p10 = new Position(1L, 4L, 0L);
        Position p11 = new Position(2L, 0L, 0L);
        Position p12 = new Position(2L, 1L, 0L);
        Position p13 = new Position(2L, 2L, 0L);
        Position p14 = new Position(2L, 3L, 0L);
        Position p15 = new Position(2L, 4L, 0L);
        Position p16 = new Position(3L, 0L, 0L);
        Position p17 = new Position(3L, 1L, 0L);
        Position p18 = new Position(3L, 2L, 0L);
        Position p19 = new Position(3L, 3L, 0L);
        Position p20 = new Position(3L, 4L, 0L);
        Position p21 = new Position(4L, 0L, 0L);
        Position p22 = new Position(4L, 1L, 0L);
        Position p23 = new Position(4L, 2L, 0L);
        Position p24 = new Position(4L, 3L, 0L);
        Position p25 = new Position(4L, 4L, 0L);
        p7.addValidMoves(SeqUtil.seq(p4));
        p6.addValidMoves(SeqUtil.seq(p13));
        g.setBoard(SeqUtil.seq(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11,
                p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23,
                p24, p25));
        IO.print("\nVERIFICAR PONTUACAO\n");
        IO.print("elementos tabuleiro: \n");

        long toVar_10 = 25L;

        for (Long i = 1L; i <= toVar_10; i++) {
            IO.print("(");
            IO.print(((Position) Utils.get(g.getBoard(), i)).getPosL());
            IO.print(",");
            IO.print(((Position) Utils.get(g.getBoard(), i)).getPosC());
            IO.print(",");
            IO.print(((Position) Utils.get(g.getBoard(), i)).getOccupied());
            IO.print(")");

            if (Utils.equals(
                        ((Position) Utils.get(g.getBoard(), i)).getPosC(), 4L)) {
                IO.print("\n");
            }
        }

        g.changePlayer();
        g.getCurrentPlayer().addPiecesFinal();
        g.getCurrentPlayer().addPiecesFinal();
        g.getCurrentPlayer().addPiecesFinal();
        g.getCurrentPlayer().addPiecesFinal();
        IO.print("Verificar se termina (ainda ha jogadas possiveis): ");
        super.assertTrue(g.gameEnds());
        IO.print("Jogador 2 move peca para linha final: ");
        super.assertTrue(g.movePiece(p7, p4));
        IO.print("Verificar se termina (Jogador 1 ainda pode jogar): ");
        super.assertTrue(g.gameEnds());
        IO.print("Jogador 1 joga: ");
        super.assertTrue(g.movePiece(p6, p13));
        IO.print(
            "Verificar se termina (Jogador 2 tem todas as suas pecas na linha do oponente e nao pode efetuar mais jogadas): ");
        super.assertTrue(g.gameEnds());
        g.countPoints();
        IO.print("Jogador 2: ");
        super.assertEqual(((Player) Utils.get(g.getPlayers(), 2L)).getScore(),
            10L);
        IO.print("Jogador 1: ");
        super.assertEqual(((Player) Utils.get(g.getPlayers(), 1L)).getScore(),
            1L);
    }

    public void testRestorePiece() {
        Game g = new Game();
        Position p1 = new Position(0L, 0L, 0L);
        Position p2 = new Position(0L, 1L, 1L);
        Position p3 = new Position(0L, 2L, 1L);
        Position p4 = new Position(0L, 3L, 0L);
        Position p5 = new Position(0L, 4L, 0L);
        Position p6 = new Position(1L, 0L, 0L);
        Position p7 = new Position(1L, 1L, 0L);
        Position p8 = new Position(1L, 2L, 0L);
        Position p9 = new Position(1L, 3L, 0L);
        Position p10 = new Position(1L, 4L, 0L);
        Position p11 = new Position(2L, 0L, 0L);
        Position p12 = new Position(2L, 1L, 0L);
        Position p13 = new Position(2L, 2L, 0L);
        Position p14 = new Position(2L, 3L, 1L);
        Position p15 = new Position(2L, 4L, 0L);
        Position p16 = new Position(3L, 0L, 0L);
        Position p17 = new Position(3L, 1L, 2L);
        Position p18 = new Position(3L, 2L, 0L);
        Position p19 = new Position(3L, 3L, 0L);
        Position p20 = new Position(3L, 4L, 0L);
        Position p21 = new Position(4L, 0L, 2L);
        Position p22 = new Position(4L, 1L, 2L);
        Position p23 = new Position(4L, 2L, 2L);
        Position p24 = new Position(4L, 3L, 2L);
        Position p25 = new Position(4L, 4L, 0L);
        p14.addValidMoves(SeqUtil.seq(p25));
        g.getCurrentPlayer().addPiecesOut();
        g.setBoard(SeqUtil.seq(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11,
                p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23,
                p24, p25));
        IO.print("\nVERIFICAR RESTAURAR PECA\n");
        IO.print("Elementos tabuleiro: \n");

        long toVar_11 = 25L;

        for (Long i = 1L; i <= toVar_11; i++) {
            IO.print("(");
            IO.print(((Position) Utils.get(g.getBoard(), i)).getPosL());
            IO.print(",");
            IO.print(((Position) Utils.get(g.getBoard(), i)).getPosC());
            IO.print(",");
            IO.print(((Position) Utils.get(g.getBoard(), i)).getOccupied());
            IO.print(")");

            if (Utils.equals(
                        ((Position) Utils.get(g.getBoard(), i)).getPosC(), 4L)) {
                IO.print("\n");
            }
        }

        IO.print("Jogador 1 move peca para linha final: ");
        super.assertTrue(g.movePiece(p14, p25));
        IO.print(
            "Pecas fora do tabuleiro do Jogador 1 (Jogador 1 tem de ter uma peca fora do tabuleiro para a poder restaurar): ");
        super.assertEqual(1L,
            ((Player) Utils.get(g.getPlayers(), 1L)).getPiecesOut());
        g.restorePiece(p1);
        IO.print("Jogador 1 restaura peca na posicao 1: ");
        super.assertEqual(((Position) Utils.get(g.getBoard(), 1L)).getOccupied(),
            1L);
        super.assertEqual(((Player) Utils.get(g.getPlayers(), 1L)).getPiecesOut(),
            0L);
    }

    public static void main() {
        TestJarmo t = new TestJarmo();
        t.testBoard();
        IO.println("-----------------------------");
        t.testMove();
        IO.println("-----------------------------");
        t.testEnd();
        IO.println("-----------------------------");
        t.testScore();
        IO.println("-----------------------------");
        t.testRestorePiece();
    }

    public String toString() {
        return "TestJarmo{}";
    }
}
