package com.example.demo.controller;

import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping("/emps")
    public String list(Model model) {
        List<Employee> employees = employeeMapper.selectList(null);
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        List<Department> departments = departmentMapper.selectList(null);
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeMapper.insert(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeMapper.selectById(id);
        model.addAttribute("emp", employee);
        List<Department> departments = departmentMapper.selectList(null);
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeMapper.updateById(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeMapper.deleteById(id);
        return "redirect:/emps";
    }

}
