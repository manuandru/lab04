package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.Robot;

/**
 *  A Robot that can handle objects
 *
 */
public interface RobotWithArms extends Robot {
	
	/**
	 * picks an object
	 * @returns true if the action is success
	 */
	boolean pickUp();
	
	/**
	 * drops an object 
	 * @returns true if the action is successful
	 */
	boolean dropDown();
	
	/**
	 * @returns the number of objects this robot is currently transporting
	 */
	int getCarriedItemsCount();
}
