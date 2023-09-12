@gonul2
Feature: US_02

  Scenario: Admin Guest User List
    Given Kullanici anasayfaya gider
    Then Kullanici login butonuna tıklar
    And Kullanici Username girer
    And Kullanici Password girer
    And Kullanici Login butonuna tiklar_gnl
    And Kullanici Hi yazisinin gorundugunu dogrular
    Then Kullanici Menu butonuna tiklar
    Then Kullanici Guest User butonuna tiklar
    And Kullanici son basarili kaydin guest user list'te oldugunu dogrular
    Then Kullanici son eklenen Guest user'i siler
    And Kullanici son eklenen Guest user'i silindigini dogrular

