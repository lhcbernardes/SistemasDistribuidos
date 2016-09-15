package echoserver;
import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer 
{ 
	public static Locale local = new Locale("pt","BR");
	public static GregorianCalendar calendario = new GregorianCalendar();
	
	
	

	public static void main(String[] args ) 
	{ 
		try 
		{ 
			@SuppressWarnings("resource")
			ServerSocket s = new ServerSocket(8189);
			Socket incoming = s.accept();
			try 
			{ 
				InputStream inStream = incoming.getInputStream(); 
				OutputStream outStream = incoming.getOutputStream(); 
				
				@SuppressWarnings("resource")
				Scanner in = new Scanner(inStream); 
				PrintWriter out = new PrintWriter(outStream, true /* autoFlush */); 
				out.println( "Hello! Enter BYE to exit." ); 
                                out.println( "encriptar para mandar mesnsagem" ); 
                                out.println( "hora para saber a hora" ); 
                                out.println( "so para sistema operacional" ); 
                                out.println( "disk para saber o tamanho e utilizado em disco" ); 


				
				// echo client input 
				boolean done = false;
				
				while (!done && in.hasNextLine()) 
				{ 
					String line = in.nextLine(); 
					//out.println("Echo: " + line);
				
					if(line.trim().equals("hora"))
					{
						getHoras(out);
						
					}
					if(line.trim().equals("so"))
					{
						getSO(out);
					}
					if(line.trim().equals("disk"))
					{
						getFreeDisk(out);
					}
					if(line.trim().equals("encriptar"))
					{
						out.println("Digite o que quer encriptar\n");
						line = in.nextLine();
						getEncriptar(out, line);
					}
					if (line.trim().equals("BYE")) 
					done = true; 
				} 
		}
			
		finally 
		{ 
			incoming.close(); 
		} 
		}
		
		catch (IOException e) 
		{ 
			e.printStackTrace(); 
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
		long total = (long) (arquivo.getTotalSpace()/1000000.00);
		StringBuilder x = new StringBuilder();
		
		x.append(total);
		Encripter texto = new Encripter(x.toString());
		out.println("Disponível: "+texto.encriptar()+"MB");
		
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
		
		concat.append( hora.get( GregorianCalendar.HOUR_OF_DAY ) );
		concat.append( ":" );
		concat.append( hora.get( GregorianCalendar.MINUTE ) );
		Encripter texto = new Encripter(concat.toString());
		out.println(texto.encriptar());
	} 
} 