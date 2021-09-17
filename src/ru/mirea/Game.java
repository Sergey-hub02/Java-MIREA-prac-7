package ru.mirea;

import java.util.Scanner;
import java.util.ArrayDeque;

public class Game {
  private static final int AMOUNT_OF_CARDS = 5;
  private static final Scanner IN = new Scanner(System.in);

  public static void main(String[] args) {
    var firstPlayerCards = new ArrayDeque<Integer>();
    var secondPlayerCards = new ArrayDeque<Integer>();

    System.out.print("Введите карты 1-го игрока: ");
    for (int i = 0; i < AMOUNT_OF_CARDS; ++i) {
      firstPlayerCards.add(IN.nextInt());
    }

    System.out.print("Введите карты 2-го игрока: ");
    for (int i = 0; i < AMOUNT_OF_CARDS; ++i) {
      secondPlayerCards.add(IN.nextInt());
    }

    int steps = 0;

    while (true) {
      if (steps >= 106) {
        System.out.println();
        System.out.println("botva");
        return;
      }

      if (firstPlayerCards.isEmpty())
        break;

      int firstPlayerCard = firstPlayerCards.poll();

      if (secondPlayerCards.isEmpty())
        break;

      int secondPlayerCard = secondPlayerCards.poll();

      if (firstPlayerCard < secondPlayerCard) {
        if (firstPlayerCard == 0 && secondPlayerCard == 9) {   // младшая карта побеждает старшую
          firstPlayerCards.add(firstPlayerCard);
          firstPlayerCards.add(secondPlayerCard);
        }
        else {
          secondPlayerCards.add(firstPlayerCard);
          secondPlayerCards.add(secondPlayerCard);
        }
      }
      else {
        if (firstPlayerCard == 9 && secondPlayerCard == 0) {    // младшая карта побеждает старшую
          secondPlayerCards.add(firstPlayerCard);
          secondPlayerCards.add(secondPlayerCard);
        }
        else {
          firstPlayerCards.add(firstPlayerCard);
          firstPlayerCards.add(secondPlayerCard);
        }
      }

      ++steps;
    }

    String winner = (firstPlayerCards.isEmpty()) ? "second" : "first";

    System.out.println();
    System.out.println(winner + " " + steps);
  }
}
