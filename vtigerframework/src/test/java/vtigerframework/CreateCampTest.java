package vtigerframework;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.generic.lib.BaseClass;
import com.vtiger.objectRepository.CampaignClass;
import com.vtiger.objectRepository.CampaignInfoPageClass;
import com.vtiger.objectRepository.CreateNewCampaignPageClass;
import com.vtiger.objectRepository.HomePageClass;

public class CreateCampTest extends BaseClass {

	@Test
	public void CreateCampaign () throws IOException
	{
		HomePageClass hp = PageFactory.initElements(driver, HomePageClass.class);
		CampaignClass cp = PageFactory.initElements(driver, CampaignClass.class);
		CreateNewCampaignPageClass cncp = PageFactory.initElements(driver, CreateNewCampaignPageClass.class);
		CampaignInfoPageClass cip = PageFactory.initElements(driver, CampaignInfoPageClass.class);
		wlib.moveMousePointer(hp.getMoredd());
		hp.getCampaignLink().click();
		cp.getCreateCampImg().click();
		cncp.getCampaignNameTxtBox().sendKeys(data.fetchDataFromExcel("Sheet1", 0, 0));
		cncp.getSaveBtn().click();
		String actMsg = cip.getSuccessMsg().getText();
		String expMSg = data.fetchDataFromExcel("Sheet1", 0, 1);
		boolean flag = actMsg.contains(expMSg);
		Assert.assertTrue(flag);
		Reporter.log("campaign createSuccessfully",true);
				
	}
}
