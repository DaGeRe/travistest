package de.travistest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMe {
   
   @Test
   public void testFileCreation() throws InterruptedException, IOException {
      final File file = new File("target/temp.txt");
      final int number = new Random().nextInt();
      System.out.println("Writing " + number);
      try (FileWriter writer = new FileWriter(file)){
         writer.write(String.valueOf(number));
      }
      Thread.sleep(5000);
      try (Scanner scanner = new Scanner(file)){
         final int number2 = scanner.nextInt();
         System.out.println("Read " + number2);
         Assertions.assertEquals(number, number2);
      }
   }
}
