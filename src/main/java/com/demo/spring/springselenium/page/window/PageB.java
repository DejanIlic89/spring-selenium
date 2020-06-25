package com.demo.spring.springselenium.page.window;

import com.demo.spring.springselenium.kelvin.annotation.Window;
import com.demo.spring.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page B")
public class PageB extends Base {

    @FindBy(id = "area")
    private WebElement textArea;

    public void addToArea(final String msg) {
        this.textArea.sendKeys(msg);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(driver1 -> this.textArea.isDisplayed());
    }
}
