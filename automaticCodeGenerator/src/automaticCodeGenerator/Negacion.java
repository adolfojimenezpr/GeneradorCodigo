package automaticCodeGenerator;



public class Negacion extends Operaciones{
	private int numero;
	
	public Negacion(int numeroANegar) {
		numero = numeroANegar;
	}
	@Override
	public int operar() {
		return -numero;
	}
	@Override
	public int operar(int anterior) {
		// TODO Auto-generated method stub
		return 0;
	}
}
