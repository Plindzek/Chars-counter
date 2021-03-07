package CharsCounter;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

class CharsCounter {

    public List<Character> countBetterChars(String str){

            return new AbstractList<Character>() {

                @Override
                public Character get(int index) {
                    return str.charAt(index);
                }

                @Override
                public int size() {
                    return str.length();
                }
            };
        }

    void countChars(String str) {
        char[] chars = new char[str.length()];
        str.getChars(0, str.length(), chars, 0);
        Arrays.sort(chars);
        int count = 1;
        System.out.println("Częstotliwość występowania znaków w ciągu: " + str);

        for (int i = 0; i < chars.length; i++) {

            /**
             * za pomoca switch zapobiegamy arrayoutofbound exception gdy różnica wyniesie
             * 0, to znak, że trzeba wykonac funkcje ostatni raz i wyjsc za pomoca break
             */

            switch (chars.length - i) {

                case 1:
                    if (chars[i] == chars[i - 1]) {

                        System.out.println(chars[i] + " występuje " + count + " razy.");
                    } else {
                        System.out.println(chars[i] + " występuje 1 raz.");
                    }
                    break;

                default:

                    if ((chars[i] == chars[i + 1]))
                        count++;
                    else {
                        System.out.println(chars[i] + " występuje " + count + " razy.");
                        count = 1;
                    }
            }
        }

    }
}
