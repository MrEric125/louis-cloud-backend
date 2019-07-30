package com.louis.es;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/7/9
 * description:
 */
public class LicenseWord {

    List<String> list = new ArrayList<>(255);



    public String  getContentWord(int number) {
            String content = list.get(number);
            if (StringUtils.isEmpty(content)) {
                return getContentWord(number - 1);
            }
            return content;



    }
    private int getRandomNumber(int x) {
        return (int) (Math.random() * x);

    }

    public void initList(String fileName) {
        if (StringUtils.isEmpty(fileName)) {

            fileName = "D:/workspace/IntelliJ Idea/spring-cloud-project/cloud-search-service/search-service-web/src/test/resource/LICENSE";
        }
        RandomAccessFile accessFile = null;
        try {
           accessFile= new RandomAccessFile(fileName, "r");
            String string = "";
            while (null != (string = accessFile.readLine())) {
                if (StringUtils.isNotEmpty(string)) {
                    list.add(string);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (accessFile != null) {
                    accessFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
