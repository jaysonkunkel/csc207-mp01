import java.io.PrintWriter;

public class CaesarCipher {

    public static int base = 97;
    
    public static void main (String[] args) throws Exception {
        
        PrintWriter stdOutPen = new PrintWriter(System.out, true);
        PrintWriter stdErrPen = new PrintWriter(System.err, true);

        if(args.length != 2) {
            
            stdErrPen.println("Incorrect number of parameters");
            System.exit(2);
            
        } //if

        if (!(args[0].equals("encode") || args[0].equals("decode"))) {
                    
            stdErrPen.println("Valid options are \"encode\" or \"decode\"");
            System.exit(1);
            
        } // if
                
        String instruction = args[0];
        String word = args[1];
        //word = word.toCharArray();

        stdOutPen.println(encrypt('c', 9));
        
    } // main

    public static int encrypt (char ch, int key) {
        
        int charValue = (int) ch - base;
        System.out.println(charValue);
        int result = (charValue + key) % 26;
        return result;
        
    } // encrypt

    public static char decrypt (char ch, int key) {

        int charValue = (int) ch - base;
        int result = (charValue + key) % 26 + charValue; // correct?
        return (char) (result); 
        
    } // decrypt

} // CaesarCipher 
