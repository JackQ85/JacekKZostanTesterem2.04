
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



}
