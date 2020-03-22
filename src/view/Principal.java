package view;

import java.util.concurrent.Semaphore;

import controller.ThreadF1;

public class Principal {

	public static Semaphore semaforo1;
	public static Semaphore semaforo2;
	
	public static void main (String[] args) {
		
		int id;
		
		semaforo1 = new Semaphore(5);
		semaforo2 = new Semaphore(1);
		for (id = 1; id <= 2; id++) {
			
			Thread es1 = new ThreadF1(id, semaforo1, semaforo2);
			Thread es2 = new ThreadF1(id, semaforo1, semaforo2);
			Thread es3 = new ThreadF1(id, semaforo1, semaforo2);
			Thread es4 = new ThreadF1(id, semaforo1, semaforo2);
			Thread es5 = new ThreadF1(id, semaforo1, semaforo2);
			Thread es6 = new ThreadF1(id, semaforo1, semaforo2);
			Thread es7 = new ThreadF1(id, semaforo1, semaforo2);
			es1.start();
			es2.start();
			es3.start();
			es4.start();
			es5.start();
			es6.start();
			es7.start();
			
		}
	}
}
