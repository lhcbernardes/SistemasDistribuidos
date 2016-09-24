
package teste;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;


public class WordCount {
    Map<String, Integer> counter = new HashMap<String, Integer>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        new WordCount().count();
    }

    private void count() {
        String string = "Hoje em dia, é necessário ser esperto. O nosso dia a dia é complicado.";

        StringTokenizer token = new StringTokenizer(string, " .,?:"); //caracateres que não interessam

        while (token.hasMoreTokens()) {
            String s = token.nextToken();
            count(s);
            System.out.println(s);
        }

        System.out.println(counter);
        print(string);
    }

    private void count(String s) {
        Integer i = this.counter.get(s);
        this.counter.put(s, i == null ? 0 : ++i);
    }

    private void print(String s) {
        for (Entry<String, Integer> e : this.counter.entrySet()) {
            if (e.getValue() > 0) {
                s = s.replaceAll(e.getKey(), String.format("<b>%s</b>", e.getKey()));
            }
        }

        System.out.println(s);
    }
}