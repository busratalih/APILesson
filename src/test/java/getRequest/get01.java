package getRequest;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class get01 {




     /*
        Bizler bu zamana kadar sizler ile birlikte POSTMAN üzerinde farklı doc. sahip olan
        çeşitli API lere request attık.
        REq atarken HTTP methodların da GET, POST; PUT, PATCH and DELETE methoslarınınkullandık.



        Bizler markete genle olarak POSTMAN i bir otomasyon toolu olarak değil manule test tool u olarka
        kullanıyoruz. Fakat dersler de işlediğimiz üsere PSTAMN ile test otomasyonu yapabiliyoruz.

        API testlerimiz bundan sonra REstAssured Lib. kullanrak yapacğaız.


        TEST leri yapabiliyor olmak içn sizlerin bir doc. ihtiyacı vardır.
        Biz test eng. bu doc. göre API leri nasıl kullanacağımız veya nasıl test edeceğimizi öğreniriz.

        Ve doc. lara göre çeşitli seneryoalr oluşturabiliriz. Tıpkı ne gibi?
        Selenium Web UI teslteri koştuğumuz gibi.

        Test Case:

         --> Expected Result


         ---> Actual Result      ====>>>>> Response dan alacağım.


        Gherkin Lang.

            Given ---> testin yapılabilmesi için ön hazırlık/ön şart
            When ---> Action --> Gerçekleştirilecek Eylemler
            Then ---> Assertion için kullanıyoruz
            And  ---> Öncesinde kullanılan keyword u etkisinin hala devame titğini zilere gösterir.

     */

    /*
    Given
        https://restful-booker.herokuapp.com/booking/7
    When
        Kullanıcı GET Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
        Content Type ın "application/json" olduğunu assert et
    And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.

     */


    @Test    // -> it is like it main method
    public void get01(){
        /*
        4 tane step var
        a-) URL i tanımlamak lazım. URL yi set etmek gerekir
        b-) Expected dataları tanımlamak lazım. Expected dataları set etmek gerekir.
        Expected datalar Test Case lerden alınır. Doc. dan alınır.
        (su an için bu step igonre edilecek.)
        c-) Request gonder.
        d-) Assertion işlemi.

         */

        // Step 1; URL i set ediniz
        String URL= "https://restful-booker.herokuapp.com/booking/7";

        // Step 2; Expected datalaı set et. (ignore edildi)

        // Step 3; Request gonder
        Response response= given().when().get(URL);

        System.out.println("RESPONSE : ");
        response.prettyPrint();  //prettyPrint()  syso gibidir.

        // Step 4; Assertion İşlemleri

        /*
        Then
        Status Code un "200" olduğunu Assert et
        And
        Content Type ın "application/json" olduğunu assert et
        And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.
         */

        //Test 1 : status code : 200
        response.then().assertThat().statusCode(200); // doc. TestCase den alındı

        // Tset 2 : Content Type : "application/json"
        response.then().assertThat().contentType("application/json");

        // Test 3 : Status Line : "HTTP/1.1 200 OK"
        response.then().assertThat().statusLine("HTTP/1.1 200 OK");

        // Status kodu konsola nasıl yazdırılır?
        System.out.println("Status Code:" + response.getStatusCode());

        // Content Type  konsola nasıl yazdırılır?
        System.out.println("Content Type :" + response.getContentType());

        // Status Line konsola nasıl yazdırlır?
        System.out.println("Status Line:" + response.getStatusLine());

        // Response Time konsola nasıl yazdırılır?
        System.out.println("Response Time :" + response.getTime());

        //Headers lar konsola nasıl yazdırılır?
        System.out.println("Headers:" + response.getHeaders());





    }



}
