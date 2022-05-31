package com.example.springbootwebapp.controller;

import com.example.springbootwebapp.entity.Employee;
import com.example.springbootwebapp.repository.EmployeeRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.sax.SAXResult;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository eRepo ;

    @GetMapping({"/showEmployees", "/", "/list"})
    public String showEmployees(Model model)
    {
        List <Employee> list = eRepo.findAll() ;
        model.addAttribute("employees", list) ;
        return "list-employee" ;
    }

    @GetMapping("/addEmployeeForm")
    public String addEmployeeForm(Model model)
    {
        Employee employee = new Employee();
        model.addAttribute("employees", employee);
        return "add-employee-form" ;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(Model model, Employee employee)
    {
        System.out.println(employee);
        eRepo.save(employee);
        return "redirect:/list" ;
    }
}
