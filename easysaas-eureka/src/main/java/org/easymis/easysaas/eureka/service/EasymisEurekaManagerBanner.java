package org.easymis.easysaas.eureka.service;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.core.env.Environment;

public class EasymisEurekaManagerBanner implements Banner {

	public static final String VERSION = "1.0.0.RELEASE";
	//http://patorjk.com/software/taag/#p=display&h=1&v=1&f=Big&t=EASYMIS-EUREKA
	private static final String BANNER =
			"  ______             _____ __     __ __  __  _____   _____         ______  _    _  _____   ______  _  __          \n" +
			" |  ____|    /\\     / ____|\\ \\   / /|  \\/  ||_   _| / ____|       |  ____|| |  | ||  __ \\ |  ____|| |/ /    /\\    \n" +
			" | |__      /  \\   | (___   \\ \\_/ / | \\  / |  | |  | (___  ______ | |__   | |  | || |__) || |__   | ' /    /  \\   \n" +
			" |  __|    / /\\ \\   \\___ \\   \\   /  | |\\/| |  | |   \\___ \\|______||  __|  | |  | ||  _  / |  __|  |  <    / /\\ \\  \n" +
			" | |____  / ____ \\  ____) |   | |   | |  | | _| |_  ____) |       | |____ | |__| || | \\ \\ | |____ | . \\  / ____ \\ \n" +
			" |______|/_/    \\_\\|_____/    |_|   |_|  |_||_____||_____/        |______| \\____/ |_|  \\_\\|______||_|\\_\\/_/    \\_\\\n" +
			"                                                                                                                  \n" +
			"                                                                                                                  ";
	private static final String SERVER_INFO = "      EASYMIS-%s HTTP port:%s  DATAEASYMIS port:%s";
	@Override
	public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {
		String serverPortProperty = environment.getProperty("server.port");
		String managerPortProperty = environment.getProperty("easymis.eureka.manager.port");
		int managerPort;
		int httpPort = 8080;
		if (serverPortProperty != null) {
			httpPort = Integer.parseInt(serverPortProperty);
		}
		if (managerPortProperty != null) {
			managerPort = Integer.parseInt(managerPortProperty);
		} else {
			managerPort = httpPort + 100;
		}
		String string = String.format(SERVER_INFO, VERSION, httpPort, managerPort);
		printStream.println();
		printStream.println(AnsiOutput.toString(AnsiColor.GREEN, BANNER));
		printStream.println();
		printStream.println(AnsiOutput.toString(AnsiColor.GREEN, string));
		printStream.println();

	}
}