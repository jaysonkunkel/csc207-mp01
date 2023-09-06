import java.io.PrintWriter;

public class VigenereCipher {
  
  public static int base = 97;

  public static void main (String[] args) throws Exception {

    // pen that writes to stdout
    PrintWriter stdOutPen = new PrintWriter(System.out, true);
    //pen that writes to stderr
    PrintWriter stdErrPen = new PrintWriter(System.err, true);

    // if there are not exactly 3 arguments, the input is invalid
    if(args.length != 3) {
      stdErrPen.println("Incorrect number of parameters");
      System.exit(2);
    } //if

    // if first parameter is neither "encode" nor "decode", the input is invalid       
    if (!(args[0].equals("encode") || args[0].equals("decode"))) {      
      stdErrPen.println("Valid options are \"encode\" or \"decode\"");
      System.exit(1);
    } // if
    
  }

}
