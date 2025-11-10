package Persistencia.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Negocio.clases.Asociado;
import Persistencia.excepciones.AsociadoExistenteException;
import Persistencia.excepciones.AsociadoInexistenteException;
import Persistencia.interfaz.IPersistencia;

public class BaseDeDatos implements IPersistencia
{
    private static BaseDeDatos instance = null;
	private Connection con = null;

    public static BaseDeDatos getInstance(){
        if (instance == null){
            instance = new BaseDeDatos();
        }
        return instance;
    }

	private BaseDeDatos()
	{
	}

	public void conectar() throws SQLException
	{

		String url = "jdbc:mysql://127.0.0.1:3306/";
		String bd = "grupo_9";
		String usuario = "progra_c";
		String password = "progra_c";

        // 1. Conexión al servidor (sin BD) para asegurar que la BD exista
        Connection serverCon = null;
        try {
            serverCon = DriverManager.getConnection(url, usuario, password);
            java.sql.Statement s = serverCon.createStatement();

            // 2. Comando clave: Crea la BD solo si no existe
            s.execute("CREATE DATABASE IF NOT EXISTS " + bd);
            s.close();
        } finally {
            // Cerramos esta conexión temporal al servidor
            if (serverCon != null) {
                serverCon.close();
            }
        }

        // 3. Ahora sí, nos conectamos a nuestra base de datos "grupo_9"
        //    (que sabemos que ya existe)
        this.con = DriverManager.getConnection(url + bd, usuario, password);
        //this.con = DriverManager.getConnection(url + bd, usuario, password);
    }



	public void desconectar() throws SQLException
	{
		this.con.close();
	}

	private void crearTablaValores(java.sql.Statement s) throws SQLException
	{
		s.execute("CREATE TABLE asociados(\r\n" + "	dni varchar(8) primary key not null,\r\n"
				+ " nombre varchar(30) not null,\r\n" + " apellido varchar(30) not null,\r\n"
				+ "	calle varchar(30) not null,\r\n" + "	numero int not null,\r\n"
				+ "	telefono varchar(15) not null,\r\n" + "	ciudad varchar(30) not null);");



		s.execute("insert into asociados(dni, nombre, apellido, calle, numero, telefono, ciudad) \r\n"
				+ "values ('47256279', 'Gian Luca', 'Distefano', 'Constitucion', 6150, '2235376209', 'Mar del Plata'),\r\n"
				+ "	('46054123', 'Santiago', 'Yanosky', 'Matheu', 5102, '2236556561', 'Mar del Plata'),\r\n"
				+ "	('45265789', 'Valentino', 'Giordano', 'San Juan', 2315, '2236851429', 'Mar del Plata'), \r\n"
				+ "	('47015236', 'Juan', 'Aldana', 'Ratery', 5013, '2236884563', 'Mar del Plata'), \r\n"
				+ "	('46025175', 'Agustin', 'Proia', 'Juan b Justo', 982, '2236841257', 'Mar del Plata');");
	}

	public void inicializacion() throws SQLException
	{
		
		java.sql.Statement s = this.con.createStatement();

        s.execute("CREATE TABLE IF NOT EXISTS asociados(\r\n" + "	dni varchar(8) primary key not null,\r\n"
                + " nombre varchar(30) not null,\r\n" + " apellido varchar(30) not null,\r\n"
                + "	calle varchar(30) not null,\r\n" + "	numero int not null,\r\n"
                + "	telefono varchar(15) not null,\r\n" + "	ciudad varchar(30) not null);");

        ResultSet rs = s.executeQuery("select * from asociados;");

        if (rs.next())
        {
            // La tabla ya tiene datos, no hacer nada
            rs.close();
            s.close();
        } else {
            s.execute("insert into asociados(dni, nombre, apellido, calle, numero, telefono, ciudad) \r\n"
                   + "values ('47256279', 'Gian Luca', 'Distefano', 'Constitucion', 6150, '2235376209', 'Mar del Plata'),\r\n"
                  + "	('46054123', 'Santiago', 'Yanosky', 'Matheu', 5102, '2236556561', 'Mar del Plata'),\r\n"
                   + "	('45265789', 'Valentino', 'Giordano', 'San Juan', 2315, '2236851429', 'Mar del Plata'), \r\n"
                    + "	('47015236', 'Juan', 'Aldana', 'Ratery', 5013, '2236884563', 'Mar del Plata'), \r\n"
                    + "	('46025175', 'Agustin', 'Proia', 'Juan b Justo', 982, '2236841257', 'Mar del Plata');");
        }
	}

    public void reiniciarBD() throws SQLException {
        java.sql.Statement s = this.con.createStatement();
        s.execute("DROP TABLE IF EXISTS asociados;");
        crearTablaValores(s);
    }

	public ArrayList<Asociado> getAsociados() throws SQLException
	{

		String nombre, apellido, dni, calle, telefono, ciudad;
		int numero;

		ArrayList<Asociado> listado = new ArrayList<Asociado>();

			java.sql.Statement s = this.con.createStatement();
			ResultSet rs = ((java.sql.Statement) s).executeQuery("Select * from asociados order by dni");

			while (rs.next())
			{
				dni = rs.getString("dni");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				calle = rs.getString("calle");
				numero = rs.getInt("numero");
				telefono = rs.getString("telefono");
				ciudad = rs.getString("ciudad");

				Asociado a = new Asociado(nombre, apellido, dni, calle, numero, telefono, ciudad);
				// System.out.println(a);
				listado.add(a);
            }

		return listado;
	}

	// el asociado debe ser distinto de null
	public void altaBD(Asociado a) throws AsociadoExistenteException
	{
		try
		{
			java.sql.Statement s = this.con.createStatement();

			ResultSet rs = ((java.sql.Statement) s)
					.executeQuery("select * from asociados where dni = '" + a.getDni() + "';");

			if (rs.next())
			{ // existe el associado en la BD
				throw new AsociadoExistenteException(a);
			} else
			{ // agregar a la BD
				s.execute("INSERT INTO asociados (dni, nombre, apellido, calle, numero, telefono, ciudad)" + " VALUES('"
						+ a.getDni() + "', '" + a.getNombre() + "', '" + a.getApellido() + "', '"
						+ a.getDomicilio().getCalle() + "', " + a.getDomicilio().getNumero() + ", '" + a.getTelefono()
						+ "', '" + a.getCiudad() + "');");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// el asociado debe ser distinto de null
	public void bajaBD(Asociado a) throws AsociadoInexistenteException
	{

		try
		{
			java.sql.Statement s = this.con.createStatement();
			ResultSet rs = ((java.sql.Statement) s)
					.executeQuery("select * from asociados where dni = '" + a.getDni() + "';");

			if (rs.next())
			{ // eliminar de la BD
				s.execute("delete from asociados where dni = '" + a.getDni() + "';");
			} else
			{ // no existe en la BD
				throw new AsociadoInexistenteException(a);
			}

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}