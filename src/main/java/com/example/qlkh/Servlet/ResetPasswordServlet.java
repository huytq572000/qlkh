package com.example.qlkh.Servlet;

import com.example.qlkh.DAO.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResetPasswordServlet", value = "/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/user/update-password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserDAO userDAO = new UserDAO();
        String otp = request.getParameter("otp");
        String email = "tranquanghuy05072000@gmail.com";
        String newPassword = request.getParameter("newPassword");
        String sessionOtp = (String) request.getSession().getAttribute("otp");

        if (otp.equals(sessionOtp)) {
            boolean isUpdated = userDAO.updatePassword(email,newPassword);
            if (isUpdated) {
                response.getWriter().println("Mật khẩu của bạn đã được cập nhật thành công.");
            } else {
                response.getWriter().println("Đã xảy ra lỗi khi cập nhật mật khẩu.");
            }
        } else {
            response.getWriter().println("Mã OTP không hợp lệ.");
        }
    }
    private boolean updatePassword(String newPassword) {

        return true; // Trả về true nếu cập nhật thành công, ngược lại trả về false
    }
}
