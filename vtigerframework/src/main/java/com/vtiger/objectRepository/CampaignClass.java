package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignClass {

	@FindBy(xpath ="//img[@title='Create Campaign...']")
	private WebElement createCampImg;

	public WebElement getCreateCampImg() {
		return createCampImg;
	}

}
