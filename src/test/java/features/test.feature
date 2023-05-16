Feature: Zaping technical test
  description: As an user i want to go to url provided for test see if i can
  watch videos and also be able to chose other videos to watch

  Scenario: Go to page and check is the right one,
    Given I enter url
    Then I should see page title "Advanced example | Video.js"
    Then I scroll down to video player
    And Video is "off"
    Then I click player
    And Video is "on"
    Then I click player
    And Video is "off"
    When I click the next video
    Then I click player
    And Video is "on"
    Then I click a random video
    And Video is "off"



