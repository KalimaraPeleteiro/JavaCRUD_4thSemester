import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainMenu implements ActionListener{

    JButton FirstOption = new JButton();
    JButton SecondOption = new JButton();
    JButton ThirdOption = new JButton();
    JFrame window = new JFrame();

    MainMenu() {
        
        // Configurando a Tela Principal
        window.setTitle("Menu Principal");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(640, 480);
        window.setVisible(true);
        window.setLayout(new GridLayout(4, 1, 25, 25));

        // Título
        JLabel title = new JLabel();
        title.setText("Escolha uma das Opções Abaixo");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Montserrat", Font.ITALIC, 30));
        window.add(title);

        // Opções
        FirstOption.setText("Criação de Projetos");
        FirstOption.setFont(new Font("Montserrat", Font.PLAIN, 12));
        FirstOption.setForeground(Color.black);
        FirstOption.setBackground(Color.lightGray);
        FirstOption.addActionListener(this);
        window.add(FirstOption);

        SecondOption.setText("Busca de Projetos");
        SecondOption.setFont(new Font("Montserrat", Font.PLAIN, 12));
        SecondOption.setForeground(Color.black);
        SecondOption.setBackground(Color.lightGray);
        SecondOption.addActionListener(this);
        window.add(SecondOption);
        
        ThirdOption.setText("Gerenciamento de Equipes");
        ThirdOption.setFont(new Font("Montserrat", Font.PLAIN, 12));
        ThirdOption.setForeground(Color.black);
        ThirdOption.setBackground(Color.lightGray);
        ThirdOption.addActionListener(this);
        window.add(ThirdOption);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==FirstOption) {
            window.dispose();
            CreatePage newWindow = new CreatePage();
        }

        if(e.getSource()==SecondOption) {
            window.dispose();
            SearchPage newWindow = new SearchPage();
        }
        
        if(e.getSource()==ThirdOption) {
            window.dispose();
            TeamPage newWindow = new TeamPage();
        }
    }

}