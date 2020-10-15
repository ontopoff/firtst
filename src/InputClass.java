import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputClass {


    public long inputExchangeable() throws IOException {
        Scanner myObj = new Scanner(System.in);
        RefactorInputClass refactor = new RefactorInputClass();
        long longValue = 0;

        String value = myObj.nextLine();

        try {
            longValue = refactor.exchangeable(value);
        } catch(NumberFormatException e) {
            longValue = inputExchangeable();
        }
        return longValue;
    }

    public Long[] Inputchanger(long value) throws IOException {
        Scanner myObj = new Scanner(System.in);
        RefactorInputClass refactor = new RefactorInputClass();
        Long[] bankM = new Long[0];
        ArrayList<Long> inputList = new ArrayList<Long>();

        String strValues = myObj.nextLine();
        strValues = strValues.trim();
        strValues = strValues.replace('.', ',');
        String[] banknotes = strValues.split("\\s+");
        for(String bank : banknotes) {
            if (bank.indexOf(',') != -1) {
                bank = bank.substring(0, bank.indexOf(','));
            }
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
                bankM = Inputchanger(value);
        }
        return bankM;
    }


}
