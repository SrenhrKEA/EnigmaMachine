import java.util.Scanner;

public class CipherCeasar {
  //Global variables
  //private char[] chrArray; // Char-array
  final int ALPHABET_LENGTH = 29; // length of the danish alphabet
  final int DIFF_CHAR_INT = 64; // difference between ASCII value of char's in Char-array and assigned integer value in Int-array.
  //private String ciphertext; //encrypted text output
  //private String plaintext; // text input
  Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    new CipherCeasar().cipherCeasar();
  }

  public void cipherCeasar() {
    //Programmet har ingen velkomstbesked, da dette blot er et modul i et større program.
    String plaintext = userInputText();
    String ciphertext = ccEncrypt(ccShiftKey(userInputKey(),ccConvert(plaintext)));
    System.out.printf("\nOriginal tekst: %s", plaintext);
    System.out.printf("\nKrypteret/dekrypteret tekst: %s", ciphertext);
  }

  //Text input
  public String userInputText() {
    System.out.print("\nSkriv den tekst der skal encrypteres: ");
    return in.nextLine();
  }

  //Shift input
  public int userInputKey() {
    System.out.print("\nIndtast i heltal hvor mange bogstaver din besked skal rykkes (+/-): ");
    String shiftStr = in.nextLine(); // shift string input
    int shiftInt = 0; // shift value converted from string to integer.
    try { //Tester om input er en integer.
      shiftInt = Integer.parseInt(shiftStr);
      System.out.println("Du har indtastet: " + shiftStr);
    } catch (NumberFormatException e) {
      System.out.printf("\n\"%s\" er ikke et heltal, prøv igen.", shiftStr);
      userInputKey();
    }
    if (Math.abs(shiftInt) > ALPHABET_LENGTH) { // Fejlsikring. Et bogstav kan ikke rykkes mere end antallet af bogstaver i alfabetet.
      userInputKey();
    }
    return shiftInt;
  }

  //Conversion
  public int[] ccConvert(String plaintext) {
    char[] chrArray = new char[plaintext.length()]; // Char-array the length of text string input.
    int[] intArray = new int[plaintext.length()]; // Int-array the length of text string input.

    for (int i = 0; i < plaintext.length(); i++) {
      chrArray[i] = Character.toUpperCase(plaintext.charAt(i)); // Den indtastede string bliver lavet til stor skrift og lavet om til et Char-array.
      intArray[i] = (int) chrArray[i] - DIFF_CHAR_INT; // Bogstaver i Char-arrayed bliver lavet om til Int-array med tal i intervallet 1-29 afhængigt af deres ASCII værdi og mellemrum til 0.
      switch (chrArray[i]) {
        case ' ' -> intArray[i] = 0; // mellemrum tildelt nummer 0
        case 'Æ' -> intArray[i] = 27; // nummer 27 i det danske alfabet
        case 'Ø' -> intArray[i] = 28; // nummer 28 i det danske alfabet
        case 'Å' -> intArray[i] = 29; // nummer 29 i det danske alfabet
      }
      if (intArray[i] < 0 || intArray[i] > ALPHABET_LENGTH) { //Der tages kun imod bogstaver og mellemrum. Alle andre symboler laves til mellemrum.
        intArray[i] = 0;
      }
    }
    return intArray;
  }

  //Shift
  public int[] ccShiftKey(int shiftInt, int[] intArray) {
    for (int i = 0; i < intArray.length; i++) {
      intArray[i] = intArray[i] + shiftInt; // Tal i Int-arrayed rykkes afhængigt af input (+/-).
    }
    return intArray;
  }

  //Encryption
  public String ccEncrypt(int[] intArray) {
    char[] chrArray = new char[intArray.length];
    // Tal i Int-arrayed bliver lavet om til bogstaver i et Char-array afhængigt af deres nye ASCII værdi.
    for (int i = 0; i < intArray.length; i++) {
      // "loop", således at den rykkede tekst kun kan bestå af danske bogstaver eller mellemrum.
      int maxShift = 30; //Maximum shift value (danish alphabet length + 1 (space))
      if (intArray[i] < 0) {
        intArray[i] = intArray[i] + maxShift;
      } else if (intArray[i] > ALPHABET_LENGTH) {
        intArray[i] = intArray[i] - maxShift;
      }
      switch (intArray[i]) {
        case 0 -> chrArray[i] = ' ';
        case 27 -> chrArray[i] = 'Æ';
        case 28 -> chrArray[i] = 'Ø';
        case 29 -> chrArray[i] = 'Å';
        default -> chrArray[i] = (char) (intArray[i] + DIFF_CHAR_INT);
      }
    }
    return String.valueOf(chrArray);
  }
}

