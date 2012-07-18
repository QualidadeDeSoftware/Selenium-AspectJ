package br.com.uol.media.test.home;

import org.junit.Test;

import br.com.uol.media.configuration.SeleniumTestCase;

public class Busca extends SeleniumTestCase {
	
	@Test
	public void testBuscaComSucesso() throws Exception {
		selenium.open("/home");
		selenium.type("id=q", "ivete sangalo");
		selenium.click("id=submitbutton");
		
		for (int second = 0;; second++) {
			if (second >= 5) fail("timeout");
			try { if (selenium.isTextPresent("Você buscou por ivete sangalo")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}
	
	@Test
	public void testBuscaComFalha() throws Exception {
		selenium.open("/home");
		selenium.type("id=q", "ivete sangalo");
		selenium.click("id=submitbutton");
		
		for (int second = 0;; second++) {
			if (second >= 5) fail("timeout");
			
			// Provoca Falha
			try { if (selenium.isTextPresent("Você buscou por roberto carlos")) break; } catch (Exception e) {}
			
			Thread.sleep(1000);
		}
	}
	
	@Test
	public void testBuscaComExcecao() throws Exception {
		selenium.open("/home");
		selenium.type("id=q", "ivete sangalo");
		selenium.click("id=submitbutton");
		
		// Provoca Exceção
		selenium.close();
		
		for (int second = 0;; second++) {
			if (second >= 5) break;
			try { if (selenium.isTextPresent("Você buscou por ivete sangalo")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}
}
