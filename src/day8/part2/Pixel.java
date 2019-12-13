package day8.part2;

public class Pixel {
    char value;

    public Pixel() {
        value = '2';
    }

    public void setValue(char c) {
        if(value == '2') {
            value = c;
        }
//        if (c < '2') {
//            value = c;
//        }
    }

    public String get() {
        if (value =='1') {
            return "#";
        } else return " ";
    }
}
