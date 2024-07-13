package extentreport;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReportsManager {

    private static ExtentReportsManager instance=null;
    private static ThreadLocal<ExtentReports> tlextent=new ThreadLocal<>();
    public ExtentReportsManager(){}

    private void initExtent(ExtentReports extent){
                tlextent.set(extent);
    }

    public static ExtentReportsManager getInstance(ExtentReports extent){
        if(instance==null){
            synchronized (ExtentReportsManager.class){
                if(instance==null){
                    instance=new ExtentReportsManager();
                }
            }
        }
        if(tlextent.get()==null){
            instance.initExtent(extent);
        }
        return instance;
    }
    public ExtentReports getExtents(){
        return tlextent.get();
    }
}
