import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class DefaultSequence extends Frame
{
	static DefaultSequence frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    frame= new DefaultSequence();
				    frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public DefaultSequence()
	{
	Button b[] = new Button[4];
	int i,j,k,m,n;
    char ch='A',x[][]=new char[7][4];
    Label la[][] = new Label[7][4];
    Label lb=new Label("Press appropriate column buttons from below which constitute your word in a sequential order..."); 
    lb.setFont(new Font("Tahoma", Font.PLAIN, 26));
    lb.setForeground(Color.RED); 
    lb.setBounds(150,75,1200,30);
    add(lb);
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
            la[i][j]=new Label(String.valueOf(x[i][j]));
            la[i][j].setBounds(450+(100*j),200+(40*i),30,35);
            la[i][j].setFont(new Font("Tahoma", Font.PLAIN, 26));
		    la[i][j].setForeground(Color.BLUE);
		    add(la[i][j]);
        }
    }
    for(i=0;i<4;i++)
    {
    	b[i]=new Button("Column "+String.valueOf(i+1));
    	b[i].setBounds(425+(100*i),150,90,40);
        b[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
		b[i].setBackground(Color.CYAN);
		add(b[i]);
    }
    File file = new File("ABCD.txt");
    try     
        {
         BufferedWriter bw = new BufferedWriter(new FileWriter(file));
         bw.write("");
         bw.close();
        }
    catch (IOException ie) {
         System.out.println("exception occoured"+ ie);
    }
    for(i=0;i<4;i++)
    {
    int p=i;
    b[i].addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    try {
         BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
         bw.write(p+" ");
         bw.close();
        }
    catch (IOException ie) {
         System.out.println("exception occoured"+ ie);
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
    AlteredSequence.main(new String[]{});
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