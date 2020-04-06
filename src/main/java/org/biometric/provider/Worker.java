package org.biometric.provider;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.mosip.registration.mdm.dto.StreamingRequestDetail;

@RestController
public class Worker {

//	ObjectMapper oB = null;
//	
//	@PostMapping("/stream")
//	protected void stream(@RequestBody String req, HttpServletResponse response)
//			throws ServletException, IOException {
//		if(oB==null)
//			oB = new ObjectMapper();
//
//		List<byte[]> imageByteList = null;
//		response.setContentType("multipart/x-mixed-replace; boundary=--BoundaryString");
//		StreamingRequestDetail request = (StreamingRequestDetail)(oB.readValue(req.getBytes(), StreamingRequestDetail.class));
//		imageByteList = new ArrayList<byte[]>();
//		OutputStream outputStream = response.getOutputStream();
//		getImage(request, imageByteList);
//		getImage(imageByteList);
//
//		int i = 0;
//		while (true) {
//			try {
//				outputStream.write(("--BoundaryString\r\n" + "Content-type: image/jpeg\r\n" + "Content-Length: "
//						+ imageByteList.get(i).length + "\r\n\r\n").getBytes());
//				outputStream.write(imageByteList.get(i));
//				outputStream.write("\r\n\r\n".getBytes());
//				outputStream.flush();
//				if (i == 0)
//					i = 1;
//				else if (i == 1)
//					i = 0;
//				TimeUnit.MILLISECONDS.sleep(500);
//			} catch (Exception e) {
//				e.printStackTrace();
//				return;
//			}
//		}
//	}
//
//	
//	private void getImage(StreamingRequestDetail requestBody, List<byte[]> imageByteList) throws IOException {
//
//		File image = new File(System.getProperty("user.dir") + "\\images\\" + requestBody.getDeviceId()
//				+ requestBody.getDeviceSubId() + ".jpg");
//		BufferedImage originalImage = ImageIO.read(image);
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		ImageIO.write(originalImage, "jpg", baos);
//		baos.flush();
//		imageByteList.add(baos.toByteArray());
//	}
//
//	private void getImage(List<byte[]> imageByteList) throws IOException {
//
//		File image = new File(System.getProperty("user.dir") + "\\images\\" + "empty" + ".jpg");
//		BufferedImage originalImage = ImageIO.read(image);
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		ImageIO.write(originalImage, "jpg", baos);
//		baos.flush();
//		imageByteList.add(baos.toByteArray());
//	}
//	

}
