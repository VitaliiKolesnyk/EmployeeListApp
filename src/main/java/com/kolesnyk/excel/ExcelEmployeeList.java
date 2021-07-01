package com.kolesnyk.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kolesnyk.model.Employee;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;


public class ExcelEmployeeList extends AbstractXlsView{

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "attachment;filename=\"employees.xls\"");
        List<Employee> employees = (List<Employee>) model.get("list");
        Sheet sheet = workbook.createSheet("Employees Data");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Name");
        header.createCell(2).setCellValue("Surname");
        header.createCell(3).setCellValue("Position");
        header.createCell(4).setCellValue("Salary");
        int rowNum = 1;
        for(Employee employee:employees){
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(employee.getId());
            row.createCell(1).setCellValue(employee.getName());
            row.createCell(2).setCellValue(employee.getSurname());
            row.createCell(3).setCellValue(employee.getPosition());
            row.createCell(4).setCellValue(employee.getSalary());
        }
    }
}

