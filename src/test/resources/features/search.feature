Feature: Google search

  @google
  Scenario Outline: I want to search on google site
    Given I am on the google site
    When I enter "<keyword>" as a keyword
    Then I should see search results page
    And I should see at least <count> results

    @dev
    Examples:
      | keyword  | count |
      | selenium | 2     |

    @stage
    Examples:
      | keyword  | count |
      | java     | 5     |
      | spring   | 7     |