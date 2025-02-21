import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

def driver = DriverFactory.getWebDriver()

WebUI.callTestCase(findTestCase('Test Cases/Login/LoginCommon'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementVisible(findTestObject('Trang chủ/userName'), 20, FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Quản lý tài khoản merchant/Quản lý danh sách tài khoản/CustomFunctions Deposit'), [:], FailureHandling.STOP_ON_FAILURE)

WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), 20)

WebElement userCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GlobalVariable.xpathUserCode)))
println(userCode.getText())
wait.until(ExpectedConditions.elementToBeClickable(By.xpath(GlobalVariable.xpathBtnAccount)))click()
WebElement searchTextbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(GlobalVariable.xpathSearchTextbox)))
searchTextbox.sendKeys('dannt11')
driver.findElement(By.xpath(GlobalVariable.xpathDannt11)).click()
driver.findElement(By.xpath(GlobalVariable.xpathBtnSearch)).click()
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GlobalVariable.xpathAccountName)))
Assert.assertEquals(driver.findElement(By.xpath(GlobalVariable.xpathAccountName)).getText(), GlobalVariable.username)
driver.findElement(By.xpath(GlobalVariable.xpathBtnDeposit)).click()
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GlobalVariable.xpathTextAccount)))
driver.findElement(By.xpath(GlobalVariable.xpathChonVi)).click()
driver.findElement(By.xpath(GlobalVariable.xpathThuHo3)).click()
driver.findElement(By.xpath(GlobalVariable.xpathDay)).click()
//driver.findElement(By.xpath(GlobalVariable.xpathHomQua)).click()
driver.findElement(By.xpath(GlobalVariable.xpathHomNay)).click()
driver.findElement(By.xpath(GlobalVariable.xpathBtnContinue)).click()
WebElement popupDS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GlobalVariable.xpathXacNhanKiDS)))
Assert.assertEquals(popupDS.getText(), "Đã tồn tại kỳ đối soát trước đó, Bạn có chắc chắn muốn tiếp tục thực hiện giao dịch?")
driver.findElement(By.xpath(GlobalVariable.xpathBtnHuy)).click()

String TTGD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GlobalVariable.xpathTitle))).getText()
Assert.assertEquals(TTGD, "NẠP TIỀN")