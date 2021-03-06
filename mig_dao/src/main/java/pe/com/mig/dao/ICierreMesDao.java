package pe.com.mig.dao;

import java.util.List;

import pe.com.mig.model.bean.CierreMesBean;

/**
 * @className: ICierreMesDao.java
 * @description: 
 * @date: 25 de jun. de 2016
 * @author: SUMERIO.
 */
public interface ICierreMesDao {

	/**
	 * @param cierre
	 * @return
	 * @throws Exception
	 */
	public abstract List<CierreMesBean> listarCierreMes(CierreMesBean cierre) throws Exception;
	
	/**
	 * @param cierre
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarCierreMes(CierreMesBean cierre) throws Exception;
	
	/**
	 * @param cierre
	 * @throws Exception
	 */
	public abstract void eliminarCierreMes(CierreMesBean cierre) throws Exception;
	
}
