package com.louis.common.web.web;

import com.google.common.collect.ImmutableMap;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.api.wrapper.WrapperMassage;
import com.louis.core.entity.BaseEntity;
import com.louis.core.response.ResponseData;
import com.louis.core.service.CRUDService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Eric
 * @date create in 2019/5/28
 */
@Controller
public class FileUploadController<Id extends Serializable,M extends BaseEntity> {

    @Value("{file.upload.dir}")
    private String uploadBasePath;

    @Value("{file.upload.fileSize}")
    private long uploadFileSizeLimit;

    @Autowired
    CRUDService<M, Id> crudService;


    @ApiOperation("文件上傳用")
    @ResponseBody
    @PostMapping(value = "/upload/{entityId}")
    public WrapMapper fileUpload(@PathVariable(name = "entityId") Id id,
                                   @RequestParam(value = "file", required = false) MultipartFile[] files,
                                   HttpServletRequest request) {
        if (ArrayUtils.isEmpty(files)) {
            return  WrapMapper.wrap(ImmutableMap.of("flag", false, "message", "沒有收到文件"));
        }
        if (id != null) {
            M m = crudService.findById(id);
            if (m!=null) {
                return  WrapMapper.wrap(WrapperMassage.SUCCESS_CODE, WrapperMassage.ERROR_CODE, "id对应的业务实体不存在");
            }

        }
    }


}
