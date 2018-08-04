package com.user.autoGen.helper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PomGeneratorHelper {

	public static void generatePomFile(String projectName, String packageName) {
		try {
			packageName = "com."+packageName;
			String pomXml = Files.lines(Paths.get("./src/main/resources/pom.xml")).collect(Collectors.joining("\n"));
			pomXml = MessageFormat.format(pomXml, packageName,projectName,"jar", projectName );
			Path file = Paths.get("./target/" + projectName + "/"+ projectName + "/pom.xml");
			Files.write(file, Arrays.asList(pomXml), Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
}
