package automaticCodeGenerator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class Interfaz extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreFuncion;
	private JLabel lblNewLabel;
	private JLabel lblParmetros;
	private JLabel lblFuncionamiento;
	private JCheckBox checkA;
	private JCheckBox checkB;
	private JTextPane paneDefinicion;
	private JCheckBox checkC;
	private JCheckBox checkD;
	private JLabel lblFuncionesDefinidas;
	private JButton btnNewButton;
	private JTextPane lista;
	private ArrayList<String> funcionesDisponibles;
	public static final String MAYOR_QUE = "mayorQue";
	public static final String MENOR_QUE = "menorQue";
	public static final String MENOR_IGUAL_QUE = "menorIgualQue";
	public static final String MAYOR_IGUAL_QUE = "mayorIgualQue";
	public static final String IGUAL_QUE = "igualQue";
	public static final String DISTINTO_QUE= "distintoQue";
	public boolean flagMientras;
	public int numParam;
	private JRadioButton radioVariable;
	private JTextField textoDevolucion;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		numParam = 0;

		lblNewLabel = new JLabel("Nueva función");
		lblNewLabel.setBounds(320, 75, 100, 15);
		contentPane.add(lblNewLabel);

		lblParmetros = new JLabel("Parámetros");
		lblParmetros.setBounds(320, 155, 100, 33);
		contentPane.add(lblParmetros);
		flagMientras = false;
		lblFuncionamiento = new JLabel("Definición");
		lblFuncionamiento.setBounds(320, 247, 134, 15);
		contentPane.add(lblFuncionamiento);

		checkA = new JCheckBox("A");
		checkA.setBounds(467, 160, 129, 23);
		contentPane.add(checkA);

		checkB = new JCheckBox("B");
		checkB.setBounds(605, 160, 129, 23);
		contentPane.add(checkB);

		paneDefinicion = new JTextPane();
		paneDefinicion.setBounds(437, 271, 380, 188);
		contentPane.add(paneDefinicion);

		checkC = new JCheckBox("C");
		checkC.setBounds(741, 160, 129, 23);
		contentPane.add(checkC);

		checkD = new JCheckBox("D");
		checkD.setBounds(874, 160, 129, 23);
		contentPane.add(checkD);

		nombreFuncion = new JTextField();
		nombreFuncion.setBounds(482, 73, 186, 19);
		contentPane.add(nombreFuncion);
		nombreFuncion.setColumns(10);

		lblFuncionesDefinidas = new JLabel("Funciones definidas");
		lblFuncionesDefinidas.setBounds(47, 66, 150, 33);
		contentPane.add(lblFuncionesDefinidas);

		btnNewButton = new JButton("Crear");

		funcionesDisponibles = new ArrayList<String>();

		listarFunciones();

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				generar();

			}
		});
		btnNewButton.setBounds(775, 70, 117, 25);
		contentPane.add(btnNewButton);


		lista = new JTextPane();
		lista.setBounds(47, 191, 155, 268);
		System.out.println(funcionesDisponibles.toString());
		lista.setText(funcionesDisponibles.toString());
		contentPane.add(lista);

		textoDevolucion = new JTextField();
		textoDevolucion.setColumns(10);
		textoDevolucion.setBounds(548, 515, 186, 19);
		contentPane.add(textoDevolucion);

		label = new JLabel("Variable a devolver");
		label.setBounds(320, 517, 198, 15);
		contentPane.add(label);
	}

	public void generar() {
		int numeroParametros = 0;
		String nombreFun = nombreFuncion.getText();
		StringBuilder resultado = new StringBuilder();
		StringBuilder definicion = new StringBuilder(paneDefinicion.getText());

		if (checkA.isSelected())
			numeroParametros++;
		if (checkB.isSelected())
			numeroParametros++;
		if (checkC.isSelected())
			numeroParametros++;
		if (checkD.isSelected())
			numeroParametros++;
		numParam = numeroParametros;
		resultado.append("package automaticCodeGenerator;\n\n" + "\n" + "public class ");
		resultado.append(nombreFun);
		resultado.append(" extends Operaciones{\n\n");

		for (int i = 0; i < numeroParametros; i++) {
			resultado.append("\tprivate int " + (char) (65 + i) + ";\n"); // he quitado "param" +
		}
		resultado.append("\tprivate int numParam= "+numeroParametros +";\n");
		String quepum = "resultado: ";
		resultado.append("\n\tpublic static void main(String[] args) {\n\t\t"+nombreFun+" objeto = new "+nombreFun+ "(");
		for(int i = 1; i < numeroParametros; i++) {
			resultado.append("1, ");
		}
		resultado.append("1);\n\t");
		resultado.append("\tSystem.out.println(objeto.operar());\n\t}");
		resultado.append("\n\tpublic ");
		resultado.append(nombreFun + "(");
		for (int i = 0; i < numeroParametros; i++) {
			resultado.append("int " + (char) (65 + i) + ", ");
		}
		resultado.replace(resultado.length() - 2, resultado.length() - 1, "){\n\n");
		for (int i = 0; i < numeroParametros; i++) {
			resultado.append("\t\tthis." + (char) (65 + i) + " = " + (char) (65 + i) + ";\n"); //he quitado "param"
		}
		resultado.append("\t}\n\n");
		resultado.append("\t@Override\n" + "\tpublic int operar(){\n\t\tint resultado;\n");

		resultado.append(traducir(definicion));
		resultado.append("\t@Override\n\t\tpublic int operar(int anterior) {\n\t\tA = anterior;\n\t\treturn operar();\n\t}\n}");
		System.out.println(resultado.toString());

		exportar(nombreFun, resultado.toString());
		//listarFunciones();
		resetear(nombreFun);
	}

	public void resetear(String nombreLista) {
		nombreFuncion.setText("");
		funcionesDisponibles.add(nombreLista);
		lista.setText(funcionesDisponibles.toString());
		checkA.setSelected(false);
		checkB.setSelected(false);
		paneDefinicion.setText("");
		checkC.setSelected(false);
		checkD.setSelected(false);
		flagMientras = false;
		textoDevolucion.setText("");


	}

	public void exportar(String nombre, String cuerpo) {

		FileWriter fichero = null; 
		try {
			fichero = new FileWriter("src/automaticCodeGenerator/"+nombre+".java");
			fichero.write(cuerpo);
			fichero.close();
		}catch(Exception err){
			System.out.println("Excepcion: "+err.getMessage());
		}

	}

	public void listarFunciones() {

		String path = "src/automaticCodeGenerator/";
		String nameFiles;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		int indiceEliminar_Oper = 0;
		int indiceEliminar_Inter = 0;
		for(int i = 0; i < listOfFiles.length; i++) {

			if(listOfFiles[i].isFile()) {
				nameFiles = listOfFiles[i].getName();
				if(nameFiles.endsWith(".java")) {

					String sinExtension = nameFiles.replace(".java", "");
					funcionesDisponibles.add(sinExtension);
				}
			}
		}

		for(int j = 0; j < funcionesDisponibles.size(); j++) {

			if(funcionesDisponibles.get(j).equals("Operaciones")) {
				indiceEliminar_Oper = j;
			}
		}

		for(int z = 0; z < funcionesDisponibles.size(); z++) {

			if(funcionesDisponibles.get(z).equals("Interfaz")) {
				indiceEliminar_Oper = z;
			}
		}

		funcionesDisponibles.remove(indiceEliminar_Oper);
		funcionesDisponibles.remove(indiceEliminar_Inter);

	}

	public boolean esFuncion(String palabras) {
		for (String funcion : funcionesDisponibles)
			if (palabras.equalsIgnoreCase(funcion) || palabras.equalsIgnoreCase("FIN")) {
				return true;
			}
		return false;
	}

	public String traducir(StringBuilder definicion) {

		int objetoN = 1;
		StringBuilder resultado = new StringBuilder();
		int temp = 0;
		String auxiliar = "";
		ArrayList<String> palabras = new ArrayList<String>();

		while (temp < definicion.length()) {

			if (definicion.toString().charAt(temp) == " ".charAt(0)) {
				palabras.add(auxiliar);
				auxiliar = "";
			} else {
				auxiliar = auxiliar + definicion.charAt(temp);
				if (temp+1 == definicion.length())
					palabras.add(auxiliar);
			}
			temp++;
		}

		ArrayList<String> parametrosTemporales = new ArrayList<String>();
		ArrayList<String> declaracionFunciones = new ArrayList<String>();

		for (int i = palabras.size()-1; i >= 0; i--) { 
			if (esFuncion(palabras.get(i))) {
				String temporal = "";

				if (palabras.get(i).equalsIgnoreCase("FIN")) {
					flagMientras = true;
					int posicionMientras = -1;
					for (int x = 0; x< palabras.size()-1; x++) {
						if (palabras.get(x).equalsIgnoreCase("MIENTRAS")) {
							posicionMientras = x;
							i = posicionMientras;
							x = palabras.size();
						}
					}
					String primerOperando, segundoOpearando;
					posicionMientras++;
					temporal += "\t\twhile(" + palabras.get(posicionMientras); 
					primerOperando = palabras.get(posicionMientras); 
					posicionMientras++;
					switch (palabras.get(posicionMientras)){

					case MAYOR_IGUAL_QUE:
						temporal += " >= ";
						break;
					case MENOR_IGUAL_QUE:
						temporal += " <= ";
						break;
					case MENOR_QUE:
						temporal += " < ";
						break;
					case MAYOR_QUE:
						temporal += " > ";
						break;
					case DISTINTO_QUE:
						temporal+= " != ";
						break;
					case IGUAL_QUE:
						temporal += " == ";
						break;
					}
					posicionMientras++;
					temporal += palabras.get(posicionMientras) + "){\n\t\t"; //while(a > b){
					segundoOpearando = palabras.get(posicionMientras); //b
					posicionMientras++; //Restar

					while(!palabras.get(posicionMientras).equalsIgnoreCase("fin") ) {
						String primerParametroOperacion = "", segundoParametroOperacion = "", tercerParametroOperacion = "", operacion = palabras.get(posicionMientras); 
						posicionMientras++;
						primerParametroOperacion = palabras.get(posicionMientras); //Restar -->X<--
						posicionMientras++; 
						if (!esFuncion(palabras.get(posicionMientras)) && !palabras.get(posicionMientras).equalsIgnoreCase("fin")) { //segundo param
							segundoParametroOperacion = palabras.get(posicionMientras); //Restar X -->Y<--
							posicionMientras++;
						}else if (!esFuncion(palabras.get(posicionMientras)) && !palabras.get(posicionMientras).equalsIgnoreCase("fin")) { //tercer param
							tercerParametroOperacion = palabras.get(posicionMientras); //Restar X Y -->Z<--
							posicionMientras++;
						}
						temporal += "\t"+ primerParametroOperacion+ " = new " + operacion + "("+ primerParametroOperacion;
						if (segundoParametroOperacion != "") {
							temporal += ", " + segundoParametroOperacion;
						}else if (tercerParametroOperacion != "") {
							temporal += ", " + tercerParametroOperacion;
						}
						temporal += ").operar();\n\t\t"; // X = new Restar(X,...);
					}
					temporal += "}\n";
					declaracionFunciones.add(temporal);

				}else {
					temporal = "\t\t" + palabras.get(i) + " objeto" + objetoN + " = new " +palabras.get(i) + "(";
					for (int j = (parametrosTemporales.size()-1); j>=0; j--) {
						temporal += (parametrosTemporales.get(j));
						if (parametrosTemporales.get(j).startsWith("objeto")) {
							if (!palabras.get(i).equals("Repeticion")) {
								temporal += ".operar()";
							}
						}
						//if (parametrosTemporales.get(j).substring(0,4).equalsIgnoreCase("obje")) //en caso de recursividad revisar esto
						//temporal+=".operar()";

						temporal+= ", ";
					}

					temporal = temporal.substring(0, temporal.length()-2); //supongo que toda funcion tiene almenos un parametro
					temporal += ");\n";
					declaracionFunciones.add(temporal);
					parametrosTemporales = new ArrayList<String>();
					parametrosTemporales.add("objeto"+objetoN);
					objetoN++;
				}
			}else {
				if (palabras.get(i) == "numParam") {
					parametrosTemporales.add("numParametros");
				}else {
					parametrosTemporales.add(palabras.get(i)); //he quitado "param"+
				}

			}

		}
		for (String e: declaracionFunciones){
			resultado.append(e.toString());
		}
		if (flagMientras) {
			resultado.append("\t\tresultado = ");
			String tempo = textoDevolucion.getText();
			if (tempo.equals("A")) {
				resultado.append("A;\n");
			}else if(tempo.equals("B")){
				resultado.append("B;\n");
			}else if(tempo.equals("C")) {
				resultado.append("C;\n");
			}else if(tempo.equals("D")) {
				resultado.append("D;\n");
			}
			resultado.append("\t\tSystem.out.println(\"Estado final variables: A: \" + A ");
			if (checkB.isSelected())
				resultado.append("+ \" B: \" + B ");
			else if(checkC.isSelected())
				resultado.append("+ \" C: \" + C ");
			else if (checkD.isSelected())
				resultado.append("+ \" D: \" + D");
			resultado.append(" );\n");
		}else {
			resultado.append("\t\tresultado = objeto" + (objetoN-1)+ ".operar();\n");
		}
		resultado.append("\t\treturn resultado;\n\t}\n");
		return resultado.toString();
	}
}
