package kata.IsSatorSquare;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

public class IsSatorSquareTest {

  IsSatorSquare isSatorSquare = new IsSatorSquare();

  char[][][] passTablets = {
      new char[][]
          {
              {'T', 'E', 'N'},
              {'E', 'Y', 'E'},
              {'N', 'E', 'T'}
          },
      new char[][]
          {
              {'R', 'O', 'T', 'O', 'R'},
              {'O', 'T', 'O', 'R', 'O'},
              {'T', 'O', 'R', 'O', 'T'},
              {'O', 'R', 'O', 'T', 'O'},
              {'R', 'O', 'T', 'O', 'R'}
          }
  };

  char[][][] errorTablets = {
      new char[][]
          {
              {'R', 'O', 'T', 'O', 'R'},
              {'O', 'T', 'O', 'R', 'O'},
              {'T', 'O', 'R', 'O', 'T'},
              {'O', 'R', 'O', 'T', 'O'},
              {'X', 'O', 'T', 'O', 'R'}
          },
      new char[][]
          {
              {'N', 'O', 'T'},
              {'O', 'V', 'O'},
              {'N', 'O', 'T'}
          },

  };

  @Test
  void test_is_sator_square() {
    AtomicInteger index = new AtomicInteger();
    for (char[][] sampleTablet : passTablets) {
      index.getAndIncrement();
      System.out.println("Test " + index);
      boolean actual = isSatorSquare.isSatorSquare(sampleTablet);
      assertThat(actual).isTrue();
    }
  }

  @Test
  void test_is_not_sator_square() {
    AtomicInteger index = new AtomicInteger();
    for (char[][] sampleTablet : errorTablets) {
      index.getAndIncrement();
      System.out.println("Test " + index);
      boolean actual = isSatorSquare.isSatorSquare(sampleTablet);
      assertThat(actual).isFalse();
    }
  }

}
