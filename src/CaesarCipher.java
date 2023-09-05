import java.io.PrintWriter;

public class CaesarCipher {

    public static int base = 97; // lowercase letters' values start at index 97 for 'a'
    
    public static void main (String[] args) throws Exception {
        
        PrintWriter stdOutPen = new PrintWriter(System.out, true); // writes to stdout
        PrintWriter stdErrPen = new PrintWriter(System.err, true); // writes to stderr

        // if there are not exactly 2 arguments, the input is invalid
        if(args.length != 2) {
            
            stdErrPen.println("Incorrect number of parameters");
            System.exit(2);
            
        } //if

        // if first parameter is neither "encode" nor "decode", the input is invalid       
        if (!(args[0].equals("encode") || args[0].equals("decode"))) {
                    
            stdErrPen.println("Valid options are \"encode\" or \"decode\"");
            System.exit(1);
            
        } // if
                
        String instruction = args[0];
        String word = args[1];
        //word = word.toCharArray();

        //stdOutPen.println(encrypt('c', 9));
        //stdOutPen.println(encrypt('c', 10));
        // for(int i = 0; i < 26; i ++) {
        //     char result = decrypt('i', i);
        //     //stdOutPen.println(decrypt('a', i));
        //     stdOutPen.println(result);
        // }
    
        //stdOutPen.println((char) 97);
        //stdOutPen.println((int) 'a');
        for(int i = 0; i < 26; i++){
            stdOutPen.print("n = " + i + ": "); 
            stdOutPen.println(new String (encryptString("helloworld", i)));
        }

        for(int i = 0; i < 26; i++){
            stdOutPen.print("n = " + i + ": "); 
            stdOutPen.println(new String (decryptString("dahhksknhz", i)));
        }

    } // main


    /**
     * Returns the result of encoding char ch by a given key.
     * @param ch
     * @param key
     * @return 
     * 
     * 
     */
    public static char encrypt (char ch, int key) {
        
        int charValue = (int) ch - base;
        int result = (charValue + key) % 26;
        return (char) (result + 97);
        
    } // encrypt (char, int)

    public static char decrypt (char ch, int key) {

        int charValue = (int) ch - base;
        int result = (charValue - key) % 26 + 26;
        return (char) (result % 26 + 97); 
        
    } // decrypt (char, int)

    public static char[] encryptString (String word, int key) {

        char[] wordArray = word.toCharArray();

        for(int i = 0; i < wordArray.length; i++){

            wordArray[i] = encrypt(wordArray[i], key);
        }

        return wordArray;
    } // encryptString (String, int)


    public static char[] decryptString (String word, int key) {

        char[] wordArray = word.toCharArray();

        for(int i = 0; i < wordArray.length; i++){

            wordArray[i] = decrypt(wordArray[i], key);
        }

        return wordArray;
    } // decryptString (String, int)


} // CaesarCipher 
