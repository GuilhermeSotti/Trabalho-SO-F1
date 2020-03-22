package controller;

import java.util.concurrent.Semaphore;

public class ThreadF1 extends Thread {

	private int id;
	private Semaphore semaforo1;
	private Semaphore semaforo2;
	private int vt[] = new int [7];
	private int[][] mt = new int [3][14];
	private int selecao[] = new int [14];
	
	public ThreadF1(int id, Semaphore semaforo1, Semaphore semaforo2) {
		
		this.id = id;
		this.semaforo1 = semaforo1;
		this.semaforo2 = semaforo2;
		
	}
	
	public void run() {
		
		try {
			semaforo1.acquire();
			corrida();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo1.release();
		}
	}

	private void corrida() {
		
		int ma = 0, aux;
		try {
			while (vt[(int) getId()] < 1) {
				
				if (vt[(int) getId()] < 1){
					
					semaforo2.acquire();
					vt[(int) getId()] = vt[(int) getId()] + 1;
					
					sleep(4);
					for (int x = (int) getId(); x == getId(); x++) {
						
						for (int y = 0; y < 3; y++) {
							
							mt[x][y] = (int)(Math.random()*2)+2;
							System.out.println("O carro ==> " + id + " da escuderia: " + getName() + 
							" fez a volta " + x + " em " + mt[x][y] + " minutos");
							if (ma < mt[x][y]) {
								ma = mt[x][y];
							}
						}
						System.out.println("A volta mais rápida do carro" + getId() + " é " + ma);
						selecao[(int) getId()] = ma;
					}
					
					for (int x = 0; x < (selecao.length - 1); x++) {
						
						if (selecao [x] < selecao [x +1]) {
							
							aux = selecao[x];
							selecao[x + 1] = selecao[x];
							selecao[x + 1] = aux;
						}
					}
					for (int x = 0; x < selecao.length; x++) {
						System.out.println("O corredor " + getId() + " ficou em " + x + "º lugar");
					}
					vt[(int) getId()] = vt[(int) getId()] -1;	
					break;
				}
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo2.release();
		}
		
	}
}
