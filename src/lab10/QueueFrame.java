package lab10;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings({"serial"})
public class QueueFrame extends JFrame
{
	public static final int FRAMEHEIGHT=350;
	public static final int FRAMEWIDTH=650;
	
	JButton AddButton;
	JButton RemoveButton;
	JButton SizeButton;
	JButton MaxSizeButton;
	JButton SetMaxButton;
	JButton ClearButton;
	JButton FrontButton;
	JButton LastButton;
	
	
	JTextArea area;
	Font font = new Font("Verdana", Font.BOLD, 16);
	JPanel buttonPanel;
	JTextField field;
	JTextField input;
	
	Scanner scan = new Scanner(System.in);
	QueueList <String> queue = new QueueListImpl <String>();
	private int userInput;
	
	public QueueFrame()
	{
		AddButton = new JButton("Add");
		RemoveButton = new JButton("Remove");
		SizeButton = new JButton("Size");
		MaxSizeButton = new JButton("Max Size");
		SetMaxButton = new JButton("Set Max");
		ClearButton = new JButton("Clear");
		FrontButton = new JButton("Front");
		LastButton = new JButton("Last");
		
		userInput = 0;
		
		field = new JTextField(50);
//		input = new JTextField(25);
		area = new JTextArea(10,28);
		area.setFont(font);
		
		field.setText("Select an option to begin. Use this field for inputting items for add() and SetMaxSize().");
		area.setText("Remember to use the field above for entering inputs for add() and SetMaxSize().");
		
		buttonPanel = new JPanel();
		
		this.setTitle("QueueFrame");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(buttonPanel);
		this.getContentPane().add(field);
		this.getContentPane().add(area);
		buttonPanel.add(AddButton);
		buttonPanel.add(RemoveButton);
		buttonPanel.add(SizeButton);
		buttonPanel.add(MaxSizeButton);
		buttonPanel.add(SetMaxButton);
		buttonPanel.add(ClearButton);
		buttonPanel.add(FrontButton);
		buttonPanel.add(LastButton);
		
		area.setEditable(false);
		
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				area.setText("Please enter a new item to be added to the queue.");
    					String item = field.getText();
    					boolean check = queue.add(item);
    					if(check == true)
    					{
    						area.setText("The item has been added to the queue." + "\n" + toString());
    					}
    					else
    					{
    						area.setText("Item was not added to the queue.");
    					}
			}});
		
		RemoveButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(queue.size() == 0)
				{
					area.setText("There are no items to remove in the queue.");
				}
				else
				{
				String result = queue.remove();
				area.setText("The item " + result + " has been removed from the queue. " + "\n" + toString());
				}
			}});
		
		SizeButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				area.setText("The current amount of items in the queue is: " + queue.size());
			}});
		
		MaxSizeButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				area.setText("The max size of this queue is: " + queue.getMaxSize());
			}});
		
		SetMaxButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				area.setText("Please enter a new max size for the queue.");
				userInput = Integer.parseInt(field.getText());
				int newSize = userInput;
				if(newSize <= 0)
				{
					area.setText("Size cannot be equal or less than 0.");
				}
				else
				{
				queue.setMaxSize(newSize);
				area.setText("New size has been set for the queue." + queue.getMaxSize());
				}
			}});
		
		ClearButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				queue.clear();
				area.setText("The queue has been cleared.");
			}});
		
		FrontButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(queue.size() == 0)
				{
					area.setText("There are no items to look at in the queue.");
				}
				else
				{
					area.setText("This is the first item in the queue: " + queue.front());
				}
			}});
		
		LastButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(queue.size() == 0)
				{
					area.setText("There are no items to look at in the queue.");
				}
				else
				{
					area.setText("This is the last item in the queue: " + queue.last());
				}
			}});
		
		
	} //end of QueueFrame
	
	//shows the GUI to the user
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}//end of main
	
	//creates the GUI to show to user
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);    
		QueueFrame frame = new QueueFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(QueueFrame.FRAMEWIDTH, QueueFrame.FRAMEHEIGHT);
		frame.setVisible(true);

	} // end createAndShowGui
}//end of class
