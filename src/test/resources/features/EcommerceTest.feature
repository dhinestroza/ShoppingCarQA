@qa
Feature:test case ecommerceS
  Scenario Outline: the user practice qa
    Given navigate
    And see the article
    When the article opens add it to the shopping cart
    And see shopping cart
    But complete the form personal information <firstName>,<lastName> and <email>
    And complete the form Address <addresses>, <addressComple>, <city> and <post>
    And complete the form shipping
    And complete the form pay
    Then make the payment

    Examples:
      | firstName | lastName | email                | addresses | addressComple | city      | post  |
      | Daniel    | Eiffel   | Deiffeel03@gmail.com | 625C ST   | AK99501       | Anchorage | 99950 |
