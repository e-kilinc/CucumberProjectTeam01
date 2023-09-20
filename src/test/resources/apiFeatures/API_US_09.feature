Feature: API US09 Vice Dean Dersleri Gorebilmeli ve Silebilmeli

  Scenario: Vice Dean basarili bir sekilde dersleri gorebilmeli
    Given Dersi gorebilmek icin get request hazirligi yapilir
    And Ders verileri hazirlanir
    When Kaydedilen ders ID ile cagirilir
    Then Ders bilgilerinin dogrulugu dogrulanir


  Scenario: Vice Dean basarili bir sekilde dersleri silebilmeli
    Given Ders silmek icin delete request hazirligi yapilir
    And Silinecek ders verileri hazirlanir
    When Ders silmek icin delete request gonderilir
    Then Dersin silindigi dogrulanir
