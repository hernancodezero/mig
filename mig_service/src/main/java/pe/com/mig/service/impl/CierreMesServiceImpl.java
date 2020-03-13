package pe.com.mig.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.mig.dao.ICierreMesDao;
import pe.com.mig.model.bean.CierreMesBean;
import pe.com.mig.service.ICierreMesService;

/**
 * @className: CierreMesServiceImpl.java
 * @description: 
 * @date: 25 de jun. de 2016
 * @author: SUMERIO.
 */
@Service
public class CierreMesServiceImpl extends GenericServiceImpl implements ICierreMesService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ICierreMesDao iCierreMesDao;

	/* (non-Javadoc)
	 * @see pe.com.mig.service.ICierreMesService#listarCierreMes(pe.com.mig.model.bean.CierreMesBean)
	 */
	@Override
	public List<CierreMesBean> listarCierreMes(CierreMesBean cierre) throws Exception {
		return iCierreMesDao.listarCierreMes(cierre);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.ICierreMesService#grabarCierreMes(pe.com.mig.model.bean.CierreMesBean)
	 */
	@Override
	public Integer grabarCierreMes(CierreMesBean cierre) throws Exception {
		return iCierreMesDao.grabarCierreMes(cierre);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.ICierreMesService#eliminarCierreMes(pe.com.mig.model.bean.CierreMesBean)
	 */
	@Override
	public void eliminarCierreMes(CierreMesBean cierre) throws Exception {
		iCierreMesDao.grabarCierreMes(cierre);
	}

}
