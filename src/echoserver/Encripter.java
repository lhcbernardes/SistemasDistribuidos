package echoserver;
public class Encripter 
{
	private String texto;
	private String cifra;
	private int chave = 3;
	
	public Encripter(String texto) 
	{
		setTexto(texto);
	}
   
	public String encriptar()
	{
	      
	      StringBuilder textoCifrado = new StringBuilder();
	      int tamanhoTexto = getTexto().length();
	      int letraCifradaASCII;
	      
	      for(int c=0; c < tamanhoTexto; c++)
	      {
	          letraCifradaASCII = ((int) texto.charAt(c)) + getChave();
	         
	         while(letraCifradaASCII > 126)
	         {
	        	 letraCifradaASCII -= 94;
	         }
	  
	         textoCifrado.append( (char)letraCifradaASCII );
	      }
	      
	      setCifra(textoCifrado.toString());
	      return getCifra().toString();
	      
	}
	
	private String privateEncriptar(int chave) 
	{
		this.chave = chave;
		return encriptar().toString();
	}

	public String descriptar() 
	{
		return privateEncriptar(this.chave*-3);
		
	}
	
	private void setTexto(String texto) 
	{
		this.texto = texto;
	}
	
	private int getChave() 
	{
		return this.chave;
	}
	
	private String getTexto()
	{
		return this.texto;
	}

	private String getCifra() 
	{
		return cifra;
	}

	private void setCifra(String cifra) 
	{
		this.cifra = cifra;
	}
	
}