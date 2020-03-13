package pe.com.mig.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.mig.dao.IGenericDao;
import pe.com.mig.util.Constantes;
import pe.com.mig.util.DateUtil;

/**
 * @className: GenericDaoImpl.java
 * @description: Clase genérica de acceso a datos.
 * @date: 02/02/2015 16:07:19
 * @author: Hernando Huaman.
 */
@Repository("iGenericDao")
public class GenericDaoImpl implements IGenericDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;	
	private Session session;
	
	/**
	 * Retorna una sesión del SessionFactory
	 * @return Session - Sesión activa, tipo Session.
	 */
	protected Session getSession() throws HibernateException {
		if (session == null || !session.isOpen()) {
			session = sessionFactory.getCurrentSession();
		}
		return session;
	}
	
	/**
	 * Graba una entidad.
	 * @param object - Entidad a grabar, tipo Object.
	 * @return Entidad grabada, tipo Object.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	@Override
	@Transactional
	public Object save(Object object) throws Exception {
		this.getSession().save(object);
		return object;
	}
	
	/**
	 * Graba o Actualiza(en caso exista) una entidad.
	 * @param object - Entidad a ser grabada o actualizada, tipo Object.
	 * @return Entidad grabada o actualizada, tipo Object.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	@Override
	@Transactional
	public Object saveOrUpdate(Object object) throws Exception {
		this.getSession().saveOrUpdate(object);
		return object;
	}

	/**
	 * Actualiza una entidad.
	 * @param object - Entidad a ser actualizada, tipo Object.
	 * @return Entidad actualizada, tipo Object.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	@Override
	@Transactional
	public Object update(Object object) throws Exception {
		this.getSession().update(object);
		return object;
	}
	
	/**
	 * Obtiene una entidad por su identificador.
	 * @param clazz - Clase a recuperar, tipo Class.
	 * @param id - Identificador de la clase a recuperar, tipo  Serializable.
	 * @return Entidad, tipo Object. 
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(readOnly=true)
	public Object getById(Class clazz, Serializable id) throws Exception {
		return this.getSession().get(clazz, id);
	}
	
	/**
	 * Busca una o mas entidades por una propiedad.
	 * @param table - Nombre de la entidad, tipo String.
	 * @param propertyName - Nombre de la propiedad de la entidad, tipo String. 
	 * @param value - Valor de la propiedad propertyName, tipo Object. 
	 * @return Lista de registros encotrados, tipo List.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(readOnly = true)
	public List findByProperty(String table, String propertyName, Object value) throws Exception {
		StringBuilder hql = new StringBuilder(); 
		hql.append("from ");
		hql.append(table);
		hql.append(" as model ");
		if(value instanceof String) {
			hql.append("where trim(model.");
			hql.append(propertyName);
			hql.append(") = ");
			hql.append("'");
			hql.append(value); 
			hql.append("'");
		} else {
			hql.append("where model.");
			hql.append(propertyName);
			hql.append(" = ");
			hql.append(value);
		}
		Query query = this.getSession().createQuery(hql.toString());
		return query.list();
	}
	
	/**
	 * Busca una entidad por el valor de una de sus propiedades.
	 * @param table - Nombre de la entidad, tipo String.
	 * @param propertyName - Nombre de la propiedad de la entidad, tipo String.
	 * @param value - Valor de la propiedad propertyName, tipo Object. 
	 * @return registro encontrador, tipo Object.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	@Override
	@Transactional(readOnly = true)
	public Object getByProperty(String table, String propertyName, Object value) throws Exception {
		StringBuilder hql = new StringBuilder(); 
		hql.append("from ");
		hql.append(table);
		hql.append(" as model ");
		if(value instanceof String) {
			hql.append("where trim(model.");
			hql.append(propertyName);
			hql.append(") = ");
			hql.append("'");
			hql.append(value); 
			hql.append("'");
		} else {
			hql.append("where model.");
			hql.append(propertyName);
			hql.append(" = ");
			hql.append(value);
		}
		Query query = this.getSession().createQuery(hql.toString());
		query.setMaxResults(1);
		return query.uniqueResult();
	}
	
	/**
	 * Busca todos los registros de la entidad.
	 * @param table - Nombre de la entidad, tipo String.
	 * @return Lista de registros encontrados, tipo List.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(readOnly = true)
	public List findAll(String table) throws Exception {
		StringBuilder hql = new StringBuilder();
		hql.append("from ");
		hql.append(table);
		Query query = this.getSession().createQuery(hql.toString());
		return query.list();
	}
	
	/**
	 * Devuelve el error formateado con el nombre del método.
	 * @param nombre - Nombre del método donde se genero el error, tipo String
	 * @param nivel - Nivel donde se genero el error, tipo String
	 * @param nombreClase - Nombre de la clase, tipo String
	 * @param mensaje - Mensaje del error, tipo String
	 * @return Mensaje formateado.
	 */
	public String getGenerarError(String nombre, String nivel, String nombreClase, String mensaje) {
		StringBuffer error = new StringBuffer();
		if(nivel.equals(Constantes.NIVEL_APP_CONSTROLLER)) {
			error.append(Constantes.DIVISOR_ERROR_4);
		}
		error.append(Constantes.DIVISOR_ERROR_1);
		error.append(nombreClase);
		error.append(" - ");
		error.append(nombre);
		error.append(Constantes.DIVISOR_ERROR_2);
		if(nivel.equals(Constantes.NIVEL_APP_DAO)) {
			error.append(Constantes.DIVISOR_ERROR_3);
		}
		error.append(mensaje);
		return error.toString();
	}
	
	/**
	 * Graba una entidad.
	 * @param object - Entidad Object, tipo Object.
	 * @return Identificador de la notificación, tipo Integer.
	 * @throws Exception - Manejador de excepción que pueda ocurrir.
	 */
	@Override
	@Transactional
	public Integer getByIdSave(Object object) throws Exception {	
		return (Integer) sessionFactory.getCurrentSession().save(object);
	}
	
	/**
	 * @throws HibernateException
	 */
	public void flush() throws HibernateException {
		this.getSession().flush();
	}
	
	/**
	 * Verifica si la cadena esta vacía
	 * @param campo - valor del parámetro a evaluar, tipo String
	 * @return true si es vacío o nulo y false lo contrario
	 */
	public static boolean isNullOrEmpty(String campo) { 
	    return campo == null || campo.trim().length() == 0;
	}
	
	/**
	 * Verifica si la cadena esta vacía
	 * @param campo - valor del parámetro a evaluar, tipo Object
	 * @return true si es vacío o nulo y false lo contrario
	 */
	public static boolean isNull(Object campo) {
		if (campo == null) {
			return true;
		} else {
			return false;
		}
	}	
	
	/**
	 * Verifica si la lista esta vacía
	 * @param coll - Lista parámetro a evaluar, tipo Collection.
	 * @return true si es vacío o nulo y false lo contrario.
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Collection coll) {
	    return (coll == null || coll.isEmpty());
	}
	
	/**
	 * Verifica si el entero es nulo o con valor 0 por defecto.
	 * @param campo - valor del parámetro a evaluar, tipo Integer.
	 * @return true si es vacío o nulo y false lo contrario
	 */
	public static boolean isNullInteger(Integer campo) {
		if (!isNull(campo) && campo > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Verifica si el entero es nulo o con valor 0 por defecto.
	 * @param campo - valor del parámetro a evaluar, tipo Long.
	 * @return true si es vacío o nulo y false lo contrario
	 */
	public static boolean isNullLong(Long campo) {
		if (!isNull(campo) && campo > 0) {
			return false;
		} else {
			return true;
		}
	}	
	
	/**
	 * Retorna el valor parseado.
	 * @param campo - Valor del parámetro a evaluar, tipo String.
	 * @return valor - Valor entero sino retorna nulo.
	 */
	public static Integer getInteger(String campo) {
		Integer valor = null;
		if (!isNullOrEmpty(campo)) {
			valor =	Integer.parseInt(campo);	
		}
		return valor; 	
	}
	
	/**
	 * Retorna el valor parseado.
	 * @param campo - Valor del parámetro a evaluar, tipo String.
	 * @return date - Valor long sino retorna nulo.
	 */
	public static Long getLong(String campo) {
		Long valor = null;
		if (!isNullOrEmpty(campo)) {
			valor =	Long.parseLong(campo);	
		}
		return valor; 	
	}
	
	/**
	 * Retorna el valor parseado.
	 * @param campo - Valor del parámetro a evaluar, tipo String.
	 * @return date - Valor long sino retorna nulo.
	 */
	public static BigDecimal getBigDecimal(String campo) {
		BigDecimal valor = null;
		if (!isNullOrEmpty(campo)) {
			valor = new BigDecimal(campo);
		}
		return valor; 	
	}
	
	/**
	 * Retorna el valor de la fecha formateada.
	 * @param campo - Valor del parámetro a evaluar, tipo String.
	 * @return date - Valor de fecha sino retorna nulo.
	 */
	public static Date getDate(String campo) {
		Date fecha = null;
		if (!isNullOrEmpty(campo)) {
			fecha =	DateUtil.obtenerFechaParseada(Constantes.FORMATO_FECHA, campo);	
		}
		return fecha; 	
	}
	
}
