//Pablo Manuel Fernandez Velazquez

package EcoCity;

public class CocheElectrico extends Vehiculo{
	//Atributos
	private int nivelBateria;
	
	//Constructor
	public CocheElectrico(int idVehiculo, String marca, double tarifaBaseDiaria, int nivelBateria){
		super(idVehiculo, marca, tarifaBaseDiaria);
		this.nivelBateria = nivelBateria;
	}
	
	//Metodos
	@Override
	public String toString(){
		return super.toString() + String.format("\nNivel de bateria: %d%%",nivelBateria);
	}
	
	@Override
	public double calcularCosteAlquiler(int dias){
		double coste;
		double descuento;
		
		coste = (tarifaBaseDiaria * dias);
		
		if(dias >= 5){
			descuento = (coste * 10) / 100;
			coste = coste - descuento;
		}
		
		return coste;
	}
}
