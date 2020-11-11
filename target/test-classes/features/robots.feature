Feature: Martian Robots

  Scenario: One Robot Inside Grid Next Robot Lost And Next Robot Prevented From Getting Lost
    Given the following instructions
      """
      5 3
      1 1 E
      RFRFRFRF
      3 2 N
      FRRFLLFFRRFLL
      0 3 W
      LLFFFLFLFL
      """
    When instructions are executed
    Then status for each robot should be:
      | Index | Status     |
      | 0     | 1 1 E      |
      | 1     | 3 3 N LOST |
      | 2     | 2 3 S      |
