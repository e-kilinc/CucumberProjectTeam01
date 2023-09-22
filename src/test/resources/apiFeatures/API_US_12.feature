Feature: US_12 ViceDean LessonProgram management testi

  @US12_api
  Scenario: Vice Dean ögretmene ders atayabilmeli API
    Given Ders programina ders eklemek icin API hazirligi yapilirY
    When Post edilecek ders bilgileri hazirlanirY
    Then Ders eklemek icin Post request gönderilirY
    When Olusturulan ders programinin ID numarasi alinirY
    Then Ogretmene ders atamak icin API hazirligi yapilirY
    Then Ogretmene post request ile ders atanirY
    Then Ögretmene dersin atandigi dogrulanirY
    And Delete request ile ders programi silinirY
