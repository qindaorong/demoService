package com.qindaorong.demo.core.framework.task.enums;

/**
 * FileTypeEnum
 *
 * @author qindaorong
 * @create 2018-06-05 10:51 AM
 **/
public enum FileTypeEnum {
    
    CSV_FILE("csv"),
    EXCEL_FILE("xlsx");
    
    private String fileType;
    
    FileTypeEnum(String fileType) {
        this.fileType = fileType;
    }
    
    public String getFileType() {
        return fileType;
    }
    
    public static FileTypeEnum fileTypeOf(String fileType) {
        for (FileTypeEnum fileTypeEnum : values()) {
            if (fileTypeEnum.getFileType().equals(fileType)) {
                return fileTypeEnum;
            }
        }
        return null;
    }
}
