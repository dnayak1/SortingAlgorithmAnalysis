public class Application {

	public static void main(String args[]){
		
		System.out.println("abc");
		
		MainControl contrl = new MainControl();
		contrl.AnalyseAlgorithm();
		System.gc(); 
		System.out.println("Run complete");
	}
	
}
