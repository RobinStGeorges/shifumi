

public class Main {

	public static void main(String[] args) {
		Runnable task = () -> {
			try {
				ShifumiServer.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};

		Runnable task2 = () -> {
			try {
				ShifumiClient.start();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		};
		
		Thread r1=new Thread(task);
		Thread r2=new Thread(task2);
		
		r1.start();
		r2.start();
	}

}
