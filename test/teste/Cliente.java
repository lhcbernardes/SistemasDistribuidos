package teste;

import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente
{

    public static void main(String[] arg)
    {
        Socket s = null;
        try
        {
            System.out.println("Conectando...");
            s = new Socket("192.168.97.42", 8189);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            Scanner scan = new Scanner(System.in);
            System.out.println("Conectado");

            String imprimir = new String("");

            String string = in.readUTF();
            System.out.print(string);

            string = in.readUTF();
            System.out.print(string);
            boolean done = false;
            while (!done)
            {
                System.out.println("BYE para encerrar");
                System.out.println("hora para mostrar a hora atual");
                System.out.println("SO para mostrar sistema operacional");
                System.out.println("disco para mostrar espaço em disco");
                string = scan.nextLine();
                out.writeUTF(string);
                if (string == "BYE")
                {
                    done = in.readBoolean();
                }

                imprimir = in.readUTF();
                imprimir(imprimir);

            }
        } catch (Exception e)
        {
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
        System.out.println("Conexao encerrada");
        try
        {
            System.in.read();
        } catch (Exception e3)
        {
        }
    }

    public static void imprimir(String imprimir)
    {
        System.out.println(decodificar(imprimir) + "\n");
    }

    public static String decodificar(String imprimir)
    {

        char encriptadoArray[] = imprimir.toCharArray();
        int auxiliar;
        for (int i = 0; i < encriptadoArray.length; i++)
        {
            auxiliar = (int) encriptadoArray[i] - 3;
            encriptadoArray[i] = (char) auxiliar;
        }
        imprimir = String.valueOf(encriptadoArray);
        return imprimir;
    }
}
