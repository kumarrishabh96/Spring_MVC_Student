package com.ty.spring_mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.spring_mvc.service.StudentService;
import com.ty.springmvc.dto.Student;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping("login")
	public ModelAndView getIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student", new Student());
		modelAndView.setViewName("login.jsp");
		return modelAndView;
	}

	@RequestMapping("signup")
	public ModelAndView getIndex1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup.jsp");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}

	@RequestMapping("saveStudent")
	public void saveStudent(@ModelAttribute Student student) {
		studentService.saveStudent(student);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.jsp");
	}

	@RequestMapping("loginStudent")
	public ModelAndView loginStudent(@ModelAttribute Student student) {
		Student student2 = studentService.getStudentByEmail(student);
		ModelAndView modelAndView = new ModelAndView();
		if (student2 != null) {
			modelAndView.addObject("name", student2.getName());
			modelAndView.addObject("slist", studentService.getAllStudent());
			modelAndView.setViewName("view.jsp");
		} else {
			modelAndView.setViewName("login.jsp");
		}
		return modelAndView;
	}

	@RequestMapping("view")
	public ModelAndView getView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("slist", studentService.getAllStudent());
		modelAndView.setViewName("view.jsp");
		return modelAndView;
	}

	@RequestMapping("delete")
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		studentService.deleteStudent(Integer.parseInt(request.getParameter("id")));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view");
		requestDispatcher.forward(request, response);

	}

	@RequestMapping("edit")
	public ModelAndView editStudent(@RequestParam int id) {
		Student student = studentService.getStudentById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student", student);
		modelAndView.setViewName("edit.jsp");
		return modelAndView;
	}

	@RequestMapping("updateStudent")
	public void updateStudent(@ModelAttribute Student student, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		studentService.updateStudent(student);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view");
		requestDispatcher.forward(request, response);
	}

}