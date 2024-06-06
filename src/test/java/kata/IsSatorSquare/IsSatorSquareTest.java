package kata.IsSatorSquare;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

public class IsSatorSquareTest {

  IsSatorSquare isSatorSquare = new IsSatorSquare();

  char[][][] sampleTablets = {
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
          },
      new char[][]
          {
              {'N', 'O', 'T'},
              {'O', 'V', 'O'},
              {'N', 'O', 'T'}
          },
      new char[][]
          {
              {'S', 'A', 'T', 'O', 'R'},
              {'A', 'R', 'E', 'P', 'O'},
              {'T', 'E', 'N', 'E', 'T'},
              {'O', 'P', 'E', 'R', 'A'},
              {'X', 'X', 'X', 'X', 'X'}
          }
  };

  @Test
  void test_is_sator_square() {
    AtomicInteger index = new AtomicInteger();
    for (char[][] sampleTablet : sampleTablets) {
      index.getAndIncrement();
      System.out.println("Test " + index);
      boolean actual = isSatorSquare.isSatorSquare(sampleTablet);
      assertThat(actual).isTrue();
    }

  }

}
