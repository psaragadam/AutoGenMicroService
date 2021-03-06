package com.user.autoGen.helper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;

import com.user.autoGen.model.Field;

public class ServiceGenerateHelper {
	
	public static void generateService(String projectName, String packageName, String modelName) {
		try {
			String className = modelName.substring(0, 1).toUpperCase() + modelName.substring(1);
			String packageNameValue = "package com." + packageName + ".service;";
			StringBuilder imports = buildImports(packageName, className);
			StringBuilder classDef = buildClassDef(packageName, className,modelName );
			
			List<String> lines = Arrays.asList(packageNameValue, imports.toString(), classDef.toString());

			Path file = Paths.get("./target/" + projectName + "/" + projectName + "/src/main/java/com/" + packageName
					+ "/service/" + className + "Service.java");

			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String generateControllerDisplay(String projectName, String packageName, String modelName) {
		String className = modelName.substring(0, 1).toUpperCase() + modelName.substring(1);
		String packageNameValue = "package com." + packageName + ".service;";
		StringBuilder imports = buildImports(packageName, className);
		StringBuilder classDef = buildClassDef(packageName, className,modelName );
		return  packageNameValue + " \n" + imports.toString() + "\n"+ classDef.toString();
}
	
	private static StringBuilder buildImports(String packageName, String className) {
		StringBuilder build = new StringBuilder();
		build.append("\n\nimport com." + packageName+"."+ className+";\r\n");
		build.append("import org.springframework.stereotype.Service;\r\n");
		return build;
	}
	
	
	private static StringBuilder buildClassDef(String packageName, String className, String modelName) {
		String serviceName= className +"Service";
		StringBuilder build = new StringBuilder();
		build.append("@Service\r\n");
		build.append("public class " + serviceName + " {\n\n");
		build.append(buildCreateMethod(packageName,  className,  modelName));
		build.append(buildGetMethod(packageName,  className,  modelName));
		build.append(buildUpdateMethod(packageName,  className,  modelName));
		build.append("\n}\n");
		return build;
	}
	
	private static StringBuilder buildCreateMethod(String packageName, String className, String modelName) {
		String methodName= " create"+ className;
		StringBuilder build = new StringBuilder();
		build.append("\npublic  " + className  +" "+ methodName +"("+ className +" "+ modelName+"){\n\n");
		build.append("return "+ modelName+";\n");
		build.append("}\n\n");
		return build;
	}
	
	private static StringBuilder buildUpdateMethod(String packageName, String className, String modelName) {
		String methodName= " update"+ className;
		StringBuilder build = new StringBuilder();
		build.append("\npublic  " + className  +" "+ methodName +"("+ className +" "+ modelName+"){\n\n");
		build.append("return "+ modelName+";\n");
		build.append("}\n\n");
		return build;
	}
	
	
	
	private static StringBuilder buildGetMethod(String packageName, String className, String modelName) {
		String methodName= " find"+ className;
		String filed="field";
		String filedType = "String";
		StringBuilder build = new StringBuilder();
		build.append("public " + className  +" "+ methodName +"("+ filedType + "  " + filed+"){\n\n");
		build.append("return null;\n");
		build.append("}\n\n");
		return build;
	}
	
	 public static void main(String[] args) {
		  System.out.println(generateControllerDisplay("Town", "town", "person"));
	   }
	

}
