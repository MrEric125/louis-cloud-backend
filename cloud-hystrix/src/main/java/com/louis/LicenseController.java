package com.louis;

import com.louis.entity.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Eric
 * @date create in 2019/4/4
 */
@RestController

public class LicenseController {

    @Autowired
    LicenseService licenseService;

    @RequestMapping("/licenseList/{orgId}")
    public List<License> getListLicense(@PathVariable("orgId") String orgId) {
        return licenseService.getLicenseByOrg(orgId);
    }
}
