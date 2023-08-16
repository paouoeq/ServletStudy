package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
public class UploadSerevlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파일 업로드 기능 구현
		/*
		 * 	enctype="multipart/form-data" 지정되었으면
		 *  더이상 request.getParameter(key) 사용 불가
		 */
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("jakarta.servlet.context.tempdir"); // Or "javax.servlet.context.tempdir" for javax
		factory.setRepository(repository);

		// Create a new file upload handler
//		JakartaServletDiskFileUpload upload = new JakartaServletDiskFileUpload(factory);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		
		// Parse the request
		try {
//			List<DiskFileItem> items = upload.parseRequest(request);
			List<FileItem> items = upload.parseRequest(request);
			
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();
			    if (item.isFormField()) {
			    	// type="file"이 아닌 것 처리  => type="text" 처리
			    	String name = item.getFieldName(); // tag의 name값, 기본적으로 한글처리가 안됨
		    	    String value = item.getString("utf-8"); // 입력값, type=text의 한글처리 방법
		    	    System.out.println("text 데이터:"+name+"\t"+value);
			    } else {
			    	// type="file"인 것 처리 / 파일은 기본적으로 한글처리가 됨
			    	String fieldName = item.getFieldName();
			        String fileName = item.getName();
			        String contentType = item.getContentType();
			        boolean isInMemory = item.isInMemory();
			        long sizeInBytes = item.getSize();
			        System.out.println("fieldName:" + fieldName);
		    	    System.out.println("fileName:" + fileName);
		    	    System.out.println("contentType:" + contentType);
		    	    System.out.println("isInMemory:" + isInMemory);
		    	    System.out.println("sizeInBytes:" + sizeInBytes);
		    	    
		    	    // 특정 경로에 파일 저장 => c:\\upload
		    	    // c:\\upload 경로 지정
		    	    File f = new File("c:\\upload", fileName);
		    	    try {
						item.write(f); // 예외처리 필수, 파일 저장시킴
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

}
