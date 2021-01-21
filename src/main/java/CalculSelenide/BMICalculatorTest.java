package CalculSelenide;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BMICalculatorTest {

    @Test
    public void calcTest1() {
        open("https://healthunify.com/bmicalculator/");
        $(By.name("wg")).sendKeys("76");
        $(By.name("ht")).sendKeys("175");
        $(By.name("cc")).click();
        String result = $(By.name("desc")).getAttribute("value");
        Assert.assertEquals(result, "Your category is Normal");
    }

    @Test
    public void calcTest2() {
        open("https://healthunify.com/bmicalculator/");
        $(By.name("wg")).sendKeys("77");
        $(By.name("ht")).sendKeys("175");
        $(By.name("cc")).click();
        String result = $(By.name("desc")).getAttribute("value");
        Assert.assertEquals(result, "Your category is Overweight");

    }

    @Test
    public void calcTest3() {
        open("https://healthunify.com/bmicalculator/");
        $(By.name("wg")).sendKeys("92");
        $(By.name("ht")).sendKeys("175");
        $(By.name("cc")).click();
        String result = $(By.name("desc")).getAttribute("value");
        Assert.assertEquals(result, "Your category is Obese");

    }

    @Test
    public void calcTest4() {
        open("https://healthunify.com/bmicalculator/");
        $(By.name("wg")).sendKeys("10");//проверяла ограничение по весу в кг
        $(By.name("ht")).sendKeys("175");
        $(By.name("cc")).click();
        String result = $(By.name("desc")).getAttribute("value");
        Assert.assertEquals(result, "Your category is Starvation");
    }

    @Test
    public void calcTest5() {
        open("https://healthunify.com/bmicalculator/");
        $(By.name("wg")).sendKeys("11");//проверяла ограничение по весу в кг
        $(By.name("ht")).sendKeys("175");
        $(By.name("cc")).click();
        String result = $(By.name("desc")).getAttribute("value");
        Assert.assertEquals(result, "Your category is Starvation");
    }

    @Test
    public void calcTest6() {
        open("https://healthunify.com/bmicalculator/");
        $(By.name("wg")).sendKeys("12");
        $(By.name("ht")).sendKeys("33");//проверяла ограничение по росту в см
        $(By.name("cc")).click();
        String result = $(By.name("desc")).getAttribute("value");
        Assert.assertEquals(result, "Your category is Obese");
    }

    @Test
    public void calcTest7() {
        open("https://healthunify.com/bmicalculator/");
        $(By.name("wg")).sendKeys("12");
        $(By.name("ht")).sendKeys("34");//проверяла ограничение по росту в см
        $(By.name("cc")).click();
        String result = $(By.name("desc")).getAttribute("value");
        Assert.assertEquals(result, "Your category is Obese");
    }

    @Test
    public void calcTest8() {
        open("https://healthunify.com/bmicalculator/");
        $(By.name("wg")).sendKeys("50");
        Select dropdown = new Select($(By.name("opt2")));
        dropdown.selectByVisibleText("4′");
        Select dropdown2 = new Select($(By.name("opt3")));
        dropdown2.selectByVisibleText("11″");
        $(By.name("cc")).click();
        String result = $(By.name("desc")).getAttribute("value");
        Assert.assertEquals(result, "Your category is Normal");
    }
}
