package Persistencia.interfaz;

import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Negocio.clases.Asociado;
import Persistencia.excepciones.AsociadoExistenteException;
import Persistencia.excepciones.AsociadoInexistenteException;

public interface IPersistencia
{
	public void conectar() throws SQLException;
	public void desconectar() throws SQLException;
	public void inicializacion() throws SQLException;
	public ArrayList<Asociado> getAsociados() throws SQLException;
	public void altaBD(Asociado a) throws AsociadoExistenteException;
	public void bajaBD(Asociado a) throws AsociadoInexistenteException;
}
