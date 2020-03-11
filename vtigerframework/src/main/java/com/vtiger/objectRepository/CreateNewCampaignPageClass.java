package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCampaignPageClass {

	@FindBy(name ="campaignname")
	private WebElement CampaignNameTxtBox;
	
	@FindBy(xpath ="//input[@value='  Save  ']")
	private WebElement SaveBtn;

	public WebElement getCampaignNameTxtBox() {
		return CampaignNameTxtBox;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

}
