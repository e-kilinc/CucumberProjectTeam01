@all
Feature: US08 Vice Dean Ders Olusturabilmelidir

  Background: Kullanici Login islemini yapar
    Given kullanici "managementonschool" sayfasina gider
    Then Kullanici Login butonuna tiklar
    And Kullanici verilen bilgiler ile login olur
      | username       | password    |
      | vicedeanteam01 | AdminTeam01 |
    And Kullanici verileri girdikten sonra login olur
@deneme1
  Scenario: TC01 Vice Dean Ders Olusturur Positive Scenario01

    Then Kullanici Lessons headerina tiklar
    And Kullanici Lesson Name kismini doldurur
      | lessonname  |
      | Cucumber106 |
    And Kullanici dersin compulsory kismina tiklar
    And Kullanici Credit Score bilgilerini girer
      | creditScore  |
      | 3 |
    And Kullanici submit butonuna tiklar
    And Kullanici basariyla ders olustugunu dogrular
    And kullanici sayfayi kapatir



  Scenario: TC02 Vice Dean Ders Olusturur Positive Scenario01(Compulsory tiklanmaz)

    Then Kullanici Lessons headerina tiklar
    And Kullanici Lesson Name kismini doldurur
      | lessonname  |
      | Cucumber103 |
    And Kullanici Credit Score bilgilerini girer
      | creditScore  |
      | 3 |
    And Kullanici submit butonuna tiklar
    And Kullanici basariyla ders olustugunu dogrular
    And kullanici sayfayi kapatir



  Scenario: TC03 Vice Dean Ders Olusturamaz Negative Scenario01(Lesson Name bos birakilir)

    Then Kullanici Lessons headerina tiklar
    And Kullanici dersin compulsory kismina tiklar
    And Kullanici Credit Score bilgilerini girer
      | creditScore  |
      | 3 |
    And Kullanici submit butonuna tiklar
    And Kullanici Lesson Name altinda Required uyarisini gorur
    And kullanici sayfayi kapatir


  Scenario: TC04 Vice Dean Ders Olusturamaz Negative Scenario01(Credit Score bos birakilir)

    Then Kullanici Lessons headerina tiklar
    And Kullanici Lesson Name kismini doldurur
      | lessonname  |
      | Cucumber104 |
    And Kullanici dersin compulsory kismina tiklar
    And Kullanici submit butonuna tiklar
    And Kullanici Credit Score altinda Required uyarisini gorur
    And kullanici sayfayi kapatir
