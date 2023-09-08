@gonul2
Feature: US001 Register Test

  Background: US_01
    Given Kullanici anasayfaya gider
    Then Kullanici register linkine tiklar

  Scenario Outline: TC01 Aday ögrenciler sisteme kayıt olabilmelidir (Register)
    And Kullanici Name "<name>", surname "<surname>" girer
    And Kullanici birth place "<birth_place>", phone "<phone_number>", gender "<gender>", Date Of Birth "<birth_day>", ssn "<ssn>" girer
    And Kullanici username "<username>" ve password "<password>" girer
    And Kullanici register butonuna tiklar
    And Kullanici cikan mesajin Guest User registered icerdigini dogrular

    Examples:
      | name    | surname | birth_place | phone_number | gender | birth_day  | ssn         | username   | password |
      | Charles | Muller  | Koln        | 456 899 2365 | male   | 10-04-2016 | 235-89-6645 | peter_mllr | Peter401 |


  #Scenario: TC02 Register (Guest User ) negatif senaryo
   # And Kullanici register butonuna tiklar
   # And Kullanıcı çıkan Required mesajlarını doğrular


