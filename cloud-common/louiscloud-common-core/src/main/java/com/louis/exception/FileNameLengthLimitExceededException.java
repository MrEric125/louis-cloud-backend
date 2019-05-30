package com.louis.exception;

import org.apache.tomcat.util.http.fileupload.FileUploadException;


/**
 * @author John·Louis
 *
 * @date 2019年5月30日22:53:36
 *
 * description
 */
public class FileNameLengthLimitExceededException extends FileUploadException {
    private static final long serialVersionUID = -1828008459456667538L;

    private int length;
    private int maxLength;
    private String filename;

    public FileNameLengthLimitExceededException(String filename, int length, int maxLength) {
        super("file name : [" + filename + "], length : [" + length + "], max length : [" + maxLength + "]");
        this.length = length;
        this.maxLength = maxLength;
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public int getLength() {
        return length;
    }


    public int getMaxLength() {
        return maxLength;
    }



}
