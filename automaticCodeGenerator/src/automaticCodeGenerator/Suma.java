package automaticCodeGenerator;



public class Suma extends Operaciones{
	
	private int paramA;
	private int paramB;

	
	public Suma(int A, int B){
		paramA = A;
		paramB = B;
		
		
	}
	@Override
	public int operar(){
		
		return paramA+paramB;
	}
	@Override
	public int operar(int anterior) {
		paramA = anterior;
		return operar();
	}
	

}
