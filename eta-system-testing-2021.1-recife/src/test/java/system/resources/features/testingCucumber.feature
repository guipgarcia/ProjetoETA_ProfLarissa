#language: en

  Feature: Cucumber First Contact

    @TableSortScenarios
    Scenario Outline: Change name position in Table Sort & Search
      Given that I access demo selenium easy application
      When I select the "<menu>" and "<submenu>"
      And I change name position
      Then The "<name>" position was changed

      Examples:
      |menu|  submenu           |name    |
      |Table|Table Sort & Search|Y. Berry|