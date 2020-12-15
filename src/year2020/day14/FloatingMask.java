package year2020.day14;

import java.util.ArrayList;
import java.util.LinkedList;

public class FloatingMask extends Mask{

    public FloatingMask(String m) {
        super(m);
    }

    @Override
    void shortenMask() {
        String mask = "";
        for (int i = 0; i < this.mask.length(); i++) {
            if (this.mask.charAt(i)== 'X' || this.mask.charAt(i) == '1') {
                mask = this.mask.substring(i);
                break;
            }
        }
        this.mask = mask;
    }

    @Override
    public ArrayList<Long> applyMask(long value) {
        String stringValue = Long.toBinaryString(value);
        StringBuilder newValue = new StringBuilder(stringValue);
        while (newValue.length() < mask.length()) {
            newValue.insert(0, '0');
        }
        int j = newValue.length() - mask.length();
        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i)!='0') {
                newValue.setCharAt(j, mask.charAt(i));
            }
            j++;
        }
        LinkedList<StringBuilder> stringResult = new LinkedList<>();
        stringResult.add(newValue);
        while (stringResult.getFirst().indexOf("X")>=0) {
            StringBuilder string = stringResult.removeFirst();
            int index = string.indexOf("X");
            StringBuilder one = new StringBuilder(string.subSequence(0, string.length()));
            one.setCharAt(index, '1');
            StringBuilder zero = new StringBuilder(string.subSequence(0, string.length()));
            zero.setCharAt(index, '0');
            stringResult.addLast(zero);
            stringResult.addLast(one);
        }
        ArrayList<Long> result = new ArrayList<>();
        for (StringBuilder string: stringResult) {
            result.add(Long.parseLong(string.toString(), 2));
        }
        return result;
    }
}
