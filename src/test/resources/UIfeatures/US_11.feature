@US11
Feature: US_11 ViceDean LessonProgram management testi

  @vice11
  Scenario Outline: TC01 ViceDean Lesson Program List'deki dersi görebilmeli
    Given kullanici "homePageUrl" sayfasina gider
    Then Vice Dean olarak login olur
    But kullanici 2 saniye bekler
    Then Lesson Program basligina tiklar
    And Lesson Program List de ders programinin göründügünü dogrular "<Lesson>","<Day>","<Start_Time>","<Stop_Time>"
    Examples:
      | Lesson     | Day       | Start_Time | Stop_Time |
      | Cucumber101| FRIDAY    | 10:00:00   | 12:00:00  |
