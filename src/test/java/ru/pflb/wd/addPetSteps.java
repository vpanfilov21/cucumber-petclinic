package ru.pflb.wd;

import cucumber.api.PendingException;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.openqa.selenium.firefox.FirefoxDriver.PROFILE;

public class addPetSteps {

    private WebDriver driver;
    //final String surname = "Black";

    private Map<String, String> aliasMap = new HashMap<>();

    @Пусть("^запущен браузер Firefox$")
    public void runFirefox() throws Throwable {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        FirefoxProfile profile = new FirefoxProfile();
        File firebug = new File(FirefoxDriver.class.getResource("/firebug-1.12.7-fx.xpi").toURI());
        File firepath = new File(FirefoxDriver.class.getResource("/firepath-0.9.7-fx.xpi").toURI());
        profile.addExtension(firebug);
        profile.addExtension(firepath);
        profile.setPreference("extensions.firebug.showFirstRunPage", false);
        capabilities.setCapability(PROFILE, profile);
        driver = new FirefoxDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        throw new PendingException();
    }

    @Пусть("^введен адрес \"([^\"]*)\"$")
    public void getURL(String url) throws Throwable {
        driver.get(url);
        throw new PendingException();
    }

    @Пусть("^произведен клик по меню \"([^\"]*)\"$")
    public void clickMenu(String name) throws Throwable {
        driver.findElement(By.xpath("//a[@title='" + name + "']")).click();
        throw new PendingException();
    }

    @Пусть("^в поле \"([^\"]*)\" введено \"([^\"]*)\"$")
    public void putBlack(String arg1, String surname) throws Throwable {
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(surname);
        throw new PendingException();
    }

    @Пусть("^нажать кнопку, начинающуюся с \"([^\"]*)\"$")
    public void clickButton(String caption) throws Throwable {
        driver.findElement(By.xpath("//*[self::a or self::button][starts-with(text(),'" + caption + "')]")).click();
        throw new PendingException();
    }

    @Пусть("^нажать кнопку, содержащую \"([^\"]*)\"$")
    public void clickContainsButton(String caption) throws Throwable {
        driver.findElement(By.xpath("//*[self::a or self::button][contains(text(),'" + caption + "')]")).click();
        throw new PendingException();
    }

    @Пусть("^сгенерировать \"([^\"]*)\" питомца длинной от (\\d+) до (\\d+)$")
    public void generate(String name, int baseLength, int randLength) throws Throwable {
        String newPetName = capitalize(randomAlphabetic(baseLength + new Random().nextInt(randLength)).toLowerCase());
        aliasMap.put(name,newPetName);
        throw new PendingException();
    }

    @Пусть("^ввести в поле \"([^\"]*)\" имя животного$")
    public void inputPetName(String id) throws Throwable {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(aliasMap.get("имя"));
        throw new PendingException();
    }

    @Пусть("^сгенерировать дату рождения питомца$")
    public void genBirthDate() throws Throwable {
        // генерация даты рождения - 2 недели назад
        LocalDate birthDate = LocalDate.now().minusWeeks(2);

        // ввод даты рождения животного в поле Birth Date
        driver.findElement(By.xpath("//input[@id='birthDate']")).sendKeys(
                birthDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        throw new PendingException();
    }

    @Пусть("^выбрать тип животного как \"([^\"]*)\"$")
    public void selectPetType(String type) throws Throwable {
        new Select(driver.findElement(By.xpath("//select[@id='type']"))).selectByVisibleText(type);
        throw new PendingException();
    }

}
