package com.demo.spring.springselenium.resourcetest;

import com.demo.spring.springselenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceTest extends SpringBaseTestNGTest {

    @Value("classpath:data/testurldata.csv")
    private Resource resource;

    @Value("${screenshot.path}")
    private Path path;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test(dataProvider = "getData")
    public void resourceTest(String url, String saveAs) throws IOException {
        FileCopyUtils.copy(
                resourceLoader.getResource(url).getInputStream(),
                Files.newOutputStream(path.resolve(saveAs))
        );
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return Files.readAllLines(resource.getFile().toPath())
                .stream()
                .map(s -> s.split(","))
                .toArray(Object[][]::new);
    }

    ////////////////////////////////////////////////////////////////////////

/*//    @Value("file:/home/ubuntu/projects/spring-selenium/src/test/resources/data/testdata.csv")
//    @Value("classpath:data/testdata.csv")
    @Value("https://www.w3.org/TR/PNG/iso_8859-1.txt")
//    @Value("https://www.google.com")
    private Resource resource;

    @Value("${screenshot.path}/some.txt")
    private Path path;

    @Test
    public void resourceTest() throws IOException {
//        Files.readAllLines(resource.getFile().toPath())
//                .forEach(System.out::println);

        // Read larger files
//        InputStreamReader fr = new InputStreamReader(resource.getInputStream());
//        BufferedReader br = new BufferedReader(fr);
//        while ((br.readLine()) != null) {
//            System.out.println(br.readLine());
//        }

        //copy files
        FileCopyUtils.copy(resource.getInputStream(), Files.newOutputStream(path));
    }*/

}
