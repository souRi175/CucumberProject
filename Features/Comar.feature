Feature: Search for "COMAR Assurances partenaire" in Actualités
    Scenario: Verify search functionality
        Given I am on the website "https://www.comar.tn/"
        When I click on the "Actualités" section
        Then the page "Actualités" is opened
        When I enter "COMAR" in the search form and submit the search
        Then I should see "COMAR Assurances partenaire du Semi-Marathon Ulysse Djerba" in the search results
