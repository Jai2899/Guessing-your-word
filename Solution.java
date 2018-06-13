import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class Solution extends Frame
{
	static Solution frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    frame= new Solution();
				    frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Solution()
	{
		int i,j;
    String str1="",str2="",str3="",answer="";
		char ch='A',x[][]=new char[7][4];
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
      System.out.println("exception occoured"+ foe);
    }
    catch(IOException ioe)
    {
      System.out.println("exception occoured"+ ioe);
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
      System.out.println("exception occoured"+ foe);
    }
    catch(IOException ioe)
    {
      System.out.println("exception occoured"+ ioe);
    }
    String[] its = str2.split(" "); 
    int[] k = new int[its.length]; 
    for (i = 0; i < k.length; i++)
    {
      k[i] = Integer.parseInt(its[i]); 
    }
    char y[][]=new char[n][7];
    for(i=0;i<n;i++)
    {
      for(j=0;j<7;j++)
        {
            y[i][j]=x[j][k[i]];
        }            
    }
    try
    {
      FileReader fr3 = new FileReader("ABCDE.txt");
      while ((i=fr3.read()) != -1)
      {
      str3+=(char)i;
      }
    }
    catch(FileNotFoundException foe)
    {
      System.out.println("exception occoured"+ foe);
    }
    catch(IOException ioe)
    {
      System.out.println("exception occoured"+ ioe);
    }
    String[] its2 = str3.split(" "); 
    int[] k2 = new int[n]; 
    for (i = 0; i < n; i++)
    {
        k2[i] = Integer.parseInt(its2[i]); 
    }
    for(i=0;i<n;i++)
    {
      answer+=y[i][k2[i]];
   	}
    Label la=new Label("Your word is : ");
    la.setFont(new Font("Tahoma", Font.PLAIN, 48));
		la.setForeground(Color.RED); 
    la.setBounds(450,300,290,55);
    Label lb=new Label(answer); 
    lb.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lb.setForeground(Color.BLUE); 
    lb.setBounds(750,300,400,60);
    add(la);
    add(lb);
    Button b1=new Button("Thanq");
    b1.setFont(new Font("Tahoma", Font.PLAIN, 28));
    b1.setBackground(Color.CYAN);
    b1.setBounds(1150,650,150,60);
    add(b1);
    b1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    System.exit(0);
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