package ru.mirea;

import java.util.Stack;
import java.util.Scanner;
import java.util.Collections;

public class StackTest {
  private static final int AMOUNT_OF_CARDS = 5;
  private static final Scanner IN = new Scanner(System.in);

  private static void reverse(Stack<Integer> s1, Stack<Integer> s2) {
    Collections.reverse(s1);
    Collections.reverse(s2);
  }

  public static void main(String[] args) {
    var firstPlayerCards = new Stack<Integer>();
    var secondPlayerCards = new Stack<Integer>();

    System.out.print("Введите карты 1-го игрока: ");
    for (int i = 0; i < AMOUNT_OF_CARDS; ++i) {
      firstPlayerCards.push(IN.nextInt());
    }

    System.out.print("Введите карты 2-го игрока: ");
    for (int i = 0; i < AMOUNT_OF_CARDS; ++i) {
      secondPlayerCards.push(IN.nextInt());
    }

    int steps = 0;

    while (true) {
      if (steps >= 106) {
        System.out.println();
        System.out.println("botva");
        return;
      }

      reverse(firstPlayerCards, secondPlayerCards);

      if (firstPlayerCards.isEmpty())
        break;

      int firstPlayerCard = firstPlayerCards.pop();

      if (secondPlayerCards.isEmpty())
        break;

      int secondPlayerCard = secondPlayerCards.pop();

      reverse(firstPlayerCards, secondPlayerCards);
      if (firstPlayerCard < secondPlayerCard) {
        if (firstPlayerCard == 0 && secondPlayerCard == 9) {   // младшая карта побеждает старшую
          firstPlayerCards.push(firstPlayerCard);
          firstPlayerCards.push(secondPlayerCard);
        }
        else {
          secondPlayerCards.push(firstPlayerCard);
          secondPlayerCards.push(secondPlayerCard);
        }
      }
      else {
        if (firstPlayerCard == 9 && secondPlayerCard == 0) {    // младшая карта побеждает старшую
          secondPlayerCards.push(firstPlayerCard);
          secondPlayerCards.push(secondPlayerCard);
        }
        else {
          firstPlayerCards.push(firstPlayerCard);
          firstPlayerCards.push(secondPlayerCard);
        }
      }

      ++steps;
    }

    String winner = (firstPlayerCards.isEmpty()) ? "second" : "first";

    System.out.println();
    System.out.println(winner + " " + steps);
  }
}
