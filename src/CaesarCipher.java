import java.io.PrintWriter;

public class CaesarCipher {

    // lowercase letters' values start at index 97 for 'a'
    public static int base = 97; 
    
    public static void main (String[] args) throws Exception {
        
        // pen that writes to stdout
        PrintWriter stdOutPen = new PrintWriter(System.out, true);

        //pen that writes to stderr
        PrintWriter stdErrPen = new PrintWriter(System.err, true);

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
        
        // if first parameter is "encode", encrypt string; otherwise, decrypt string
        if(args[0].equals("encode")){
            // prints all 26 possible encryption shifts
            for(int i = 0; i < 26; i++){
                stdOutPen.print("n = " + i + ": "); 
                stdOutPen.println(encryptString(args[1], i));
            } // for
        } // if 
        else {
            // prints all 26 possible decryption shifts
            for(int i = 0; i < 26; i++){
                stdOutPen.print("n = " + i + ": "); 
                stdOutPen.println(decryptString(args[1], i));
            } // for
        } // if

    } // main


    /**
     * Returns the result of encoding char ch by a given key.
     * 
     * @param ch - Lowercase char
     * @param key - integer
     * @return - Encoded character
     */
    public static char encryptChar (char ch, int key) {
        
        // "re-base" at 0 by subtracting value of 'a'
        int charValue = (int) ch - base;
        // shift char and wrap around to front if needed
        int result = (charValue + key) % 26;
        // return encrypted character
        return (char) (result + base);
        
    } // encryptChar (char, int)

     /**
     * Returns the result of decoding char ch by a given key.
     * 
     * @param ch - Lowercase char
     * @param key - integer
     * @return - Decoded character
     */   
    public static char decryptChar (char ch, int key) {

        // "re-base" at 0 by subtracting value of 'a'
        int charValue = (int) ch - base;
        // shift char and wrap around to end if needed
        int result = (charValue - key) % 26 + 26;
        // return decrypted character
        return (char) (result % 26 + base); 
        
    } // decryptChar (char, int)

     /**
     * Returns the result of encoding a String by a given key.
     * 
     * @param word - Lowercase string
     * @param key - integer
     * @return - Encoded string
     */      
    public static String encryptString (String word, int key) {

        char[] wordArray = word.toCharArray();

        // encrypt every letter in the string
        for(int i = 0; i < wordArray.length; i++){
            wordArray[i] = encryptChar(wordArray[i], key);
        } // for

        return new String (wordArray);

    } // encryptString (String, int)

     /**
     * Returns the result of decoding a String by a given key.
     * 
     * @param word - Lowercase string
     * @param key - integer
     * @return - Decoded string
     */  
    public static String decryptString (String word, int key) {

        char[] wordArray = word.toCharArray();

        // decrypt every letter in the string
        for(int i = 0; i < wordArray.length; i++){
            wordArray[i] = decryptChar(wordArray[i], key);
        } // for

        return new String(wordArray);

    } // decryptString (String, int)

} // class CaesarCipher 
