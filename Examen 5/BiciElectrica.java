//Pablo Manuel Fernandez Velazquez

package EcoCity;

public class BiciElectrica extends Vehiculo{
	//Atributos
	private boolean incluyeCasco = false;
	
	//Constructor
	public BiciElectrica(int idVehiculo, String marca, double tarifaBaseDiaria, boolean incluyeCasco){
		super(idVehiculo, marca, tarifaBaseDiaria);
		this.incluyeCasco = incluyeCasco;
	}
	
	//Metodos
	@Override
	public String toString(){
		return super.toString() + String.format("\nIncluye Casco: %b",incluyeCasco);
	}
	
	@Override
	public double calcularCosteAlquiler(int dias){
		double coste;
		double extra;
		
		coste = tarifaBaseDiaria * dias;
		
		if(incluyeCasco = true){
			extra = dias * 2;
			
			coste = coste + extra;
		}
		
		return coste;
	}
}
