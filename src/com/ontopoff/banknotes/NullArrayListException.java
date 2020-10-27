package com.ontopoff.banknotes;

public class NullArrayListException extends Exception {

    NullArrayListException() {
    }

    public String toString() {
        return "com.ontopoff.banknotes.NullArrayListException[ArrayList is empty]  Enter banknotes again:";
    }
}
