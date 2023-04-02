
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


// modyfikatory dostępu: public, private, protected u Java
public class UltimateQATest extends PageSetup {


    // zwracanie z funkcji: jakis typ, void - nic nie zwraca
    @Test
    public void testOne() {
        WebElement buttonUsingID = driver.findElement(By.id("idExample"));
        buttonUsingID.click();
        WebElement buttonSuccesText = driver.findElement(By.className("entry-title"));

        Assertions.assertEquals("Button success", buttonSuccesText.getText());
        // driver.findElement(By.id("idExample"));
    }
    //dopisać przypadki testowe na button using ClassName and Name

    @Test
    public void testTwo() throws InterruptedException {
        // sposoby szukania elementów przez Selenium: xpath, className, id, selektory CSS
        WebElement nameInput = driver.findElement(By.id("et_pb_contact_name_0"));
        nameInput.sendKeys("Tester");

        WebElement emailInput = driver.findElement(By.id("et_pb_contact_email_0"));
        emailInput.sendKeys("tester@tester.com");

        Thread.sleep(200);

        //waity w Selenium: implicit wait, explicit wait, fluent wait i Thread.sleep ()
        WebElement emailMebutton = driver.findElement(By.name("et_builder_submit_button"));
        emailMebutton.click();
        Thread.sleep(200);

        // ogólna postać xpath: //*[]
        // odbijanie się od elementów: //*[@class='']/p      / - jeden poziom   //-1 poziom i więcej
        WebElement thanksText = driver.findElement(By.xpath("//div[@class='et-pb-contact-message']/p"));
        Assertions.assertEquals("Thanks for contacting us", thanksText.getText());
    }

    //assertTrue(webElement.isDisplayed)
    //assertTrue(webElement.isSelected)
    @Test
    public void testThree() {
        //różnica pomiędzy List, a Array List
        List<String> listOfcars = new ArrayList<>();
        // skrót Ctrl+D - kopiowanie linii
        listOfcars.add("volvo");
        listOfcars.add("saab");
        listOfcars.add("opel");
        listOfcars.add("audi");
        // xpath wyszukiwanie po tekscie: //div[text()='Select an option an validate that it is selected']
        WebElement dropdown = driver.findElement(By.xpath("//div[text()='Select an option and validate that it is selected']"));

        for(int i=0; i<listOfcars.size(); i++) {
            dropdown.click();

            WebElement dropdownOption = driver.findElement(By.xpath("//option[@value='" + listOfcars.get(i) + "']"));
            dropdownOption.click();
            //import static Assertions
            Assertions.assertTrue(dropdownOption.isSelected());
            Assertions.assertEquals(listOfcars.get(i), dropdownOption.getText().toLowerCase());
        }
    }
}