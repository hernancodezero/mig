package pe.com.mig.service;

import java.io.Serializable;
import java.util.List;

/**
 * Resumen.
 * Objeto : IGenericService
 * Descripción : Interfaz de acceso a datos genérica.
 * Fecha de creación : 03/12/2012 11:36:10
 * @author Hernando Huaman
 */

public interface IGenericService {

	/**
	 * Graba una entidad.
	 * @param object - Entidad a grabar, tipo Object.
	 * @return Entidad grabada, tipo Object.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	public abstract Object save(Object object) throws Exception;
	
	/**
	 * Graba o Actualiza(en caso exista) una entidad.
	 * @param object - Entidad a ser grabada o actualizada, tipo Object.
	 * @return Entidad grabada o actualizada, tipo Object.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	public abstract Object saveOrUpdate(Object object) throws Exception;
	
	/**
	 * Actualiza una entidad.
	 * @param object - Entidad a ser actualizada, tipo Object.
	 * @return Entidad actualizada, tipo Object.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	public abstract Object update(Object object) throws Exception;
	
	/**
	 * Obtiene una entidad por su identificador.
	 * @param clazz - Clase a recuperar, tipo Class.
	 * @param id - identificador de la clase a recuperar, tipo  Serializable.
	 * @return Entidad, tipo Object.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	@SuppressWarnings("rawtypes")
	public abstract Object getById(Class clazz, Serializable id) throws Exception;
	
	/**
	 * Busca una o mas entidades por una propiedad.
	 * @param table - Nombre de la entidad, tipo String.
	 * @param propertyName - Nombre de la propiedad de la entidad, tipo String. 
	 * @param value - Valor de la propiedad propertyName, tipo Object. 
	 * @return Lista de registros encotrados, tipo List.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	@SuppressWarnings("rawtypes")
	public abstract List findByProperty(String table, String propertyName, Object value) throws Exception;
	
	/**
	 * Busca una entidad por el valor de una de sus propiedades.
	 * @param table - Nombre de la entidad, tipo String.
	 * @param propertyName - Nombre de la propiedad de la entidad, tipo String.
	 * @param value - Valor de la propiedad propertyName, tipo Object. 
	 * @return registro encontrado, tipo Object.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	public abstract Object getByProperty(String table, String propertyName, Object value) throws Exception;	
	
	/**
	 * Busca todos los registros de la entidad.
	 * @param table - Nombre de la entidad, tipo String.
	 * @return Lista de registros encontrados, tipo List.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	@SuppressWarnings("rawtypes")
	public abstract List findAll(String table) throws Exception;
	
	/**
	 * Graba una entidad.
	 * @param object - Entidad Object, tipo Object.
	 * @return Identificador de la notificación, tipo Integer.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	public abstract Integer getByIdSave(Object object) throws Exception;
	
}
