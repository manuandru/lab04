package it.unibo.oop.lab04.robot.arms;


public class BasicArm {
	
	private static final double PICKUP_DELTA_CONSUMPTION = 1.5;
	private static final double DROPDOWN_DELTA_CONSUMPTION = 0.5;
	
	private final String name;
	private boolean isGrabbing;

	
	public BasicArm(String name) {
		this.name = name;
	}


	/**
	 * @return true if the arm is grabbing something
	 */
	public boolean isGrabbing() {
		return this.isGrabbing;
	}
	
	/**
	 *  pick up something
	 */
	public void pickUp() {
		this.isGrabbing = true;
	}
	
	
	/**
	 *  drop down something
	 */
	public void dropDown() {
		this.isGrabbing = false;
	}
	
	
	/**
	 * @return PICKUP_DELTA_CONSUMPTION
	 */
	public double getConsuptionForPickUp() {
		return PICKUP_DELTA_CONSUMPTION;
	}
	
	
	/**
	 * @return DROPDOWN_DELTA_CONSUMPTION
	 */
	public double getConsuptionForDropDown() {
		return DROPDOWN_DELTA_CONSUMPTION;
	}

	
	
	public String toString() {
		return "BasicArm [name=" + name + "]";
	}
	

}
