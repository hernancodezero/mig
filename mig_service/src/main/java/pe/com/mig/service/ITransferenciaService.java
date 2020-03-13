package pe.com.mig.service;

import java.util.List;

import pe.com.mig.model.bean.DetalleTransferenciaBean;
import pe.com.mig.model.bean.TransferenciaBean;

/**
 * @className: ITransferenciaService.java
 * @description: 
 * @date: 12 de jun. de 2016
 * @author: SUMERIO.
 */
public interface ITransferenciaService {

	/**
	 * @param transferencia
	 * @return
	 * @throws Exception 
	 */
	public abstract List<TransferenciaBean> listarTransferencias(TransferenciaBean transferencia) throws Exception;
	
	/**
	 * @param detalle
	 * @return
	 * @throws Exception 
	 */
	public abstract List<DetalleTransferenciaBean> listarDetalleTransferencias(DetalleTransferenciaBean detalle) throws Exception;
	
	/**
	 * @param transferencia
	 * @param detalle
	 * @return
	 */
	public abstract Integer grabarTransferencia(TransferenciaBean transferencia, List<DetalleTransferenciaBean> detalle) throws Exception;
	
	/**
	 * @param transferencia
	 * @throws Exception
	 */
	public abstract void eliminarTransferencia(TransferenciaBean transferencia) throws Exception;
	
}
