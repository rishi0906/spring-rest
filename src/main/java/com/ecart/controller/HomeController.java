package com.ecart.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecart.dao.ITestDao;
import com.ecart.model.DataClass;
import com.ecart.service.ItestService;


@Controller
public class HomeController {


	@Autowired
	private ItestService iTestService;

	@Autowired
	private ITestDao iTestDao;

	@RequestMapping(value = "/loanDetailsById/{customerId}", method = RequestMethod.GET)
	@ResponseBody
	public Response getLoanDetailsById(@PathVariable("customerId") Long customerId) {
		
		String asd= iTestService.test();
		return Response.status(Status.OK).entity(asd).build();
	
	}
	
	@RequestMapping(value = "/gete/{customerId}", method = RequestMethod.GET)
	@ResponseBody
	public Response getLoan(@PathVariable("customerId") Long customerId) {
		
		DataClass asd= iTestDao.loadDataClassRowId(1l);
		return Response.status(Status.OK).entity(asd).build();
	
	}
}
