package Jarmo;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Tests {
    public Tests() {
    }

    protected void assertTrue(final Boolean arg) {
        if (!(arg)) {
            IO.print("#Falso#\n");
        } else {
            IO.print("#Verdadeiro#\n");
        }
    }

    protected void assertEqual(final Object expected, final Object actual) {
        if (!(Utils.equals(expected, actual))) {
            IO.print("Valor atingido (");
            IO.print(((Object) actual));
            IO.print(") diferente do esperado (");
            IO.print(((Object) expected));
            IO.println(")");
        } else {
            IO.print("Valor atingido (");
            IO.print(((Object) actual));
            IO.print(") corresponde ao esperado (");
            IO.print(((Object) expected));
            IO.println(")");
        }
    }

    public String toString() {
        return "Tests{}";
    }
}
