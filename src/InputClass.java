import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputClass {

    public long exchangeable() throws IOException {
        long longValue = 0;
        Scanner myObj = new Scanner(System.in);
        String value = myObj.nextLine();
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
            System.out.println("Invalid format! Enter value again:");
            longValue = exchangeable();
        }
        return longValue;
    }

    public Long[] changer(long value) throws IOException {
        ArrayList<Long> inputList = new ArrayList<Long>();
        Long[] bankM;
        Scanner myObj = new Scanner(System.in);
        String values = myObj.nextLine();
        values = values.trim();
        values = values.replace('.', ',');
        String[] banknotes = values.split("\\s+");
        for(String bank : banknotes) {
            if(bank.indexOf(',') != -1) {
                bank = bank.substring(0, bank.indexOf(','));
            }
            Pattern pattern = Pattern.compile("^[\\d]+$");
            Matcher matcher = pattern.matcher(bank);
            boolean found = matcher.matches();
            try {
                if((found) && (bank.indexOf('0') != 0)) {
                    inputList.add(Long.parseLong(bank));
                    if(inputList.get(inputList.size()-1) > value) {
                        throw new GreaterNumberException(inputList.get(inputList.size()-1));
                    }
                } else {
                    throw new NumberFormatException();
                }
            } catch(NumberFormatException | GreaterNumberException e) {
                if(e instanceof GreaterNumberException) {
                    System.out.println(e);
                    inputList.remove(inputList.size()-1);
                } else if(e instanceof NumberFormatException) {
                    System.out.println("Value \"" + bank + "\" has an invalid format! It will be skipped");
                }
            }
        }
        try {
            if(inputList.size() == 0) {
                throw new NullArrayListException();
            }
        } catch (NullArrayListException e) {
            System.out.println(e);
            Collections.addAll(inputList, changer(value));
        }
        Set<Long> hs = new HashSet<>();
        hs.addAll(inputList);
        inputList.clear();
        inputList.addAll(hs);
        Collections.sort(inputList, Collections.reverseOrder());
        bankM = inputList.toArray(new Long[inputList.size()]);
        return bankM;
    }



}
