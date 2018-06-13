import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class AlteredSequence extends Frame
{
	static AlteredSequence frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    frame= new AlteredSequence();
				    frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AlteredSequence()
	{
		int i,j;
		Button b[] = new Button[7];
    char ch='A',x[][]=new char[7][4];
    String str1="",str2="",str3="";
    for(i=0;i<7;i++)
    {
      for(j=0;j<4;j++)
      {
        x[i][j]=ch;
        ch++;
        if(x[i][j]>'Z')
        {
          x[i][j]=' ';
        }
      }
    }
    try
    {
      FileReader fr1 = new FileReader("ABC.txt");
      while ((i=fr1.read()) != -1)
      {
          str1+=(char)i;
      }
    }
    catch(FileNotFoundException foe)
    {
      System.out.println("exception occured"+ foe);
    }
    catch(IOException ioe)
    {
      System.out.println("exception occured"+ ioe);
    }
    int n = Integer.parseInt(str1);
    try
    {
      FileReader fr2 = new FileReader("ABCD.txt");
      while ((i=fr2.read()) != -1)
      {
        str2+=(char)i;
      }
    }
    catch(FileNotFoundException foe)
    {
      System.out.println("exception occured"+ foe);
    }
    catch(IOException ioe)
    {
      System.out.println("exception occured"+ ioe);
    }
    String[] its = str2.split(" "); 
    int[] k = new int[its.length]; 
    for (i = 0; i < k.length; i++)
    {
      k[i] = Integer.parseInt(its[i]); 
    }
    Label lb=new Label("Please press appropriate column buttons from below which constitute your word in a sequential order for last time..."); 
    lb.setFont(new Font("Tahoma", Font.PLAIN, 26));
    lb.setForeground(Color.RED); 
    lb.setBounds(25,50,1350,30);
    add(lb);
    char y[][]=new char[n][7];
    Label la[][] = new Label[n][7];
    for(i=0;i<n;i++)
    {
      for(j=0;j<7;j++)
      {
          y[i][j]=x[j][k[i]];
          la[i][j]=new Label(String.valueOf(y[i][j]));
          la[i][j].setBounds(375+(100*j),150+(40*i),30,35);
          la[i][j].setFont(new Font("Tahoma", Font.PLAIN, 26));
		      la[i][j].setForeground(Color.BLUE);
		      add(la[i][j]);
      }
    }
	  File file = new File("ABCDE.txt");
	  try     
    {
       BufferedWriter bw = new BufferedWriter(new FileWriter(file));
       bw.write("");
       bw.close();
    }
    catch (IOException ie)
    {
       System.out.println("exception occured"+ ie);
    }
	  for(i=0;i<7;i++)
	  {
	    	b[i]=new Button("Column "+String.valueOf(i+1));
    	  b[i].setBounds(350+(100*i),100,85,40);
        b[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
		    b[i].setBackground(Color.CYAN);
		    add(b[i]);
		    int p=i;
        b[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        try {
              BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
              bw.write((char)(p+48)+" ");
              bw.close();
            }
        catch (IOException ie) 
        {
            System.out.println("exception occured"+ ie);
        }
        }
       });
	 }
   Button b1=new Button("NEXT");
   b1.setFont(new Font("Tahoma", Font.PLAIN, 28));
   b1.setBackground(Color.CYAN);
   b1.setBounds(1150,650,150,60);
   add(b1);
   b1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   Solution.main(new String[]{});
   frame.dispose();
   }
   });
   setLayout(null);
   setSize(1370,730);
   setBackground(Color.ORANGE);
   addWindowListener(new WindowAdapter()
   {
     public void windowClosing(WindowEvent ae)
      {
        System.exit(0);
      }
    });
	}
}