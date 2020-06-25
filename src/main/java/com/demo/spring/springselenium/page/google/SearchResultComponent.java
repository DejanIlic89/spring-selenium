package com.demo.spring.springselenium.page.google;

import com.demo.spring.springselenium.kelvin.annotation.PageFragment;
import com.demo.spring.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResultComponent extends Base {

    @FindBy(css = "div.rc")
    private List<WebElement> results;

    public int getCount() {
        return this.results.size();
    }

    @Override
    public boolean isAt() {
        return this.wait.until(driver1 -> !this.results.isEmpty());
    }
}
