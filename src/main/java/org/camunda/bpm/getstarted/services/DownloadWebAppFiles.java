package org.camunda.bpm.getstarted.services;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import net.lingala.zip4j.exception.ZipException;

public class DownloadWebAppFiles {

	public static String camundaPath;
	public static String camundaWebAppVersion;

	public static void download_pom_file() throws IOException, ZipException {

		URL url = new URL("https://raw.githubusercontent.com/muammersahin/camunda-bpm-langs/master/pom.xml");

		File webappJSON = new File(camundaPath + "/pom.xml");

		File webappJar = new File(camundaPath + "/camunda-bpm-springboot-webapp.jar");

		if (!webappJar.exists()) {

			FileUtils.copyURLToFile(url, webappJSON);
			System.out.println("Pom downloaded");
			download_webapp_config_file();
			download_webapp_jar_file();
			download_webapp_tr_json_file();
			InternationalizationCamundaBPM.insertTurkishLanguage();
			System.out.println("All files have downloaded. Please update Maven. Rerun the program.");
			System.exit(0);
		}

	}

	public static void download_webapp_tr_json_file() throws IOException {

		URL url = new URL(
				"https://raw.githubusercontent.com/muammersahin/camunda-bpm-langs/master/admin/locale/tr.json");

		File webappJSON = new File(camundaPath + "/tr.json");

		if (!webappJSON.exists()) {

			FileUtils.copyURLToFile(url, webappJSON);

			System.out.println("JSON Downloaded");
		}

	}

	public static void download_webapp_config_file() throws IOException {

		URL url = new URL(
				"https://raw.githubusercontent.com/muammersahin/camunda-bpm-langs/master/admin/script/config.js");

		File webappConfig = new File(camundaPath + "/config.js");

		if (!webappConfig.exists()) {
			FileUtils.copyURLToFile(url, webappConfig);

			System.out.println("Config Downloaded");

		}

	}

	public static void download_webapp_jar_file() throws IOException, ZipException {

		URL url = new URL("http://central.maven.org/maven2/org/camunda/bpm/webapp/camunda-webapp-webjar/"
				+ camundaWebAppVersion + "/camunda-webapp-webjar-" + camundaWebAppVersion + ".jar");

		File webappJar = new File(camundaPath + "/camunda-bpm-springboot-webapp.jar");

		if (!webappJar.exists()) {
			FileUtils.copyURLToFile(url, webappJar);

			System.out.println("Jar downloaded");

		}

	}

}
