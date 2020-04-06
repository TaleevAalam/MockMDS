package org.biometric.provider;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoRequest extends HttpServlet {  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		if(req.getMethod().contentEquals("MOSIPDINFO"))
			doPost(req, res);
    }
	
	@Override
    protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
		String info = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\files\\MockMDS\\" + "deviceInfo" + ".txt")));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(info);
    }
}