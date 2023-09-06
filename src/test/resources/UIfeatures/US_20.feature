@Teacher_Check
Feature: Teacher Check Meet List

  Scenario Outline: US_20 Teacher Meet List gorur, gunceller ve siler

    Given Kullanici homePage  sayfasina gider.
    When Kullanici Login butonuna tiklar.
    And Kullanici kullanici "<teacherUsername>" ve password "<password>" bilgilerini girer.
    And Kullanici Login butonuna tiklar.
    And Kullanici Menu butonuna tiklar.
    And Kullanici acilan pencerede Meet Management butonuna tiklar.
    And Kullanici Meet List bolumunde Date, Start Time,Stop Time ve Desciraption nin oldugunu dogrular


    And Kullanici Edit butonuna tiklar.
    And Kullanici Chose Student kismindan Team01 Student secer.
    And Kullanici Date of Meet bolumunde degisiklik yapar
    And Kullanici Submit butonuna tiklar.
    And Kullanici Meet Updated Succesfully yazisinin gorundugunu dogrular.
    And Kullanici Exit butonuna tiklar.
    And Kullanici Delete butonuna tiklar
    And Kullanici Meet deleted succesfully yazisinin gorundugunu dogrular

    Examples:
      | teacherUsername | password |
      | teacherteam01   | AdminTeam01  |

