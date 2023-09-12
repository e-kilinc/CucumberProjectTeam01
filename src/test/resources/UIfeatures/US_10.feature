@dersprogrami
Feature: US10_Vice Dean ders programı oluşturabilmelidir

  Background: Kullanici login islemi yapar ve Lesson kismina gider
    Given kullanici "managementonschool" sayfasina gider
    Then Kullanici Login butonuna tiklar
    And Kullanici verilen bilgiler ile login olur
      | username       | password    |
      | vicedeanteam01 | AdminTeam01 |
    And Kullanici verileri girdikten sonra login olur
    Then Kullanici Lesson Program headerina tiklar

    @deneme1
    Scenario: TC01 Vice Dean Ders Programi Olusturur
      And Kullanici istedigi dersi secer
      And Kullanici egitim donemini secer
      And Kullanici ders gununu secer
      And Kullanici ders baslama saatini secer
        | 0011AM |
      And Kullanici ders bitis saatini secer
        | 0051AM|
      And Kullanici ders programi submit butonuna tiklar
      And Kullanici ders programinin olustugunu dogrular
      And kullanici sayfayi kapatir

  Scenario: TC02 Vice Dean Eksik Bilgi Girdigi icin Ders programi olusturamaz

    And Kullanici egitim donemini secer
    And Kullanici ders gununu secer
    And Kullanici ders baslama saatini secer
      | 0013AM |
    And Kullanici ders bitis saatini secer
      | 0053AM|
    And Kullanici ders programi submit butonuna tiklar
    And Kullanici hata mesaji aldigini dogrular
    And kullanici sayfayi kapatir

  Scenario: TC03 Vice Dean Eksik Bilgi Girdigi icin Ders programi olusturamaz

    And Kullanici istedigi dersi secer
    And Kullanici ders gununu secer
    And Kullanici ders baslama saatini secer
      | 0014AM |
    And Kullanici ders bitis saatini secer
      | 0054AM|
    And Kullanici ders programi submit butonuna tiklar
    And Kullanici hata mesaji aldigini dogrular
    And kullanici sayfayi kapatir

  Scenario: TC04 Vice Dean Eksik Bilgi Girdigi icin Ders programi olusturamaz

    And Kullanici istedigi dersi secer
    And Kullanici egitim donemini secer
    And Kullanici ders baslama saatini secer
      | 0015AM |
    And Kullanici ders bitis saatini secer
      | 0055AM|
    And Kullanici ders programi submit butonuna tiklar
    And Kullanici hata mesaji aldigini dogrular
    And kullanici sayfayi kapatir

  Scenario: TC05 Vice Dean Eksik Bilgi Girdigi icin Ders programi olusturamaz

    And Kullanici istedigi dersi secer
    And Kullanici egitim donemini secer
    And Kullanici ders gununu secer
    And Kullanici hata Required yazini gorur
    And Kullanici ders bitis saatini secer
      | 0055AM|
    And Kullanici ders programi submit butonuna tiklar
    And kullanici sayfayi kapatir

  Scenario: TC06 Vice Dean Eksik Bilgi Girdigi icin Ders programi olusturamaz

    And Kullanici istedigi dersi secer
    And Kullanici egitim donemini secer
    And Kullanici ders gununu secer
    And Kullanici ders baslama saatini secer
      | 0015AM |
    And Kullanici hata Required yazini gorur
    And Kullanici ders programi submit butonuna tiklar
    And kullanici sayfayi kapatir