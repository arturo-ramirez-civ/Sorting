package Project_1B;

import java.io.*;
import java.util.*;
import javax.swing.*;

// Project 1 main class

class Report {
	
	//Attributes
	JFrame window;
	JScrollPane scroll;
	JTable table;
	String[] column;
	Object[][] data;
	
	//Constructor
	public Report() {
		window = new JFrame("Benchmark Report");
		column = new String[] {"Size", "Avg Count", "Coef Count", "Ave Time", "Coef Time"};
		data = getData();	
		table = new JTable(data, column);
		scroll = new JScrollPane(table);
		window.add(scroll);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.pack();
		window.setSize(500,300);
		window.setLocation(300,400);
		window.setVisible(true);
		
	}
	
	Object[][] getData() {
 
            try {
  
                File textFile;
                JFileChooser choice = new JFileChooser(new File("."));
                int option = choice.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    textFile = choice.getSelectedFile();
                    BufferedReader read = new BufferedReader(new FileReader(textFile));
                    ArrayList<String> list = new ArrayList<String>();
                    String str = "";				
                    while ((str = read.readLine()) != null) {
                    	list.add(str);
                    	System.out.println(str);
                    }

				Object[][] data = new Object[list.size()][5];
				for (int i = 0; i < list.size(); i++) {
					data[i] = list.get(i).split(",");
				}
			
				read.close();
				return data;
				
                } 
            } catch (Exception e) {
				e.printStackTrace();
				return null;
			}
            
            return data;
	}
	
	

	
	
 
	public static void main(String[] args) {

		Report report = new Report();
		report.getData();
    	
    }//End of main method
    
	
}//End of Report Class
