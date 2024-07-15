package testdatareader;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import extentreport.ExtentReportsManager;
import extentreport.ExtentTestManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import testRunnerFile.ExtentReportGenerationClass;
import userdefinedExceptions.ColumnNameIsNotFound;
import userdefinedExceptions.TestCaseOrFlagNotFoundException;
import userdefinedExceptions.TestCasenotFoundInOuputDataSheet;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class TestDataReader extends ExtentReportGenerationClass {
    Properties prop=new Properties();
    Properties prop2=new Properties();
    String workbookname,sheetname;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFCell cellval,topCellValue;
    String data;
    String topRowData;
    Map<Object,Map<String,String>> datatable= new HashMap<Object,Map<String,String>>();
    Map<String,String> datatable1= new HashMap<String,String>();
    int matchingrow;

    public XSSFWorkbook getWb() {
        return wb;
    }

    public void setWb(XSSFWorkbook wb) {
        this.wb = wb;
    }

    ExtentReportGenerationClass ergc;
//    public static void main(String args[]){
//        TestDataReader tdr=new TestDataReader();
//        tdr.readTestData();
//    }

    public TestDataReader() {

    }




    public Map<String,String> readTestData(String testCaseName) throws TestCaseOrFlagNotFoundException{
        try {

//            test=ExtentReportsManager.getInstance(getExtent()).getExtents().createTest(testCaseName);
//            ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("Thread ID is "+Thread.currentThread().getId()));
            return checkTestDataFile(testCaseName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized Map<String,String> checkTestDataFile(String testCaseName) throws IOException,TestCaseOrFlagNotFoundException {
        prop.load(new FileInputStream( new File(System.getProperty("user.dir")+"\\applicationproperties\\"+"testconfiguration.properties")));
        workbookname=prop.getProperty("workbookname");
        sheetname=prop.getProperty("testsheetname");
        File file=new File(System.getProperty("user.dir")+"\\TestDataSheet\\"+workbookname);
        try {
            wb= new XSSFWorkbook(file);
            sheet=wb.getSheet(sheetname);
            setWb(wb);
            int noofrows=sheet.getLastRowNum();
            int colnumber=sheet.getRow(noofrows).getPhysicalNumberOfCells();
            int topRow=sheet.getTopRow();
            int topColNum=sheet.getRow(topRow).getPhysicalNumberOfCells();
            for (int i=1;i<=noofrows;i++){
                if(sheet.getRow(i).getCell(0).toString().equals(testCaseName)){  //&& sheet.getRow(i).getCell(1).toString().equals("Y")
                    matchingrow=i;
                   // ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("ThreadID matching row is "+Thread.currentThread().getId()));
                    break;
                }

            }
            if(matchingrow>=1) {

                for (int j = 0; j < colnumber; j++) {
                    cellval = sheet.getRow(matchingrow).getCell(j);
                    switch (cellval.getCellType()) {
                        case STRING:
                            data = cellval.getStringCellValue();
                            break;

                        case NUMERIC:
                            data = String.valueOf(cellval.getNumericCellValue());
                            break;

                        case FORMULA:
                            data = cellval.getCellFormula();
                            break;

                        case BOOLEAN:
                            boolean bool = cellval.getBooleanCellValue();
                            if (bool) {
                                data = "True";
                            } else {
                                data = "false";
                            }
                            break;

                        case ERROR :
                            data = cellval.getErrorCellString();
                            break;

                        case _NONE :
                            data = "";
                            break;

                        case BLANK :
                            data = "";

                        default:
                            data = null;

                    }
                    datatable1.put(sheet.getRow(0).getCell(j).getStringCellValue(), data);

                }

                wb.close();

            }
            else{
               throw new TestCaseOrFlagNotFoundException("Either Test Case Name is not matching or Flag is not set as Y");
            }
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }


        return datatable1;

    }

    public String getData(String key){
        return datatable1.get(key);
    }
    public void closeWorkBook(){
        try {
            if(getWb()!=null){
                getWb().close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  void writeToExcelSheet(String strworkbookname,String outputSheetname,String testCaseName,String outputColumn,String strData) throws IOException, InvalidFormatException {
        prop.load(new FileInputStream( new File(System.getProperty("user.dir")+"\\applicationproperties\\"+"testconfiguration.properties")));
        //workbookname=prop.getProperty("workbookname");
        sheetname=outputSheetname;
        File file=new File(System.getProperty("user.dir")+"\\TestDataSheet\\"+strworkbookname);
        try {
            wb = new XSSFWorkbook(file);
            sheet = wb.getSheet(sheetname);
            int noofrows = sheet.getLastRowNum();
            int colnumber = sheet.getRow(noofrows).getPhysicalNumberOfCells();
            int topRow = sheet.getTopRow();
            int topColNum = sheet.getRow(topRow).getPhysicalNumberOfCells();
            FileOutputStream outputStream;
            XSSFCell cell;
            int flag=0;
            int testcasenameflag=0;
            for (int i = 1; i <= noofrows; i++) {
                if (sheet.getRow(i).getCell(0).toString().equals(testCaseName)) {  //&& sheet.getRow(i).getCell(1).toString().equals("Y")
                    matchingrow = i;
                    testcasenameflag = 1;
                    // ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("ThreadID matching row is "+Thread.currentThread().getId()));
                    break;
                }
            }
                for(int j=0;j<topColNum;j++){
                    String header=sheet.getRow(0).getCell(j).toString();
                    if(header.equals(outputColumn)){
                        flag=1;
                        cell=sheet.getRow(matchingrow).createCell(j);
                        cell.setCellValue(strData);
                        try {
                            outputStream=new FileOutputStream(file,true);
                            wb.write(outputStream);
                            wb.close();
                            outputStream.close();

                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }


            if(testcasenameflag==0){
                throw new TestCasenotFoundInOuputDataSheet("test Cases is not available in OutputDataSheet");
            }
            if(flag==0){
                throw new ColumnNameIsNotFound("Column name is not available");
            }
        }catch (Exception e){
           System.out.println(e.getMessage());
        }
    }

    public  String readFromTestDataSheet(String strworkbookname,String outputSheetname,String testCaseName,String InputColumn) throws IOException, InvalidFormatException
    {
        prop.load(new FileInputStream( new File(System.getProperty("user.dir")+"\\applicationproperties\\"+"testconfiguration.properties")));
        //workbookname=prop.getProperty("workbookname");
        sheetname=outputSheetname;
        String data=null;
        File file=new File(System.getProperty("user.dir")+"\\TestDataSheet\\"+strworkbookname);
        try {
            wb = new XSSFWorkbook(file);
            sheet = wb.getSheet(sheetname);
            int noofrows = sheet.getLastRowNum();
            int colnumber = sheet.getRow(noofrows).getPhysicalNumberOfCells();
            int topRow = sheet.getTopRow();
            int topColNum = sheet.getRow(topRow).getPhysicalNumberOfCells();
            FileOutputStream outputStream;
            XSSFCell cell;
            int flag=0;
            int testcasenameflag=0;

            for (int i = 1; i <= noofrows; i++) {
                if (sheet.getRow(i).getCell(0).toString().equals(testCaseName)) {  //&& sheet.getRow(i).getCell(1).toString().equals("Y")
                    matchingrow = i;
                    testcasenameflag = 1;
                    // ExtentTestManager.getInstance(test).getTest().log(Status.INFO,String.valueOf("ThreadID matching row is "+Thread.currentThread().getId()));
                    break;
                }
            }
            for(int j=0;j<topColNum;j++)
            {
                String header=sheet.getRow(0).getCell(j).toString();
                if(header.equals(InputColumn))
                {
                    flag=1;
                    cellval=sheet.getRow(matchingrow).getCell(j);

                    switch (cellval.getCellType())
                    {
                        case STRING:
                            data = cellval.getStringCellValue();
                            break;

                        case NUMERIC:
                            data = String.valueOf(cellval.getNumericCellValue());
                            break;

                        case FORMULA:
                            data = String.valueOf(cellval.getCellFormula());
                            break;

                        case BOOLEAN:
                            boolean bool = cellval.getBooleanCellValue();
                            if (bool) {
                                data = "True";
                            } else {
                                data = "false";
                            }
                            break;

                        case ERROR :
                            data = cellval.getErrorCellString();
                            break;

                        case _NONE:
                            data = "";
                            break;

                        case BLANK:
                            data = "";

                        default:
                            data = null;


                    }
                    try {
                        wb.close();
                    } catch (FileNotFoundException e) {

                        throw new RuntimeException(e);

                    }
                }
            }


            if(testcasenameflag==0){
                throw new TestCasenotFoundInOuputDataSheet("test Cases is not available in OutputDataSheet");
            }
            if(flag==0){
                throw new ColumnNameIsNotFound("Column name is not available");
            }

        }catch (Exception e){

            System.out.println(e.getMessage());
        }
        return data;
    }
}


