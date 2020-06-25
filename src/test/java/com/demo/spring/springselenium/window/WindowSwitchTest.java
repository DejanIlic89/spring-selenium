package com.demo.spring.springselenium.window;

import com.demo.spring.springselenium.SpringBaseTestNGTest;
import com.demo.spring.springselenium.kelvin.annotation.LazyAutowired;
import com.demo.spring.springselenium.page.window.MainPage;
import com.demo.spring.springselenium.page.window.PageA;
import com.demo.spring.springselenium.page.window.PageB;
import com.demo.spring.springselenium.page.window.PageC;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@TestPropertySource(properties = "browser=chrome")
public class WindowSwitchTest extends SpringBaseTestNGTest {

    @LazyAutowired
    private MainPage mainPage;

    @LazyAutowired
    private PageA pageA;

    @LazyAutowired
    private PageB pageB;

    @LazyAutowired
    private PageC pageC;

//    @LazyAutowired
//    private WindowSwitchService switchService;

    @BeforeClass
    public void setup() {
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.launchAllWindows();
    }

    @Test(dataProvider = "getData")
    public void switchTest(int index) {
        this.pageA.addToArea(index + "\n");
        this.pageB.addToArea((index * 2) + "\n");
        this.pageC.addToArea((index * 3) + "\n");
    }

    @DataProvider
    public Object[] getData() {
        return new Object[] {
                3,
                4,
                1,
                5,
                6,
                2
        };
    }

//    @Test
//    public void switchTest() {
//        this.switchService.switchByTitle("Page A");
//        this.pageA.addToArea("Hi Page A");
//        this.switchService.switchByIndex(2);
//        this.pageB.addToArea("Hello Page B");
//    }

}
