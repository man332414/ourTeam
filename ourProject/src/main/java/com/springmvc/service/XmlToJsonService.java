package com.springmvc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.springmvc.DTO.Response;

import org.springframework.stereotype.Service;

@Service
public class XmlToJsonService {

    public String convertXmlToJson(String xml) throws Exception {
        // XML을 Java 객체로 변환
        XmlMapper xmlMapper = new XmlMapper();
        Response response = xmlMapper.readValue(xml, Response.class);

        // Java 객체를 JSON 문자열로 변환
        ObjectMapper jsonMapper = new ObjectMapper();
        return jsonMapper.writeValueAsString(response);
    }
}
