package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TechGlobalPaginationPage extends TechGlobalBasePage{
    public TechGlobalPaginationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
@FindBy(id = "main_heading")
    public WebElement mainHeading;
@FindBy(id = "sub_heading")
    public WebElement subHeading;
@FindBy(id = "content")
    public WebElement pageContent;
@FindBy(id = "previous")
    public WebElement previousButton;
@FindBy(id = "next")
    public WebElement nextButton;
@FindBy(css = "div[class*='pagBodyData'] p")
    public List<WebElement> countryInfo;
@FindBy (css = "img[class='city_image']")
    public WebElement cityImage;

}
