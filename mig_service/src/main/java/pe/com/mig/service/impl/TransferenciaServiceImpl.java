package pe.com.mig.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.mig.dao.ITransferenciaDao;
import pe.com.mig.model.bean.DetalleTransferenciaBean;
import pe.com.mig.model.bean.TransferenciaBean;
import pe.com.mig.service.ITransferenciaService;

/**
 * @className: TransferenciaServiceImpl.java
 * @description: 
 * @date: 12 de jun. de 2016
 * @author: SUMERIO.
 */
@Service
public class TransferenciaServiceImpl extends GenericServiceImpl implements ITransferenciaService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ITransferenciaDao iTransferenciaDao;

	/* (non-Javadoc)
	 * @see pe.com.mig.service.ITransferenciaService#listarTransferencias(pe.com.mig.model.bean.TransferenciaBean)
	 */
	@Override
	public List<TransferenciaBean> listarTransferencias(TransferenciaBean transferencia) throws Exception {
		return iTransferenciaDao.listarTransferencias(transferencia);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.ITransferenciaService#listarDetalleTransferencias(pe.com.mig.model.bean.DetalleTransferenciaBean)
	 */
	@Override
	public List<DetalleTransferenciaBean> listarDetalleTransferencias(DetalleTransferenciaBean detalle) throws Exception {
		return iTransferenciaDao.listarDetalleTransferencias(detalle);
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.ITransferenciaService#grabarTransferencia(pe.com.mig.model.bean.TransferenciaBean, java.util.List)
	 */
	@Override
	public Integer grabarTransferencia(TransferenciaBean transferencia, List<DetalleTransferenciaBean> detalle) throws Exception {
		return iTransferenciaDao.grabarTransferencia(transferencia, detalle);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.ITransferenciaService#eliminarTransferencia(pe.com.mig.model.bean.TransferenciaBean)
	 */
	@Override
	public void eliminarTransferencia(TransferenciaBean transferencia) throws Exception {
		iTransferenciaDao.eliminarTransferencia(transferencia);
	}

}
