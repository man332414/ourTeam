package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springmvc.service.XmlToJsonService;

@Controller
public class XmlToJsonController {

    @Autowired
    private XmlToJsonService xmlToJsonService;

    @GetMapping("/convert")
    public String convertXmlToJson(@RequestBody String xml) {
    	System.out.println("convert 진입");
    	System.out.println("xml = "+ xml);
    	
        try {
            return xmlToJsonService.convertXmlToJson(xml);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Conversion failed: " + e.getMessage() + "\"}";
        }
    }
}