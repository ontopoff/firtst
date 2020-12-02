package com.ontopoff.banknotes;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InputClass {


    public long inputExchangeable(InputStream stream) throws IOException {
        Scanner inputBanknote = new Scanner(stream);
        long longValue;

        String value = inputBanknote.nextLine();
        String beforeProcessingValue = value;
        value = value.trim();
        value = value.replace('.', ',');
        if(value.indexOf(',') != -1) {
            value = value.substring(0, value.indexOf(','));
        }
        Pattern pattern = Pattern.compile("^[\\d]+$");
        Matcher matcher = pattern.matcher(value);
        boolean found = matcher.matches();
        try {
            if((found) && (value.indexOf('0') != 0)) {
                longValue = Long.parseLong(value);
            } else {
                throw new NumberFormatException();
            }
        } catch(NumberFormatException e) {
            throw new NumberFormatException("Value " + beforeProcessingValue +  " has an invalid format!");
        }
        return longValue;
    }

    public Long[] inputChanger(InputStream stream, long value) throws IOException {
        Scanner inputBanknote = new Scanner(stream);
        RefactorInputClass refactor = new RefactorInputClass();
        Long[] bankM = new Long[0];
        ArrayList<Long> inputList = new ArrayList<Long>();

        String strValues = inputBanknote.nextLine();
        strValues = strValues.trim();
        String[] banknotes = strValues.split("\\s+");
        for(String bank : banknotes) {
            Pattern pattern = Pattern.compile("^[\\d]+$");
            Matcher matcher = pattern.matcher(bank);
            boolean found = matcher.matches();
            try {
                inputList.add(refactor.changer(value, found, bank));
            } catch (NumberFormatException | GreaterNumberException e) {
                if (e instanceof NumberFormatException) {
                    System.out.println(e);
                    continue;
                } else if (e instanceof GreaterNumberException) {
                    System.out.println(e);
                    continue;
                }
            }
        }
        try {
            if(!(refactor.nullArrayCheck(inputList))) {
                Set<Long> hs = new HashSet<>();
                hs.addAll(inputList);
                inputList.clear();
                inputList.addAll(hs);
                Collections.sort(inputList, Collections.reverseOrder());
                bankM = inputList.toArray(new Long[inputList.size()]);
            }
        } catch (NullArrayListException e) {
                System.out.println(e);
                bankM = inputChanger(stream, value);
        }
        return bankM;
    }


}
