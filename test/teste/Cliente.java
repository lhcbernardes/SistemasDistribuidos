package teste;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente
{

    public static void main(String[] arg)
    {
        double numero;
        int c, total = (int) (10 * Math.random());
        Socket s = null;
        try
        {
            System.out.println("Conectando...");
            s = new Socket("192.168.97.43", 6789);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            System.out.println("Conectado. Enviando " + total + " números...");
            double contador = 0;
            while (contador != -1)
            {
                Scanner scan = new Scanner(in);
                contador = scan.nextDouble();
                System.out.println("Enviando " + contador);
                out.writeDouble(contador);
            }
            out.flush();
            out.writeDouble(-1.0);
            System.out.println("Somatório = " + in.readDouble());
        } catch (Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
        } finally
        {
            try
            {
                if (s != null)
                {
                    s.close();
                }
            } catch (Exception e2)
            {
            }
        }
        System.out.println("Conexão encerrada");
        try
        {
            System.in.read();
        } catch (Exception e3)
        {
        }
    }
}
