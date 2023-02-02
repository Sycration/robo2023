// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final int LF = 8;
  public static final int LB = 7;
  public static final int RF = 5;
  public static final int RB = 14;

  public static final double SpeedScale = 0.5;

  public static final String LimelightName = "KakyloptekUponTheKaidu";
  //PV url http://kakyloptekuponthekaidu.local:5800/
  public static final int RollingAverageLength = 14;
  public static final double AimDivide = 5;
  public static final double AimSpeedScale = 0.3;

  public static final double AimPidP = 1.0;
  public static final double AimPidI = 0.0;
  public static final double AimPidD = 0.0;



  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
