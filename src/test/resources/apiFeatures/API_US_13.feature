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

