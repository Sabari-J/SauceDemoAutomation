package pages;

import org.openqa.selenium.By;

public class OrderConfirmationPage extends CheckoutInformationPage{
	
	By OrderConfirmationMsg = By.className("complete-header");

    public String getOrderConfirmationMessage() {
        return driver.findElement(OrderConfirmationMsg).getText();
    }

}
