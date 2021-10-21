package cursojava.thread;

import javax.swing.JOptionPane;

public class AulaThread {
	public static void main(String[] args) throws InterruptedException {
		//Thread processando em paralelo do envio de email
		Thread threadEmail = new Thread(thread1) ;
		threadEmail.start();
		
		
		/***************************** DIVISÃO DAS THREADS ***********************************/
		Thread threadNotas = new Thread(thread2) ;
		threadNotas.start();
		
		
		
		/*Código chegou ao fim*/
		System.out.println("Fim");
		JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuario");
	}
	private static Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
			//Executa o que queremos
			//Código da rotina
			/*Código que será executado em paralelo*/
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i+" - Enviando Email ...");
			}
			
		}
	};
private static Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			//Executa o que queremos
			//Código da rotina
			/*Código que será executado em paralelo*/
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i+" - Enviando Nota ...");
			}
			
		}
	};
}
