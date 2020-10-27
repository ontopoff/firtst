package com.ontopoff.banknotes;

public class GreaterNumberException extends Exception {
    private long num;

    GreaterNumberException(long errNum){
        num = errNum;
    }

    public String toString() {
        return "com.ontopoff.banknotes.GreaterNumberException[Number " + num + " greater then input value]";
    }
}