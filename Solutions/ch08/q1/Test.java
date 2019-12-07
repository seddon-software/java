

//File Copy



package ch08.q1;
import java.io.*;


public class Test
{
  public static void main(String[] args) {
    try {
      String inFile = "ch08/q1/Test.txt";
      String outFile = "ch08/q1/Copy.txt";

      FileInputStream  in  = new FileInputStream(inFile);
      FileOutputStream out = new FileOutputStream(outFile);
      byte[] buffer = new byte[256];
      int bytesRead;

      while(true) {
        bytesRead = in.read(buffer);
        if(bytesRead == -1) break;
        out.write(buffer, 0, bytesRead);
      }

    } catch(FileNotFoundException e) {
      System.out.println("Can't open file: " + e.getMessage());
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("No command line parameters specified");
    } catch(IOException e) {
      System.out.println("General I/O exception: " + e.getMessage());
    }}
}
