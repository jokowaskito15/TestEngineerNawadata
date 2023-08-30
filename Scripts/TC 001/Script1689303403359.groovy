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
import java.awt.Robot
import java.awt.event.KeyEvent
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

Robot robot = new Robot();
WebUI.openBrowser('https://ndsrndserver.southeastasia.cloudapp.azure.com/NFQA_Test/Login.aspx?ReturnUrl=%2fNFQA_Test%2fDefault.aspx')
WebUI.maximizeWindow()
robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_0);
robot.keyRelease(KeyEvent.VK_CONTROL);
robot.keyRelease(KeyEvent.VK_0);

TestData excelData = findTestData('Data Files/Input New Data')
String userName = excelData.getValue('Username' , 1)
String password = excelData.getValue('Password' , 1)
String id = excelData.getValue('ID' , 1)

WebUI.setText(findTestObject('Object Repository/01 Utilities/01 txtLogin'), userName)
WebUI.setText(findTestObject('Object Repository/01 Utilities/02 txtPassword'), password)
WebUI.click(findTestObject('Object Repository/01 Utilities/03 btnLogin'))
WebUI.waitForPageLoad(500)
WebUI.doubleClick(findTestObject('Object Repository/02 Home/01 menuTestEngineer'))
WebUI.doubleClick(findTestObject('Object Repository/02 Home/02 menuTransaction'))
WebUI.click(findTestObject('Object Repository/02 Home/03 menuView'))
WebUI.switchToFrame(findTestObject('Object Repository/03 New Record/02 iframe'), 0)
WebUI.click(findTestObject('Object Repository/03 New Record/01 btnAddNewRecord'))
def nomorID = id + RandomStringUtils.randomNumeric(4)
WebUI.setText(findTestObject('Object Repository/03 New Record/03 txtId'), nomorID)