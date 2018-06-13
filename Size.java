import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class Size extends Frame
{
	static Size frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    frame= new Size();
				    frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Size()
	{
		Label la=new Label("Enter the length of your word : "); 
		la.setFont(new Font("Tahoma", Font.PLAIN, 40));
		la.setForeground(Color.RED); 
        la.setBounds(250,300,525,45);
        TextField t=new TextField();
        t.setBounds(800,310,200,27);
        Button b1=new Button("NEXT");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		b1.setBackground(Color.CYAN);
        b1.setBounds(1150,650,150,60);
       	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        File file = new File("ABC.txt");
        try     
        {
         BufferedWriter bw = new BufferedWriter(new FileWriter(file));
         bw.write(t.getText());
         bw.close();
        }
        catch (IOException ie) {
         System.out.println("exception occured"+ ie);
        }
		DefaultSequence.main(new String[]{});
		frame.dispose();
		}
		});
        add(la);
        add(t);
        add(b1);
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