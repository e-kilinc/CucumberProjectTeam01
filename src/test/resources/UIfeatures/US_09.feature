Feature: US09 Vice Dean ders listesini görebilmeli ve güncellemeler yapabilmelidir.

  Background: Kullanici Login islemini yapar
    Given kullanici "managementonschool" sayfasina gider
    Then Kullanici Login butonuna tiklar
    And Kullanici verilen bilgiler ile login olur
      | username       | password    |
      | vicedeanteam01 | AdminTeam01 |
    And Kullanici verileri girdikten sonra login olur
    Then Kullanici Lessons headerina tiklar
    And Kullanici ders listesinde son sayfaya gider
  @deneme1
  Scenario: TC01 Vice Dean ders listesini görur

    And Kullanici derslerin gorunur oldugunu dogrular
    And Kullanici derslerin compulsary olup olmadiginin gorunur oldugunu dogrular
    And Kullanici derslerin credit scorelerinin gorunur oldugunu dogrular
    And kullanici sayfayi kapatir


  @deneme1
  Scenario: TC02 Vice Dean ders listesini siler
    And Kullanici dersi silme butonuna tiklar
    And Kullanici dersin silindigini dogrular
    And kullanici sayfayi kapatir


  Scenario: TC03 Vice Dean ders listesini gunceller
    #And Kullanici dersi guncelleme butonuna tiklar
    #And Kullanici dersin credit scorunu gunceller
    #And Kullanici dersin guncellendigini dogrular