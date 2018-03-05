package es.tecnilogica.abstracto;

public class Coche implements Vehiculo{

	private Motor motor;

	@Override
	public void conducir() {
		System.out.println("Conduciendo Coche");

	}

	@Override
	public String cambioColor() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the motor
	 */
	public Motor getMotor() {
		return motor;
	}

	/**
	 * @param motor the motor to set
	 */
	public void setMotor(Motor motor) {
		this.motor = motor;
	}

}
