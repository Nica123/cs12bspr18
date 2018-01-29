import java.awt.Color;

import java.awt.Graphics;

/**
 * A simple class that holds the size, color, and location of a colored disk,
 * with a method for drawing the circle in a graphics context.  The circle
 * is drawn as a filled oval, with a black outline.
 *
 * It also holde the velocity vx and vy of the circle in terms of
 * the change in x and y respectively in pixels per second.
 * We also assume the circles are on a rectanular board which limits their movement
 */
public class CircleShape {
	  public static int boardWidth=500;
		public static int boardHeight=500;

    public double radius;     // The radius of the circle.
    public double x,y;       // The location of the center of the circle.
    public Color color;   // The color of the circle.
		private double vx=20;
		private double vy=10;

    /**
     * Create a CircleShape with a given location and radius and with a
     * randomly selected, semi-transparent color.
     * @param centerX   The x coordinate of the center.
     * @param centerY   The y coordinate of the center.
     * @param rad       The radius of the circle.
     */
    public CircleShape( double x, double y, int radius ) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        int red = (int)(255*Math.random());
        int green = (int)(255*Math.random());
        int blue = (int)(255*Math.random());
        this.color = new Color(red,green,blue, 100);

    }

		/**
				create a circle with a random position and velocity and color
		*/
		public CircleShape() {
			  this(0,0,10);
				this.x = (int)(500*Math.random());
				this.y = (int)(500*Math.random());
			  this.radius = 10 + (int)(40*Math.random());
				this.vx = (int)(50*Math.random()-25);
				this.vy = (int)(50*Math.random()-25);
		}

    /**
     * Draw the disk in graphics context g, with a black outline.
		 * Its posiion is given by doubles so we have to convert them to integers!
     */
    public void draw( Graphics g ) {
				int u = (int)(x-radius);
				int v = (int)(y-radius);
				int r = (int)(2*radius);
        g.setColor( color );
        g.fillOval( u,v,r,r );
        g.setColor( Color.BLACK );
        g.drawOval(u,v,r,r );
    }

		/**
		    update the position of the circleShape after dt seconds
				@param dt the number of seconds for the update (e.g. 0.02)
		*/
		public void update(double dt){
			// change the properties of the CircleShape after dt seconds have elapsed.
			this.x += 0;  \\ for now they do not move
			this.y += 0;

			this.keepOnBoard();
		}

		public String toString(){
			return "circle("+this.x+","+this.y+","+this.radius+")";
		}

		/**
			change the values of x,y,vx,vy to keep the circle on the board
		*/
		public void keepOnBoard(){
			if (this.x < this.radius) {
				// it went off the left edge! do something!

			}else if (this.x > CircleShape.boardWidth-this.radius) {
				// it went off the right edge! do something!
			}

			if (this.y < this.radius){
				// it went above the top edge!

			} else if (this.y > CircleShape.boardHeight-this.radius) {
				// it went below the bottom edge!
			}
		}
}
