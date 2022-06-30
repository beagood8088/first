package com.example.first.controller;

import com.example.first.DisplaySupervisor;
import com.example.first.consumingrest.Manager;
import com.example.first.entity.NotificationToSupervisor;
import com.example.first.repository.NotificationToSupervisorRepository;
import com.example.first.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NotificationToSupervisorController {
    private static final String MANAGER_URL = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";
    @Autowired
    private NotificationToSupervisorRepository notificationToSupervisorRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Utils utils;


    @RequestMapping(value = "/api/supervisors")
    List<DisplaySupervisor> getSupervisorList() {

        /* rest client */
        var managersArray = restTemplate.getForObject(MANAGER_URL, Manager[].class);

        /* exception custom handling if result null */
        assert managersArray != null;

        /* filter only supervisors ordered by */
        return Arrays.stream(managersArray)
                .filter(manager -> !utils.isNumeric(manager.getJurisdiction()))
                .sorted(utils.supervisorComparator())
                .map(DisplaySupervisor::from)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/api/submit", method = RequestMethod.POST)
    NotificationToSupervisor addNotification(@Valid @RequestBody NotificationToSupervisor notificationToSupervisor) {
        notificationToSupervisorRepository.save(notificationToSupervisor);
        return notificationToSupervisor;
    }
}
