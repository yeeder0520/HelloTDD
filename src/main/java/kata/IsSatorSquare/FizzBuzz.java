package kata.IsSatorSquare;

public class FizzBuzz {

  /**
   * version 1
   */
//  public String execute(int i) {
//    return String.valueOf(1);
//  }

  /**
   * version 2
   */
//  public String execute(int i) {
//    StringBuilder result = new StringBuilder();
//    for (int j = 1; j <= i; j++) {
//      if (j == 3) {
//        result.append("Fizz");
//      } else {
//        result.append(j);
//      }
//      if (j != i) {
//        result.append(",");
//      }
//    }
//    return result.toString();
//  }

  /**
   * version 3
   */
//  public String execute(int i) {
//    StringBuilder result = new StringBuilder();
//    for (int j = 1; j <= i; j++) {
//      if (j == 3) {
//        result.append("Fizz");
//      } else if (j == 5) {
//        result.append("Buzz");
//      } else {
//        result.append(j);
//      }
//      if (j != i) {
//        result.append(",");
//      }
//    }
//    return result.toString();
//  }

  /**
   * version 4
   */
//  public String execute(int i) {
//    StringBuilder result = new StringBuilder();
//    for (int j = 1; j <= i; j++) {
//      if (j % 3 == 0 && j % 5 == 0) {
//        result.append("FizzBuzz");
//      } else if (j % 3 == 0) {
//        result.append("Fizz");
//      } else if (j % 5 == 0) {
//        result.append("Buzz");
//      } else {
//        result.append(j);
//      }
//
//      if (j != i) {
//        result.append(",");
//      }
//    }
//    return result.toString();
//  }

  /**
   * version 5
   */
  public String execute(int inputNumber) {

    StringBuilder result = new StringBuilder();

    for (int j = 1; j <= inputNumber; j++) {

      if (isThreeAndFiveMultiple(j)) {
        result.append("FizzBuzz");
      } else {
        result.append(j);
      }

      if (isThreeMultiple(j)) {
        result.append("Fizz");
      }

      if (isFiveMultiple(j)) {
        result.append("Buzz");
      }

      if (isNotLastNumber(inputNumber, j)) {
        result.append(",");
      }
    }
    return result.toString();
  }

  private boolean isNotLastNumber(int i, int j) {
    return j != i;
  }

  private boolean isFiveMultiple(int j) {
    return j % 5 == 0;
  }

  private boolean isThreeMultiple(int j) {
    return j % 3 == 0;
  }

  private boolean isThreeAndFiveMultiple(int j) {
    return j % 3 == 0 && j % 5 == 0;
  }
}
