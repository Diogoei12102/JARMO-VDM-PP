package Jarmo;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Game {
    private VDMSeq board;
    private Player currentPlayer;
    private Player opponent;
    private VDMSeq players;
    private Boolean restore;

    public Game() {
        cg_init_Game_1();
    }

    public void cg_init_Game_1() {
        Position p1 = new Position(0L, 0L, 1L);
        Position p2 = new Position(0L, 1L, 1L);
        Position p3 = new Position(0L, 2L, 1L);
        Position p4 = new Position(0L, 3L, 1L);
        Position p5 = new Position(0L, 4L, 1L);
        Position p6 = new Position(1L, 0L, 0L);
        Position p7 = new Position(1L, 1L, 0L);
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
        Position p21 = new Position(4L, 0L, 2L);
        Position p22 = new Position(4L, 1L, 2L);
        Position p23 = new Position(4L, 2L, 2L);
        Position p24 = new Position(4L, 3L, 2L);
        Position p25 = new Position(4L, 4L, 2L);
        p1.addValidMoves(SeqUtil.seq(p8, p12));
        p2.addValidMoves(SeqUtil.seq(p9, p11));
        p3.addValidMoves(SeqUtil.seq(p6, p10, p12));
        p4.addValidMoves(SeqUtil.seq(p7, p15));
        p5.addValidMoves(SeqUtil.seq(p8, p14));
        p6.addValidMoves(SeqUtil.seq(p3, p13));
        p7.addValidMoves(SeqUtil.seq(p4, p8, p12, p14));
        p8.addValidMoves(SeqUtil.seq(p1, p5, p7, p9, p17));
        p9.addValidMoves(SeqUtil.seq(p2, p8, p14, p20));
        p10.addValidMoves(SeqUtil.seq(p3, p13));
        p11.addValidMoves(SeqUtil.seq(p2, p22));
        p12.addValidMoves(SeqUtil.seq(p1, p3, p7, p17, p19, p21));
        p13.addValidMoves(SeqUtil.seq(p6, p10, p16, p24));
        p14.addValidMoves(SeqUtil.seq(p5, p7, p9, p19, p23, p25));
        p15.addValidMoves(SeqUtil.seq(p4, p18));
        p16.addValidMoves(SeqUtil.seq(p13, p23));
        p17.addValidMoves(SeqUtil.seq(p8, p12, p18, p24));
        p18.addValidMoves(SeqUtil.seq(p15, p17, p19, p21, p25));
        p19.addValidMoves(SeqUtil.seq(p12, p14, p18, p22));
        p20.addValidMoves(SeqUtil.seq(p9, p23));
        p21.addValidMoves(SeqUtil.seq(p12, p18));
        p22.addValidMoves(SeqUtil.seq(p11, p19));
        p23.addValidMoves(SeqUtil.seq(p14, p16, p20));
        p24.addValidMoves(SeqUtil.seq(p13, p17));
        p25.addValidMoves(SeqUtil.seq(p14, p18));
        board = SeqUtil.seq(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12,
                p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25);
        currentPlayer = new Player(1L);
        opponent = new Player(2L);
        players = SeqUtil.seq(currentPlayer, opponent);
        restore = false;

        return;
    }

    public VDMSeq getBoard() {
        return Utils.copy(board);
    }

    public void setBoard(final VDMSeq b) {
        board = Utils.copy(b);
    }

    public VDMSeq getPlayers() {
        return Utils.copy(players);
    }

    public void changePlayer() {
        if (Utils.equals(currentPlayer.getNumber(), 1L)) {
            currentPlayer = ((Player) Utils.get(players, 2L));

            opponent = ((Player) Utils.get(players, 1L));
        } else {
            currentPlayer = ((Player) Utils.get(players, 1L));

            opponent = ((Player) Utils.get(players, 2L));
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Boolean isMoveValid(final Position pi, final Position pf) {
        Boolean orResult_1 = false;

        if (!(Utils.equals(pi.getOccupied(), currentPlayer.getNumber()))) {
            orResult_1 = true;
        } else {
            Boolean orResult_2 = false;

            if (Utils.equals(pf.getOccupied(), currentPlayer.getNumber())) {
                orResult_2 = true;
            } else {
                Boolean orResult_3 = false;

                if (!(SetUtil.inSet(pf, SeqUtil.elems(pi.getValidMoves())))) {
                    orResult_3 = true;
                } else {
                    Boolean orResult_4 = false;

                    Boolean andResult_4 = false;

                    if (Utils.equals(pi.getPosL(), 4L)) {
                        if (Utils.equals(currentPlayer.getNumber(), 1L)) {
                            andResult_4 = true;
                        }
                    }

                    if (andResult_4) {
                        orResult_4 = true;
                    } else {
                        Boolean andResult_5 = false;

                        if (Utils.equals(pi.getPosL(), 0L)) {
                            if (Utils.equals(currentPlayer.getNumber(), 2L)) {
                                andResult_5 = true;
                            }
                        }

                        orResult_4 = andResult_5;
                    }

                    orResult_3 = orResult_4;
                }

                orResult_2 = orResult_3;
            }

            orResult_1 = orResult_2;
        }

        if (orResult_1) {
            return false;
        }

        return true;
    }

    public Boolean movePiece(final Position pi, final Position pf) {
        if (isMoveValid(pi, pf)) {
            if (Utils.equals(pf.getOccupied(), opponent.getNumber())) {
                eatPiece();
            }

            pi.setOccupied(0L);
            pf.setOccupied(currentPlayer.getNumber());

            Boolean orResult_6 = false;

            Boolean andResult_8 = false;

            if (Utils.equals(pf.getPosL(), 0L)) {
                Boolean andResult_9 = false;

                if (Utils.equals(currentPlayer.getNumber(), 2L)) {
                    if (currentPlayer.getPiecesOut().longValue() > 0L) {
                        andResult_9 = true;
                    }
                }

                if (andResult_9) {
                    andResult_8 = true;
                }
            }

            if (andResult_8) {
                orResult_6 = true;
            } else {
                Boolean andResult_10 = false;

                if (Utils.equals(pf.getPosL(), 4L)) {
                    Boolean andResult_11 = false;

                    if (Utils.equals(currentPlayer.getNumber(), 1L)) {
                        if (currentPlayer.getPiecesOut().longValue() > 0L) {
                            andResult_11 = true;
                        }
                    }

                    if (andResult_11) {
                        andResult_10 = true;
                    }
                }

                orResult_6 = andResult_10;
            }

            if (!(orResult_6)) {
                changePlayer();
            } else {
                restore = true;
            }

            return true;
        }

        return false;
    }

    public void eatPiece() {
        opponent.addPiecesOut();
    }

    public void restorePiece(final Position p) {
        Boolean andResult_13 = false;

        if (Utils.equals(currentPlayer.getNumber(), 1L)) {
            if (Utils.equals(p.getPosL(), 0L)) {
                andResult_13 = true;
            }
        }

        if (andResult_13) {
            p.setOccupied(currentPlayer.getNumber());
        } else {
            Boolean andResult_14 = false;

            if (Utils.equals(currentPlayer.getNumber(), 2L)) {
                if (Utils.equals(p.getPosL(), 4L)) {
                    andResult_14 = true;
                }
            }

            if (andResult_14) {
                p.setOccupied(currentPlayer.getNumber());
            } else {
                return;
            }
        }

        currentPlayer.subPiecesOut();
        changePlayer();
    }

    public Boolean gameEnds() {
        Number cntP2 = 0L;
        Number cntP1 = 0L;
        long toVar_1 = 5L;

        for (Long l = 1L; l <= toVar_1; l++) {
            if (!(Utils.equals(((Position) Utils.get(board, l)).getOccupied(),
                        2L))) {
                cntP2 = cntP2.longValue() + 1L;
            }
        }

        long toVar_2 = 25L;

        for (Long l = 21L; l <= toVar_2; l++) {
            if (!(Utils.equals(((Position) Utils.get(board, l)).getOccupied(),
                        1L))) {
                cntP1 = cntP1.longValue() + 1L;
            }
        }

        Boolean andResult_15 = false;

        if (Utils.equals(currentPlayer.getNumber(), 1L)) {
            if (Utils.equals(currentPlayer.getPiecesOut(), cntP1)) {
                andResult_15 = true;
            }
        }

        if (andResult_15) {
            return true;
        }

        Boolean andResult_16 = false;

        if (Utils.equals(currentPlayer.getNumber(), 2L)) {
            if (Utils.equals(currentPlayer.getPiecesOut(), cntP2)) {
                andResult_16 = true;
            }
        }

        if (andResult_16) {
            return true;
        }

        Boolean orResult_7 = false;

        if (Utils.equals(currentPlayer.getPiecesOut(), 5L)) {
            orResult_7 = true;
        } else {
            orResult_7 = Utils.equals(opponent.getPiecesOut(), 5L);
        }

        if (orResult_7) {
            return true;
        }

        return false;
    }

    public void countPoints() {
        Number cntP2 = 0L;
        Number cntP1 = 0L;
        long toVar_3 = 5L;

        for (Long l = 1L; l <= toVar_3; l++) {
            if (Utils.equals(((Position) Utils.get(board, l)).getOccupied(), 2L)) {
                cntP2 = cntP2.longValue() + 2L;
            }
        }

        long toVar_4 = 20L;

        for (Long l = 6L; l <= toVar_4; l++) {
            if (Utils.equals(((Position) Utils.get(board, l)).getOccupied(), 1L)) {
                cntP1 = cntP1.longValue() + 1L;
            } else if (Utils.equals(
                        ((Position) Utils.get(board, l)).getOccupied(), 2L)) {
                cntP2 = cntP2.longValue() + 1L;
            }
        }

        long toVar_5 = 25L;

        for (Long l = 21L; l <= toVar_5; l++) {
            if (Utils.equals(((Position) Utils.get(board, l)).getOccupied(), 1L)) {
                cntP1 = cntP1.longValue() + 2L;
            }
        }

        if (Utils.equals(currentPlayer.getNumber(), 1L)) {
            currentPlayer.setScore(cntP1);
            opponent.setScore(cntP2);
        } else {
            currentPlayer.setScore(cntP2);
            opponent.setScore(cntP1);
        }
    }

    public void turn(final Position pi, final Position pf) {
        Boolean andResult_17 = false;

        if (movePiece(pi, pf)) {
            if (restore) {
                andResult_17 = true;
            }
        }

        if (andResult_17) {
            IO.print("A espera que o Jogador ");
        }

        IO.print(currentPlayer.getNumber());
        IO.print(" restaure uma peca.");

        if (gameEnds()) {
            countPoints();
        }
    }

    public Boolean getRestore() {
        return restore;
    }

    public String toString() {
        return "Game{" + "board := " + Utils.toString(board) +
        ", currentPlayer := " + Utils.toString(currentPlayer) +
        ", opponent := " + Utils.toString(opponent) + ", players := " +
        Utils.toString(players) + ", restore := " + Utils.toString(restore) +
        "}";
    }
}
