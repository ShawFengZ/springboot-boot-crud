package com.atguigu.controller;

import com.atguigu.dao.DepartmentDao;
import com.atguigu.dao.EmployeeDao;
import com.atguigu.entities.Department;
import com.atguigu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author zxf
 * @date 2018/8/3 9:11
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中进行共享
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //来到添加页面
        return "emp/add";
    }

    //员工添加
    //springmvc自动将请求参数和入参对象的属性进行帮的那个；
    // 要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表
        System.out.println("保存的员工信息："+employee.toString());
        //保存员工
        employeeDao.save(employee);
        //redirect:重定向到一个地址 /代表的是当前项目路径
        //forward:表示转发到一个地址
        return "redirect:/emps";
    }

    //来到修改页面的请求
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        //查出员工信息
        Employee employee = employeeDao.get(id);
        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //在页面回显
        model.addAttribute("emp",employee);
        //回到修改页面(add是修改和添加的二合一)
        return "emp/add";
    }


    //员工修改的功能,需要员工id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println(employee.toString());
        //进行员工更新
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
