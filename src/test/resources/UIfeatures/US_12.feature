Feature: US_12 ViceDean LessonProgram management testi

  Background: Kullanici Vice Dean olarak Login olur, LessonProgram bölümüne gelir
    Given kullanici "homePageUrl" sayfasina gider
    Then Vice Dean olarak login olur
    Then Lesson Program basligina tiklar
    But kullanici 2 saniye bekler
    When Lesson Program Assignment bölümüne gelir


  @vice12.01
  Scenario: TC01 ViceDean Lesson Program Assignment'da ögretmen ders atayabilmeli
    Then Choose Lesson altindaki kutucuga tiklar
    Then Choose Teacher alaninda bir ögretmen secer
    And Submit butonuna tiklar
    But kullanici 2 saniye bekler
    And Dersin atandigini dogrular


  @vice12.02
  Scenario: TC02 ViceDean Lesson Program Assignment'da ögretmen secmeden kayit yapamaz
    Then Choose Lesson altindaki kutucuga tiklar
    And Submit butonuna tiklar
    And Teacher secilmedigi icin uyari mesajinin görünüdügünü dogrular

  @vice12.03
  Scenario: TC03 ViceDean Lesson Program Assignment'da ders secmeden kayit yapamaz
    Then Choose Teacher alaninda bir ögretmen secer
    And Submit butonuna tiklar
    And Lesson Secilmedigi icin uyari mesajinin göründügünü dogrular