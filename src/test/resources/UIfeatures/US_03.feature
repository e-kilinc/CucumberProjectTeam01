@gonul
Feature: US_03 Kullanıcılar sayfadan mesaj gönderebilmelidir (Contact)

  Background: US03
    Given Kullanici anasayfaya gider
    Then Contact butonuna tiklar

  Scenario Outline: TC01 Kullanıcılar sayfadan mesaj gönderebilmelidir (Contact)
    And Kullanici "<name>", e-mail ve "<Subject>" bolumlerini girer
    And Kullanici Mail adresinin "@" ve "." karakterlerini icerdigini dogrular
    And Kullanici "contactMessage" yazar
    Then Kullanici Send Message butonuna tiklar
    And Kullanici "Contact Message Created Successfully" mesajinin gorundugunu dogrular

    Examples:
      | name         | Subject        |
      | Denis Muller | Kayit Yenileme |


  Scenario: TC02 Negatif Senaryo
    And Kullanici name bolumune 4 karakterden daha az olan "Ali" girer
    And Kullanici Mail adresi bolumune @ ve . karakterlerini iceren mail girer
    Then Kullanici  Subject bolumune 4 karakterli "odev" girer
    And Kullanici "contactMessage" yazar
    Then Kullanici Send Message butonuna tiklar
    And Kullanici "Your name should be at least 4 characters" mesajinin gorundugunu dogrular


  Scenario: TC03 Negatif Senaryo
    And Kullanici name bolumune 4 karakterli "Seda" girer
    And Kullanici Mail adresi bolumune @ ve . karakterlerini iceren mail girer
    Then Kullanici Subject bolumune 4 karakterden az "Not" konusunu girer
    And Kullanici "contactMessage" yazar
    Then Kullanici Send Message butonuna tiklar
    And Kullanici "Your subject should be at least 4 characters" mesajinin gorundugunu dogrular


  Scenario: TC04 Negatif Senaryo
    And Kullanici name bolumune 4 karakterli "Seda" girer
    And Kullanici Mail adresi bolumune @ ve . karakterlerini iceren mail girer
    Then Kullanici  Subject bolumune 4 karakterli "odev" girer
    And Kullanici mesaj bolumune 3 karakterli "Not" yazar
    Then Kullanici Send Message butonuna tiklar
    And Kullanici "Your subject should be at least 4 characters" mesajinin gorundugunu dogrular
