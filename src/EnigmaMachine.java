import java.util.Scanner;

import static java.lang.System.exit;

public class EnigmaMachine {
  //global variables
  boolean encrypt; // ikke implementeret endnu
  boolean decrypt; // ikke implementeret endnu
  final CipherCeasar cc = new CipherCeasar();
  Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    new EnigmaMachine().enigmaMachine();
  }

  void enigmaMachine() {
    menuWelcome();
    //menuEncryptionOrDecryption();
    menuCipherTypes();
  }

  void menuWelcome() {
    System.out.println("Velkommen til Enigma Maskinen!");
    System.out.println();
    System.out.println("1. \tSTART\tProgram");
    System.out.println("2. \tEXIT\tProgram");

    String encryptionOrDecryption = in.nextLine();
    switch (encryptionOrDecryption) {
      case "1", "Start", "start", "START" -> {
      }
      case "2", "Exit", "exit", "EXIT" -> exit(0);
      default -> {
        System.out.println("Du har ikke valgt hvorvidt du vil starte eller forlade programmet, prøv igen.");
        menuWelcome();
      }
    }
  }

  void menuEncryptionOrDecryption() {
    System.out.println("Vælg hvorvidt din besked skal:");
    System.out.println("1. Krypteres");
    System.out.println("2. Dekrypteres");

    String encryptionOrDecryption = in.nextLine();
    switch (encryptionOrDecryption) {
      case "1", "Krypteres", "krypteres" -> {
        System.out.println("Du har valgt at kryptere din besked.");
        encrypt = true;
        decrypt = false;
      }
      case "2", "Dekrypteres", "dekrypteres" -> {
        System.out.println("Du har valgt at dekryptere din besked.");
        encrypt = false;
        decrypt = true;
      }
      default -> {
        System.out.println("Du har ikke valgt hvorvidt du vil kryptere eller dekryptere, prøv igen.");
        menuEncryptionOrDecryption();
      }
    }
  }

  void menuCipherTypes() {
    System.out.println("Vælg hvilken type krypteringsalgoritme (chiffer) du vil bruge:");
    System.out.println("1. Cæsars");
    /*
    System.out.println("2. Vigenères");
    System.out.println("3. Number");
    System.out.println("4. Substitution");

     */

    String encryptionType = in.nextLine();
    switch (encryptionType) {
      case "1", "Cæsars", "cæsars" -> {
        System.out.println("Du har valgt Cæsaralgoritmen.");
        cc.ccInfo();
        cc.cipherCeasar();
      }
      /*
      case "2", "Vigenères", "vigenères", "Vigeneres", "vigeneres" -> System.out.println("Du har valgt Vigenères chiffer.");
      case "3", "Number", "number" -> System.out.println("You have chosen Number cipher");
      case "4", "Substitution", "substitution" -> System.out.println("You have choosen Substitution cipher");

       */
      default -> {
        System.out.println("Du har ikke valgt en chiffer, prøv igen.");
        menuCipherTypes();
      }
    }
  }

  String userInputPlaintext() {
    System.out.print("\nIndtast beskeden der skal krypteres/dekrypteres: ");
    return in.nextLine();
  }

  String userInputKey() {
    System.out.print("\nIndtast en nøgle: ");
    return in.nextLine();
  }

  void displayCiphertext(String plaintext, String ciphertext) {
    System.out.printf("\nOriginal tekst: %s", plaintext);
    System.out.printf("\nKrypteret/dekrypteret tekst: %s", ciphertext);
    enigmaMachine();
  }
}
