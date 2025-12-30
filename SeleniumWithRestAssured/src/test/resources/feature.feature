Feature: this is a demo feature

  Scenario: load the url
    Given  URL is set
    When  driver is initialized
    Then  i am "relieved"

  @smoke
  Scenario: read the data table as key
    Given data as maps
    | name | pass |
    | aditya | 123 |
    | anshul | 234 |

    And  data as map
    | paramType | queryParam |
    | url | www.anything.com |
    | path | /v1/api |

    And  data as list
    | red |
    | green |
    | yellow |

