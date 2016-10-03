package teste;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class WordCount
{

    Map<String, Integer> counter = new HashMap<String, Integer>();

    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        new WordCount().count();
    }

    private void count() throws FileNotFoundException, IOException
    {
        URL url = new URL("https://jorgemachicado.blogspot.com.br/2010/07/cmt.html");

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String string = new String();
        String linha;
        /**
         * while ((linha = in.readLine()) != null) { System.out.println(linha);
         * }
         */
        while ((linha = in.readLine()) != null)
        {
            string = string + linha;
        }

        StringTokenizer token = new StringTokenizer(string, " /-=+{}()[]<>.,?:"); //caracateres que nÃ£o interessam

        while (token.hasMoreTokens())
        {
            String s = token.nextToken();
            count(s);
            System.out.println(s);
        }

        System.out.println(counter);
        print(string);
    }

    private void count(String s)
    {
        Integer i = this.counter.get(s);
        this.counter.put(s, i == null ? 0 : ++i);
    }

    private void print(String s)
    {
        for (Entry<String, Integer> e : this.counter.entrySet())
        {
            if (e.getValue() > 0)
            {
                s = s.replaceAll(e.getKey(), String.format("<b>%s</b>", e.getKey()));
            }
        }

        System.out.println(s);
    }
}
