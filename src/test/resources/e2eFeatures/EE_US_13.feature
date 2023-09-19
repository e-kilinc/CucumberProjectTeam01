@E2E_US13
Feature:  US_13 Vice Dean Teacher olustururEEY
  Scenario Outline: Vice Dean Teacher olusturur(pozitif senaryo)EEY
    Given kullanici "homePageUrl" sayfasina giderEEY
    Then Vice Dean olarak login olurEEY
    Then Menu butonuna tiklarEEY
    Then Teacher Mananement basligina tiklarEEY
    Then Add Teacher  basliginin altinda choose Lessons'da ders secerEEY
    Then Zorunlu alanlari doldurur; name "<name>", surname "<surname>",birth_place "<birth_place>",email "<email>", phone_number "<phone_number>",gender "<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",password"<password>"EEY
    But Is Advisor alanini bos birakirEEY
    When Sayfadaki Submit butonuna tiklarEEY
    Then Teacher saved successfully yazisinin göründügünü dogrularEEY
    Examples:
      | username   | birth_day  | birth_place | email                    | gender | name  | phone_number  | ssn        | surname | password   |
      | Alinder    | 05-01-1990 | Can         | elyjah.hersh@feerock.com | Female | Aline | 156-666-5896 | 123-52-7456 | Linder  | 05012123Ka |

  @db_13
 Scenario Outline: ViceDean tarafindan olusturulan Teacher DataBase sorgulamasi
   Given DataBase baglantisi yapilirDBY
   When Teacher username"<username>" bilgisi ile cagirilirDBY
   Then Teacher bilgileri dogrulanirDBY: name "<name>", surname "<surname>",birth_place "<birth_place>",email "<email>", phone_number "<phone_number>",gender "<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>"
   Examples:
     | username   | birth_day  | birth_place| email                    | gender | name  | phone_number  | ssn        | surname |
     | Alinder    | 1990-01-05 | Can        | elyjah.hersh@feerock.com | FEMALE | Aline | 156-666-5896 | 123-52-7456 | Linder  |


  @api_13
  Scenario Outline: Vice Dean tarafindan olusturulan Ogretmenin API Testi
    Given Teacher userId bilgisi alinirY
    When Get request ile olusturulmus Teacher bilgisine ulasilirY
    Then Teacher bilgileri dogrulanirGet_APIY: name "<name>", surname "<surname>",birth_place "<birth_place>",email "<email>", phone_number "<phone_number>",gender "<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>"
    And Teacher silinirY
    Examples:
      | username   | birth_day  | birth_place| email                    | gender | name  | phone_number  | ssn        | surname |
      | Alinder    | 1990-01-05 | Can        | elyjah.hersh@feerock.com | FEMALE | Aline | 156-666-5896 | 123-52-7456 | Linder  |


