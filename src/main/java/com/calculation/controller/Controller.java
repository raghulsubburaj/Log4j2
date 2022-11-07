package com.calculation.controller;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculation.service.TestService;







@SpringBootApplication(scanBasePackages = ("com.calculation"))
@RestController
@RequestMapping("/api/")
public class Controller {

	@Autowired
	TestService objTestService;

	@RequestMapping(value = "testApi", method = RequestMethod.GET)

	public ResponseEntity<?> testApi(@RequestParam Map<String, String> requestParams) throws Exception {
		long ans = 0;
		String Status = "Success";
		try {
			 System.out.println(requestParams);
			Logger log = LogManager.getLogger("ArithmeticOperation");

			log.debug("testAPI started: " + requestParams);
			log.info("testAPI started: " + requestParams);

			String operation = requestParams.get("operation");
			int n1 = Integer.parseInt(requestParams.get("number1"));
			int n2 = Integer.parseInt(requestParams.get("number2"));

			switch (operation) {
			case "add":
				ans = objTestService.add(n1, n2);
				break;
			case "sub":
				ans = objTestService.sub(n1, n2);
				break;
			case "mul":
				ans = objTestService.mul(n1, n2);
				break;
			case "div":
				ans = objTestService.div(n1, n2);
				break;

			}
		} catch (Exception e) {
			e.printStackTrace();
			Status = "failure";

		}
		requestParams.put("result", ans + "");
		requestParams.put("status", Status);
		return new ResponseEntity<>(requestParams, HttpStatus.OK);

	}
    @Value("${FilePath}")
    private String FileUrl;

	@RequestMapping(value = "loadProperty", method = RequestMethod.GET)
	public ResponseEntity<?> loadProperty(@RequestParam Map<String, String> requestParams) throws Exception {
		String Status="Success";
	    Properties prop=new Properties();
		try {
			 System.out.println(requestParams);
          FileInputStream file = new FileInputStream(FileUrl);
      	Logger log = LogManager.getLogger("ArithmeticOperation");

		log.debug("testAPI started: " + requestParams);
		log.info("testAPI started: " + requestParams);
      
          prop.load(file);
			

			
		} catch (Exception e) {
			e.printStackTrace();
			Status ="failure";
		}
	    System.out.println(requestParams);
		return new ResponseEntity<>(prop, HttpStatus.OK);

	}
}
