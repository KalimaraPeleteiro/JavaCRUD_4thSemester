import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ProjectPage implements ActionListener{

    JFrame window = new JFrame();
    JButton deleteButton = new JButton();
    JButton updateButton = new JButton();
    Font standardFont = new Font ("Montserrat", Font.PLAIN, 14);
    Dimension standardDimension = new Dimension(250, 40);
    int projectID;
    String titleProject;
    String City;
    String State;
    String Category;
    String Description;

    ProjectPage(int id, String projectTitle, String city, String state, String category, String description){
    	
    	projectID = id;
    	String titleProject = projectTitle;
        String City = city;
        String State = state;
        String Category = category;
        String Description = description;
        
    	
        // Configurando a Tela Principal
        window.setTitle(titleProject);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(720, 720);
        window.setLayout(null);


        // Título
        JLabel title = new JLabel();
        title.setText(titleProject);
        title.setFont(new Font("Montserrat", Font.ITALIC, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(80, 20, 550, 40);
        window.add(title);


     // Informações do Projeto
        JLabel infoTitle = new JLabel();
        infoTitle.setText("Título do Projeto: " + titleProject);
        infoTitle.setBounds(50, 100, 600, 25);
        infoTitle.setFont(standardFont);
        window.add(infoTitle);

        JLabel infoCity = new JLabel();
        infoCity.setText("Cidade: " + City);
        infoCity.setBounds(50, 200, 600, 25);
        infoCity.setFont(standardFont);
        window.add(infoCity);

        JLabel infoState = new JLabel();
        infoState.setText("Estado: " + State);
        infoState.setBounds(50, 300, 600, 25);
        infoState.setFont(standardFont);
        window.add(infoState);

        JLabel infoCategory = new JLabel();
        infoCategory.setText("Categoria: " + Category);
        infoCategory.setBounds(50, 400, 600, 25);
        infoCategory.setFont(standardFont);
        window.add(infoCategory);

        JLabel infoDescription = new JLabel();
        infoDescription.setText("Descrição: " + Description);
        infoDescription.setBounds(50, 500, 600, 25);
        infoDescription.setFont(standardFont);
        window.add(infoDescription);


        // Botão de Deleção
        deleteButton.setText("DELETAR PROJETO");
        deleteButton.setFont(standardFont);
        deleteButton.setBounds(100, 600, 200, 50);
        deleteButton.addActionListener(this);
        window.add(deleteButton);
        
        
        // Botão de Atualização
        updateButton.setText("ALTERAR PROJETO");
        updateButton.setFont(standardFont);
        updateButton.setBounds(450, 600, 200, 50);
        updateButton.addActionListener(this);
        window.add(updateButton);


         window.setVisible(true);
        
    }

    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource()==deleteButton){
            Database db = new Database();
            db.DeleteProject(projectID);
            window.dispose();
        }
        
        if (e.getSource()==updateButton) {
        	UpdatePage newWindow = new UpdatePage(projectID);
        	window.dispose();
        }
    }
    
}
