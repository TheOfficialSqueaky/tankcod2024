// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.lang.ModuleLayer.Controller;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.ColorSensorV3.MainControl;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  private Timer timer;
  private XboxController main_Controller;
  private double starttime;
  private double deltaTime;
  private double currentTime;
  private double endtime;

  private final CANSparkMax m_frontLeftMotor = new CANSparkMax(4, MotorType.kBrushless);
  private final CANSparkMax m_frontRightMotor = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax m_backLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax m_backRightMotor = new CANSparkMax(3, MotorType.kBrushless);

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    //m_frontLeftMotor.follow(m_backLeftMotor);
    //m_frontRightMotor.follow(m_backRightMotor); 
    m_backLeftMotor.setInverted(true);

    m_myRobot = new DifferentialDrive(m_backRightMotor, m_backLeftMotor);
    main_Controller = new XboxController(0);
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
  

  }

  @Override
  public void teleopInit(){
   starttime = timer.getFPGATimestamp();
   deltaTime = 0;
  }


  public double round(double Num){
    return Math.floor(Num*100)/100;
  }

  
  @Override
  public void teleopPeriodic() {
    //m_myRobot.tankDrive(-main_Controller.getLeftY(), -main_Controller.getRightY());
    //timer.
    
    currentTime = timer.getFPGATimestamp();
    System.out.println("Start: "+starttime + "\nDelta: " + round(deltaTime)+ "\nCurrent: " + currentTime +"\n---------");
    deltaTime = currentTime - starttime;
    
    

    
      
  }

  //@Override
  //public void autono
}
