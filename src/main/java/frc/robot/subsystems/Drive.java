// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ManualDrive;
import frc.robot.subsystems.Drive;

public class Drive extends SubsystemBase {
  MotorController leftfront;
  MotorController rightfront;
  MotorControllerGroup left;
  MotorController leftback;
  MotorController rightback;
  MotorControllerGroup right;
  DifferentialDrive drive;

  /** Creates a new ExampleSubsystem. */
  public Drive() {
    leftfront = new CANSparkMax(Constants.LF, MotorType.kBrushless);
      ((CANSparkMaxLowLevel) leftfront).restoreFactoryDefaults();
    leftback = new CANSparkMax(Constants.LB, MotorType.kBrushless);
      ((CANSparkMaxLowLevel) leftback).restoreFactoryDefaults();
    left = new MotorControllerGroup(leftfront, leftback);

    rightfront = new CANSparkMax(Constants.RF, MotorType.kBrushless);
      ((CANSparkMaxLowLevel) rightfront).restoreFactoryDefaults();
    rightback = new CANSparkMax(Constants.RB, MotorType.kBrushless);
      ((CANSparkMaxLowLevel) rightback).restoreFactoryDefaults();
    right = new MotorControllerGroup(rightfront, rightback);

    drive = new DifferentialDrive(left, right);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a
   * digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */

   public void drive(double l, double r) {
    double sgnL = Math.signum(l);
    double sgnR = Math.signum(r);
    drive.tankDrive(-(l*l * sgnL) * Constants.SpeedScale, (r*r * sgnR) * Constants.SpeedScale);
   }
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
