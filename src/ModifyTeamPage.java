import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ModifyTeamPage implements ActionListener{
    
    JFrame window = new JFrame();
    JButton sendButton = new JButton();
    JTextField nameInput01 = new JTextField();
    JTextField emailInput01 = new JTextField();
    JTextField telephoneInput01 = new JTextField();
    JTextField nameInput02 = new JTextField();
    JTextField emailInput02 = new JTextField();
    JTextField telephoneInput02 = new JTextField();
    JTextField nameInput03 = new JTextField();
    JTextField emailInput03 = new JTextField();
    JTextField telephoneInput03 = new JTextField();
    
    Font standardFont = new Font ("Montserrat", Font.PLAIN, 14);
    Dimension standardDimension = new Dimension(125, 40);
    
    int ProjectID;


    ModifyTeamPage(int id){
    	
    	ProjectID = id;

        // Configurando a Tela Principal
        window.setTitle("Gerenciamento de Equipes");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(640, 720);
        window.setLayout(null);


        // Título
        JLabel title = new JLabel();
        title.setText("Gerencie a Equipe");
        title.setFont(new Font("Montserrat", Font.ITALIC, 30));
        title.setBounds(200, 10, 600, 40);
        window.add(title);


        // Informações do Projeto
        JLabel infoName = new JLabel();
        infoName.setText("Nome");
        infoName.setBounds(100, 75, 150, 25);
        infoName.setFont(standardFont);
        window.add(infoName);

        JLabel infoEmail = new JLabel();
        infoEmail.setText("Email");
        infoEmail.setBounds(300, 75, 150, 25);
        infoEmail.setFont(standardFont);
        window.add(infoEmail);

        JLabel infoTelephone = new JLabel();
        infoTelephone.setText("Telefone");
        infoTelephone.setBounds(500, 75, 150, 25);
        infoTelephone.setFont(standardFont);
        window.add(infoTelephone);


        // Inputs
        nameInput01.setPreferredSize(standardDimension);
        nameInput01.setFont(standardFont);
        nameInput01.setText("Nome");
        nameInput01.setBounds(60, 150, 150, 25);
        window.add(nameInput01);
        
        nameInput02.setPreferredSize(standardDimension);
        nameInput02.setFont(standardFont);
        nameInput02.setText("Nome");
        nameInput02.setBounds(60, 300, 150, 25);
        window.add(nameInput02);
        
        nameInput03.setPreferredSize(standardDimension);
        nameInput03.setFont(standardFont);
        nameInput03.setText("Nome");
        nameInput03.setBounds(60, 450, 150, 25);
        window.add(nameInput03);
        
        emailInput01.setPreferredSize(standardDimension);
        emailInput01.setFont(standardFont);
        emailInput01.setText("teste@gmail.com");
        emailInput01.setBounds(250, 150, 150, 25);
        window.add(emailInput01);
        
        emailInput02.setPreferredSize(standardDimension);
        emailInput02.setFont(standardFont);
        emailInput02.setText("teste@gmail.com");
        emailInput02.setBounds(250, 300, 150, 25);
        window.add(emailInput02);
        
        emailInput03.setPreferredSize(standardDimension);
        emailInput03.setFont(standardFont);
        emailInput03.setText("teste@gmail.com");
        emailInput03.setBounds(250, 450, 150, 25);
        window.add(emailInput03);
        
        telephoneInput01.setPreferredSize(standardDimension);
        telephoneInput01.setFont(standardFont);
        telephoneInput01.setText("XXXXXXXXXXX");
        telephoneInput01.setBounds(450, 150, 150, 25);
        window.add(telephoneInput01);
        
        telephoneInput02.setPreferredSize(standardDimension);
        telephoneInput02.setFont(standardFont);
        telephoneInput02.setText("XXXXXXXXXXX");
        telephoneInput02.setBounds(450, 300, 150, 25);
        window.add(telephoneInput02);

        telephoneInput03.setPreferredSize(standardDimension);
        telephoneInput03.setFont(standardFont);
        telephoneInput03.setText("XXXXXXXXXXX");
        telephoneInput03.setBounds(450, 450, 150, 25);
        window.add(telephoneInput03);
        
        
        // Botão de Criação
        sendButton.setText("ENVIAR");
        sendButton.setFont(standardFont);
        sendButton.setBounds(275, 625, 100, 50);
        sendButton.addActionListener(this);
        window.add(sendButton);

        window.setVisible(true);
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource()==sendButton){
            String firstMemberName = nameInput01.getText();
            String firstMemberEmail = emailInput01.getText();
            String firstMemberTelephone = telephoneInput01.getText();
            
            String secondMemberName = nameInput02.getText();
            String secondMemberEmail = emailInput02.getText();
            String secondMemberTelephone = telephoneInput02.getText();
            
            String thirdMemberName = nameInput03.getText();
            String thirdMemberEmail = emailInput03.getText();
            String thirdMemberTelephone = telephoneInput03.getText();
            
            Database db = new Database();
            db.CreateNewTeamMember(firstMemberName, firstMemberEmail, firstMemberTelephone, ProjectID);
            db.CreateNewTeamMember(secondMemberName, secondMemberEmail, secondMemberTelephone, ProjectID);
            db.CreateNewTeamMember(thirdMemberName, thirdMemberEmail, thirdMemberTelephone, ProjectID);
            
            window.dispose();
        }
    }
}
