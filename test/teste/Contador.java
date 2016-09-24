/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.DataInputStream;

class contpalavra
{

    public static void main(String args[])
    {
        int palavra = 0;
        String s = " ", frase;
        DataInputStream dado;
        try
        {
            System.out.println("Digite uma frase:");
            dado = new DataInputStream(System.in);
            s = dado.readLine();
            frase = s;
            for (int i = 0; i < frase.length(); i++)
            {
                if (frase.charAt(i) == ' ')
                {
                    palavra += 1;
                }
                if (frase.charAt(i) == '.')
                {
                    palavra += 1;
                    break;
                } else
                {
                    continue;
                }
            }
            System.out.println("Numero de palavras: " + palavra);
        } catch (Exception a)
        {
            System.out.println("erro");
        }
    }
}
