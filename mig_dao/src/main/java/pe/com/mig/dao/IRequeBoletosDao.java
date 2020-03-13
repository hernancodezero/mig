package pe.com.mig.dao;

import java.util.List;

import pe.com.mig.model.bean.DetalleBoletosBean;
import pe.com.mig.model.bean.EntregaBoletosBean;
import pe.com.mig.model.bean.RequeBoletosBean;

/**
 * @className: IRequeBoletosDao.java
 * @description: 
 * @date: 18 de jul. de 2016
 * @author: SUMERIO.
 */
public interface IRequeBoletosDao {

	/**
	 * @param boleto
	 * @return
	 * @throws Exception 
	 */
	public abstract List<RequeBoletosBean> listarRequeBoletos(RequeBoletosBean boleto) throws Exception;
	
	/**
	 * @param detalle
	 * @return
	 * @throws Exception 
	 */
	public abstract List<DetalleBoletosBean> listarDetalleBoletos(DetalleBoletosBean detalle) throws Exception;
	
	/**
	 * @param entrega
	 * @return
	 * @throws Exception 
	 */
	public abstract List<EntregaBoletosBean> listarEntregaBoletos(EntregaBoletosBean entrega) throws Exception;
	
	/**
	 * @param boleto
	 * @param detalle
	 * @param entrega 
	 * @return
	 * @throws Exception 
	 */
	public abstract Integer grabarRequeBoletos(RequeBoletosBean boleto, List<DetalleBoletosBean> detalle, List<EntregaBoletosBean> entrega) throws Exception;
	
	/**
	 * @param boleto
	 * @throws Exception
	 */
	public abstract void eliminarRequeBoletos(RequeBoletosBean boleto) throws Exception;
	
	/**
	 * @param detalle
	 * @return
	 * @throws Exception 
	 */
	public abstract void actualizarTarifaBoleto(DetalleBoletosBean detalle) throws Exception;
	
}
