package automaticCodeGenerator;



public class Repeticion extends Operaciones{
	private Operaciones operacion; //utilizamos la poliformia
	private int numero;
	
	
	public Repeticion(int numeroRepeticiones, Operaciones operacionRepeticion) {
		operacion = operacionRepeticion;
		numero = numeroRepeticiones;
	}

	@Override
	public int operar() {
		int resultado = 0;
		resultado+=(operacion.operar());
		for (int i = 0; i<numero-2; i++) {
			resultado = operacion.operar(resultado); 
		}
		return resultado;
	}

	@Override
	public int operar(int anterior) {
		// TODO Auto-generated method stub
		return 0;
	}

}
