// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

/** Add your docs here. */
public class ArmFunctions {
        ///radians
        public double UpperAngle(double a, double b, double h, double x, double y) {
                return (2 * Math.atan((((a * a * (-1.0)) + (b * a * 2.0) + (b * b * (-1.0)) + h * h + x * x
                                + (y * h * (-2.0)) + y * y)
                                * (1.0)
                                / (Math.sqrt(((a * (-1.0)) + b
                                                + Math.sqrt((h * h + x * x + (y * h * (-2.0)) + y * y)))))
                                * (1.0)
                                / (Math.sqrt((a + (b * (-1.0))
                                                + Math.sqrt((h * h + x * x + (y * h * (-2.0)) + y * y)))))
                                * (1.0)
                                / (Math.sqrt((a + b
                                                + (Math.sqrt((h * h + x * x + (y * h * (-2.0)) + y * y)) * (-1.0)))))
                                * (1.0)
                                / (Math.sqrt((a + b + Math.sqrt((h * h + x * x + (y * h * (-2.0)) + y * y))))))));
        }
        ///radians
        public double LowerAngle(double a, double b, double h, double x, double y) {
                return (2
                                * (Math.atan(((1.0)
                                                / (((x * a * a) + (x * b * b * (-1.0)) + (x * h * h) + x * x * x
                                                                + (y * x * h * (-2.0))
                                                                + (y * y * x)
                                                                + (((Math.sqrt(
                                                                                (a + (b * (-1.0)) + Math.sqrt((h * h
                                                                                                + x * x
                                                                                                + (y * h * (-2.0))
                                                                                                + y * y))))
                                                                                * Math.sqrt((a + b
                                                                                                + (Math.sqrt((h * h
                                                                                                                + x * x
                                                                                                                + (y * h * (-2.0))
                                                                                                                + y * y))
                                                                                                                * (-1.0))))
                                                                                * Math.sqrt((a + b + Math.sqrt((h * h
                                                                                                + x * x
                                                                                                + (y * h * (-2.0))
                                                                                                + y * y))))
                                                                                * h)
                                                                                + (Math.sqrt((a + (b * (-1.0))
                                                                                                + Math.sqrt((h * h
                                                                                                                + x * x
                                                                                                                + (y * h * (-2.0))
                                                                                                                + y * y))))
                                                                                                * Math.sqrt((a + b
                                                                                                                + (Math.sqrt((h * h
                                                                                                                                + x * x
                                                                                                                                + (y * h * (-2.0))
                                                                                                                                + y * y))
                                                                                                                                * (-1.0))))
                                                                                                * Math.sqrt(
                                                                                                                (a + b + Math.sqrt(
                                                                                                                                (h * h + x * x + (y
                                                                                                                                                * h
                                                                                                                                                * (-2.0))
                                                                                                                                                + y * y))))
                                                                                                * y * (-1.0)))
                                                                                * Math.sqrt(((a * (-1.0)) + b
                                                                                                + Math.sqrt((h * h
                                                                                                                + x * x
                                                                                                                + (y * h * (-2.0))
                                                                                                                + y * y)))))))
                                                * ((h * a * a * (-1.0)) + (h * b * b) + (h * h * a * 2.0)
                                                                + (h * h * h * (-1.0))
                                                                + (x * x * a * 2.0) + (x * x * h * (-1.0)) + (y * a * a)
                                                                + (y * b * b * (-1.0))
                                                                + (y * h * a * (-4.0)) + (y * h * h * 3.0) + (y * x * x)
                                                                + (y * y * a * 2.0)
                                                                + (y * y * h * (-3.0)) + y * y * y
                                                                + (Math.sqrt(((a * (-1.0)) + b + Math.sqrt((h * h
                                                                                + x * x + (y * h * (-2.0)) + y * y))))
                                                                                * Math.sqrt((a + (b * (-1.0))
                                                                                                + Math.sqrt((h * h
                                                                                                                + x * x
                                                                                                                + (y * h * (-2.0))
                                                                                                                + y * y))))
                                                                                * Math.sqrt((a + b
                                                                                                + (Math.sqrt((h * h
                                                                                                                + x * x
                                                                                                                + (y * h * (-2.0))
                                                                                                                + y * y))
                                                                                                                * (-1.0))))
                                                                                * Math.sqrt((a + b + Math.sqrt((h * h
                                                                                                + x * x
                                                                                                + (y * h * (-2.0))
                                                                                                + y * y))))
                                                                                * x))
                                                * (-1.0))) * (-1.0)));
        }
}
