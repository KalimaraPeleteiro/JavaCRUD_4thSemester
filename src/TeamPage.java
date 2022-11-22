import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TeamPage implements ActionListener {
	
    JFrame window = new JFrame();
    JButton confirmButton = new JButton();
    
    Database db = new Database();
    String[] allProjects = db.ReturnAllProjects();
    JComboBox<String> choiceInput = new JComboBox<String>(allProjects);

	
	TeamPage(){
		
		window.setTitle("Gerenciamento de Equipes");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(500, 200);
        window.setLayout(null);
        
        
        JLabel title = new JLabel();
        title.setText("Gostaria de Gerenciar Equipes de Qual Projeto?");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Montserrat", Font.ITALIC, 18));
        title.setBounds(10, 10, 475, 20);
        window.add(title);
        
        choiceInput.setBounds(175, 75, 150, 20);
        window.add(choiceInput);
        
        confirmButton.setText("MODIFICAR");
        confirmButton.setFont(new Font("Montserrat", Font.PLAIN, 12));
        confirmButton.setForeground(Color.black);
        confirmButton.setBackground(Color.lightGray);
        confirmButton.setBounds(175, 100, 150, 20);
        confirmButton.addActionListener(this);
        window.add(confirmButton);
        
        
        window.setVisible(true);

		
	}
	
	@Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==confirmButton) {
            String selectedProject = choiceInput.getItemAt(choiceInput.getSelectedIndex());
            window.dispose();
            ModifyTeamPage newWindow = new ModifyTeamPage(db.ReturnProjectId(selectedProject));
        }

	}
	
}
