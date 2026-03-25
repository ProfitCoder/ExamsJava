//Pablo Manuel Fernandez Velazquez

package EcoCity;

public class Vehiculo implements Alquilable{
	//Atributos
	protected int idVehiculo;
	protected String marca;
	protected double tarifaBaseDiaria;
	
	//Constructor
	public Vehiculo(int idVehiculo, String marca, double tarifaBaseDiaria){
		this.idVehiculo = idVehiculo;
		this.marca = marca;
		this.tarifaBaseDiaria = tarifaBaseDiaria;
	}
	
	//Metodos
	@Override
	public String toString(){
		return String.format("\nidVehiculo: %d\nMarca: %s\nTarifaBaseDiaria: %.2f",idVehiculo,marca,tarifaBaseDiaria);
	}
	
	@Override
	public double calcularCosteAlquiler(int dias){
		double ejemplo = 0.0;
		
		return ejemplo;
	}
}