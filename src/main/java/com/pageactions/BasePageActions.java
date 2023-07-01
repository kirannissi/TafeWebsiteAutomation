package com.pageactions;

import com.helpers.ConfigReader;
import com.pageobjects.BasePage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class BasePageActions {

    private final Logger logger = LoggerFactory.getLogger(BasePageActions.class);
    public static Map<String, String> testData = new HashMap<>();
    public WebDriver driver;
    private final ConfigReader configReader = new ConfigReader();
    public String excelPath = "src/test/resources/testdata/WebShopTestData.xlsx";
    Properties properties = configReader.init_prop();

    public BasePageActions(WebDriver driver) {
        this.driver = driver;
    }

    public void customLogger(String level, String comment) {
        level = level.toLowerCase();
        switch (level) {
            case "trace":
                logger.trace(comment);
                break;
            case "debug":
                logger.debug(comment);
                break;
            case "warn":
                logger.warn(comment);
                break;
            case "error":
                logger.error(comment);
                break;
            default:
                logger.info(comment);
        }
    }

    public void customWait(int seconds, By locator) {
        WebDriverWait customDriverWait = new WebDriverWait(driver, seconds);
        try {
            customDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void click(By locator) {
        if (isDisplayed(locator)) {
            WebElement element = driver.findElement(locator);
            element.click();
            customLogger("info", element + " clicked successfully");
        } else {
            customLogger("error", "Element is not displayed. So not able to enter: ");
        }


    }

    public void jsForceClick(By locator) {

        if (isDisplayed(locator)) {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", element);
            customLogger("info", "Force clicking --> " + element + "");
        } else {
            customLogger("error", "Element is not displayed. So not able to enter: ");
        }


    }

    public void clearAndSetField(By locator, String text) {

        if (isDisplayed(locator)) {
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
            customLogger("info", text + " was entered successfully");
        } else {
            customLogger("error", "Web element is not displayed. So not able to enter: " + text);
        }
    }

    public boolean isDisplayed(By locator) {
        customWait(20, locator);
        List<WebElement> element = driver.findElements(locator);
        if (element.isEmpty()) {
            customLogger("info", "Web Element is not visible");
            return false;
        } else {
            return true;
        }
    }

    public void selectOptionFromDropdown(By locator, String text) {
        Select option;
        if (isDisplayed(locator)) {
            WebElement element = driver.findElement(locator);
            option = new Select(element);
            option.selectByVisibleText(text);

            customLogger("info", text + " option was selected successfully");
        } else {
            customLogger("error", "Web element is not displayed. So not able to select: " + text);
        }
    }

    public void pressKeyboardButton(By locator, Keys key) {

        if (isDisplayed(locator)) {
            WebElement element = driver.findElement(locator);
            element.sendKeys(key);

            customLogger("info", key + " is clicked successfully");
        } else {
            customLogger("error", "Web element is not displayed. So not able to click: " + key);
        }
    }

    /*
     * first column of the Excel sheet should be test case id
     *
     * @sheetName - name of the sheet inside Excel
     * @prefix - prefix before values to push in test data
     * @testCaseID - test case id of the data from excel
     * */

    public void captureRowFromExcelAndMergeTestDataWithPrefix(String sheetName, String testCaseID, String prefix) throws IOException {

        HashMap<String, String> excelRowData = new HashMap<>();

        FileInputStream inputStream = new FileInputStream(new File(excelPath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);


        if (getRowByTestCaseId(sheet, testCaseID) != null) {
            Row finalRow = getRowByTestCaseId(sheet, testCaseID);

            Iterator<Cell> finalRowCells = finalRow.cellIterator();
            while (finalRowCells.hasNext()) {

                Cell cell = finalRowCells.next();
                String columnName = sheet.getRow(0).getCell(cell.getColumnIndex()).getStringCellValue();

                String cellValue = new String();
                CellType type = cell.getCellType();

                if (type == CellType.NUMERIC) {
                    cellValue = cell.getNumericCellValue() + "";
                } else if (type == CellType.STRING) {
                    cellValue = cell.getStringCellValue();
                } else if (type == CellType.BOOLEAN) {
                    cellValue = cell.getBooleanCellValue() + "";
                }

                excelRowData.put(prefix + "_" + columnName, cellValue);

            }
            testData.putAll(excelRowData);

        } else {
            customLogger("error", "Unable to get the row for test case Id: " + testCaseID);
        }
    }

    public Row getRowByTestCaseId(Sheet sheet, String testCaseID) {
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Cell firstCell = nextRow.getCell(0);
            if (testCaseID.equals(firstCell.getStringCellValue())) {
                return nextRow;
            }
        }
        return null;
    }
    public WebElement findElement(By locator){
        WebElement element = null;
        if (isDisplayed(locator)) {
            element = driver.findElement(locator);
            customLogger("info", "Element found for locator is: " + element);
        } else {
            customLogger("error", "Element not found for locator " + locator);
        }
        return element;
    }
    public List<WebElement> findElements(By locator){
        List<WebElement> elements = null;
        if (isDisplayed(locator)) {
            elements = driver.findElements(locator);
        } else {
            customLogger("error", "Multiple Elements not found for locator " + locator);
        }
        return elements;
    }
}




