package com.ontopoff.banknotes;

import java.io.IOException;
import java.util.*;

public class RefactorInputClass {

    public long changer(long value, boolean found, String bank) throws IOException, GreaterNumberException {
        long banknote;
        if ((found) && (bank.indexOf('0') != 0)) {
            banknote = Long.parseLong(bank);
            if (banknote > value) {
                throw new GreaterNumberException(banknote);
            }
        } else {
            throw new NumberFormatException("Value \"" + bank + "\" has an invalid format! It will be skipped");
        }
        return banknote;
    }

    public boolean nullArrayCheck(ArrayList<Long> inputList) throws  NullArrayListException {
        boolean isNull = false;
        if (inputList.size() == 0) {
            throw new NullArrayListException();
        }
        return isNull;
    }



}
