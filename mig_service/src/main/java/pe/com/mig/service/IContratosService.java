package pe.com.mig.service;

import java.util.List;

import pe.com.mig.model.bean.ContratosBean;
import pe.com.mig.model.bean.DetalleContratosBean;

/**
 * @className: IContratoService.java
 * @description: 
 * @date: 25 de jun. de 2016
 * @author: SUMERIO.
 */
public interface IContratosService {
	
	/**
	 * @param contrato
	 * @return
	 * @throws Exception
	 */
	public abstract List<ContratosBean> listarContrato(ContratosBean contrato) throws Exception;
	
	/**
	 * @param contrato
	 * @param listaDetalleContrato 
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarContrato(ContratosBean contrato, List<DetalleContratosBean> listaDetalleContrato) throws Exception;
	
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
