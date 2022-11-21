import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu implements ActionListener{

    JButton FirstOption = new JButton();
    JButton SecondOption = new JButton();
    JFrame window = new JFrame();

    MainMenu() {
        
        // Configurando a Tela Principal
        window.setTitle("Menu Principal");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(640, 640);
        window.setVisible(true);
        window.setLayout(new GridLayout(3, 1, 25, 25));

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
        window.add(FirstOption);

        SecondOption.setText("Busca de Projetos");
        SecondOption.setFont(new Font("Montserrat", Font.PLAIN, 12));
        SecondOption.setForeground(Color.black);
        SecondOption.setBackground(Color.lightGray);
        window.add(SecondOption);

    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == FirstOption) {
            window.dispose();
            CreatePage newWindow = new CreatePage();
        }

        if(event.getSource() == SecondOption) {
            window.dispose();
            SearchPage newWindow = new SearchPage();
        }
    }

}