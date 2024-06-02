package actions;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import locators.ProductDetailPageLocators;
import utils.HelperClass;

public class ProductDetailPageActions {
    
  ProductDetailPageLocators productDetailLocators = null;

  public ProductDetailPageActions() {
    this.productDetailLocators= new ProductDetailPageLocators();
    PageFactory.initElements(HelperClass.getDriver(), productDetailLocators);
  }

  public void clickProductCardLink() {
    productDetailLocators.productCardLink.click();
  }

  public WebElement getProductDetail() {
    return productDetailLocators.productDetailCard;
  }

  public WebElement getAddToCartButton() {
    return productDetailLocators.addToCartButton;
  }

  public WebElement getAddToCartButtonOnesie() {
    return productDetailLocators.addToCartButtonOnesie;
  }

  public WebElement getRemoveButtonOnesie() {
    return productDetailLocators.removeButtonOnesie;
  }
  
  public void addOnesieToCart() {
    productDetailLocators.addToCartButtonOnesie.click();
  }

  public void removeOnesieToCart() {
    productDetailLocators.removeButtonOnesie.click();
  }

  public WebElement getItemCartCountBadge() {
    return productDetailLocators.itemCartCountBadge;
  }

}
