import java.util.Scanner;


public class JCriptoCesar {
   
   /**
    * Metodo que criptografa um texto,
    * utilizando a famosa cifra de Cesar.
    */
   public static String encriptar(int chave, String texto){
      // Variavel que ira guardar o texto crifrado
      StringBuilder textoCifrado = new StringBuilder();
      // Variavel com tamanho do texto a ser encriptado
      int tamanhoTexto = texto.length();
      
      // Criptografa cada caracter por vez 
      for(int c=0; c < tamanhoTexto; c++){
         // Transforma o caracter em codigo ASCII e faz a criptografia
         int letraCifradaASCII = ((int) texto.charAt(c)) + chave;
         
         // Verifica se o codigo ASCII esta no limite dos caracteres imprimiveis
         while(letraCifradaASCII > 126)
            letraCifradaASCII -= 94;

         // Transforma codigo ASCII criptografado em caracter ao novo texto
         textoCifrado.append( (char)letraCifradaASCII );
      }
      
      // Por fim retorna a mensagem criptografada por completo
      return textoCifrado.toString();
   }
   
   /**
    * Metodo que descriptografa um texto,
    * utilizando a famosa cifra Cesar.
    */
   public static String decriptar(int chave, String textoCifrado){
      // Variavel que ira guardar o texto decifrado
      StringBuilder texto = new StringBuilder();
      // Variavel com tamanho do texto a ser decriptado
      int tamanhoTexto = textoCifrado.length();
      
      // Descriptografa cada caracter por vez
      for(int c=0; c < tamanhoTexto; c++){
         // Transforma o caracter em codigo ASCII e faz a descriptografia
         int letraDecifradaASCII = ((int) textoCifrado.charAt(c)) - chave;
         
         // Verifica se o codigo ASCII esta no limite dos caracteres imprimiveis
         while(letraDecifradaASCII < 32)
            letraDecifradaASCII += 94;

         // Transforma codigo ASCII descriptografado em caracter ao novo texto
         texto.append( (char)letraDecifradaASCII );
      }
      
      // Por fim retorna a mensagem descriptografada por completo
      return texto.toString();
   }

   
   public static void main(String[] args){
      
      try {
         Scanner entrada = new Scanner(System.in);
      
         System.out.println("*****************************************************");
         
         // Informa texto e chave de criptografia
         System.out.print("Informe o texto a ser criptografado: ");
         String texto = entrada.nextLine();
         System.out.print("Informe a chave de deslocamento: ");
         int chave = entrada.nextInt();
         
         // Criptografando
         String textoCriptografado = encriptar(chave, texto);
         // Descriptografando
         String textoDescriptografado = decriptar(chave, textoCriptografado);
         
         // Imprimindo no CONSOLE os resultados 
         System.out.println("\n\nTEXTO CRIPTOGRAFADO: " + textoCriptografado);
         System.out.println("TEXTO DESCRIPTOGRAFADO: " + textoDescriptografado);
         
         System.out.println("*****************************************************");
         
      } catch (RuntimeException e) { // Trata erro de digitacao
         System.out.println("A chave de deslocamento foi informada incorretamente.");
         System.out.println("Execute o programa novamente e entre com uma chave valida.");
      }
      
   }
}