package com.blog.BloggingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.blog.BloggingProject.entity.Employee;
import com.blog.BloggingProject.service.EmpService;

import org.springframework.ui.Model;
//import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	@Autowired
	private EmpService service;
	
@GetMapping("/")
public String home(Model model) {
	
	List<Employee> empList=service.getAllEmp();
	model.addAttribute("emp",empList);
		return "index";
}
@GetMapping("/addemp")
public String addEmpForm() {
	return "add_emp";
}

@PostMapping("/register")
public String emppRegister(@ModelAttribute Employee e) {
	
	service.addEmp(e);
//	session.setAttribute("msg","Employee added successfully");
	return "redirect:/";
}
@GetMapping("/edit/{id}")
public String edit(@PathVariable int id,Model m) {
	
	Employee emp=service.getEmpById(id);
	m.addAttribute("emp",emp);
	return "edit";
}
@PostMapping("/update")
public String updateEmp(@ModelAttribute Employee e) {
service.addEmp(e);
return "redirect:/";
}

@GetMapping("/delete/{id}")
public String deleteEmp(@PathVariable int id) {
	service.deleteEmp(id);
	return "redirect:/";
}
}