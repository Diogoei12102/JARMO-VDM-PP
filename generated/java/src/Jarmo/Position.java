package Jarmo;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Position {
    private Number posL;
    private Number posC;
    private Number occupied;
    private VDMSeq valid_moves;

    public Position(final Number x, final Number y, final Number o) {
        cg_init_Position_1(x, y, o);
    }

    public Position() {
    }

    public void cg_init_Position_1(final Number x, final Number y,
        final Number o) {
        posL = x;
        posC = y;
        occupied = o;

        return;
    }

    public void addValidMoves(final VDMSeq moves) {
        valid_moves = Utils.copy(moves);
    }

    public VDMSeq getValidMoves() {
        return Utils.copy(valid_moves);
    }

    public Number getPosL() {
        return posL;
    }

    public Number getPosC() {
        return posC;
    }

    public Number getOccupied() {
        return occupied;
    }

    public void setOccupied(final Number o) {
        occupied = o;
    }

    public String toString() {
        return "Position{" + "posL := " + Utils.toString(posL) + ", posC := " +
        Utils.toString(posC) + ", occupied := " + Utils.toString(occupied) +
        ", valid_moves := " + Utils.toString(valid_moves) + "}";
    }
}
