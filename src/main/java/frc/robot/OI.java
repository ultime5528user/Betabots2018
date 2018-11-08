/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.CracherBalles;
import frc.robot.commands.PrendreBalles;
import frc.robot.commands.Viser;

public class OI {

  private Joystick joystick;
  private JoystickButton button1, button2, button3;

  public OI() {

    joystick = new Joystick(0);

    button1 = new JoystickButton(joystick, 1);
    button1.toggleWhenPressed(new PrendreBalles());

    button2 = new JoystickButton(joystick, 2);
    button2.toggleWhenPressed(new CracherBalles());

    button3 = new JoystickButton(joystick, 3);
    button3.toggleWhenPressed(new Viser());


  }

  public Joystick getJoystick() {

    return joystick;

  }

}