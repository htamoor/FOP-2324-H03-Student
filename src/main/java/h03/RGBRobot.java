package h03;

import fopbot.RobotFamily;

import static fopbot.RobotFamily.*;
import static fopbot.RobotFamily.SQUARE_RED;

/**
 * A {@link RGBRobot} is a {@link MultiFamilyRobot} with a sequence of the robot families (possibly inverted)
 * {@link RobotFamily#SQUARE_RED}, {@link RobotFamily#SQUARE_GREEN} and {@link RobotFamily#SQUARE_BLUE}.
 */
public class RGBRobot extends MultiFamilyRobot {

    private static final RobotFamily[] fam = new RobotFamily[]{SQUARE_RED, SQUARE_GREEN, SQUARE_BLUE};
    private static final RobotFamily[] fam1 = new RobotFamily[]{SQUARE_BLUE, SQUARE_GREEN, SQUARE_RED};

    /**
     * Constructs a {@link RGBRobot} on the given position with a sequence of the robot families
     * {@link RobotFamily#SQUARE_RED}, {@link RobotFamily#SQUARE_GREEN} and {@link RobotFamily#SQUARE_BLUE}.
     *
     * @param x        the position on the x-axis
     * @param y        the position on the y-axis
     * @param inverted whether the sequence of predefined robot families should be inverted
     */
    public RGBRobot(int x, int y, boolean inverted) {
        super(x, y, !inverted ? fam : fam1);
    }

    /**
     * Exchanges the current robot family three times to cycle through all robot families.
     */
    public void testRGB() {
        exchange();
        exchange();
        exchange();
    }


}
