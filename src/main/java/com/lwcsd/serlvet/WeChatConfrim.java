package com.lwcsd.serlvet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lwcsd.util.CheckUtil;


@WebServlet("/WeChatConfrim")
public class WeChatConfrim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WeChatConfrim() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String signature = request.getParameter("signature");
        
        String timestamp = request.getParameter("timestamp");
        
        String nonce = request.getParameter("nonce");

        String echostr = request.getParameter("echostr");
 
        PrintWriter out = response.getWriter();
        if(CheckUtil.checkSignature(signature, timestamp, nonce)){
            out.print(echostr);
        }
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
