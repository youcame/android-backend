package com.neu.edu.android_backend.controller;

import com.neu.edu.android_backend.mapper.AdministratorMapper;
import com.neu.edu.android_backend.po.Administrator;
import com.neu.edu.android_backend.po.Student;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Log4j2
@RestController
public class AdministratorController {
    @Resource
    AdministratorMapper administratorMapper;

    @GetMapping("/administrators")
    public ResponseEntity<List<Administrator>> getAllAdministrators() {
        try {
            List<Administrator> administrators = administratorMapper.getAllAdministrators();
            return ResponseEntity.status(HttpStatus.OK).body(administrators);
        } catch (Exception e) {
            log.error("Failed to get administrators", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/administrators/{name}")
    public ResponseEntity<Administrator> getAdministratorByName(@PathVariable String name){
        try {
            Administrator administrator = administratorMapper.getAdministratorByName(name);
            if (administrator != null) {
                return ResponseEntity.status(HttpStatus.OK).body(administrator);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            log.error("Failed to get student by name: " + name, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}




