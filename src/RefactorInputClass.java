import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RefactorInputClass {

    public long exchangeable(String value) throws IOException {
        long longValue = 0;
        value = value.trim();
        value = value.replace('.', ',');
        if (value.indexOf(',') != -1) {
            value = value.substring(0, value.indexOf(','));
        }
        Pattern pattern = Pattern.compile("^[\\d]+$");
        Matcher matcher = pattern.matcher(value);
        boolean found = matcher.matches();
        if ((found) && (value.indexOf('0') != 0)) {
            longValue = Long.parseLong(value);
        } else {
            throw new NumberFormatException("Invalid format! Enter value again:");
        }
        return longValue;
    }

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
