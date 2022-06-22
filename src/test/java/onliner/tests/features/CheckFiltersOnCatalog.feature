Feature: Check filters in Catalog

  Background:
    Given Onliner Main page is opened
    When I will go to the Catalog menu point
      And Catalog page is opened
    And I navigate to TV page through menu

  Scenario Outline: Check filters in TV page
    Given TV page is opened
    When I select '<manufacturer>' in the Manufacturer section
      And I enter '<maxPrice>' in the max price field
      And I select '<minDiagonal>' and '<maxDiagonal>' in the Diagonal section
      And I select '<resolution>' in the Resolution section
    Then Required products are displayed according to the filter parameters '<manufacturer>', '<maxPrice>', '<minDiagonal>', '<maxDiagonal>', '<resolution>'

    Examples:
      | manufacturer | maxPrice | minDiagonal | maxDiagonal |      resolution     |
      |   Samsung    |   1500   |      40     |     50      | 1920x1080 (Full HD) |
      |     LG       |   1500   |      40     |     50      | 1920x1080 (Full HD) |
      |   Thomson    |   1000   |      32     |     55      |    1366x768 (HD)    |

