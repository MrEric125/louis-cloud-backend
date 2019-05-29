package com.louis.core.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author louis
 * <p>
 * Date: 2019/5/29
 * Description:
 */
@Service
public class FileUploadService {

    public void upload(MultipartFile[] files, String path) throws IOException {
        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            File filePath = new File(path, filename);
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            file.transferTo(filePath);
        }
    }
}
