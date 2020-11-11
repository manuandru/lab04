package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;


public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {
	
	private static final int NUMBER_OF_ARMS = 2;
	private static final String NAME_OF_ARM = "arm ";
	public static final double DELTA_CONSUMPTION_FOREACH_CARRIED_OBJECT = 1.5;
	
	private final BasicArm[] arms;

	public RobotWithTwoArms(String robotName) {
		super(robotName);
		
		this.arms = new BasicArm[RobotWithTwoArms.NUMBER_OF_ARMS];
		for (int i = 0; i < NUMBER_OF_ARMS; i++) {
			arms[i] = new BasicArm(NAME_OF_ARM + i);
		}
	}


	
	/**
	 * @return true if it picks an object
	 */
	public boolean pickUp() {
		
		for (var arm : this.arms) {
			//need to check the battery
			if (!arm.isGrabbing()) {
				arm.pickUp();
				this.consumeBattery(arm.getConsuptionForPickUp());
				
				return true;
			}
		}
		
		return false;
	}

	

	
	/**
	 * @return true if it drops an object
	 */
	public boolean dropDown() {
		
		for (var arm : this.arms) {
			if (arm.isGrabbing()) {
				arm.dropDown();
				this.consumeBattery(arm.getConsuptionForDropDown());
				
				return true;
			}
		}
		
		return false;
	}

	

	public int getCarriedItemsCount() {
		
		int returnValue = 0;
		
		for (var arm : this.arms) {
			if (arm.isGrabbing()) {
				returnValue++;
			}
		}
		
		return returnValue;
	}



	/**
	 * @return the battery requires for movement with carried objects
	 */
	protected double getBatteryRequirementForMovement() {
		
		return super.getBatteryRequirementForMovement() + 
				this.getCarriedItemsCount() * RobotWithTwoArms.DELTA_CONSUMPTION_FOREACH_CARRIED_OBJECT;
	}
	
	
	
	

}
