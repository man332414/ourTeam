package com.springmvc.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlToJsonConverter {
    public static void main(String[] args) {
        try {
        	System.out.println("XmlToJsonConverter   진입");

            // XML 문자열 예시
            String xml = "<person><name>John Doe</name><age>30</age></person>";
            System.out.println("xml = " + xml);

            // XML을 Java 객체로 변환
            XmlMapper xmlMapper = new XmlMapper();
            Person person = xmlMapper.readValue(xml, Person.class);


            // Java 객체를 JSON 문자열로 변환
            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writeValueAsString(person);

            // 결과 출력
            System.out.println("JSON Output: " + json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Java 객체 클래스
class Person {
    private String name;
    private int age;
	public String getName() {
		name = "윤경일";
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		age =33;
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

    // Getter와 Setter 생략
}
