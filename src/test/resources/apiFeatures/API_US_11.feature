Feature: US_11 ViceDean LessonProgram management testi

    @US11_api
  Scenario: Vice Dean olusturulan ders programini görebilmeli ve silebilmeli API
      Given Ders programina ders eklemek icin API hazirligi yapilirY
      When Post edilecek ders bilgileri hazirlanirY
      Then Ders eklemek icin Post request gönderilirY
      When Olusturulan ders programinin ID numarasi alinirY
      When Get request ile olusturulmus ders programi bilgisine ulasilirY
      Then Ders Programinin bilgileri dogrulanirY
      When Delete request ile ders programi silinirY
      Then ders programinin silindigi dogrulanirY

