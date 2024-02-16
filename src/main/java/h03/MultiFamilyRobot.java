package h03;

import fopbot.Robot;
import fopbot.RobotFamily;

/**
 * A {@link MultiFamilyRobot} is a {@link Robot} that changes its robot family -
 * according to a given sequence of robot families - on each move.
 */
public class MultiFamilyRobot extends Robot {

    private RobotFamily[] families;
    private int counter;

    /**
     * Constructs a {@link MultiFamilyRobot} on the given position with the given families.
     *
     * @param x        the position on the x-axis
     * @param y        the position on the y-axis
     * @param families the sequence of families to change between
     */
    public MultiFamilyRobot(int x, int y, RobotFamily[] families) {
        super(x, y, families[0]);
        this.families = families;
    }

    /**
     * Exchanges the current robot family with the next one in the sequence.
     * If the current robot family is the last robot family in the sequence,
     * the first robot family in the sequence will be used again.
     */
    public void exchange() {
        counter = (counter + 1) % families.length;
        setRobotFamily(families[counter]);
    }
    @Override
    public void move() {
        super.move();
        exchange();
    }


/**
 * Moves the robot and exchanges the robot family, if <code>exchange</code> is <code>true</code>.
 * @para x change whether to exchange the robot family
 */
    public void move(boolean exchange) {
        super.move();
        if (exchange)
            exchange();
    }
}
