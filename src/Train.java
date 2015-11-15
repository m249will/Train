import java.awt.*;
import java.applet.*;


public class Train extends Applet
{
    public void paint(Graphics g)
    {
        Point start = new Point(275,225);
        TrainCar traincar1 = new TrainCar(start,175,100,50,Color.red,Color.black);
        traincar1.drawTrainCar(g);
        
        Point start2 = new Point(475,225);
        TrainCar traincar2 = new TrainCar(start2,175,100,50,Color.green,Color.black);
        traincar2.drawTrainCar(g);
        
        Point start3 = new Point(75,225);
        //Locomotive locomotive = new Locomotive();
        Locomotive locomotive = new Locomotive(start3,175,100,50,Color.blue,Color.black);
        locomotive.drawTrainCar(g);
        locomotive.drawFunnel(g);
        locomotive.drawScoop(g);
        
        Point start4 = new Point(675,225);
        Caboose caboose = new Caboose(start4,175,100,50,Color.red,Color.black);
        caboose.drawTrainCar(g);
        caboose.drawWindows(g);
        caboose.drawCupola(g);
    }
}

class TrainCar
{
    private Point tcStart;
    private int bodyWidth;
    private int bodyHeight;
    private Point wheel1Start;
    private Point wheel2Start;
    private int wheelDiameter;
    private Color tcColor;
    private Color wheelColor;
    private int tempStartX;
    private int tempStartY;
    private int width;
    private int height;
    private Color connectorColor;
    
    public Point gettcStart()    {return tcStart;      }
    public int getbodyWidth()    {return bodyWidth;    }
    public int getbodyHeight()   {return bodyHeight;   }
    public Point getwheel1Start(){return wheel1Start;  }
    public Point getwheel2Start(){return wheel2Start;  }
    public int getwheelDiameter(){return wheelDiameter;}
    public Color gettcColor()    {return tcColor;      }
    public Color getwheelColor() {return wheelColor;   }
    
    public void settcStart(Point start)  {tcStart = start;   }
    public void setbodyWidth(int BW)     {bodyWidth = BW;    }
    public void setbodyHeight(int BH)    {bodyHeight = BH;   }
    public void setwheel1Start(Point W1S){wheel1Start = W1S; }
    public void setwheel2Start(Point W2S){wheel2Start = W2S; }
    public void setwheelDiameter(int WD) {wheelDiameter = WD;}
    public void setwheelColor(Color C)   {wheelColor = C;    }
    public void settcColor(Color C)      {tcColor = C;       }
    public void settempStartX(int x)     {tempStartX = x;    }
    public void settempStartY(int y)     {tempStartY = y;    }
    public void setWidth(int w)          {width = w;         }
    public void setHeight(int h)         {height = h;        }
    public void setConnectorColor(Color C){connectorColor = C;}
    
    public TrainCar()
    {
        tcColor = Color.red;
        wheelColor = Color.black;
        tcStart = new Point(100,100);
        bodyWidth = 150;
        bodyHeight = 75;
        wheelDiameter = 40;
        wheel1Start = new Point(tcStart.getX()+15, tcStart.getY()+50);
        wheel2Start = new Point(wheel1Start.getX()+75, wheel1Start.getY());
    }
    
    public TrainCar(Point tcStart, int width, int height, int diameter, Color car, Color wheel)
    {
        tcColor = car;
        wheelColor = wheel;
        this.tcStart = tcStart;
        bodyWidth = width;
        bodyHeight = height;
        wheelDiameter = diameter;
        wheel1Start = new Point(tcStart.getX()+25, tcStart.getY()+70);
        wheel2Start = new Point(wheel1Start.getX()+75, wheel1Start.getY());
        connectorColor = Color.black;
    }
    
    public void drawTrainCar(Graphics g)
    {
        g.setColor(tcColor);
        g.fillRect(tcStart.getX(),tcStart.getY(),bodyWidth,bodyHeight);
        g.setColor(wheelColor);
        g.fillOval(wheel1Start.getX(),wheel1Start.getY(),wheelDiameter,wheelDiameter);
        g.fillOval(wheel2Start.getX(),wheel2Start.getY(),wheelDiameter,wheelDiameter);
        
        g.setColor(connectorColor);
        tempStartX = tcStart.getX()-25;
        tempStartY = tcStart.getY()+40;
        width = 25;
        height = 20;
        g.fillRect(tempStartX,tempStartY,width,height);
    }
}

class Locomotive extends TrainCar
{
    private Point funnelStart;
    private Point scoopStart;
    
    public Locomotive()
    {
        funnelStart = new Point(125,100);
        scoopStart = new Point(100,150);
        setConnectorColor(Color.white);
    }
    
    public Locomotive(Point a, int b, int c, int d, Color e, Color f)
    {
        super(a,b,c,d,e,f);
        funnelStart = new Point(100,225);
        scoopStart = new Point(75,275);
        setConnectorColor(Color.white);
    }
   
    public void drawFunnel(Graphics g)
    {
        g.setColor(Color.black);
        Polygon funnel = new Polygon();
        funnel.addPoint(funnelStart.getX(),funnelStart.getY());
        funnel.addPoint(funnelStart.getX(),funnelStart.getY()-50);
        funnel.addPoint(funnelStart.getX()-25,funnelStart.getY()-75);
        funnel.addPoint(funnelStart.getX()-25,funnelStart.getY()-100);
        funnel.addPoint(funnelStart.getX()+50,funnelStart.getY()-100);
        funnel.addPoint(funnelStart.getX()+50,funnelStart.getY()-75);
        funnel.addPoint(funnelStart.getX()+25,funnelStart.getY()-50);
        funnel.addPoint(funnelStart.getX()+25,funnelStart.getY());
        g.fillPolygon(funnel);
    }
    
    public void drawScoop(Graphics g)
    {
        g.setColor(Color.black);
        Polygon scoop = new Polygon();
        scoop.addPoint(scoopStart.getX(),scoopStart.getY());
        scoop.addPoint(scoopStart.getX(),scoopStart.getY()+50);
        scoop.addPoint(scoopStart.getX()-50,scoopStart.getY()+50);
        g.fillPolygon(scoop);
    }
}

class Caboose extends TrainCar
{
    private Point windowsStart;
    
    public Caboose()
    {
        windowsStart = new Point(125,125);
    }
    
    public Caboose(Point a, int b, int c, int d, Color e, Color f)
    {
        super(a,b,c,d,e,f);
        windowsStart = new Point(700,240);
    }
    
    public void drawWindows(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(windowsStart.getX(),windowsStart.getY(),50,50);
        g.fillRect(windowsStart.getX()+75,windowsStart.getY(),50,50);
    }
    
    public void drawCupola(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(windowsStart.getX(),windowsStart.getY()-40,125,25);
        g.setColor(Color.black);
        g.fillRect(windowsStart.getX()-10,windowsStart.getY()-45,145,6);
    }
}
