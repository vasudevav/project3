package com.nt.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RailwayTicketReservationController {
	
	@RequestMapping("/home.htm")
	public   String showHome() {
		return "welcome";
	}
	
	@RequestMapping("/running.htm")
	public  String   showTrainningStatus(Map<String,Object> map,@RequestParam("tno") String tno) {
		String statusMsg=null;
		int trainNo;
		trainNo=Integer.parseInt(tno);
		if(trainNo==6789)
		    statusMsg="Train No::6789 Hyd Express  is running "+new Random().nextInt(20)+" hour delay";
		else if(trainNo==6189)
			statusMsg="Train No::6189  Chennai Express  is running "+new Random().nextInt(20)+" hour delay";
		else if(trainNo==6289)
			statusMsg="Train No::6289  Danapur Express  is running "+new Random().nextInt(20)+" hour delay";
		else 
			statusMsg="Wrong TrainNo (or) Train is cancelled";
		//put model data
		map.put("status",statusMsg);
		return "show_status";
	}

}
