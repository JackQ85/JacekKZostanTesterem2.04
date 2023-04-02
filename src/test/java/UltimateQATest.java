
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;


// modyfikatory dostępu: public, private, protected u Java
public class UltimateQATest extends PageSetup{


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
}