/**
 *
 * @author Nelson Blanco Charro
 * @date 10/05/2022
 * @description Clase para realizar la conexion y modificacion de una base de
 * datos Oracle mediante entorno grafico
 */
package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.Operaciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

    private JPanel contentPane;
    private JTextField inputNumeroAlzas;
    private JTextField inputIDcolmena;
    private JTextField inputReinaTemporada;
    private JTextField inputDireccion;
    private JTextField inputKgMiel;
    private JLabel txtResultado;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Principal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton insertarBtn = new JButton("Insertar");
        insertarBtn.setBounds(36, 10, 91, 25);
        insertarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if (!comprobarNumero(inputReinaTemporada.getText()) || inputReinaTemporada.getText().equals("")) {
                        txtResultado.setText("El campo Reina temporada tiene que ser un numero");
                    } else if (inputDireccion.getText().equals("")) {
                        txtResultado.setText("El campo Direccion no puede estar vacio");
                    } else if (!comprobarNumero(inputKgMiel.getText()) || inputKgMiel.getText().equals("")) {
                        txtResultado.setText("El campo Kg de miel tiene que ser un numero");
                    } else if (!comprobarNumero(inputNumeroAlzas.getText()) || inputNumeroAlzas.getText().equals("")) {
                        txtResultado.setText("El campo Numero de alzas tiene que ser un numero");
                    } else {
                        Operaciones.insertarBD(Integer.parseInt(inputReinaTemporada.getText()),
                                inputDireccion.getText(), Integer.parseInt(inputKgMiel.getText()),
                                Integer.parseInt(inputNumeroAlzas.getText()));
                        txtResultado.setText("El registro se ha insertado");
                        limpiarCampos();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    txtResultado.setText("Error: " + e.getMessage());
                }
            }
        });
        contentPane.setLayout(null);
        contentPane.add(insertarBtn);

        JButton buscarBtn = new JButton("Buscar");
        buscarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if (!comprobarNumero(inputIDcolmena.getText()) || inputIDcolmena.getText().equals("")) {
                        txtResultado.setText("El campo Id de la colmena tiene que ser un numero");
                    } else {
                        String[] resultado = new String[4];
                        resultado = Operaciones.buscarBD(Integer.parseInt(inputIDcolmena.getText()));
                        inputReinaTemporada.setText(resultado[0]);
                        inputDireccion.setText(resultado[1]);
                        inputKgMiel.setText(resultado[2]);
                        inputNumeroAlzas.setText(resultado[3]);
                        txtResultado.setText("Registro obtenido");
                    }
                } catch (Exception e) {
                    txtResultado.setText("Error: " + e.getMessage());
                }
            }
        });
        buscarBtn.setBounds(132, 10, 82, 25);
        contentPane.add(buscarBtn);

        JButton modificarBtn = new JButton("Modificar");
        modificarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if (!comprobarNumero(inputIDcolmena.getText()) || inputIDcolmena.getText().equals("")) {
                        txtResultado.setText("El campo Id de la colmena tiene que ser un numero");
                    } else if (!comprobarNumero(inputReinaTemporada.getText())
                            || inputReinaTemporada.getText().equals("")) {
                        txtResultado.setText("El campo Reina temporada tiene que ser un numero");
                    } else if (inputDireccion.getText().equals("")) {
                        txtResultado.setText("El campo Direccion no puede estar vacio");
                    } else if (!comprobarNumero(inputKgMiel.getText()) || inputKgMiel.getText().equals("")) {
                        txtResultado.setText("El campo Kg de miel tiene que ser un numero");
                    } else if (!comprobarNumero(inputNumeroAlzas.getText()) || inputNumeroAlzas.getText().equals("")) {
                        txtResultado.setText("El campo Numero de alzas tiene que ser un numero");
                    } else {
                        Operaciones.modificarBD(Integer.parseInt(inputIDcolmena.getText()),
                                Integer.parseInt(inputReinaTemporada.getText()), inputDireccion.getText(),
                                Integer.parseInt(inputKgMiel.getText()), Integer.parseInt(inputNumeroAlzas.getText()));
                        txtResultado.setText("El registro se ha modificado");
                        limpiarCampos();
                    }
                } catch (Exception e) {
                    txtResultado.setText("Error: " + e.getMessage());
                }
            }
        });
        modificarBtn.setBounds(219, 10, 99, 25);
        contentPane.add(modificarBtn);

        JButton eliminarBtn = new JButton("Eliminar");
        eliminarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if (!comprobarNumero(inputIDcolmena.getText()) || inputIDcolmena.getText().equals("")) {
                        txtResultado.setText("El campo Id de la colmena tiene que ser un numero");
                    } else {
                        Operaciones.eliminarBD(Integer.parseInt(inputIDcolmena.getText()));
                        txtResultado.setText("El registro se ha eliminado");
                        limpiarCampos();
                    }
                } catch (Exception e) {
                    txtResultado.setText("Error: " + e.getMessage());
                }
            }
        });
        eliminarBtn.setBounds(323, 10, 90, 25);
        contentPane.add(eliminarBtn);

        JButton limpiarBtn = new JButton("Limpiar");
        limpiarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txtResultado.setText("Campos reseteados");
                limpiarCampos();
            }
        });
        limpiarBtn.setBounds(38, 40, 86, 25);
        contentPane.add(limpiarBtn);

        JButton totalMielBtn = new JButton("Total de miel");
        totalMielBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    txtResultado.setText("Kg de miel totales: " + Operaciones.totalMielBD());
                } catch (Exception e) {
                    txtResultado.setText("Error: " + e.getMessage());
                }
            }
        });
        totalMielBtn.setBounds(129, 40, 125, 25);
        contentPane.add(totalMielBtn);

        JButton numAlzasBtn = new JButton("Numero de alzas");
        numAlzasBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    txtResultado.setText("Numero medio de alzas: " + Operaciones.numAlzasBD());
                } catch (Exception e) {
                    txtResultado.setText("Error: " + e.getMessage());
                }
            }
        });
        numAlzasBtn.setBounds(259, 40, 153, 25);
        contentPane.add(numAlzasBtn);

        inputIDcolmena = new JTextField();
        inputIDcolmena.setBounds(175, 75, 120, 21);
        inputIDcolmena.setColumns(10);
        contentPane.add(inputIDcolmena);

        inputReinaTemporada = new JTextField();
        inputReinaTemporada.setBounds(175, 100, 120, 21);
        inputReinaTemporada.setColumns(10);
        contentPane.add(inputReinaTemporada);

        inputDireccion = new JTextField();
        inputDireccion.setBounds(175, 125, 120, 21);
        inputDireccion.setColumns(10);
        contentPane.add(inputDireccion);

        inputKgMiel = new JTextField();
        inputKgMiel.setBounds(175, 150, 120, 21);
        inputKgMiel.setColumns(10);
        contentPane.add(inputKgMiel);

        inputNumeroAlzas = new JTextField();
        inputNumeroAlzas.setBounds(175, 175, 120, 21);
        contentPane.add(inputNumeroAlzas);
        inputNumeroAlzas.setColumns(10);

        JTextPane txtIdColmena = new JTextPane();
        txtIdColmena.setBounds(30, 75, 120, 21);
        txtIdColmena.setBackground(UIManager.getColor("CheckBox.background"));
        txtIdColmena.setText("Id Colmena");
        contentPane.add(txtIdColmena);

        JTextPane txtReinaTemporada = new JTextPane();
        txtReinaTemporada.setBounds(30, 100, 120, 21);
        txtReinaTemporada.setText("Reina temporada");
        txtReinaTemporada.setBackground(UIManager.getColor("Button.background"));
        contentPane.add(txtReinaTemporada);

        JTextPane txtDireccion = new JTextPane();
        txtDireccion.setBounds(30, 125, 120, 21);
        txtDireccion.setText("Direccion");
        txtDireccion.setBackground(UIManager.getColor("Button.background"));
        contentPane.add(txtDireccion);

        JTextPane txtKgMiel = new JTextPane();
        txtKgMiel.setBounds(30, 150, 120, 21);
        txtKgMiel.setText("Kg de miel");
        txtKgMiel.setBackground(UIManager.getColor("Button.background"));
        contentPane.add(txtKgMiel);

        JTextPane txtNumAlzas = new JTextPane();
        txtNumAlzas.setBounds(30, 175, 120, 21);
        txtNumAlzas.setText("Numero de alzas");
        txtNumAlzas.setBackground(UIManager.getColor("Button.background"));
        contentPane.add(txtNumAlzas);

        txtResultado = new JLabel();
        txtResultado.setBackground(Color.WHITE);
        txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
        txtResultado.setText("Resultados del programa");
        txtResultado.setBounds(36, 210, 377, 41);
        contentPane.add(txtResultado);

        JLabel imagenAbeja = new JLabel("");
        imagenAbeja.setIconTextGap(2);
        imagenAbeja.setIcon(new ImageIcon("/home/nelson/eclipse-workspace/PROG10_Nelson_Blanco_Charro/abeja.png"));
        imagenAbeja.setBounds(323, 71, 90, 125);
        contentPane.add(imagenAbeja);

    }

    private void limpiarCampos() {
        inputIDcolmena.setText("");
        inputReinaTemporada.setText("");
        inputDireccion.setText("");
        inputKgMiel.setText("");
        inputNumeroAlzas.setText("");
    }

    private boolean comprobarNumero(String numero) {
        boolean esNumero = true;
        for (int i = 0; i < numero.length(); i++) {
            if (!Character.isDigit(numero.charAt(i))) {
                esNumero = false;
            }
        }
        return esNumero;
    }
}
