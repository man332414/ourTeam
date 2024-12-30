package com.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.service.NavigationService;

@RestController
public class NavigationController {

    private final NavigationService navigationService;

    public NavigationController(NavigationService navigationService) {
        this.navigationService = navigationService;
    }

//    @GetMapping("/travel-time")
//    public String getTravelTime(@RequestParam String start, @RequestParam String destination) {
//        return navigationService.getTravelTime(start, destination);
//    }
}