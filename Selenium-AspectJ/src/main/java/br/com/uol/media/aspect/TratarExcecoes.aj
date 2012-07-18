package br.com.uol.media.aspect;

import java.io.File;

import br.com.uol.media.configuration.SeleniumTestCase;

public aspect TratarExcecoes extends SeleniumTestCase {
	
	// Ponto de corte
	pointcut tratamentoExcecao(Exception e): handler(Exception+) && args(e);
	
	// Advice
	before(Exception e) : tratamentoExcecao(e) {
		selenium.captureScreenshot(new File("pom.xml").getAbsolutePath().replace("pom.xml", "src\\test\\resource\\printErro\\tratamentoExcecao.png"));
	}

}
