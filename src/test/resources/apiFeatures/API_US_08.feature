@apitesti
  Feature: API US08 Vice Dean Ders Olusturabilmelidir
    @api1
    Scenario: Vice Dean basarili bir sekilde ders ekleyebilir
    Given Ders eklemek icin post request hazirligi yapilir
    And Gonderilecek ders bilgileri hazirlanir
    When Ders eklemek icin post request gonderilir
    Then Ders bilgileri dogrulanir

@api2
  Scenario: TC02 Vice Dean basarili bir sekilde ders ekleyebilir(Compulsory secilmeden)
    Given Ders eklemek icin post request hazirligi yapilir
    And Gonderilecek ders bilgileri compulsory secilmeden hazirlanir
    When Ders eklemek icin post request gonderilir
    Then Ders bilgileri dogrulanir

  @api3
    Scenario: TC03 Vice Dean ders adini secmeden ders olusturamaz
      Given Ders eklemek icin post request hazirligi yapilir
      And Gonderilecek ders ismi secilmeden hazirlanir
      When Ders eklemek icin dersismi olmadan post request gonderilir
      Then Ders olusturulamadigi bilgisi dogrulanir

#    Scenario: TC04 Vice Dean credit score secmeden ders olusturamaz
#      Given Ders eklemek icin post request hazirligi yapilir
#      And Gonderilecek credit score secilmeden hazirlanir
#      When Ders eklemek icin credit score olmadan post request gonderilir
#      Then Ders olusturulamadigi bilgisi dogrulanir