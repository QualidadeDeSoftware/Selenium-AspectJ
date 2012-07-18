package br.com.uol.media.aspect;

import java.io.File;

import br.com.uol.media.configuration.SeleniumTestCase;

public aspect TratarFalhasSelenium extends SeleniumTestCase {
	
	// Ponto de corte	
	pointcut tratamentoFalha() : call (* *.fail(*));

	// Advice
	before() : tratamentoFalha() {
		selenium.captureScreenshot(new File("pom.xml").getAbsolutePath().replace("pom.xml", "src\\test\\resource\\printErro\\tratamentoFalha.png"));
	}
	
}
