package demo3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo1 {
    public static void main(String[] args) throws IOException {

        if (checkCount())
        {
            run();
        }

    }

    public static void run()
    {
        System.out.println("软件运行");
    }

    public static boolean checkCount() throws IOException {
        boolean isRun = true;

        File configFile = new File("E:\\java代码\\day10\\tempfile\\count.properties");

        if(!configFile.exists())
        {
//            System.out.println("not exist");
            configFile.createNewFile();
        }

        int count = 0;

        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(configFile);
        FileOutputStream fos = new FileOutputStream(configFile);

        prop.load(fis);

        String value = prop.getProperty("count");

        System.out.println(value);

        if (value != null)
        {
            count = Integer.parseInt(value);
            if(count >= 5)
            {
                System.out.println("请注册");
                isRun = false;
            }
        }
        count++;
        System.out.println(count);

        prop.setProperty("count", Integer.toString(count));

        prop.store(fos, "");

        fos.close();
        fis.close();

        return isRun;
    }
}
