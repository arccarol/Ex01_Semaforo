package controller;

import java.util.concurrent.Semaphore;

public class Semáforo01 extends Thread{
	
	private int idCarro;
	private String sentido;
	private Semaphore semaforo;

	public Semáforo01(String sentido, Semaphore semaforo) {
		this.idCarro = (int) this.getId();
		this.sentido = sentido;
		this.semaforo = semaforo;
	}
	
	public void run() {
		 carromove();
		 
		 //inicio da seção critica
		 try {
			 semaforo.acquire();
			 carroparado();
		 }catch (Exception e) {
			 e.printStackTrace();
		 }finally {
			 //obriga a rodar
			 semaforo.release();
			//fim da seção critica
		 }
		 carropassando();
	}
	
	public void carromove() {
		int temp = 1000;
		int distperco = 0;
		
		while(distperco < 100) {
			distperco = distperco + (int) ((Math.random() * 5) + 10);
			try {
				Thread.sleep(temp);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O Carro " + idCarro + " já percorreu " + distperco + " metros");
		}
	}
	
	private void carroparado() {
		
		System.out.println("O carro" +idCarro +" parou no cruzamento");
		
		}
	
	private void carropassando() {
		System.out.println("O Carro cruzou do sentido " + sentido);
	

	}

}
