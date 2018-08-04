package com.user.autoGen.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.user.autoGen.helper.ControllerGenerateHelper;
import com.user.autoGen.helper.MainAppGeneratorHelper;
import com.user.autoGen.helper.ModelFileCreationHelper;
import com.user.autoGen.helper.PomGeneratorHelper;
import com.user.autoGen.helper.ProjectFolderGenerateHelper;
import com.user.autoGen.helper.ServiceGenerateHelper;
import com.user.autoGen.helper.ZipDirectoryHelper;
import com.user.autoGen.model.AutoGenerateRequest;
import com.user.autoGen.model.ModelDetailsRequest;

@Service
public class AutoGeneratorService {

	public void generateService(AutoGenerateRequest autoGenerateRequest, HttpServletResponse response) {
		String projectName=autoGenerateRequest.getProjectDetails().getProjectName();
		String packageName = autoGenerateRequest.getProjectDetails().getPackageName();
		//project directory generation
		ProjectFolderGenerateHelper.generateRootFolders(projectName,packageName);
		//pom.xml generation
		PomGeneratorHelper.generatePomFile(projectName,packageName);
		// Micro service main App
		MainAppGeneratorHelper.generateMainApplication(projectName,packageName);
		// config generator changes
		
		// Micro service main model, service, controller generation
		for(ModelDetailsRequest model: autoGenerateRequest.getModels()) {
			ModelFileCreationHelper.generateModels(projectName,packageName, model.getModelName(), model.getFields());	
			//Controller generator
			ControllerGenerateHelper.generateController(projectName, packageName, model.getModelName());
			//Service generator
			ServiceGenerateHelper.generateService(projectName, packageName, model.getModelName());
		}
		// Micro service JPA and other integration details
		
		
		//Zip file generator
		try {
			String fileName = "./target/"+ autoGenerateRequest.getProjectDetails().getProjectName();
			ZipDirectoryHelper.generateZip(fileName);
			new File(fileName).deleteOnExit();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String filePath = "./target/"+ autoGenerateRequest.getProjectDetails().getProjectName();
		Path file = Paths.get("./target/", autoGenerateRequest.getProjectDetails().getProjectName()+".zip");
        if (Files.exists(file))
        {
        	response.setHeader("Content-Type", "application/zip");
        	response.addHeader("Content-Disposition", "attachment; filename="+autoGenerateRequest.getProjectDetails().getProjectName()+".zip");
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
        	System.out.println("file doesn't exist!");
        }
        ZipDirectoryHelper.deleteDirectory(filePath);
        ZipDirectoryHelper.deleteFile(filePath+".zip");
	}
}
