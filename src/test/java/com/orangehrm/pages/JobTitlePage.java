package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class JobTitlePage extends BaseClass {
	
	@FindBy(css="li#menu_admin_viewAdminModule")
    public WebElement admin;
	
	@FindBy(css="li#menu_admin_Job")
    public WebElement job;
	
	@FindBy(css="a#menu_admin_viewJobTitleList")
    public WebElement jobTitle;
	
	@FindBy(xpath="//i[text()='add']")
    public WebElement addJobTitle;
	
	@FindBy(css="input#jobTitleName")
    public WebElement jobTitleField;
	
	@FindBy(css="*#jobDescription")
    public WebElement jobDescription;
    
    @FindBy(xpath="//a[text()='Save']")
    public WebElement save;
    
    @FindBy(css="input#jobSpecification")
    public WebElement jobSpecification;
  
  @FindBy(xpath = "//table[@class='highlight bordered']/tbody/tr")
   public List<WebElement> jobTitleTableRows;

	public JobTitlePage() {
		PageFactory.initElements(driver, this);
	} 

}
