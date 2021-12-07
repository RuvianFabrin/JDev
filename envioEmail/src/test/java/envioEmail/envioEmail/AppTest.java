package envioEmail.envioEmail;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	//Mesma coisa que o main
	@org.junit.Test
   public void testeEmail() throws Exception{
		
			ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("ruvian.fabrim@gmail.com", "Ruvian", "Teste Java", "Mensagem Java");
			  enviaEmail.enviarEmail();
			  //Caso o email não seja enviado coloque um sleep só pra testes
			  //Thread.sleep(5000);
			  
		
	}
	
	

}
