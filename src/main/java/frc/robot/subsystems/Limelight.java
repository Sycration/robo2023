// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
  public static Double avg = 0.0;

  public Limelight() {
    avg = 0.0;
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
      PhotonTrackedTarget target = camera.getLatestResult().getBestTarget();
      Double current = 0.0;
      if (!Objects.isNull(target)) {
        current = target.getYaw();
      }
      
      for (int i = 0; i < avgList.length - 1; i++) {
        avgList [i] = avgList[(i+1)];
      }
      avgList[avgList.length - 1 ] = current;

      Double average = 0.0;
      for (Double d : avgList) {
        average += d;
      }
      average = average/avgList.length;
      avg = average;
      //System.out.println(avgList.toString());
      SmartDashboard.putNumber("Limelight current", current);
      SmartDashboard.putNumberArray("Limelight target rolling avg array", avgList);
      SmartDashboard.putNumber("Limelight average", average);
    }
  }

  public static Double getYaw() {
    if (avg.isNaN()) {
      return 0.0;
    }
    if (avg.isInfinite()) {
      return 0.0;
    }
    return avg;
  }
}
