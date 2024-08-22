package com.example.demo.controller;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
@CrossOrigin("*")
@AllArgsConstructor

@RestController  //now this class capable of handling http requests;
@RequestMapping("/api/employees")
public class EmployeeController {
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	public EmployeeController() {
		super();
	}

  @Autowired
  private EmployeeService employeeService;
  //build add employee RESTAPI
  
  @PostMapping    //to map incoming http post request to this method;
  //extract json from http request and convert to employeedto java class object-> requestbody
  
  public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
	 EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
	  return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
  }
  
  

  
  //build getemployee rest api;
  
  @GetMapping("{id}")
  public ResponseEntity<EmployeeDto> getEmployeeId(@PathVariable("id") Long employeeId){
	  EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
	  return ResponseEntity.ok(employeeDto);  
  }
  
  //build get all employees rest api;
  @GetMapping
  public ResponseEntity<List<EmployeeDto>>getAllEmployees(){
	  List<EmployeeDto>employees=employeeService.getAllEmployee();
	  return ResponseEntity.ok(employees);
	  }
  @Autowired
  private EmployeeService service;
  

  @GetMapping("/employees/export")
  public void exportToCSV(HttpServletResponse response) throws IOException {
	  response.setContentType("text/csv");
	  String fileName="users.csv";
	  String headerKey="Content-Disposition";
	  String headerValue="attachment; filename=" + fileName;
	  
	  response.setHeader(headerKey, headerValue);
	  
	  List<EmployeeDto> listUsers =service.getAllEmployee();
	  ICsvBeanWriter csvWriter=new CsvBeanWriter(response.getWriter(),CsvPreference.STANDARD_PREFERENCE);
	  
			  String[] csvHeader= {"id","first-name","last-name","email-id"};
	          String[] nameMapping= {"id","firstname","lastname","email"};
	          csvWriter.writeHeader(csvHeader);
	          
	          for(EmployeeDto user:listUsers) {
	        	  csvWriter.write(user, nameMapping);
	          }
	          csvWriter.close();
  }
  
  @GetMapping("/employees/exportpdf")
  public void exportToPDF(HttpServletResponse response) throws IOException  {
	  response.setContentType("application/pdf");
//	  DateFormat dateformatter= new SimpleDAteFormat("yyyy-MM-dd_HH:mm:ss");
//	  String currentDateTime=dateFormatter.format(new Date());
	  String fileName="users.pdf";
	  String headerKey="Content-Disposition";
	  String headerValue="attachment; filename=" + fileName;
	  
	  response.setHeader(headerKey, headerValue);
	  
	  List<EmployeeDto> listUsers =service.getAllEmployee();
	  UserPDFExporter exporter=new UserPDFExporter(listUsers);
	  exporter.export(response);
  }
  
  @GetMapping("/employees/exportexcel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_"  + ".xlsx";
		response.setHeader(headerKey, headerValue);
		
		List<EmployeeDto> listUsers = service.getAllEmployee();
		
		ExcelExporter excelExporter = new ExcelExporter(listUsers);
		
		excelExporter.export(response);		
	}	
}




