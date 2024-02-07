import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login')

CustomKeywords.'essentials.User.Login'(user)
WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Withdrawl'))

WebUI.setText(findTestObject('Object Repository/Page_XYZ Bank/input_form-control ng-untouched ng-dirty ng_0a70e2'), withdrawal)
WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Withdraw'))
WebUI.takeScreenshot()

TestObject tObj = new TestObject()

CustomKeywords.'essentials.Checker.CheckValidity'(is_sufficent)

CustomKeywords.'essentials.User.Logout'()
WebUI.takeScreenshot()

WebUI.closeBrowser()