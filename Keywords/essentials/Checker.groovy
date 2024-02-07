package essentials

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

public class Checker {
	@Keyword
	def CheckValidity(is_sufficent) {
		/*
		 * Check if the transaction alert is showing. If transaction succeeds,
		 * the alert should contain 'successful' string and 'Failed' if the
		 * transaction failed.
		 * */
		TestObject tObj = new TestObject()

		tObj.addProperty('xpath', ConditionType.EQUALS, GlobalVariable.error_msg_xpath)

		def feedback_msg = WebUI.getText(tObj)

		def toIntOrNull = {
			it.isInteger() ? it.toInteger() : null
		}

		if (toIntOrNull(is_sufficent)) {
			assert feedback_msg.contains('successful')
		} else {
			assert feedback_msg.contains('Failed')
		}
	}
}
