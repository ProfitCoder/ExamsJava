//Pablo Manuel Fernandez Velazquez

package EcoCity;

public class GestorEcoCity{
	public static void main(String [] args){
		//Declaración de variables y objetos
		Vehiculo[] vehiculos = new Vehiculo[4];
		
		vehiculos[0] = new CocheElectrico(1,"Seat",150.00,100);
		vehiculos[1] = new CocheElectrico(2,"Tesla",200.00,100);
		vehiculos[2] = new BiciElectrica(3,"Trek",50.00,true);
		vehiculos[3] = new BiciElectrica(4,"Mondraker",50.00,false);	
		
		
		//Resto ejercicio
		System.out.println("****************** INFORME **************");
		for(int i = 0;i < vehiculos.length;i++){
			System.out.println(vehiculos[i]);
			System.out.println("El coste por un alquiler de 7 dias es: " + vehiculos[i].calcularCosteAlquiler(7) + "€");
			System.out.println("****************************************");
		}
	}
}
