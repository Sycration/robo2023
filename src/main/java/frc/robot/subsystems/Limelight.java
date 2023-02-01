// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  /** Creates a new Limelight. */

  Double[] avgList;
  PhotonCamera camera;

  public Limelight() {
    camera = new PhotonCamera("OV5647");
    avgList = new Double[Constants.RollingAverageLength];
    for (int i = 0; i < avgList.length; i++) {
      avgList[i] = 0.0;
    }
  }

  @Override
  public void periodic() {
    Boolean connected = camera.isConnected();
    SmartDashboard.putBoolean("PV connected", connected);
    if (connected) {
      Double current = camera.getLatestResult().getBestTarget().getYaw();
      for (int i = 0; i < avgList.length - 1; i++) {
        avgList [i] = avgList[(i+1)];
      }
      avgList[avgList.length - 1 ] = current;

      Double average = 0.0;
      for (Double d : avgList) {
        average += d;
      }
      average = average/avgList.length;
      //System.out.println(avgList.toString());
      SmartDashboard.putNumber("Limelight current", current);
      SmartDashboard.putNumberArray("Limelight target rolling avg array", avgList);
      SmartDashboard.putNumber("Limelight average", average);
    }
  }
}
