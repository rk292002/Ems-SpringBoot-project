//package com.example.demo.reporting;
//
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//import org.supercsv.io.CsvBeanWriter;
//import org.supercsv.prefs.CsvPreference;
//import com.example.demo.dto.EmployeeDto;
//import jakarta.servlet.http.HttpServletResponse;
//@Component
//public class FileExporter {
//
//    public void exportToCSV(List<EmployeeDto> listEmployee, HttpServletResponse response) throws IOException {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String timeStamp = dateFormat.format(new Date());
//        String fileName = "Users_" + timeStamp + ".csv";
//
//        response.setContentType("text/csv");
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=\"" + fileName + "\"";
//        response.setHeader(headerKey, headerValue);
//
//        CsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
//
//        String[] csvHeader = {"ID", "First Name", "Last Name", "Email"};
//        String[] fieldMapping = {"id", "firstname", "lastname", "email"};
//
//        csvWriter.writeHeader(csvHeader);
//        for (EmployeeDto emp : listEmployee) {
//            csvWriter.write(emp, fieldMapping);
//        }
//        csvWriter.close();
//    }
//}
