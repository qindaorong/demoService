package com.qindaorong.demo.core.framework.task.enums;

/**
 * Created by Michael on 3/5/2018.
 */
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
