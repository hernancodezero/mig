package pe.com.mig.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.mig.dao.IRequeBoletosDao;
import pe.com.mig.model.bean.DetalleBoletosBean;
import pe.com.mig.model.bean.EntregaBoletosBean;
import pe.com.mig.model.bean.RequeBoletosBean;
import pe.com.mig.service.IRequeBoletosService;

/**
 * @className: RequeBoletosServiceImpl.java
 * @description: 
 * @date: 18 de jul. de 2016
 * @author: SUMERIO.
 */
@Service
public class RequeBoletosServiceImpl extends GenericServiceImpl implements IRequeBoletosService {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IRequeBoletosDao iRequeBoletosDao;

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IRequeBoletosService#listarRequeBoletos(pe.com.mig.model.bean.RequeBoletosBean)
	 */
	@Override
	public List<RequeBoletosBean> listarRequeBoletos(RequeBoletosBean boleto) throws Exception {
		return iRequeBoletosDao.listarRequeBoletos(boleto);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IRequeBoletosService#listarDetalleBoletos(pe.com.mig.model.bean.DetalleBoletosBean)
	 */
	@Override
	public List<DetalleBoletosBean> listarDetalleBoletos(DetalleBoletosBean detalle) throws Exception {
		return iRequeBoletosDao.listarDetalleBoletos(detalle);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IRequeBoletosService#listarEntregaBoletos(pe.com.mig.model.bean.EntregaBoletosBean)
	 */
	@Override
	public List<EntregaBoletosBean> listarEntregaBoletos(EntregaBoletosBean entrega) throws Exception {
		return iRequeBoletosDao.listarEntregaBoletos(entrega);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IRequeBoletosService#grabarRequeBoletos(pe.com.mig.model.bean.RequeBoletosBean, java.util.List, java.util.List)
	 */
	@Override
	public Integer grabarRequeBoletos(RequeBoletosBean boleto, List<DetalleBoletosBean> detalle, List<EntregaBoletosBean> entrega) throws Exception {
		return iRequeBoletosDao.grabarRequeBoletos(boleto, detalle, entrega);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IRequeBoletosService#eliminarRequeBoletos(pe.com.mig.model.bean.RequeBoletosBean)
	 */
	@Override
	public void eliminarRequeBoletos(RequeBoletosBean boleto) throws Exception {
		iRequeBoletosDao.eliminarRequeBoletos(boleto);
	}

}
