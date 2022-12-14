import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreatePage implements ActionListener{
    
    JFrame window = new JFrame();
    JButton createButton = new JButton();
    JTextField titleInput = new JTextField();
    JTextField CityInput = new JTextField();
    JTextField StateInput = new JTextField();
    JTextField CategoryInput = new JTextField();
    JTextField DescriptionInput = new JTextField();
    Font standardFont = new Font ("Montserrat", Font.PLAIN, 14);
    Dimension standardDimension = new Dimension(250, 40);


    CreatePage(){

        // Configurando a Tela Principal
        window.setTitle("Criação de Projeto");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(640, 720);
        window.setLayout(null);


        // Título
        JLabel title = new JLabel();
        title.setText("Crie seu Projeto");
        title.setFont(new Font("Montserrat", Font.ITALIC, 30));
        title.setBounds(200, 10, 600, 40);
        window.add(title);


        // Informações do Projeto
        JLabel infoTitle = new JLabel();
        infoTitle.setText("Título do Projeto");
        infoTitle.setBounds(50, 100, 150, 25);
        infoTitle.setFont(standardFont);
        window.add(infoTitle);

        JLabel infoCity = new JLabel();
        infoCity.setText("Cidade");
        infoCity.setBounds(50, 200, 150, 25);
        infoCity.setFont(standardFont);
        window.add(infoCity);

        JLabel infoState = new JLabel();
        infoState.setText("Estado");
        infoState.setBounds(50, 300, 150, 25);
        infoState.setFont(standardFont);
        window.add(infoState);

        JLabel infoCategory = new JLabel();
        infoCategory.setText("Categoria");
        infoCategory.setBounds(50, 400, 150, 25);
        infoCategory.setFont(standardFont);
        window.add(infoCategory);

        JLabel infoDescription = new JLabel();
        infoDescription.setText("Descrição");
        infoDescription.setBounds(50, 500, 150, 25);
        infoDescription.setFont(standardFont);
        window.add(infoDescription);


        // Inputs
        titleInput.setPreferredSize(standardDimension);
        titleInput.setFont(standardFont);
        titleInput.setText("Meu Projeto");
        titleInput.setBounds(200, 100, 400, 25);
        window.add(titleInput);

        CityInput.setPreferredSize(standardDimension);
        CityInput.setFont(standardFont);
        CityInput.setText("Salvador");
        CityInput.setBounds(200, 200, 400, 25);
        window.add(CityInput);

        StateInput.setPreferredSize(standardDimension);
        StateInput.setFont(standardFont);
        StateInput.setText("BA");
        StateInput.setBounds(200, 300, 400, 25);
        window.add(StateInput);

        CategoryInput.setPreferredSize(standardDimension);
        CategoryInput.setFont(standardFont);
        CategoryInput.setText("Tecnologia");
        CategoryInput.setBounds(200, 400, 400, 25);
        window.add(CategoryInput);

        DescriptionInput.setPreferredSize(standardDimension);
        DescriptionInput.setFont(standardFont);
        DescriptionInput.setText("Tecnologia");
        DescriptionInput.setBounds(200, 500, 400, 100);
        window.add(DescriptionInput);

        
        // Botão de Criação
        createButton.setText("CRIAR");
        createButton.setFont(standardFont);
        createButton.setBounds(320, 625, 100, 50);
        createButton.addActionListener(this);
        window.add(createButton);

        window.setVisible(true);
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource()==createButton){
            String infoTitle = titleInput.getText();
            String infoCity = CityInput.getText();
            String infoState = StateInput.getText();
            String infoCategory = CategoryInput.getText();
            String infoDescription = DescriptionInput.getText();

            Database db = new Database();

            db.CreateProject(infoTitle, infoCity, infoState, infoCategory, infoDescription);
            
            window.dispose();
        }
    }
}

