Feature: Ebay_Search

Scenario: Ebay Search

  Given User goes to BestBuy home page
  Then User verify that home page is present
  Then User open login page and register with a user
  And  User type samsung in the Search box click the Search button
  And  User click page two, and confirm that page two is displayed
  Then User Click favorites button third product from the top
  And  User Click my favorites button
  Then User will confirm that there is the product that was tracked on the previous page
  And  User press Remove button
  And  User will confirm that product is no longer in the favorites.