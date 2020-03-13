package pe.com.mig.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.mig.dao.ICierreMesDao;
import pe.com.mig.model.bean.CierreMesBean;
import pe.com.mig.model.entity.TCierreMes;
import pe.com.mig.util.Constantes;

/**
 * @className: CierreMesDaoImpl.java
 * @description: 
 * @date: 25 de jun. de 2016
 * @author: SUMERIO.
 */
@Repository
public class CierreMesDaoImpl extends GenericDaoImpl implements ICierreMesDao {

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.ICierreMesDao#listarCierreMes(pe.com.mig.model.bean.CierreMesBean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<CierreMesBean> listarCierreMes(CierreMesBean cierre) throws Exception {
		try {
			StringBuilder hql = new StringBuilder();			
			hql.append("select tcm.srlIdMes as cod_mes, tcm.intAno as anio, ");		
			hql.append("tcm.intMes as mes, ");			
			hql.append("to_char(tcm.dteFecCierre, 'DD/MM/YYYY') as fec_cierre, ");
			hql.append("to_char(tcm.dteFecDescierre, 'DD/MM/YYYY') as fec_des_cierre, ");
			hql.append("to_char(tcm.dteFecApertura, 'DD/MM/YYYY') as fec_apertura, ");
			hql.append("tcm.chrMesActivo as mes_activo, tcm.chrFlgApertura as fla_apertura, ");
			hql.append("tcm.chrFlgActivo as fla_activo ");
			hql.append("from TCierreMes tcm ");		
			hql.append("where tcm.chrFlgActivo = :fla_activo ");
			if (!isNullInteger(cierre.getAnio())) {
				hql.append("and tcm.intAno = :anio ");
			}
			if (!isNullInteger(cierre.getMes())) {
				hql.append("and tcm.intMes = :mes ");
			}
			hql.append("order by tcm.srlIdMes");	
			Query query = super.getSession().createQuery(hql.toString());
			query.setParameter("fla_activo", Constantes.FLAG_ACTIVO);
			if (!isNullInteger(cierre.getAnio())) {
				query.setParameter("anio", cierre.getAnio());
			}
			if (!isNullInteger(cierre.getMes())) {
				query.setParameter("mes", cierre.getMes());
			}
			return query.setResultTransformer(Transformers.aliasToBean(CierreMesBean.class)).list();		
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.ICierreMesDao#grabarCierreMes(pe.com.mig.model.bean.CierreMesBean)
	 */
	@Transactional
	@Override
	public Integer grabarCierreMes(CierreMesBean cierre) throws Exception {
		Integer codigo = cierre.getCod_mes();
		try {		
			TCierreMes tcierremes = new TCierreMes();
			if (!isNullInteger(codigo)) {				
				tcierremes = (TCierreMes) getById(TCierreMes.class, codigo);
			}
			tcierremes.setIntAno(cierre.getAnio());
			tcierremes.setIntMes(cierre.getMes());
			tcierremes.setDteFecCierre(getDate(cierre.getFec_cierre()));
			tcierremes.setDteFecDescierre(getDate(cierre.getFec_des_cierre()));
			tcierremes.setDteFecApertura(getDate(cierre.getFec_apertura()));
			tcierremes.setChrMesActivo(cierre.getMes_activo());
			tcierremes.setChrFlgApertura(cierre.getFla_apertura());
			
			if (!isNullInteger(codigo)) {
				tcierremes.setChrCodUsuaModifica(cierre.getVnomusuario());
				tcierremes.setDteFecModifica(Calendar.getInstance().getTime());
				update(tcierremes);			
			} else {
//				tcierremes.setChrFlgActivo(Constantes.FLAG_ACTIVO);
				tcierremes.setChrCodUsuaCreacion(cierre.getVnomusuario());
				tcierremes.setDteFecCreacion(Calendar.getInstance().getTime());
				codigo = getByIdSave(tcierremes);
			}
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
		return codigo;
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.dao.ICierreMesDao#eliminarCierreMes(pe.com.mig.model.bean.CierreMesBean)
	 */
	@Transactional
	@Override
	public void eliminarCierreMes(CierreMesBean cierre) throws Exception {
		try {
			TCierreMes tcierremes = new TCierreMes(); 
			tcierremes = (TCierreMes) getById(TCierreMes.class, cierre.getCod_mes());			
//			tcierremes.setChrFlgActivo(Constantes.FLAG_INACTIVO);
			tcierremes.setChrCodUsuaModifica(cierre.getVnomusuario());
			tcierremes.setDteFecModifica(Calendar.getInstance().getTime());
			update(tcierremes);
		} catch (Exception e) {
			throw new Exception(getGenerarError(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								Constantes.NIVEL_APP_DAO, 
								this.getClass().getName(), e.getMessage()));
		}
	}

}
