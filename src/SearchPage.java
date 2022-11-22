import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class SearchPage implements ActionListener{

    JFrame window = new JFrame();
    JButton searchButton = new JButton();
    JTextField titleInput = new JTextField();
    Font standardFont = new Font ("Montserrat", Font.PLAIN, 14);
    Dimension standardDimension = new Dimension(250, 40);

    SearchPage(){

        // Configurando a Tela Principal
        window.setTitle("Busca de Projetos");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(400, 240);
        window.setLayout(null);


        // Título
        JLabel title = new JLabel();
        title.setText("Busque por um Projeto");
        title.setFont(new Font("Montserrat", Font.ITALIC, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(80, 10, 250, 40);
        window.add(title);


        // Campo de Busca
        titleInput.setPreferredSize(standardDimension);
        titleInput.setFont(standardFont);
        titleInput.setText("Título do Projeto");
        titleInput.setBounds(40, 100, 325, 25);
        window.add(titleInput);


        // Botão de Busca
        searchButton.setText("BUSCAR");
        searchButton.setFont(standardFont);
        searchButton.setBounds(150, 150, 100, 50);
        searchButton.addActionListener(this);
        window.add(searchButton);


         window.setVisible(true);
        
    }

    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource()==searchButton){
            String title = titleInput.getText();
            Database db = new Database();

            db.SearchProject(title);
        }
    }
    
}
