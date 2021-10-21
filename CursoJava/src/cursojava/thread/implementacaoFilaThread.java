package cursojava.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class implementacaoFilaThread extends Thread{
	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = 
			new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_fila.add(objetoFilaThread);
	}
	@Override
	public void run() {
		System.out.println("Fila Rodando");
		
		while(true) {
			
			/*Bloqueia o acesso a lista por outro processo*/
			synchronized (pilha_fila) {
				Iterator iteracao =  pilha_fila.iterator();
			
				//Enquanto tiver dados na lista irá processar
				while(iteracao.hasNext()) {
					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();
					/*processar 10 mil notas fiscais*/
					/*Gerar uma lista enorme de PDF*/
					/*Envio em massa de email*/
					System.out.println("-------------------------------");
					System.out.println(processar.getEmail());
					System.out.println(processar.getNome());
					iteracao.remove();
					try {
						Thread.sleep(100);/*Dar um tempo para descarga de memória*/
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}		
		
			try {
				Thread.sleep(1000);/*Aguarda para pegar uma nova carga de trabalho*/
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
