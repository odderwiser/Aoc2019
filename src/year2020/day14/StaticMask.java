package year2020.day14;

import java.util.ArrayList;
import java.util.Collections;

public class StaticMask extends Mask {

    public StaticMask(String m) {
        super(m);
    }

    void shortenMask() {
        String mask = "";
        for (int i = 0; i < this.mask.length(); i++) {
            if (this.mask.charAt(i)== '0' || this.mask.charAt(i) == '1') {
                mask = this.mask.substring(i);
                break;
            }
        }
        this.mask = mask;
    }

    public ArrayList<Long> applyMask(long value) {
        String stringValue = Long.toBinaryString(value);
        StringBuilder newValue = new StringBuilder(stringValue);
        while (newValue.length() < mask.length()) {
            newValue.insert(0, '0');
        }
        int j = newValue.length() - mask.length();
        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i)!='X') {
                newValue.setCharAt(j, mask.charAt(i));
            }
            j++;
        }
        return new ArrayList<Long>(Collections.singleton(Long.parseLong(newValue.toString(), 2)));
    }

}
