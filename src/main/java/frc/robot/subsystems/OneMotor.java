// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OneMotor extends SubsystemBase {

  private CANSparkMax spark;
  private RelativeEncoder enc;
  private double lastSpeed;

  /** Creates a new ExampleSubsystem. */
  public OneMotor() {
    System.out.println("Subsystem init!");

    spark = new CANSparkMax(8, MotorType.kBrushless);
    enc = spark.getEncoder();

    lastSpeed = 0.0;
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
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  public void speed(Double s) {
    spark.set(s);
    lastSpeed = s;
  }

  public Double get() {
    return spark.get();
  }

  public Double lastSpeed() {
    return lastSpeed;
  }

  public void stop() {
    Double oldSpeed = spark.get();
    spark.set(0);
    lastSpeed = oldSpeed;
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
