package com.louis.proxy;


import org.springframework.stereotype.Service;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/7/2
 * Description:
 */

@Service
public class ConferenceServiceImpl implements ConferenceService{
    @Override
    public void conference() {
        System.out.println("aoooooop source code");
    }
}
