package kata.IsSatorSquare;

import java.util.HashSet;
import java.util.Set;

public class IsSatorSquare {

  public static Boolean isSatorSquare(char[][] tablet) {

    Set<String> rowSet = new HashSet<>();
    Set<String> rowReverseSet = new HashSet<>();
    Set<String> upToDownSet = new HashSet<>();
    Set<String> downToUpSet = new HashSet<>();

    handleRowChar(tablet, rowSet, rowReverseSet);
    handleColumnChar(tablet, upToDownSet, downToUpSet);

    return rowSet.containsAll(rowReverseSet) && rowSet.containsAll(downToUpSet) && rowSet.containsAll(upToDownSet);
  }

  private static void handleColumnChar(char[][] tablet, Set<String> upToDownSet, Set<String> downToUpSet) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < tablet.length; i++) {
      for (char[] chars : tablet) {
        stringBuilder.append(chars[i]);
      }
      upToDownSet.add(stringBuilder.toString());
      downToUpSet.add(stringBuilder.reverse()
                          .toString());
      stringBuilder.setLength(0);
    }
  }

  private static void handleRowChar(char[][] tablet, Set<String> rowSet, Set<String> rowReverseSet) {
    StringBuilder stringBuilder = new StringBuilder();
    for (char[] chars : tablet) {
      for (char aChar : chars) {
        stringBuilder.append(aChar);
      }
      rowSet.add(stringBuilder.toString());
      rowReverseSet.add(stringBuilder.reverse()
                            .toString());
      stringBuilder.setLength(0);
    }
  }

}
