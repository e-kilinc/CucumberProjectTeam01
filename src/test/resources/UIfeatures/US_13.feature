Feature:  US_13 Vice Dean Teacher olusturur
  Background: Kullanici login islemi yapar ve Add Teacher kismina gider
    Given kullanici "homePageUrl" sayfasina gider
    Then Vice Dean olarak login olur
    Then Menu butonuna tiklar
    Then Teacher Mananement basligina tiklar


  @vice13
  Scenario Outline: Vice Dean Teacher olusturur(pozitif senaryo)
    Then Add Teacher  basliginin altinda choose Lessons'da ders secer
    Then Zorunlu alanlari doldurur; name "<name>", surname "<surname>",birth_place "<birth_place>",email "<email>", phone_number "<phone_number>",gender "<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",password"<password>"
    But Is Advisor alanini bos birakir
    When Sayfadaki Submit butonuna tiklar
    Then Teacher saved successfully yazisinin göründügünü dogrular

    Examples:
      | username   | birth_day  | birth_place | email                 | gender | name  | phone_number  | ssn        | surname | password   |
      | Yas        | 01-01-1990 | Can         | yasemineri@gmail.com  | Male   | Yase  | 444 666 8767 | 434-66-7154 | Eri     | 05012123Ka |


  @vice13_2
  Scenario Outline: Zorunlu alanlari bos birakarak ögretmen ekleme
    And Sayfadaki Submit alanina gelir, butonuna tiklar
    And Zorunlu alanlar;name,surname,birth_place,email,phone_number,gender,birth_day,ssn,username,password altinda uyari yazilarinin göründügünü dogrular.
    And Add Teacher  basliginin altinda choose Lessons'da ders secer
    And Zorunlu alanlari gender haric doldurur; name "<name>", surname "<surname>",birth_place "<birth_place>",email "<email>", phone_number "<phone_number>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",password"<password>"
    And Sayfadaki Submit butonuna tiklar
    And Gender icin uyari mesajinin göründügünü dogrular
    Examples:
      | username   | birth_day  | birth_place | email                  | name  | phone_number  | ssn        | surname | password   |
      | Yase       | 01-01-1990 | Can         | yasemineri@gmail.com   | Kunst  | 444 666 8767 | 434-66-7154| Lehr    | 05012123Ka |


  @vice13_5
  Scenario Outline: Choose Lesson Alanini bos birakarak ögretmen ekleme
    Then Zorunlu alanlari doldurur; name "<name>", surname "<surname>",birth_place "<birth_place>",email "<email>", phone_number "<phone_number>",gender "<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",password"<password>"
    And Sayfadaki Submit butonuna tiklar
    And Choose Lesson icin uyari mesajinin göründügünü dogrular
    Examples:
      | username   | birth_day  | birth_place | email                 | gender | name  | phone_number  | ssn        | surname | password   |
      | Yas        | 01-01-1990 | Can         | yasemineri@gmail.com  | Male   | Yase  | 444 666 8767 | 434-66-7154 | Eri     | 05012123Ka |




  @vice13_3.01
  Scenario Outline: Yanlis SSN formati ile ögretmen ekleme(- yerine baska karakter)
    Then Zorunlu alanlari ssn haric doldurur; name "<name>", surname "<surname>",birth_place "<birth_place>",email "<email>", phone_number "<phone_number>",gender "<gender>", birth_day "<birth_day>",username "<username>",password"<password>"
    And SSN alanina gecersizSsn girer
      |gecersizSsn|
      |133*96*1996|
    And Sayfadaki Submit butonuna tiklar
    And SSN hakkinda hata mesajinin göründügünü dogrular
    Examples:
      | username   | birth_day  | birth_place | email                 | gender | name  | phone_number | surname  | password   |
      | Yas        | 01-01-1990 | Can         | yasemineri@gmail.com  | Male   | Yase  | 444 666 8767 |  Eri     | 05012123Ka |


  @vice13_3.02
  Scenario Outline: Yanlis SSN formati ile ögretmen ekleme2(10 karakter)
    Then Zorunlu alanlari ssn haric doldurur; name "<name>", surname "<surname>",birth_place "<birth_place>",email "<email>", phone_number "<phone_number>",gender "<gender>", birth_day "<birth_day>",username "<username>",password"<password>"
    And SSN alanina OnkarakterSSN girer
      |OnkarakterSSN|
      |133-15-199   |
    And Sayfadaki Submit butonuna tiklar
    And Min. "11 character(XXX-XX-XXX)" yazisinin göründügünü dogrular
    Examples:
      | username   | birth_day  | birth_place | email                 | gender | name  | phone_number | surname  | password   |
      | Yas        | 01-01-1990 | Can         | yasemineri@gmail.com  | Male   | Yase  | 444 666 8767 |  Eri     | 05012123Ka |


  @vice13_3.03
  Scenario Outline: Yanlis SSN formati ile ögretmen ekleme3(Harfli 11 karakter)
    Then Zorunlu alanlari ssn haric doldurur; name "<name>", surname "<surname>",birth_place "<birth_place>",email "<email>", phone_number "<phone_number>",gender "<gender>", birth_day "<birth_day>",username "<username>",password"<password>"
    And SSN alanina OnBirkarakterHarfSayiSSn girer
      |11karakterHarfSayiSSn |
      |KA1-12-1996           |
    And Sayfadaki Submit butonuna tiklar
    And SSN hakkinda hata mesajinin göründügünü dogrular
    Examples:
      | username   | birth_day  | birth_place | email                 | gender | name  | phone_number | surname  | password   |
      | Yas        | 01-01-1990 | Can         | yasemineri@gmail.com  | Male   | Yase  | 444 666 8767 |  Eri     | 05012123Ka |



  @vice13_4.01
  Scenario Outline: Sekiz karakterden az veri ile password girme
    Then Zorunlu alanlari password haric doldurur; name "<name>", surname "<surname>",birth_place "<birth_place>",email "<email>", phone_number "<phone_number>",gender "<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>"
    And Password alanina sekiz karakterden az veri girer
      |Password1|
      |050121   |
    And Sayfadaki Submit butonuna tiklar
    And Password hakkinda hata mesajinin göründügünü dogrular
    Examples:
      | username   | birth_day  | birth_place | email                 | gender | name  | phone_number | surname  | ssn       |
      | Yas        | 01-01-1990 | Can         | yasemineri@gmail.com  | Male   | Yase  | 444 666 8767 |  Eri     |434-66-7154|


  @vice13_4.02
  Scenario Outline: Sadece sayilardan olusan password girme
    Then Zorunlu alanlari password haric doldurur; name "<name>", surname "<surname>",birth_place "<birth_place>",email "<email>", phone_number "<phone_number>",gender "<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>"
    And Password alanina sekiz adet rakam girer
      |Password2|
      |05012123   |
    And Sayfadaki Submit butonuna tiklar
    And One lowercase uyarisinin göründügünü dogrular
    Examples:
      | username   | birth_day  | birth_place | email                 | gender | name  | phone_number | surname  | ssn       |
      | Yas        | 01-01-1990 | Can         | yasemineri@gmail.com  | Male   | Yase  | 444 666 8767 |  Eri     |434-66-7154|


  @vice13_4.03
  Scenario Outline: Sekiz karakter ve bir kücük harf ile password girme
    Then Zorunlu alanlari password haric doldurur; name "<name>", surname "<surname>",birth_place "<birth_place>",email "<email>", phone_number "<phone_number>",gender "<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>"
    And Password alanina sekiz karakterden ve bir kücük harf girer
      |Password3 |
      |050121236a|
    And Sayfadaki Submit butonuna tiklar
    And One uppercase uyarisinin göründügünü dogrular
    Examples:
      | username   | birth_day  | birth_place | email                 | gender | name  | phone_number | surname  | ssn       |
      | Yas        | 01-01-1990 | Can         | yasemineri@gmail.com  | Male   | Yase  | 444 666 8767 |  Eri     |434-66-7154|

  @vice13_4.04
  Scenario Outline: Sekiz adet büyük ve kücük harf girme
    Then Zorunlu alanlari password haric doldurur; name "<name>", surname "<surname>",birth_place "<birth_place>",email "<email>", phone_number "<phone_number>",gender "<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>"
    And Password alanina sekiz adet büyük ve kücük harf girer
      |Password3|
      |abcdEfgh |
    And Sayfadaki Submit butonuna tiklar
    And One number uyarisinin göründügünü dogrular
    Examples:
      | username   | birth_day  | birth_place | email                 | gender | name  | phone_number | surname  | ssn       |
      | Yas        | 01-01-1990 | Can         | yasemineri@gmail.com  | Male   | Yase  | 444 666 8767 |  Eri     |434-66-7154|