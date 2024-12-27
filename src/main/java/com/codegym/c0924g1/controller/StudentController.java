package com.codegym.c0924g1.controller;

import com.codegym.c0924g1.entity.Student;
import com.codegym.c0924g1.service.IStudentService;
import com.codegym.c0924g1.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {

    private static final IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        String message = req.getParameter("message");
        if (message != null) {
            switch (message) {
                case "created":
                    req.setAttribute("message", "Thêm mới thành công");
                    break;
                case "deleted":
                    req.setAttribute("message", "Xóa thành công");
                    break;
            }
        }
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("WEB-INF/view/student/create.jsp").forward(req, resp);
                break;
            case "update":
                break;
            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                studentService.remove(id);
                resp.sendRedirect("/student?message=deleted");
                break;
            default:
                List<Student> students = studentService.getAll();
                req.setAttribute("students", students);
                req.getRequestDispatcher("WEB-INF/view/student/list.jsp").forward(req, resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String name = req.getParameter("name");
                String address = req.getParameter("address");
                String point = req.getParameter("point");
                String className = req.getParameter("className");
                Student student = new Student(name, address, Integer.parseInt(point), className);
                studentService.save(student);
                resp.sendRedirect("/student?message=created");
                break;
            case "update":
                break;
        }
    }
}
