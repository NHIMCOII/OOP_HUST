import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main(String args[]) {
		String[] options = new String[] {"Yes", "No"};
		int option = JOptionPane.showOptionDialog(null,"Do you want to change to first class ticket ?", "First-Class Ticket",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[0]);
		
		JOptionPane.showMessageDialog(null,"You've chosen: " + (option == JOptionPane.YES_OPTION? "Yes" : "No"));
		
		System.exit(0);
	}
}
