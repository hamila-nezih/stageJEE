package com.hc.stage.controller.login;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hc.stage.entities.upload.upload;
import com.hc.stage.metier.upload.InterfaceMetierUpload;

@Controller
public class UploadController {

	@Autowired
	private InterfaceMetierUpload iMetierUpload;

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = "application/json;" + "charset=UTF-8")
	public @ResponseBody void creerUtl(@RequestBody upload up) {

		iMetierUpload.ajouterNouvelleFichier(up);
	}
	@RequestMapping(value = "/file")
	public String   file() {
       return "file";
		
	}
	

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	void uploadFileHandler(
			@RequestParam("file") MultipartFile file ,@RequestParam("name") String name) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				 upload jetUpload =new upload();
				 jetUpload.setNomFichier(name);
				 jetUpload.setPhoto(bytes);
				 iMetierUpload.ajouterNouvelleFichier(jetUpload);

				//return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				//return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			//return "You failed to upload " + name
				//	+ " because the file was empty.";
		}
	}
	
/*
 * download 
 */
	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
	public @ResponseBody byte[] getOpenedEventsInPdf(HttpServletResponse response) {
	    response.setHeader("Content-Disposition", "inline; filename=file.pdf");
	    response.setContentType("application/pdf");
	// get file in bytearray from my custom service in backend
	    byte[] file = iMetierUpload.getFichier().getPhoto();
	    return file;
	}
}
