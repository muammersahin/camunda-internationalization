package org.camunda.bpm.main;

import java.io.IOException;

import org.camunda.bpm.getstarted.services.DownloadWebAppFiles;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import net.lingala.zip4j.exception.ZipException;

public class JarFileCreatorMainClass {

	// Path Selection
	@Option(name = "-p", required = true, usage = "Camunda Project Path")
	public static String CAMUNDA_PATH = "/";

	// Version Selection
	@Option(name = "-v", required = true, usage = "WebApp Version")
	public static String CAMUNDA_WEBAPP_VERSION = "7.9.0";

	public static void main(String[] args) throws IOException, ZipException {
		System.exit(new JarFileCreatorMainClass().run(args));

	}

	private int run(String[] args) throws IOException, ZipException {

		CmdLineParser p = new CmdLineParser(this);
		try {
			p.parseArgument(args);
			run();
			return 0;
		} catch (CmdLineException e) {
			System.err.println(e.getMessage());
			p.printUsage(System.err);
			return 1;
		}
	}

	private void run() throws IOException, ZipException {
		// Declare Static Objects
		DownloadWebAppFiles.camundaPath = CAMUNDA_PATH;
		DownloadWebAppFiles.camundaWebAppVersion = CAMUNDA_WEBAPP_VERSION;

		DownloadWebAppFiles.download_pom_file();

	}

}
