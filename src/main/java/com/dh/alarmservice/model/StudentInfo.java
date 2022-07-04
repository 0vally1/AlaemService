package com.dh.alarmservice.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@HeadRowHeight(20)
@ContentRowHeight(20)
public class StudentInfo implements Serializable {
    private static final long serialVersionUID = 1L;

//    @ColumnWidth(20)
//    @ExcelProperty(value = { "id号码" }, index = 0)
    private String id;

//    @ColumnWidth(20)
//    @ExcelProperty(value = { "学生" }, index = 0)
    private String name;

//    @ColumnWidth(20)
//    @ExcelProperty(value = { "学号" }, index = 0)
    private String admissionTicketNumber;

    @ColumnWidth(20)
    @ExcelProperty(value = { "学号" }, index = 0)
    private String info;


}
