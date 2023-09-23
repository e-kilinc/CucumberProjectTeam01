Feature: API US09 Vice Dean Dersleri Gorebilmeli ve Silebilmeli

  @lessonGet
  Scenario Outline: Vice Dean basarili bir sekilde dersleri gorebilmeli
    Given Ders ismi ile get request yapilir
    Then Gelen Ders bilgileri dogrulanir: lessonId="<lessonId>",lessonName="<lessonName>",creditScore="<creditScore>",compulsory="<compulsory>",message="<message>"
    Examples:
      | lessonId | lessonName  | creditScore | compulsory | message                   |
      | 1488     | Cucumber999 | 3           | false      | Lesson successfully found |

@lessonDelete
  Scenario: Vice Dean basarili bir sekilde dersleri silebilmeli
    Given Dersi silmek icin lessonName bilgisi hazirlanir
    When Ders silmek icin delete request gonderilir
    Then Dersin silindigi dogrulanir
