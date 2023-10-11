package Personas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
* Esta clase denominada VentanaPrincipal define una interfaz gr�fica
* que permitir� crear una persona y agregarla a un vector de personas.
* Luego, se puede eliminar una persona seleccionada o borrar todas las
* personas.
* @version 1.2/2020
*/

public class VentanaPrincipal extends JFrame implements
ActionListener {
    private ListaPersonas lista; // El objeto ListaPersonas de la aplicaci�n
    private Container contenedor; /* Un contenedor de elementos
    gr�ficos */
    // Etiquetas est�ticas para los nombres de los atributos
    private JLabel nombre, apellidos, telefono, direccion;
    // Campos de ingreso de texto
    private JTextField campoNombre, campoApellidos, campoTelefono,
    campoDireccion;
    private JButton a�adir, eliminar, borrarLista; // Botones
    private JList listaNombres; // Lista de personas
    private DefaultListModel modelo; // Objeto que modela la lista
    private JScrollPane scrollLista; // Barra de desplazamiento vertical
    /**
    * Constructor de la clase VentanaPrincipal
    */
public VentanaPrincipal(){
    lista = new ListaPersonas(); // Crea la lista de personas
    inicio();
    setTitle("Personas"); 
    setSize(270,350); // Establece el tama�o de la ventana
    setLocationRelativeTo(null); /* La ventana se posiciona en el
    centro de la pantalla */
    // Establece que el bot�n de cerrar permitir� salir de la aplicaci�n
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false); /* Establece que el tama�o de la ventana no
    se puede cambiar */
}
/**
* M�todo que crea la ventana con sus diferentes componentes
* gr�ficos
*/
private void inicio() {
    contenedor = getContentPane(); /* Obtiene el panel de
    contenidos de la ventana */
    contenedor.setLayout(null); /* Establece que el panel no tiene
    asociado ning�n layout */
    // Establece la etiqueta y el campo nombre
    nombre = new JLabel();
    nombre.setText("Nombre:");
    nombre.setBounds(20, 20, 135, 23); /* Establece la posici�n de
    la etiqueta nombre */
    campoNombre = new JTextField();
    // Establece la posici�n del campo de texto nombre
    campoNombre.setBounds(105, 20, 135, 23);
    // Establece la etiqueta y el campo apellidos
    apellidos = new JLabel();
    apellidos.setText("Apellidos:"); /* Establece la posici�n de la
    etiqueta apellidos */
    apellidos.setBounds(20, 50, 135, 23);
    campoApellidos = new JTextField();
    // Establece la posici�n del campo de texto apellidos
    campoApellidos.setBounds(105, 50, 135, 23);
    // Establece la etiqueta y el campo tel�fono
    telefono = new JLabel();
    telefono.setText("Tel�fono:");
    telefono.setBounds(20, 80, 135, 23); /* Establece la posici�n de
    la etiqueta tel�fono */
    campoTelefono = new JTextField();
    // Establece la posici�n del campo de texto tel�fono
    campoTelefono.setBounds(105, 80, 135, 23);
    // Establece la etiqueta y el campo direcci�n
    direccion = new JLabel();
    direccion.setText("Direcci�n:");
    direccion.setBounds(20, 110, 135, 23); /* Establece la posici�n
    de la etiqueta direcci�n */
    campoDireccion = new JTextField();
    // Establece la posici�n del campo de texto direcci�n
    campoDireccion.setBounds(105, 110, 135, 23);
    // Establece el bot�n A�adir persona
    a�adir = new JButton();
    a�adir.setText("A�adir");
    a�adir.setBounds(105, 150, 80, 23); /* Establece la posici�n del
    bot�n A�adir persona */
    /* Agrega al boton un ActionListener para que gestione eventos
    del bot�n */
    a�adir.addActionListener(this);
    // Establece el bot�n Eliminar persona
    eliminar= new JButton();
    eliminar.setText("Eliminar");
    eliminar.setBounds(20, 280, 80, 23); /* Establece la posici�n del
    bot�n Eliminar persona */
    /* Agrega al boton un ActionListener para que gestione eventos
    del bot�n */
    eliminar.addActionListener(this);
    // Establece el bot�n Borrar lista
    borrarLista= new JButton();
    borrarLista.setText("Borrar Lista");
    borrarLista.setBounds(120, 280, 120, 23); /* Establece la
    posici�n del bot�n Borrar lista */
    /* Agrega al boton un ActionListener para que gestione eventos
    del boton */
    borrarLista.addActionListener(this);
    // Establece la lista gr�fica de personas
    listaNombres = new JList();
    /* Establece que se pueda seleccionar solamente un elemento de
    la lista */
    listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    modelo = new DefaultListModel();
    // Establece una barra de desplazamiento vertical
    scrollLista = new JScrollPane();
    // Establece la posici�n de la barra de desplazamiento vertical
    scrollLista.setBounds(20, 190 ,220, 80);
    // Asocia la barra de desplazamiento vertical a la lista de personas
    scrollLista.setViewportView(listaNombres);
    // Se a�ade cada componente gr�fico al contenedor de la ventana
    contenedor.add(nombre);
    contenedor.add(campoNombre);
    contenedor.add(apellidos);
    contenedor.add(campoApellidos);
    contenedor.add(telefono);
    contenedor.add(campoTelefono);
    contenedor.add(direccion);
    contenedor.add(campoDireccion);
    contenedor.add(a�adir);
    contenedor.add(eliminar);
    contenedor.add(borrarLista);
    contenedor.add(scrollLista);
}
/**
* M�todo que gestiona los eventos generados en la ventana principal
*/
@Override
public void actionPerformed(ActionEvent evento) {
if (evento.getSource() == a�adir) { // Si se pulsa el bot�n a�adir
a�adirPersona(); // Se invoca a�adir persona
}
if (evento.getSource() == eliminar) { /* Si se pulsa el bot�n
eliminar */
/* Se invoca el m�todo eliminarNombre que elimina el
elemento seleccionado */
eliminarNombre(listaNombres.getSelectedIndex() );
}
if (evento.getSource() == borrarLista) { /* Si se pulsa el bot�n
borrar lista */
borrarLista(); // Se invoca borrar lista
}
}
/**
* M�todo que agrega una persona al vector de personas y a la lista
* grafica de personas
*/
private void a�adirPersona() {
/* Se obtienen los campos de texto ingresados y se crea una
persona */
Persona p = new Persona(campoNombre.getText(),
campoApellidos.getText(),
campoTelefono.getText(), campoDireccion.getText());
lista.anadirPersona(p); /* Se a�ade una persona al vector de
personas */
String elemento = campoNombre.getText() + "-" + campoApellidos.getText() + "-" + campoTelefono.getText() + "-" + campoDireccion.getText();
modelo.addElement(elemento); /* Se agrega el texto con los
datos de la persona al JList */
listaNombres.setModel(modelo);
// Se colocan todos los campos de texto nulos
campoNombre.setText("");
campoApellidos.setText("");
campoTelefono.setText("");
campoDireccion.setText("");
}
/**
* Metodo que elimina una persona del vector de personas y de la
* lista gr�fica de personas en la ventana
* @param indice Parametro que define la posicion de la persona a
* eliminar
*/
private void eliminarNombre(int indice) {
if (indice >= 0) { // Si la posici�n existe
modelo.removeElementAt(indice); /* Se elimina la persona
seleccionada de la lista gr�fica */
lista.eliminarPersona(indice); /* Se elimina la persona
seleccionada del vector de personas */
} else { /* Si no se seleccion� ninguna persona, se genera un
mensaje de error */
JOptionPane.showMessageDialog(null, "Debe seleccionar unelemento","Error",JOptionPane.ERROR_MESSAGE);
}
}
/**
* Metodo que elimina todas las personas del vector de personas
*/
private void borrarLista() {
lista.borrarLista(); // Se eliminan todas las personas del vector
modelo.clear(); // Limpia el JList, la lista grafica de personas
}
}
