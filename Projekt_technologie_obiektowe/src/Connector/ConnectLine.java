package Connector;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.*;
import java.awt.geom.Point2D.*;

public class ConnectLine {
    public static final int LINE_TYPE_SIMPLE = 0;
    public static final int LINE_TYPE_RECT_1BREAK = 1;
    public static final int LINE_TYPE_RECT_2BREAK = 2;

    public static final int LINE_START_HORIZONTAL = 0;
    public static final int LINE_START_VERTICAL = 1;

    public static final int LINE_ARROW_NONE = 0;
    public static final int LINE_ARROW_SOURCE = 1;
    public static final int LINE_ARROW_DEST = 2;
    public static final int LINE_ARROW_BOTH = 3;
    public static final int LINE_INHERITANCE = 4;

    public static int LINE_ARROW_WIDTH = 10;

    Point p1;

    Point p2;

    int lineType = LINE_TYPE_SIMPLE;

    int lineStart = LINE_START_HORIZONTAL;

    int lineArrow = LINE_ARROW_NONE;

    public ConnectLine(Point p1, Point p2) {
        this(p1, p2, LINE_TYPE_SIMPLE, LINE_START_HORIZONTAL, LINE_ARROW_NONE);
    }


    public ConnectLine(Point p1, Point p2, int lineType, int lineStart, int lineArrow) {
        this.p1 = p1;
        this.p2 = p2;
        this.lineType = lineType;
        this.lineStart = lineStart;
        this.lineArrow = lineArrow;
    }


    public void paint(Graphics2D g2d) {
        switch (lineType) {
            case LINE_TYPE_SIMPLE:
                paintSimple(g2d);
                break;
            case LINE_TYPE_RECT_1BREAK:
                paint1Break(g2d);
                break;
            case LINE_TYPE_RECT_2BREAK:
                paint2Breaks(g2d);
                break;
        }
    }

    protected void paintSimple(Graphics2D g2d) {
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        switch (lineArrow) {
            case LINE_ARROW_DEST:
                paintArrow(g2d, p1, p2);
                paintRelationOne(g2d,p2,p1);
                break;
            case LINE_ARROW_SOURCE:
                paintArrow(g2d, p2, p1);
                break;
            case LINE_ARROW_BOTH:
                paintArrow(g2d, p1, p2);
                paintArrow(g2d, p2, p1);
                break;
            case LINE_INHERITANCE:
                paintInheritanceArrow(g2d, p1, p2);
                break;
        }
    }

    protected void paintArrow(Graphics2D g2d, Point p1, Point p2) {
        paintArrow(g2d, p1, p2, getRestrictedArrowWidth(p1, p2));
    }

   protected void paintArrow(Graphics2D g2d, Point p1, Point p2, int width) {
        int  x1=p2.x,x2=p2.x,y1=p2.y,y2=p2.y;

       if(p1.x>p2.x) {
           y1 += 5;
           y2+=-5;
       }
       if(p1.x<p2.x) {
          y1 +=5;
           y2 +=-5;
       }
       if(p1.y>p2.y) {
           x1 +=5;
          x2 +=-5;
       }
       if(p1.y<p2.y) {
          x1 +=5;
           x2+=-5;
       }
        p2=shiftPoints(p1,p2,10);

        g2d.drawLine(p2.x, p2.y,x1, y1);
        g2d.drawLine(p2.x, p2.y,x2, y2);

    }

     private Point shiftPoints(Point p1,Point p2,int shift){
        if(p1.x>p2.x)
             p2.x+=shift;
         if(p1.x<p2.x)
             p2.x+=-shift;
         if(p1.y>p2.y)
             p2.y+=shift;
         if(p1.y<p2.y)
             p2.y+=-shift;
         return p2;
     }
    protected void paintRelationOne(Graphics2D g2d, Point p1, Point p2) {
        Point2D.Float pp1 = new Point2D.Float(p1.x, p1.y);
        Point2D.Float pp2 = new Point2D.Float(p2.x, p2.y);
        Point2D.Float left = getLeftArrowPoint(pp1, pp2, 30);
        Point2D.Float right = getRightArrowPoint(pp1, pp2, 30);

        g2d.drawLine(Math.round(right.x), Math.round(right.y), Math.round(left.x), Math.round(left.y));

    }

   /* protected void paintArrow(Graphics2D g2d, Point p1, Point p2, int width) {
        Point2D.Float pp1 = new Point2D.Float(p1.x, p1.y);
        Point2D.Float pp2 = new Point2D.Float(p2.x, p2.y);
        Point2D.Float left = getLeftArrowPoint(pp1, pp2, width);
        Point2D.Float right = getRightArrowPoint(pp1, pp2, width);

        g2d.drawLine(p2.x, p2.y, Math.round(left.x), Math.round(left.y));
        g2d.drawLine(p2.x, p2.y, Math.round(right.x), Math.round(right.y));
    }*/

  protected void paintInheritanceArrow(Graphics2D g2d, Point p1, Point p2) {
      Point2D.Float pp1 = new Point2D.Float(p1.x, p1.y);
      Point2D.Float pp2 = new Point2D.Float(p2.x, p2.y);
      Point2D.Float left = getLeftArrowPoint(pp1, pp2, 30);
      Point2D.Float right = getRightArrowPoint(pp1, pp2, 30);

      g2d.drawLine(p2.x, p2.y, Math.round(left.x), Math.round(left.y));
      g2d.drawLine(p2.x, p2.y, Math.round(right.x), Math.round(right.y));
      g2d.drawLine(Math.round(left.x), Math.round(left.y), Math.round(right.x), Math.round(right.y));
  }

    protected void paint1Break(Graphics2D g2d) {
        if (lineStart == LINE_START_HORIZONTAL) {
            g2d.drawLine(p1.x, p1.y, p2.x, p1.y);
            g2d.drawLine(p2.x, p1.y, p2.x, p2.y);
            switch (lineArrow) {
                case LINE_ARROW_DEST:
                    paintArrow(g2d, new Point(p2.x, p1.y), p2);
                    paintRelationOne(g2d, new Point(p2.x, p1.y),p1);
                    break;
                case LINE_ARROW_SOURCE:
                    paintArrow(g2d, new Point(p2.x, p1.y), p1);
                    break;
                case LINE_ARROW_BOTH:
                    paintArrow(g2d, new Point(p2.x, p1.y), p2);
                    paintArrow(g2d, new Point(p2.x, p1.y), p1);
                    break;
                case LINE_INHERITANCE:
                    paintInheritanceArrow(g2d, new Point(p2.x, p1.y), p2);
                    break;
            }
        }
        else if (lineStart == LINE_START_VERTICAL) {
            g2d.drawLine(p1.x, p1.y, p1.x, p2.y);
            g2d.drawLine(p1.x, p2.y, p2.x, p2.y);
            switch (lineArrow) {
                case LINE_ARROW_DEST:
                    paintArrow(g2d, new Point(p1.x, p2.y), p2);
                    paintRelationOne(g2d,new Point(p1.x, p2.y),p1);
                    break;
                case LINE_ARROW_SOURCE:
                    paintArrow(g2d, new Point(p1.x, p2.y), p1);
                    break;
                case LINE_ARROW_BOTH:
                    paintArrow(g2d, new Point(p1.x, p2.y), p2);
                    paintArrow(g2d, new Point(p1.x, p2.y), p1);
                    break;
                case LINE_INHERITANCE:
                    paintInheritanceArrow(g2d, new Point(p1.x, p2.y), p2);
                    break;
            }
        }
    }

    protected void paint2Breaks(Graphics2D g2d) {
        if (lineStart == LINE_START_HORIZONTAL) {
            g2d.drawLine(p1.x, p1.y, p1.x + (p2.x - p1.x) / 2, p1.y);
            g2d.drawLine(p1.x + (p2.x - p1.x) / 2, p1.y, p1.x + (p2.x - p1.x) / 2, p2.y);
            g2d.drawLine(p1.x + (p2.x - p1.x) / 2, p2.y, p2.x, p2.y);
            switch (lineArrow) {
                case LINE_ARROW_DEST:
                    paintArrow(g2d, new Point(p1.x + (p2.x - p1.x) / 2, p2.y), p2);
                    paintRelationOne(g2d,new Point(p1.x + (p2.x - p1.x) / 2, p1.y),p1);
                    break;
                case LINE_ARROW_SOURCE:
                    paintArrow(g2d, new Point(p1.x + (p2.x - p1.x) / 2, p1.y), p1);
                    break;
                case LINE_ARROW_BOTH:
                    paintArrow(g2d, new Point(p1.x + (p2.x - p1.x) / 2, p2.y), p2);
                    paintArrow(g2d, new Point(p1.x + (p2.x - p1.x) / 2, p1.y), p1);
                    break;
                case LINE_INHERITANCE:
                    paintInheritanceArrow(g2d, new Point(p1.x + (p2.x - p1.x) / 2, p2.y), p2);
                    break;
            }
        }
        else if (lineStart == LINE_START_VERTICAL) {
            g2d.drawLine(p1.x, p1.y, p1.x, p1.y + (p2.y - p1.y) / 2);
            g2d.drawLine(p1.x, p1.y + (p2.y - p1.y) / 2, p2.x, p1.y + (p2.y - p1.y) / 2);
            g2d.drawLine(p2.x, p1.y + (p2.y - p1.y) / 2, p2.x, p2.y);

            switch (lineArrow) {
                case LINE_ARROW_DEST:
                    paintArrow(g2d, new Point(p2.x, p1.y + (p2.y - p1.y) / 2), p2);
                    paintRelationOne(g2d,new Point(p1.x, p1.y + (p2.y - p1.y) / 2),p1);
                    break;
                case LINE_ARROW_SOURCE:
                    paintArrow(g2d, new Point(p1.x, p1.y + (p2.y - p1.y) / 2), p1);
                    break;
                case LINE_ARROW_BOTH:
                    paintArrow(g2d, new Point(p2.x, p1.y + (p2.y - p1.y) / 2), p2);
                    paintArrow(g2d, new Point(p1.x, p1.y + (p2.y - p1.y) / 2), p1);
                    break;
                case LINE_INHERITANCE:
                    paintInheritanceArrow(g2d,new Point(p2.x, p1.y + (p2.y - p1.y) / 2), p2);
                    break;
            }
        }
    }

    public int getLineType() {
        return lineType;
    }

    public void setLineType(int type) {
        lineType = type;
    }

    public int getLineStart() {
        return lineStart;
    }

    public void setLineStart(int start) {
        lineStart = start;
    }

    public int getLineArrow() {
        return lineArrow;
    }

    public void setLineArrow(int arrow) {
        lineType = lineArrow;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p) {
        p1 = p;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p) {
        p2 = p;
    }

    protected static Point2D.Float getMidArrowPoint(Point2D.Float p1, Point2D.Float p2, float w) {
        Point2D.Float res = new Point2D.Float();
        float d = Math.round(Math.sqrt( (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)));

        if (p1.x < p2.x) {
            res.x = p2.x - w * Math.abs(p1.x - p2.x) / d;
        }
        else {
            res.x = p2.x + w * Math.abs(p1.x - p2.x) / d;
        }

        if (p1.y < p2.y) {
            res.y = p2.y - w * Math.abs(p1.y - p2.y) / d;
        }
        else {
            res.y = p2.y + w * Math.abs(p1.y - p2.y) / d;
        }

        return res;
    }

    protected static Point2D.Float getLeftArrowPoint(Point2D.Float p1, Point2D.Float p2) {
        return getLeftArrowPoint(p1, p2, LINE_ARROW_WIDTH);
    }

    protected static Point2D.Float getLeftArrowPoint(Point2D.Float p1, Point2D.Float p2, float w) {
        Point2D.Float res = new Point2D.Float();
        double alpha = Math.PI / 2;
        if (p2.x != p1.x) {
            alpha = Math.atan( (p2.y - p1.y) / (p2.x - p1.x));
        }
        alpha += Math.PI / 10;
        float xShift = Math.abs(Math.round(Math.cos(alpha) * w));
        float yShift = Math.abs(Math.round(Math.sin(alpha) * w));
        if (p1.x <= p2.x) {
            res.x = p2.x - xShift;
        }
        else {
            res.x = p2.x + xShift;
        }
        if (p1.y < p2.y) {
            res.y = p2.y - yShift;
        }
        else {
            res.y = p2.y + yShift;
        }
        return res;
    }

    protected static Point2D.Float getRightArrowPoint(Point2D.Float p1, Point2D.Float p2) {
        return getRightArrowPoint(p1, p2, LINE_ARROW_WIDTH);
    }

    protected static Point2D.Float getRightArrowPoint(Point2D.Float p1, Point2D.Float p2, float w) {
        Point2D.Float res = new Point2D.Float();
        double alpha = Math.PI / 2;
        if (p2.x != p1.x) {
            alpha = Math.atan( (p2.y - p1.y) / (p2.x - p1.x));
        }
        alpha -= Math.PI / 10;
        float xShift = Math.abs(Math.round(Math.cos(alpha) * w));
        float yShift = Math.abs(Math.round(Math.sin(alpha) * w));
        if (p1.x < p2.x) {
            res.x = p2.x - xShift;
        }
        else {
            res.x = p2.x + xShift;
        }
        if (p1.y <= p2.y) {
            res.y = p2.y - yShift;
        }
        else {
            res.y = p2.y + yShift;
        }
        return res;
    }

    protected int getRestrictedArrowWidth(Point p1, Point p2) {
        return Math.min(LINE_ARROW_WIDTH, (int) Math.sqrt( (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)));
    }
}
