package h03;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;

/**
 * A {@link RobotSynchronizer} is used to synchronize the position and direction of each robot of a set of robots
 * with a given position and direction.
 */
public class RobotSynchronizer {
    private final Robot[] robots;
    private int x = -1;
    private int y = -1;
    private Direction direction = null;


    /**
     * Constructs a {@link RobotSynchronizer} for the given set of robots.
     *
     * @param robots the set of robots
     */
    public RobotSynchronizer(Robot[] robots) {
        this.robots = robots;
    }

    /**
     * Sets the position on the x-axis to sync the robots with.
     * If an invalid position is passed, the position will leave unchanged.
     *
     * @param x the position on the x-axis
     */
    public void setX(int x) {
        if (0 <= x && x < World.getWidth()) {
            this.x = x;
        }
    }

    /**
     * Sets the position on the y-axis to sync the robots with.
     * If an invalid position is passed, the position will leave unchanged.
     *
     * @param y the position on the y-axis
     */
    public void setY(int y) {
        if (0 <= y && y < World.getHeight()) {
            this.y = y;
        }
    }

    /**
     * Sets the direction to sync the robots with.
     * If <code>null</code> is passed, the direction will leave unchanged.
     *
     * @param direction the direction
     */
    public void setDirection(Direction direction) {
        if (direction != null) {
            this.direction = direction;
        }
    }

    /**
     * Syncs each robot of the set of robots with the given position and direction.
     * If the position on the x- or y-axis or the direction is not set,
     * the current position/direction of the corresponding robot will be used instead.
     */
    public void sync() {
        for (Robot r : robots) {
            int goalX = (this.x != -1) ? this.x : r.getX();
            int goalY = (this.y != -1) ? this.y : r.getY();
            Direction goalDirection = (this.direction != null) ? this.direction : r.getDirection();

            while (!(r.getDirection() == goalDirection && r.getX() == goalX && r.getY() == goalY)) {
                while ((r.getDirection() == Direction.UP && r.getY() < goalY)
                    || (r.getDirection() == Direction.RIGHT && r.getX() < goalX)
                    || (r.getDirection() == Direction.DOWN && r.getY() > goalY)
                    || (r.getDirection() == Direction.LEFT && r.getX() > goalX)) {
                    r.move();
                }
                if (!(r.getDirection() == goalDirection && r.getX() == goalX && r.getY() == goalY)) {
                    r.turnLeft();
                }
            }
        }
    }


}
