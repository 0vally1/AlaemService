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
@ContentRowHeight(40)
public class StudentInfoExcel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ColumnWidth(20)
    @ExcelProperty(value = { "学号" }, index = 0)
    private String a;

    @ColumnWidth(20)
    @ExcelProperty(value = { "学号" }, index = 1)
    private String b;

    @ColumnWidth(20)
    @ExcelProperty(value = { "学号" }, index = 2)
    private String c;

    @ColumnWidth(20)
    @ExcelProperty(value = { "学号" }, index = 3)
    private String d;

    @ColumnWidth(20)
    @ExcelProperty(value = { "学号" }, index = 4)
    private String e;

    @ColumnWidth(20)
    @ExcelProperty(value = { "学号" }, index = 5)
    private String f;



}
