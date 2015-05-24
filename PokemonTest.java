
/**
 * Write a description of class PokemonTest here.
 * final runner class with GUI!
 * @author (your name) Amber Hu, Teresa Mao
 * @version (a version number or a date) 5/24/15
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class PokemonTest extends JPanel implements ActionListener
{
    JLabel picture;
    public PokemonTest() {
        super(new BorderLayout());
        //pokemon selection
        String[] pokemonStrings = {"Pikachu", "Squirtle", "Bulbasaur", "Pidgey", "Charmander"};
        JComboBox pokemonList = new JComboBox(pokemonStrings);
        pokemonList.setSelectedIndex(0);
        pokemonList.addActionListener(this);
        
        //action selection
        String[] actionStrings = {"Attack", "Catch", "Switch", "Run"};
        JComboBox actionList = new JComboBox(actionStrings);
        pokemonList.setSelectedIndex(0);
        pokemonList.addActionListener(this);
        
        picture = new JLabel();
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);
        //updateLabel(petStrings[petList.getSelectedIndex()]);
        picture.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        
        picture.setPreferredSize(new Dimension(177, 122+10));


        add(pokemonList, BorderLayout.PAGE_START);
        //add ActionList
        add(picture, BorderLayout.PAGE_END);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String pokemonName = (String)cb.getSelectedItem();
        //updateLabel(petName);
    }
    
//     public void updateLabel(String name) {
//         ImageIcon icon = createImageIcon("images/" + name + ".gif");
//         picture.setIcon(icon);
//         picture.setToolTipText("A drawing of a " + name.toLowerCase());
//         if (icon != null) {
//             picture.setText(null);
//         } else {
//             picture.setText("Image not found");
//         }
//     }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Choose a Pokemon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new PokemonTest();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Choose a starter Pokemon: ");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
        
    }
}