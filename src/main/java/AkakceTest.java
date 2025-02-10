import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;

public class AkakceTest {
    public static void main(String[] args) throws InterruptedException {

        // ChromeDriver
        WebDriverManager.chromedriver().setup();

        // WebDriver başlat
        WebDriver driver = new ChromeDriver();

        // Tarayıcıyı tam ekran yap
        driver.manage().window().maximize();

        // Akakçe'ye git
        driver.get("https://www.akakce.com/");

        // WebDriverWait kullanarak sayfa yüklenene kadar bekle
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle

        // Giriş yap butonuna tıklayın
        WebElement girisYapButonu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#H_rl_v8 a[href='/akakcem/giris/']")));
        girisYapButonu.click();

        // 2 saniye bekle
        Thread.sleep(2000);

        // E-posta alanına yaz
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='frm_v8']//input[@id='life']")));
        emailInput.sendKeys("demir.ibrahimalper@gmail.com");

        // 1 saniye bekle
        Thread.sleep(1000);

        // Şifre alanına yaz
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='frm_v8']//input[@id='lifp']")));
        passwordInput.sendKeys("Alperdemir27");

        // 1 saniye bekle
        Thread.sleep(1000);

        // Giriş yap butonuna tıklayın
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("lfb")));
        loginButton.click();

        // 2 saniye bekle
        Thread.sleep(2000);

        // Arama çubuğunu bul ve "iphone" yaz
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.sendKeys("iphone");

        // 2 saniye bekle
        Thread.sleep(2000);

        // Enter tuşuna bas
        searchBox.submit();

        // 2 saniye bekle
        Thread.sleep(2000);

        // Ürüne git butonuna tıklayın
        WebElement uruneGitButonu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.bt_v8")));
        uruneGitButonu.click();

        // 2 saniye bekle
        Thread.sleep(2000);

        // Takip Et butonunun görünür olmasını bekleyin
        WebElement takipEtButonu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ntf_w']/span")));

        // JavaScript ile tıklama işlemi
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", takipEtButonu);

        // 2 saniye bekle
        Thread.sleep(2000);

        // Takip listem linkine tıklayın
        WebElement followListLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("H_f_v8")));
        followListLink.click();

        // Tarayıcıyı açık bırak (driver.quit() veya driver.close() kullanmıyoruz)
    }
}
