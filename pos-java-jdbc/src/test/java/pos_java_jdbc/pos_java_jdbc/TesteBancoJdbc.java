package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import conexaojdbc.SingleConnection;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		//pegue a versão mais nova do Junit para aparecer o teste
		SingleConnection.getConnection();
	}
}
