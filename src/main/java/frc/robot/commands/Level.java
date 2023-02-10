// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Level extends PIDCommand {
  /** Creates a new Level. */
  public Level() {
    super(
        // The controller that the command will use
        new PIDController(Constants.LevelPidP, Constants.LevelPidI, Constants.AimPidD),
        // This should return the measurement
        () -> RobotContainer.gyroscope.getPitch(),
        // This should return the setpoint (can also be a constant)
        () -> 0,
        // This uses the output
        output -> {
          // Use the output here
          RobotContainer.drive.drive(
              Math.min(output * Constants.LevelSpeedScale, Constants.LevelMaxSpeed),
              Math.min(output * Constants.LevelSpeedScale, Constants.LevelMaxSpeed));
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.gyroscope);
    addRequirements(RobotContainer.drive);

    // Configure additional PID options by calling `getController` here.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
