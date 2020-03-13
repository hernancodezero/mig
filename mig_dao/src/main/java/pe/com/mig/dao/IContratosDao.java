package pe.com.mig.dao;

import java.util.List;

import pe.com.mig.model.bean.ContratosBean;
import pe.com.mig.model.bean.DetalleContratosBean;

/**
 * @className: IContratosDao.java
 * @description: 
 * @date: 25 de jun. de 2016
 * @author: SUMERIO.
 */
public interface IContratosDao {
	
	/**
	 * @param contrato
	 * @return
	 * @throws Exception
	 */
	public abstract List<ContratosBean> listarContrato(ContratosBean contrato) throws Exception;
	
	/**
	 * @param contrato
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarContrato(ContratosBean contrato, List<DetalleContratosBean> detalle) throws Exception;
	
	/**
	 * @param contrato
	 * @throws Exception
	 */
	public abstract void eliminarContrato(ContratosBean contrato) throws Exception;
	/**
	 * @param detalle
	 * @return
	 * @throws Exception
	 */
	public abstract List<DetalleContratosBean> listarDetalleContrato(DetalleContratosBean detalle) throws Exception;

}
