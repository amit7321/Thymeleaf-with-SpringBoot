package com.example.springbootwebapp.controller;

import com.example.springbootwebapp.entity.Employee;
import com.example.springbootwebapp.repository.EmployeeRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository eRepo ;

    @GetMapping("/showEmployees")
    public ModelAndView showEmployees()
    {
        ModelAndView mav = new ModelAndView("list-employees");
        List <Employee> list = eRepo.findAll() ;
        mav.addObject("employee", list) ;

        return mav ;
    }
}