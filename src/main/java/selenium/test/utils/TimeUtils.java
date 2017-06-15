package selenium.test.utils;

/**
 * Created by pavelpozniakov on 14.06.17.
 */
public class TimeUtils {
    public static void waitForSeconds (int timeoutInSeconds){
        try{
            Thread.sleep(timeoutInSeconds * 1000);
        } catch (InterruptedException e){ e.printStackTrace();}
    }
}
