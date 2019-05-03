package com.louis;

import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @author Eric
 * @date create in 2019/4/4
 */

@Service
public class LicenseService {


    /**
     * 这种事称之为后备模式，当出现一场的时候就自动调用默认的方法
     * @param orgId
     * @return
     */
    /*@HystrixCommand(fallbackMethod = "defaultListLicense",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1200")})
    public List<License> getLicenseByOrg(String orgId) {
        return randomRunLong(orgId);
    }*/

    private List<License> randomRunLong(String orgId) {
        Random random = new Random();
        int anInt = random.nextInt((6 - 1) + 1)+1;
        License license = License.builder().id(anInt).build();
        List<License> licenseList = Lists.newArrayList();
        licenseList.add(license);
        if (anInt==3) sleep();
        return licenseList;

    }
    private List<License> defaultListLicense(String orgId) {
       return Lists.newArrayList(License.builder().id(Integer.parseInt(orgId)).build());

    }
    private void sleep() {
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @HystrixCommand(fallbackMethod = "defaultListLicense",threadPoolKey = "licenseByOrgThreadpool",
        threadPoolProperties = { @HystrixProperty(name = "coreSize", value = "30")
    ,@HystrixProperty(name = "maxQueueSize",value = "10")})

    public List<License> getLicenseByOrg(String orgId) {
        return randomRunLong(orgId);
    }



}
@Setter
@Getter
@Builder
@Slf4j
class License{
    private int id;

}
