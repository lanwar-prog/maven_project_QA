import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Sergey_QA_test {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        //Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://yandex.ru/");
        //Переходим в маркет
        driver.findElement(By.cssSelector("[data-id=market]")).click();
        //Переключаемся во вторую вкладку браузера
        ArrayList<String> tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        //driver.findElement(By.cssSelector("div.q2jz_gHGnl button")).click();
        driver.findElement(By.cssSelector("._2EPSjI-GdM._2s55WErgIp.BCVQlNQsVv._3WgR56k47x")).click();
        //driver.findElement(By.cssSelector("a._2qvOOvezty._2x2zBaVN-3._3kgUl_l6nB")).click();
        driver.findElement(By.cssSelector(".pEcbzwIiNV:nth-child(1) div")).click();
        //развернуть весь список
        driver.findElement(By.cssSelector("div .b_gLQFKEDc_p .b_245NbFgwl7.b_3vHNBbWfR5 span")).click();
        //кликнуть по мобильным телефонам
        driver.findElement(By.cssSelector("div .b_gLQFKEDc_p .b_3vcmcivINd .b_2OcFObA-cH a")).click();
        //Раскрываем список с производителями, что бы выбрать HUAWEI
        driver.findElement(By.cssSelector(".b_3M-BxXXLT-")).click();
        // кликаем по чекбоксу  HUAWEI
        driver.findElement(By.cssSelector(".b_ozkTEFGEZz:nth-child(6) .b_3HTZJridbm.b_39u9B5r5gw:last-child .b_FFDvPT4vH6")).click();
//===================================================
// Второй вариант клика на чекбокс который не работает как не заставляй
//        //ввод в поиск HUAWEI
//        driver.findElement(By.cssSelector(".b_2rWdZSWQdz.b_nkiJ02woLW:nth-child(4) input")).sendKeys("HUAWEI");
//        // Ждем в цикле когда соответсвие текста HUAWEI у чекбокса
//        while (true){
//            String text = driver.findElement(By.cssSelector(".b_2rWdZSWQdz.b_nkiJ02woLW:nth-child(4) span.b_1LZT0xNcJk")).getText();
//            //System.out.println(text);
//            if (text.equals("HUAWEI")) {
//
//                //Кликаем чекбокс HUAWEI
//                driver.findElement(By.cssSelector(".b_2rWdZSWQdz.b_nkiJ02woLW:nth-child(4) span.b_FFDvPT4vH6")).click();
//                break;
//            }
//        }
//===================================================

        //отслеживаем появление вспывающей таблички о Найденом товаре
        wait.until(visibilityOf(driver.findElement(By.cssSelector(".b_3l-uEDOaBN.b_20Jv_9PW6N.b_3HJsMt3YC_.b_W-B6JRTjJH")))).click();
        //считываем в массив таблицу выбранных телефонов HUAWEI
        List<WebElement> list = driver.findElements(By.cssSelector(".b_lS7Xz3hU_W span.b_3l-uEDOaBN.b_20Jv_9PW6N.b_3HJsMt3YC_.b_QDV8hKAp1G"));
        //Проверяем выборку что бы все были только HUAWEI
        for (WebElement modelPhone : list) {
            System.out.println(modelPhone.getText());
            assertTrue(modelPhone.getText().contains("HUAWEI"));

        }

    }

}
