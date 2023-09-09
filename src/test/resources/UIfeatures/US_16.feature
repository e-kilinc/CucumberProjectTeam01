Feature: ViceDean Kullanici Mesajlarini Gorebilmeli

  Background:
    Given kullanici ana sayfaya gider
    Then kullanici vice dean olarak login olur
    And vdkullanici 3 saniye bekler
    Then kullanici menuye click yapar
    And vdkullanici 3 saniye bekler
    And vdKullanici contactgetall sekmesini acar
    Then vdkullanici 3 saniye bekler
  @msj
  Scenario:TC01 ViceDean Silme Butonunu Görebilmeli
    And contact message sayfasinda delete butonu gorumedigini dogrula

  @msj
  Scenario Outline:TC02 Vice Dean Mesajlari, Yazarlarini, e-maillerini, Gönderilme Tarihi ve Subject Bilgilerini Görebilir
    And get Contact ve "<yourname>" "<youremail>" "<yoursubject>" "<yourmessage>"  bilgilerini doldur ve gonder
    Then kullanici menuye click yapar
    And vdkullanici 3 saniye bekler
    And vdKullanici contactgetall sekmesini acar
    Then get Contact ve "<yourname>" "<youremail>" "<yoursubject>" "<yourmessage>" bilgileri liste ile gorundugunu dogrular
    Examples:
      | yourname | youremail     | yoursubject | yourmessage |
      | tester   | test@test.com | testsubject | testmessage |