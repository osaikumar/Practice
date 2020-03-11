package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageClass {

	@FindBy(linkText ="More")
	private WebElement moredd;
	
	@FindBy(linkText ="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(xpath ="//span[text()=' Administrator']/../following-sibling::td")
	private WebElement logoutBtn;
	
	@FindBy(linkText ="Sign Out")
	private WebElement signoutLink;

	public WebElement getMoredd() {
		return moredd;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
}
