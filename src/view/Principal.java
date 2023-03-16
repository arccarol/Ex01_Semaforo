	package view;

	import java.util.concurrent.Semaphore;
	import controller.Semáforo01;

	public class Principal {
		
		public static void main(String[] args) {
			String[] sentidos = { "Norte para o Sul", "Leste para o Oeste", "Oeste para o Leste", "Sul para o Norte" };
			int permissoes = 1;
			Semaphore semaforo = new Semaphore(permissoes);
			for (int i = 1; i <= 4; i++) {
			Semáforo01 carro = new Semáforo01(sentidos[i - 1], semaforo);
				carro.start();
			}

	}
	}


