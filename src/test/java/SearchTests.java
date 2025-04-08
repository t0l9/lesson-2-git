import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class SearchTests {

    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }

    @Test
    void successfulSearchTestYandex() {
        open("https://yandex.kz/");
        $("#text").setValue("selenide").pressEnter();
        $(".main__center").shouldHave(text("selenide"));
    }


    @Test
    void pageCanBeOpenedTest() {
        open("https://www.google.com/");
        $("html").shouldHave(text("Србија"));
    }

    @Test
    void bccAuto(){
        open("https://business-test.bcc.kz/");
        $("#phoneNumber").setValue("").pressEnter();
        $("#userPass1").setValue("").pressEnter();
        $(".ant-input").setValue("00000").pressEnter();
        $(".account-config-btn").shouldHave(text("Счета и карты"));

        $("#0.3_MENU_div").click();
        $("#root > section > section > main > div > div.payment-cells > a:nth-child(1) > div.payment-cells__content").click();
        $(".page__title").shouldHave(text("Создание платежа по реквизитам"));
    }

    @Test
    void goToPayment(){
        $("#0.3_MENU_div").click();
        $("#root > section > section > main > div > div.payment-cells > a:nth-child(1) > div.payment-cells__content").click();
        $(".page__title").shouldHave(text("Создание платежа по реквизитам"));
    }



}