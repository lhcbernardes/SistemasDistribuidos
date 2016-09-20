package teste;

import echoserver.Encripter;
import java.io.*;
import java.net.*;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Cliente
{

    public static void main(String[] arg) throws IOException
    {

        Socket s = null;
        try
        {
            System.out.println("Conectando...");
            s = new Socket("192.168.0.100", 6789);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            System.out.println("Conectado.");
            /**
             * for (c = 0; c < total; c++) { numero = 100.0 * Math.random();
             * System.out.println("Enviando " + numero);
             * out.writeDouble(numero); } out.flush(); out.writeDouble(-1.0);
             * System.out.println("Somatório = " + in.readDouble());
             *
             */

            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(in);
            PrintWriter printWriter = new PrintWriter(out, true /* autoFlush */);
            System.out.println("encriptar para mandar mesnsagem");
            System.out.println("hora para saber a hora");
            System.out.println("so para sistema operacional");
            System.out.println("disk para saber o tamanho e utilizado em disco");

            boolean done = false;

            while (!done && scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                //out.println("Echo: " + line);

                if (line.trim().equals("hora"))
                {
                    getHoras(printWriter);
                }
                if (line.trim().equals("so"))
                {
                    getSO(printWriter);
                }
                if (line.trim().equals("disk"))
                {
                    getFreeDisk(printWriter);
                }
                if (line.trim().equals("encriptar"))
                {
                    printWriter.println("Digite o que quer encriptar\n");
                    line = scanner.nextLine();
                    getEncriptar(printWriter, line);
                }
                if (line.trim().equals("BYE"))
                {
                    done = true;
                }
            }
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

    private static void getEncriptar(PrintWriter out, String texto)
    {
        Encripter cripter = new Encripter(texto);
        out.println(cripter.encriptar());

    }

    private static void getFreeDisk(PrintWriter out)
    {
        File arquivo = new File("C:\\");
        long total = (long) (arquivo.getTotalSpace() / 1000000.00);
        StringBuilder x = new StringBuilder();

        x.append(total);
        Encripter texto = new Encripter(x.toString());
        out.println("Disponível: " + texto.encriptar() + "MB");

    }

    private static void getSO(PrintWriter out)
    {
        String so = System.getProperty("os.name").toUpperCase();

        Encripter texto = new Encripter(so);
        out.println(texto.encriptar());
    }

    private static void getHoras(PrintWriter out)
    {
        GregorianCalendar hora = new GregorianCalendar();
        StringBuilder concat = new StringBuilder();

        concat.append(hora.get(GregorianCalendar.HOUR_OF_DAY));
        concat.append(":");
        concat.append(hora.get(GregorianCalendar.MINUTE));
        Encripter texto = new Encripter(concat.toString());
        out.println(texto.encriptar());
    }
}
