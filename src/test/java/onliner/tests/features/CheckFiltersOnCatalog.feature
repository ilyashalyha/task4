Feature: Check filters in Catalog

  Background:
    Given Onliner Main page is opened
    When I will go to the Catalog menu point
      And Catalog page is opened
    And I navigate to TV page through menu
      And TV page is opened

  Scenario Outline: Check filters in TV page
    Given TV page is opened
    When I select <manufacturer> in the Manufacturer section
      And I enter <maxPrice> in the max price field
      And I select <minDiagonal> and <maxDiagonal> in the Diagonal section
      And I select <resolution> in the Resolution section
    Then Required products are displayed according to the filter parameters

    Examples:
      | manufacturer | maxPrice | minDiagonal | maxDiagonal |      resolution     |
      |  "Samsung"   |  "1500"  |    "40"     |   "50"      |"1920x1080 (Full HD)"|



