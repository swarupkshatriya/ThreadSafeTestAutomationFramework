package extentreport;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    private static ExtentTestManager instance=null;
    private static ThreadLocal<ExtentTest> tlTest=new ThreadLocal<>();
    private static ExtentTest extentTest;
    private ExtentTestManager(){}

    private void initExtentTest(ExtentTest test){
        tlTest.set(test);
    }

    public static ExtentTestManager getInstance(ExtentTest test){
        if(instance==null){
            synchronized (ExtentTestManager.class){
                if(instance==null){
                    instance=new ExtentTestManager();
                }
            }
        }
        if(tlTest.get()==null){
            instance.initExtentTest(test);
        }
        return instance;
    }
    public ExtentTest getTest(){
        return tlTest.get();
    }

    public static void remoteAttachment(){
        if(tlTest.get()!=null){
            tlTest.remove();
        }
    }



}


