// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Gyroscope extends SubsystemBase {
  PigeonIMU gyro;

  double startPitch = 0;
  /** Creates a new RioGyroscope. */
  public Gyroscope() {
    gyro = new PigeonIMU(Constants.PigeonBusID);
    startPitch = gyro.getPitch();
  }

  public double getPitch() {
    return gyro.getPitch() - startPitch;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
