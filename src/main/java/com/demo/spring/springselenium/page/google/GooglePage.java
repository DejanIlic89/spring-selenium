package com.demo.spring.springselenium.page.google;

import com.demo.spring.springselenium.kelvin.annotation.Page;
import com.demo.spring.springselenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends Base {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResultComponent searchResultComponent;

    @Value("${application.url}")
    private String url;

    public void goTo() {
        this.driver.get(url);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResultComponent getSearchResultComponent() {
        return searchResultComponent;
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }

    public void close() {
        this.driver.quit();
    }
}
