package org.camunda.bpm.getstarted.services;

import java.io.File;
import java.util.ArrayList;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class InternationalizationCamundaBPM {

	@SuppressWarnings("unchecked")
	public static void insertTurkishLanguage() throws ZipException {

		String localePath = DownloadWebAppFiles.camundaPath + "camunda-bpm-springboot-webapp.jar";

		ZipFile zipFile = new ZipFile(new File(localePath));

		@SuppressWarnings("rawtypes")
		ArrayList filesToAdd = new ArrayList();
		filesToAdd.add(new File(DownloadWebAppFiles.camundaPath + "/tr.json"));

		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

		parameters.setRootFolderInZip("META-INF\\resources\\app\\admin\\locales\\");

		zipFile.addFiles(filesToAdd, parameters);

		parameters.setRootFolderInZip("META-INF\\resources\\app\\admin\\scripts\\");
		zipFile.removeFile("META-INF\\resources\\app\\admin\\scripts\\config.js");
		filesToAdd.remove(0);
		filesToAdd.add(new File(DownloadWebAppFiles.camundaPath + "/config.js"));

		zipFile.addFiles(filesToAdd, parameters);

	}

}
