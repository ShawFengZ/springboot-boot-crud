package com.atguigu.controller;

import com.atguigu.dao.EmployeeDao;
import com.atguigu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @author zxf
 * @date 2018/8/3 9:11
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    //查询所有员工返回列表页面

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中进行共享
        model.addAttribute("emps", employees);
        return "emp/list";
    }
}
