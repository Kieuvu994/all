import java.io.File;

import com.poscoict.glueframework.tester.GlueTester;

public class Run_GlueTester
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        String baseDir = new File( "" ).getAbsolutePath()+File.separator+"test";
        System.setProperty( "CONFIG_PATH", baseDir );
        new GlueTester();
    }
}
