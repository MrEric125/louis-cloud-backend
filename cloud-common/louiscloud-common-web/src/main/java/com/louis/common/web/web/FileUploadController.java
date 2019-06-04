package com.louis.common.web.web;

import com.google.common.collect.ImmutableMap;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.api.wrapper.WrapperMassage;
import com.louis.core.constant.GlobalConstant;
import com.louis.core.entity.AjaxUploadResponse;
import com.louis.core.entity.BaseEntity;
import com.louis.core.service.CRUDService;
import com.louis.core.service.FileUploadService;
import com.louis.core.utils.FileUploadUtils;
import com.louis.exception.FileNameLengthLimitExceededException;
import com.louis.exception.InvalidExtensionException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

/**
 * @author John·Louis
 * @date create in 2019/5/28
 */
@Controller
@Slf4j
public class FileUploadController<ID extends Serializable,M extends BaseEntity> {

    @Value(value = "${file.upload.dir}")
    private String baseDir;

    @Value(value = "${file.upload.fileSize}")
    private long uploadFileSizeLimit;

    private String[] allowedExtension = FileUploadUtils.DEFAULT_ALLOWED_EXTENSION;
//    @Autowired
//    CRUDService<M, ID> crudService;

    @Autowired
    FileUploadService fileUploadService;


    @ApiOperation("文件上专用")
    @ResponseBody
    @PostMapping(value = "/upload/{entityId}")
    public Wrapper fileUpload(@PathVariable(name = "entityId") ID id,
                                   @RequestParam(value = "file", required = false) MultipartFile[] files,
                                   HttpServletRequest request) {
        if (ArrayUtils.isEmpty(files)) {
            return  WrapMapper.wrap(ImmutableMap.of("flag", false, "message", "沒有收到文件"));
        }
//        boolean present = Optional.ofNullable(id).map(x -> crudService.findById(x)).isPresent();
//        if (present) {
//            return  WrapMapper.wrap(WrapperMassage.SUCCESS_CODE, WrapperMassage.ERROR_MESSAGE, "id对应的业务实体不存在");
//        }

        try {
            for (MultipartFile file : files) {
                if (file.getSize()> uploadFileSizeLimit) {
                    return WrapMapper.wrap(WrapMapper.error("上传文件过大"));
                }
            }
            fileUploadService.upload(files, baseDir);
        } catch (IOException e) {
            log.error("文件上传异常:{}", e.getMessage());
            return WrapMapper.wrap(WrapMapper.error("上传文件出现异常"));
        }
        return WrapMapper.wrap(WrapperMassage.SUCCESS_MESSAGE);

    }

    /**
     * 文件上传
     * @param request
     * @param response
     * @param files
     * @return
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public AjaxUploadResponse fileUpload(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(value = "files[]", required = false) MultipartFile[] files) {

        baseDir = baseDir.endsWith("/") ? baseDir.substring(0,baseDir.length()-1) : baseDir;
        baseDir = baseDir.endsWith("\\") ? baseDir.substring(0,baseDir.length()-2) : baseDir;

        AjaxUploadResponse ajaxUploadResponse = new AjaxUploadResponse();

        if (ArrayUtils.isEmpty(files)) {
            return ajaxUploadResponse;
        }

        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            long size = file.getSize();
            try {
                String url = FileUploadUtils.upload(request, baseDir, file, allowedExtension, uploadFileSizeLimit, true);
                String deleteURL = "/ajaxUpload/delete?filename=" + URLEncoder.encode(url, GlobalConstant.ENCODING);
                ajaxUploadResponse.add(filename, size, url, deleteURL);
            } catch (FileNameLengthLimitExceededException e) {
                ajaxUploadResponse.add(filename, size, "upload.filename.exceed.length");
                log.error("upload.filename.exceed.length:", e);
            } catch (UnsupportedEncodingException e) {
                ajaxUploadResponse.add(filename, size, "file encode error");
                log.error("file encode error: ",e);
            } catch (InvalidExtensionException e) {
                log.error("upload.not.allow.extension", e);
                ajaxUploadResponse.add(filename, size, "upload.not.allow.extension");
            } catch (IOException e) {
                log.error("file upload error:",e);
                ajaxUploadResponse.add(filename, size, "upload.server.error");
            } catch (FileUploadBase.FileSizeLimitExceededException e) {
                log.error("upload.exceed.maxSize:",e);
                ajaxUploadResponse.add(filename, size, "upload.exceed.maxSize");
            }
        }
        return ajaxUploadResponse;


    }


}
