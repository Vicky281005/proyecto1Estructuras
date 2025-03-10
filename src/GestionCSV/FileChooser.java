/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionCSV;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mishel
 */

//Abre el FileChooser


public class FileChooser {
    
    /**
     * Atributos de la clase FlieChooser
     */
    private JFrame ventana;
    private String contenidoCsv; // con esto se almacena el contenido leído del  CSV

    /**
     * Constructor de la clase FileChooser
     * @param ventana 
     */
    
    public FileChooser(JFrame ventana) {
        this.ventana = ventana;
        this.contenidoCsv = "";
    }
    
    /**
     * Getters y Setters 
     * @return 
     */
    public JFrame getVentana() {
        return ventana;
    }

    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }

    public String getContenidoCsv() {
        return contenidoCsv;
    }

    public void setContenidoCsv(String contenidoCsv) {
        this.contenidoCsv = contenidoCsv;
    }
    
    /**
     * Método para abrir un archivo CSV y poder leer el contenido que tiene
     */
    public void abrir() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Abrir archivo CSV");
        fc.setFileFilter(new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv"));

        int seleccion = fc.showOpenDialog(ventana);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();

            try (FileReader fr = new FileReader(archivo)) {
                StringBuilder cadena = new StringBuilder();
                int valor;
                while ((valor = fr.read()) != -1) {
                    cadena.append((char) valor);
                }
                contenidoCsv = cadena.toString();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(ventana, "Error al leer el archivo CSV.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(ventana, "No se ha seleccionado ningún archivo.");
        }
    }

    /**
     * Método para guardar un archivo CSV y selecciona la ruta
     * @param contenido contenido es el contenido que se va a guardar en el archivo CSV
     */
    public void guardar(String contenido) {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Guardar archivo CSV");
        fc.setFileFilter(new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv"));
        String ruta;

        int seleccion = fc.showSaveDialog(ventana);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            ruta = archivo.getAbsolutePath();

            // Esto nos ssegurar que el archivo SI tenga la extensión .csv
            if (!ruta.toLowerCase().endsWith(".csv")) {
                ruta += ".csv";
            }

            try (FileWriter fw = new FileWriter(ruta)) {
                fw.write(contenido);
                JOptionPane.showMessageDialog(ventana, "Archivo guardado de forma exitosa en:\n" + ruta);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(ventana, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(ventana, "No se ha seleccionado un archivo donde guardar el contenido.");
        }
    }
}
