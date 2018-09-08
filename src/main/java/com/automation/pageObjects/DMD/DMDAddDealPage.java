package com.automation.pageObjects.DMD;

import com.automation.Utils.WebDriverClient;
import com.automation.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DMDAddDealPage extends BasePage {
    public DMDAddDealPage(WebDriver driver) {super(driver);
    }

    public WebDriverClient webDriverClient= null;

    @FindBy(css= "#Name[name='Name']")
    private WebElement txt_Name;

    @FindBy(css= "#Description")
    private WebElement txt_Description;

    @FindBy(css= "#DealTypeId")
    private WebElement dropdown_DealType;

    @FindBy(css= "#DefaultLocalTimeZoneCode")
    private WebElement dropdown_TimeZone;

    @FindBy(css = "DealLikelihoodId")
    private WebElement dropdown_DealLikelihood;

    @FindBy(css = "#CustomAttributeData_0__Value")
    private WebElement dropdown_CustomAttribute;

    @FindBy(css= "#CalendarType[name='CalendarType']")
    private WebElement dropdown_DealCalendarType;

    @FindBy(css= "#DateRangeFirstDate-display[name]")
    private WebElement txt_StartDate;

    @FindBy(css= "#DateRangeLastDate-display[name]")
    private WebElement txt_EndDate;

    @FindBy(css= "#ProposalDueDate-display[name]")
    private WebElement txt_ProposalDueDate;

    @FindBy(css= "[name='DateRangeFirstDate'] ~ button")
    private WebElement btn_StartDatepicker;

    @FindBy(css= "[name='DateRangeLastDate'] ~ button")
    private WebElement btn_EndDatePicker;

    @FindBy(css= "[name='ProposalDueDate-display'] ~ button")
    private WebElement btn_ProposalDueDatePicker;

    @FindBy(css= "[name='AdvertiserName']")
    private WebElement txt_Advertiser;

    @FindBy(css= "[name='BuyingAgencyPathName']")
    private WebElement txt_BuyingAgencyLocation;

    @FindBy(css = "[name='AgencyPathName']")
    private WebElement txt_BillingAgencyLocation;

    @FindBy(css = "[name='Partners[0].Name']")
    private WebElement txt_Partner;

    @FindBy(xpath = "//a[@class='add-partner']")
    private WebElement lnk_AddParter;

    @FindBy(css= "#CurrencyCode")
    private WebElement dropdown_Currency;

    @FindBy(css= "#RevenueTypeId")
    private WebElement dropdown_RevenueType;

    @FindBy(css= "[name='BillingCycleValue']")
    private WebElement dropdown_BillingCycle;

    @FindBy(css= "#IsBillingCashInAdvance[name='IsBillingCashInAdvance']")
    private WebElement chkbox_RequireCashInAdvance;

    @FindBy(css= "[name='BillableRevenueValue']")
    private WebElement dropdown_BillingRevenue;

    @FindBy(css= "#PaymentTermValue[name='PaymentTermValue']")
    private WebElement dropdown_PaymentTerms;

    @FindBy(xpath= "//input[@name='BillingAddressLine1']" )
    private WebElement txt_BillinAddress1;

    @FindBy(xpath= "//input[@name='BillingAddressLine2']")
    private WebElement txt_BillinAddress2;

    @FindBy(xpath= "//input[@name='BillingAddressLine3']")
    private WebElement txt_BillinAddress3;

    @FindBy(xpath= "//input[@name='BillingAddressCity']")
    private WebElement txt_BillingCity;

    @FindBy(xpath= "//input[@name='BillingAddressState']")
    private WebElement txt_BilllingState_Province;

    @FindBy(css= "#BillingAddressPostalCode[name]")
    private WebElement txt_BillingPostalCode;

    @FindBy(css= "#BillingAddressCountry[name]")
    private WebElement txt_BillingCountry;

    @FindBy(css= "#RevenueSplits_0__LineItems_0__RevenueOwnerId")
    private WebElement dropdown_RevenueSplitsOwner;

    @FindBy(css= ".btn-group>a:nth-child(2)>span")
    private WebElement btn_AddRevenueSplitsOwner;

    @FindBy(css= "[name='StakeHolders[0].UserName']")
    private WebElement txt_SalesPlanner;

    @FindBy(css= "[name='StakeHolders[1].UserName']")
    private WebElement txt_Trafficker;

    @FindBy(id= "DealIds_0_")
    private WebElement txt_ReferencedDeals;

    @FindBy(css= "[value='Save']")
    private WebElement btn_Save;

    @FindBy(css= ".btn-cancel")
    private WebElement btn_Cancel;

    public void CreateNewDMDDeal() throws Exception {
        try{
            webDriverClient.ClearTextType(txt_Name,"Manpreet DMD Automation deal");
        } catch(Exception e){
            throw new Exception("Could not enter name for deal",e);
        }
        try{
            webDriverClient.ClearTextType(txt_Description,"Test Description");
        } catch (Exception e){
            throw new Exception("Could not enter description for deal",e);
        }
        try {
            webDriverClient.SelectByVisibleText(dropdown_DealType,"National");
        }catch (Exception e){
            throw new Exception("Could not select Deal type for deal",e);
        }
        try {
            webDriverClient.SelectByVisibleText(dropdown_TimeZone,"(UTC-11:00) Coordinated Universal Time-11");
        } catch (Exception e){
            throw new Exception("Could not select Time Zone for deal",e);
        }
        try {
            webDriverClient.SelectByVisibleText(dropdown_DealLikelihood,"88% - Most Likely");
        }catch (Exception e){
            throw new Exception("Could not select Deal likelihood for deal",e);
        }
        try {
            webDriverClient.SelectByVisibleText(dropdown_DealCalendarType,"Gregorian");
        }catch (Exception e){
            throw new Exception("Could not select Deal Calendar Type for deal",e);
        }
        try {
            webDriverClient.ClearTextType(txt_StartDate,"01/01/2018 12:00:00 AM");
        }catch (Exception e){
            throw new Exception("Could not enter Start Date for deal",e);
        }
        try {
            webDriverClient.ClearTextType(txt_EndDate,"12/30/2018 11:59:59 PM");
        }catch (Exception e){
            throw new Exception("Could not enter End Date for deal",e);
        }
        try {
            webDriverClient.ClearTextType(txt_ProposalDueDate,"12/30/2018 11:59:59 PM");
        }catch (Exception e){
            throw new Exception("Could not enter Proposal Due Date for deal",e);
        }
        try {
            webDriverClient.ClearTextType(txt_Advertiser,"Bose");
        }catch (Exception e){
            throw new Exception("Could not enter Advertiser for deal",e);
        }
        try {
            webDriverClient.SelectByVisibleText(dropdown_Currency,"Canadian Dollar (CAD)");
        }catch (Exception e){
            throw new Exception("Could not select Currency for deal",e);
        }
        try {
            webDriverClient.SelectByVisibleText(dropdown_RevenueType,"Cash");
        }catch (Exception e){
            throw new Exception("Could not select Revenue Type for deal",e);
        }
        try {
            webDriverClient.SelectByVisibleText(dropdown_BillingCycle,"Weekly");
        }catch (Exception e){
            throw new Exception("Could not select Billing Cycle for deal",e);
        }
        try {
            webDriverClient.Click(chkbox_RequireCashInAdvance);
        }catch (Exception e){
            throw new Exception("Could not check box Cash in Advance for deal",e);
        }
        try {
            webDriverClient.SelectByVisibleText(dropdown_BillingRevenue,"CappedActualsWithRollover");
        }catch (Exception e){
            throw new Exception("Could not select Billing Revenue for deal");
        }
        try {
            webDriverClient.SelectByVisibleText(dropdown_PaymentTerms,"Net 30");
        }catch (Exception e){
            throw new Exception("Could not select Payment Terms for deal");
        }
        try {
            webDriverClient.SelectByVisibleText(dropdown_RevenueSplitsOwner,"Sundara Jeyamanoharan");
        }catch (Exception e){
            throw new Exception("Could not select Revenue Splits owner for deal");
        }
        try {
            webDriverClient.SelectByVisibleText(txt_SalesPlanner,"Manpreet Singh");
        }catch (Exception e){
            throw new Exception("Could not enter Sales Planner for deal");
        }
        try {
            webDriverClient.Click(btn_Save);
        }catch (Exception e){
            throw new Exception("Could not click on Save deal");
        }

    }

}
