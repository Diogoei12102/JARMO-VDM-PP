package Jarmo;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Player {
    private Number number;
    private Number score = 0L;
    private Number piecesOut = 0L;
    private Number piecesFinal = 0L;

    public Player(final Number num) {
        cg_init_Player_1(num);
    }

    public Player() {
    }

    public void cg_init_Player_1(final Number num) {
        number = num;

        return;
    }

    public Number getNumber() {
        return number;
    }

    public Number getPiecesOut() {
        return piecesOut;
    }

    public Number getPiecesFinal() {
        return piecesFinal;
    }

    public void addPiecesFinal() {
        piecesFinal = piecesFinal.longValue() + 1L;
    }

    public void subPiecesFinal() {
        piecesFinal = piecesFinal.longValue() - 1L;
    }

    public void addPiecesOut() {
        piecesOut = piecesOut.longValue() + 1L;
    }

    public void subPiecesOut() {
        piecesOut = piecesOut.longValue() - 1L;
    }

    public void setScore(final Number sc) {
        score = sc;
    }

    public Number getScore() {
        return score;
    }

    public String toString() {
        return "Player{" + "number := " + Utils.toString(number) +
        ", score := " + Utils.toString(score) + ", piecesOut := " +
        Utils.toString(piecesOut) + ", piecesFinal := " +
        Utils.toString(piecesFinal) + "}";
    }
}
