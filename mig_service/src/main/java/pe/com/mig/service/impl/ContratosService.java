package pe.com.mig.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.mig.dao.IContratosDao;
import pe.com.mig.model.bean.ContratosBean;
import pe.com.mig.model.bean.DetalleContratosBean;
import pe.com.mig.service.IContratosService;

/**
 * @className: ContratosService.java
 * @description: 
 * @date: 25 de jun. de 2016
 * @author: SUMERIO.
 */
@Service
public class ContratosService extends GenericServiceImpl implements IContratosService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IContratosDao iContratosDao;
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IContratosService#listarContrato(pe.com.mig.model.bean.ContratosBean)
	 */
	@Override
	public List<ContratosBean> listarContrato(ContratosBean contrato) throws Exception {
		return iContratosDao.listarContrato(contrato);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IContratosService#grabarContrato(pe.com.mig.model.bean.ContratosBean)
	 */
	@Override
	public Integer grabarContrato(ContratosBean contrato, List<DetalleContratosBean> listaDetalleContrato) throws Exception {
		return iContratosDao.grabarContrato(contrato, listaDetalleContrato);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IContratosService#eliminarContrato(pe.com.mig.model.bean.ContratosBean)
	 */
	@Override
	public void eliminarContrato(ContratosBean contrato) throws Exception {
		iContratosDao.eliminarContrato(contrato);
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IContratosService#listarDetalleContrato(pe.com.mig.model.bean.DetalleContratosBean)
	 */
	@Override
	public List<DetalleContratosBean> listarDetalleContrato(DetalleContratosBean detalle) throws Exception {
		return iContratosDao.listarDetalleContrato(detalle);
	}

}
