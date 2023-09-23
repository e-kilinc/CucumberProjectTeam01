@US_13API
Feature: Teacher olusturma testi

  @US13_Api_TC01
  Scenario: ViceDean basarili bir sekilde ogretmen olusturur
    Given Teacher olusturmak icin Post request hazirligi yapilirY
    And Gönderilecek Teacher bilgileri hazirlanirY
    When Teacher olusturmak icin Post request gönderilirY
    Then Teacher bilgileri dogrulanirY

  @US13_Api_TC02
  Scenario: Teacher kaydi silinir
    Given Teacher userId bilgisi alinirY
    And Teacher silinirY
    Then Teacher kaydinin silindigi dogrulanirY


  @US13_Api_TC03
  Scenario: Gender bilgisi girmeden ögretmen eklemeAPI
    Given Teacher olusturmak icin Post request hazirligi yapilirY
    Then Gönderilecek Teacher bilgileri Gender olmadan hazirlanirY
    When Teacher olusturmak icin eksik bilgi ile Post request gönderilirY
    Then Teacher olusturulmadigi dogrulanirY

  @US13_Api_TC04
  Scenario: Yanlis SSN formati ile ögretmen ekleme(- yerine baska karakter)API
    Given Teacher olusturmak icin Post request hazirligi yapilirY
    Then Gönderilecek Teacher bilgileri Yanlis SSN ile hazirlanirY
    When Teacher olusturmak icin eksik bilgi ile Post request gönderilirY
    Then Teacher olusturulmadigi dogrulanirY

  @US13_Api_TC05
  Scenario: Zayif Password ile ögretmen eklemeAPI
    Given Teacher olusturmak icin Post request hazirligi yapilirY
    Then Gönderilecek Teacher bilgileri zayif Password ile hazirlanirY
    When Teacher olusturmak icin eksik bilgi ile Post request gönderilirY
    Then Teacher olusturulmadigi dogrulanirY






