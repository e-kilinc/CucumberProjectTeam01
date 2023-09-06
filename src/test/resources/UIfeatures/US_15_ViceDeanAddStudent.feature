Feature: ViceDean Student Ekleyebilmeli
  Background:
    Given kullanici ana sayfaya gider
    Then kullanici vice dean olarak login olur
    Then vdkullanici 3 saniye bekler
    Then kullanici menuye click yapar
    Then vdkullanici 3 saniye bekler
    Then kullanici main menuden "student management"sayfasini acar
  @US15 @ui
  Scenario Outline:TC01 ViceDean ogrenci eklemesi
    And kullanici chooseTeacher "<chooseteacher>", name "<name>",surname "<surname>", birth_place "<birth_place>" , email "<email>" , phone_number "<phone_number>",gender"<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",fatherName"<fathername>" , motherName "<mothername>", password "<password>" bilgilerini girer
    Then basarili kayit yapildigini dogrular
    And student numberin otomatik geldigini dogrular

    Examples:
      | chooseteacher | name   | surname | birth_place | email    | phone_number | gender | birth_day  | ssn         | username | fathername | mothername | password  |
      | mecid kays    | meco   | jack    | Katar       | asd@s.com| 111-222-3888 | male   | 12-05-2001 | 123-55-1234 | m446565  | john       | wick       | Ma1234567 |
  @US15 @ui
  Scenario Outline: TC02 ViceDean  eksik bilgi ile ogrenci ekleyemez
    And kullanici eksik chooseteacher ile chooseTeacher "<chooseteacher>", name "<name>",surname "<surname>", birth_place "<birth_place>" , email "<email>" , phone_number "<phone_number>",gender"<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",fatherName"<fathername>" , motherName "<mothername>", password "<password>" bilgilerini girer
    Then  no chooseteacher ile kayit yapilmadigini dogrular
    And kullanici sayfa yeniler
    And kullanici eksik name chooseTeacher "<chooseteacher>", name "<name>",surname "<surname>", birth_place "<birth_place>" , email "<email>" , phone_number "<phone_number>",gender"<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",fatherName"<fathername>" , motherName "<mothername>", password "<password>" bilgilerini girer
    Then  no "name" ile kayit yapilmadigini dogrular
    And kullanici sayfa yeniler
    And kullanici eksik surname chooseTeacher "<chooseteacher>", name "<name>",surname "<surname>", birth_place "<birth_place>" , email "<email>" , phone_number "<phone_number>",gender"<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",fatherName"<fathername>" , motherName "<mothername>", password "<password>" bilgilerini girer
    Then  no "surname" ile kayit yapilmadigini dogrular
    And kullanici sayfa yeniler
    And kullanici eksik birth_place chooseTeacher "<chooseteacher>", name "<name>",surname "<surname>", birth_place "<birth_place>" , email "<email>" , phone_number "<phone_number>",gender"<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",fatherName"<fathername>" , motherName "<mothername>", password "<password>" bilgilerini girer
    Then  no "birth_place" ile kayit yapilmadigini dogrular
    And kullanici sayfa yeniler
    And kullanici eksik email ile chooseTeacher "<chooseteacher>", name "<name>",surname "<surname>", birth_place "<birth_place>" , email "<email>" , phone_number "<phone_number>",gender"<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",fatherName"<fathername>" , motherName "<mothername>", password "<password>" bilgilerini girer
    Then  no "email" ile kayit yapilmadigini dogrular
    And kullanici sayfa yeniler
    And kullanici eksik phoneNumber ile chooseTeacher "<chooseteacher>", name "<name>",surname "<surname>", birth_place "<birth_place>" , email "<email>" , phone_number "<phone_number>",gender"<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",fatherName"<fathername>" , motherName "<mothername>", password "<password>" bilgilerini girer
    Then no "phone_number" ile kayit yapilmadigini dogrular
    And kullanici sayfa yeniler
    And kullanici eksik gender ile chooseTeacher "<chooseteacher>", name "<name>",surname "<surname>", birth_place "<birth_place>" , email "<email>" , phone_number "<phone_number>",gender"<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",fatherName"<fathername>" , motherName "<mothername>", password "<password>" bilgilerini girer
    Then no gender ile kayit yapilmadigini dogrular
    And kullanici sayfa yeniler
    And kullanici eksik birth_day ile chooseTeacher "<chooseteacher>", name "<name>",surname "<surname>", birth_place "<birth_place>" , email "<email>" , phone_number "<phone_number>",gender"<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",fatherName"<fathername>" , motherName "<mothername>", password "<password>" bilgilerini girer
    Then no "birth_day" ile kayit yapilmadigini dogrular

    Examples:
      | chooseteacher | name   | surname | birth_place | email        | phone_number | gender | birth_day  | ssn         | username | fathername | mothername | password  |
      | mecid kays    | murat  | kara    | constanti   | karamrt@g.com| 666-222-8856 | male   | 12-05-2000 | 123-55-1111 | c152152  | john       | wick       | Tc1234567 |
  @US15 @ui
  Scenario Outline: TC03 ViceDean  eksik bilgi ile ogrenci ekleyemez
    And kullanici eksik ssn ile chooseTeacher "<chooseteacher>", name "<name>",surname "<surname>", birth_place "<birth_place>" , email "<email>" , phone_number "<phone_number>",gender"<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",fatherName"<fathername>" , motherName "<mothername>", password "<password>" bilgilerini girer
    Then  no "ssn" ile kayit yapilmadigini dogrular
    And kullanici ssn bilgisine - yazmaz
    Then no "ssn eksik" ile kayit yapilmadigini dogrular
    And kullanici ssn bilgisine "asd-22-5555" girer
    Then ssn "harf kullanilarak" ile kayit yapilmadigini "enter valid SSN number" ile dogrular
    And kullanici ssn bilgisine "12-222-5555" girer
    Then ssn "ikinci rakam sonrasi -" ile kayit yapilmadigini "enter valid SSN number" ile dogrular
    And kullanici ssn bilgisine "a.?-22-5555" girer
    Then ssn "sembol kullanma" ile kayit yapilmadigini "enter valid SSN number" ile dogrular
    And kullanici ssn bilgisine "121-22-55" girer
    Then no "eksik karakter" ile kayit yapilmadigini dogrular
    And kullanici ssn bilgisine "121222-55" girer
    Then no "eksik karakter" ile kayit yapilmadigini dogrular
    And kullanici sayfa yeniler
    And kullanici eksik username ile chooseTeacher "<chooseteacher>", name "<name>",surname "<surname>", birth_place "<birth_place>" , email "<email>" , phone_number "<phone_number>",gender"<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",fatherName"<fathername>" , motherName "<mothername>", password "<password>" bilgilerini girer
    Then  no "username" ile kayit yapilmadigini dogrular
    And kullanici sayfa yeniler
    And kullanici eksik fathername ile chooseTeacher "<chooseteacher>", name "<name>",surname "<surname>", birth_place "<birth_place>" , email "<email>" , phone_number "<phone_number>",gender"<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",fatherName"<fathername>" , motherName "<mothername>", password "<password>" bilgilerini girer
    Then  no "fathername" ile kayit yapilmadigini dogrular
    And kullanici sayfa yeniler
    And kullanici eksik mothername ile chooseTeacher "<chooseteacher>", name "<name>",surname "<surname>", birth_place "<birth_place>" , email "<email>" , phone_number "<phone_number>",gender"<gender>", birth_day "<birth_day>",ssn "<ssn>",username "<username>",fatherName"<fathername>" , motherName "<mothername>", password "<password>" bilgilerini girer
    Then  no "mothername" ile kayit yapilmadigini dogrular

    Examples:
      | chooseteacher | name   | surname | birth_place | email        | phone_number | gender | birth_day  | ssn       | username | fathername | mothername | password  |
      | mecid kays    | murat  | kara    | karamurat   | ssad@aaa.com | 123-222-8888 | male   | 12-03-2001 | 129551111 | u122152  | john       | wick       | Tc1234567 |
