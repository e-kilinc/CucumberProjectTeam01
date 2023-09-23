Feature: US_10 ViceDean LessonProgram olusturma testi

  @lessonprogramek
  Scenario: Vice Dean  ders programi olusturabilmeli
    Given Ders programina ders eklemek icin API hazirligi yapilir
    When Post edilecek ders bilgileri hazirlanir
    And Ders eklemek icin Post request gönderilir
    Then Ders programi bilgileri dogrulanir