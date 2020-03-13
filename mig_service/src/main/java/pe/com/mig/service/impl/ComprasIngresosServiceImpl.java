package pe.com.mig.service.impl; 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.mig.dao.IComprasIngresosDao;
import pe.com.mig.model.bean.CierreMesBean;
import pe.com.mig.model.bean.ComprasIngresosBean;
import pe.com.mig.model.bean.DetalleComprasBean;
import pe.com.mig.model.bean.DetalleIngresosBean;
import pe.com.mig.model.bean.DetalleOtrosBean;
import pe.com.mig.model.bean.DetalleVoucherBean;
import pe.com.mig.model.bean.ProductoBean;
import pe.com.mig.model.bean.ReporteDetalleComprasBean;
import pe.com.mig.model.bean.ReporteDetalleIngresosBean;
import pe.com.mig.model.bean.SucursalBean;
import pe.com.mig.model.bean.TarifaBoletoBean;
import pe.com.mig.model.bean.TarifaServicioBean;
import pe.com.mig.model.bean.TarifaTupaBean;
import pe.com.mig.model.bean.TransferenciaBean;
import pe.com.mig.model.bean.UbigeoBean;
import pe.com.mig.service.IComprasIngresosService;
import pe.com.mig.util.Constantes;

/**
 * @className: ComprasIngresosServiceImpl.java
 * @description: 
 * @date: 14 de jun. de 2016
 * @author: SUMERIO.
 */
@Service
public class ComprasIngresosServiceImpl extends GenericServiceImpl implements IComprasIngresosService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IComprasIngresosDao iCompraDao;
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.ICompraService#listarCompras(pe.com.mig.model.bean.ComprasBean)
	 */
	@Override
	public List<ComprasIngresosBean> listarComprasSerie(ComprasIngresosBean cod_serie) throws Exception {
		return iCompraDao.listarComprasSerie(cod_serie);
	}	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.ICompraService#listarCompras(pe.com.mig.model.bean.ComprasBean)
	 */
	@Override
	public List<ComprasIngresosBean> listarCompras(ComprasIngresosBean compra) throws Exception {
		return iCompraDao.listarCompras(compra);
	}
	@Override
	public List<ComprasIngresosBean> listarNotasRet(ComprasIngresosBean compra) throws Exception {
		return iCompraDao.listarCompras(compra);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.ICompraService#listarDetalleCompras(pe.com.mig.model.bean.ComprasBean)
	 */
	@Override
	public List<DetalleComprasBean> listarDetalleCompras(ComprasIngresosBean compra) throws Exception {
		return iCompraDao.listarDetalleCompras(compra);
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.ICompraService#grabarCompra(pe.com.mig.model.bean.ComprasBean, java.util.List)
	 */
	@Override
	public Integer grabarCompra(ComprasIngresosBean compra, List<DetalleComprasBean> detalle) throws Exception {
		return iCompraDao.grabarCompra(compra, detalle);
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.ICompraService#eliminarCompra(pe.com.mig.model.bean.ComprasBean)
	 */
	@Override
	public void eliminarCompra(ComprasIngresosBean compra) throws Exception {
		iCompraDao.eliminarCompra(compra);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#montoTransferencia(pe.com.mig.model.bean.TransferenciaBean)
	 */
	@Override
	public BigDecimal montoTransferencia(TransferenciaBean transferencia) throws Exception {
		return iCompraDao.montoTransferencia(transferencia);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarTarifaServicios(pe.com.mig.model.bean.TarifaServicioBean)
	 */
	@Override
	public List<TarifaServicioBean> listarTarifaServicios(TarifaServicioBean servicio) throws Exception {
		return iCompraDao.listarTarifaServicios(servicio);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarProductos(pe.com.mig.model.bean.ProductoBean)
	 */
	@Override
	public List<ProductoBean> listarProductos(ProductoBean producto) throws Exception {
		return iCompraDao.listarProductos(producto);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarBoletos(pe.com.mig.model.bean.TarifaBoletoBean)
	 */
	@Override
	public List<TarifaBoletoBean> listarBoletos(TarifaBoletoBean boleto) throws Exception {
		return iCompraDao.listarBoletos(boleto);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarTupas(pe.com.mig.model.bean.TarifaTupaBean)
	 */
	@Override
	public List<TarifaTupaBean> listarTupas(TarifaTupaBean tupa) throws Exception {
		return iCompraDao.listarTupas(tupa);
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarOtros(pe.com.mig.model.bean.DetalleOtrosBean)
	 */
	@Override
	public List<DetalleOtrosBean> listarOtros(DetalleOtrosBean otros) throws Exception {
		return iCompraDao.listarOtros(otros);
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#grabarIngreso(pe.com.mig.model.bean.ComprasIngresosBean, java.util.List, java.util.List)
	 */
	@Override
	public Integer grabarIngreso(ComprasIngresosBean ingreso, List<DetalleIngresosBean> detalle, List<DetalleVoucherBean> det_voucher) throws Exception {
		return iCompraDao.grabarIngreso(ingreso, detalle, det_voucher);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarDetalleIngresos(pe.com.mig.model.bean.ComprasIngresosBean)
	 */
	@Override
	public List<DetalleIngresosBean> listarDetalleIngresos(ComprasIngresosBean ingreso) throws Exception {
		return iCompraDao.listarDetalleIngresos(ingreso);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#grabarNotaCredito(pe.com.mig.model.bean.ComprasIngresosBean, pe.com.mig.model.bean.DetalleComprasBean, pe.com.mig.model.bean.DetalleIngresosBean)
	 */
	@Override
	public Integer grabarNotaCredito(ComprasIngresosBean com_ingreso, DetalleComprasBean det_compras, DetalleIngresosBean det_ingresos) throws Exception {
		return iCompraDao.grabarNotaCredito(com_ingreso, det_compras, det_ingresos);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#montoCompraNota(pe.com.mig.model.bean.TransferenciaBean)
	 */
	@Override
	public BigDecimal montoCompraNota(TransferenciaBean transferencia) throws Exception {
		return iCompraDao.montoCompraNota(transferencia);
	}
	
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarReporteCompras(pe.com.mig.model.bean.ComprasIngresosBean)
	 */
	@Override
	public List<ReporteDetalleComprasBean> listarReporteCompras(ComprasIngresosBean compra) throws Exception {
		List<ReporteDetalleComprasBean> lista = iCompraDao.listarReporteCompras(compra);
		if (compra.getCod_servicio().equals(Constantes.TWO_INT) &&  // Documentos de la Rendición de Cuenta	
				!isNullOrEmpty(compra.getNro_doc_rc()) && !isEmpty(lista)) {
			List<ReporteDetalleComprasBean> lis_aux = new ArrayList<ReporteDetalleComprasBean>();
			List<DetalleComprasBean> lis_detalle = iCompraDao.listarDetalleCompraTransferencia(compra);
			if (!isEmpty(lis_detalle)) {
				for (ReporteDetalleComprasBean rep_compra : lista) {
					boolean indicador = false;
					for (DetalleComprasBean detalle : lis_detalle) {
						if (!indicador) {
							if (rep_compra.getCod_especifica().equals(detalle.getCod_especifica()) &&
									rep_compra.getVcod_especifica().equals(detalle.getVcod_especifica()) &&
									rep_compra.getCod_meta().equals(detalle.getCod_meta())) {
								ReporteDetalleComprasBean rep_com_tra = new ReporteDetalleComprasBean();
								rep_com_tra = rep_compra;
								rep_com_tra.setDes_fue_financiamiento(detalle.getFue_financiamiento());
								rep_com_tra.setNum_siaf(detalle.getNum_siaf());
								rep_com_tra.setNum_comprobante(detalle.getNum_comprobante());
								rep_com_tra.setFec_com_transferencia(detalle.getFec_com_transferencia());
								lis_aux.add(rep_com_tra);
								indicador = true;
							}
						}
					}
				}
				lista.clear();
				lista.addAll(lis_aux);
			} else {
				lista.clear();
			}
		} else if (compra.getCod_servicio().equals(Constantes.THREE_INT) && !isEmpty(lista)) { // Reporte de Compras
			compra.setInd_not_credito(Constantes.ONE_INT);
			List<ComprasIngresosBean> lis_compra = iCompraDao.listarCompras(compra);
			if (!isEmpty(lis_compra)) {
				for (ReporteDetalleComprasBean rep_compra : lista) {
					for (ComprasIngresosBean com : lis_compra) {
						if (!isNullInteger(rep_compra.getCod_pad_com_ingresos()) &&	
								rep_compra.getCod_pad_com_ingresos().equals(com.getCod_com_ingresos())) {
							rep_compra.setSer_com_not_cre(com.getSer_comprobante());
							rep_compra.setNro_com_not_cre(com.getNro_comprobante());
							rep_compra.setFec_com_not_cre(com.getFec_comprobante());
							rep_compra.setTip_com_not_cre(com.getVcod_comprobante());
						}						
					}
				}
			}			
		}
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarReporteIngresos(pe.com.mig.model.bean.ComprasIngresosBean)
	 */
	@Override
	public List<ReporteDetalleIngresosBean> listarReporteIngresos(ComprasIngresosBean ingreso) throws Exception {
		List<ReporteDetalleIngresosBean> lista = iCompraDao.listarReporteIngresos(ingreso);
		if (!isEmpty(lista) && (!ingreso.getTip_transaccion().equals(Constantes.SIX_STRING) &&
								!ingreso.getTip_transaccion().equals(Constantes.SEVEN_STRING))) {
			List<ReporteDetalleIngresosBean> lis_aux = new ArrayList<ReporteDetalleIngresosBean>();
			lis_aux.addAll(lista);
			DetalleVoucherBean voucher = new DetalleVoucherBean();
			voucher.setFec_inicio(ingreso.getFec_inicio());
			voucher.setFec_final(ingreso.getFec_final());
			voucher.setCod_mes(ingreso.getCod_mes());
			List<DetalleVoucherBean> lis_det_voucher = iCompraDao.listarDetalleVoucher(voucher);
			if (!isEmpty(lis_det_voucher)) {
				for (ReporteDetalleIngresosBean det : lis_aux) {					
					String num_voucher = Constantes.EMPTY;
					String fec_voucher = Constantes.EMPTY;
					for (DetalleVoucherBean vou : lis_det_voucher) {						
						if (vou.getCod_com_ingresos().equals(det.getCod_com_ingresos())) {						
							num_voucher = num_voucher.concat(vou.getNum_voucher()).concat(", ");
							fec_voucher = fec_voucher.concat(vou.getFec_voucher()).concat(", ");
						}						
					}
					if (num_voucher.length() > 2) {
						num_voucher = num_voucher.substring(0, num_voucher.length() - 2);
						det.setNum_voucher(num_voucher);
					}
					if (fec_voucher.length() > 2) {
						fec_voucher = fec_voucher.substring(0, fec_voucher.length() - 2);
						det.setFec_voucher(fec_voucher);
					}
				}
			}
			
			lista.clear();
			lista.addAll(lis_aux);			
		} else if (ingreso.getTip_transaccion().equals(Constantes.SEVEN_STRING) && !isEmpty(lista)) { // Registro Compras
			ingreso.setInd_not_credito(Constantes.ONE_INT);
			List<ComprasIngresosBean> lis_compra = iCompraDao.listarCompras(ingreso);
			if (!isEmpty(lis_compra)) {
				for (ReporteDetalleIngresosBean det : lista) {
					for (ComprasIngresosBean com : lis_compra) {
						if (!isNullInteger(det.getCod_pad_com_ingresos()) &&	
								det.getCod_pad_com_ingresos().equals(com.getCod_com_ingresos())) {
							det.setSer_com_not_cre(com.getSer_comprobante());
							det.setNro_com_not_cre(com.getNro_comprobante());
							det.setFec_com_not_cre(com.getFec_comprobante());
							det.setTip_com_not_cre(com.getVcod_comprobante());
						}						
					}
				}
			}			
		}
		return lista;
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarDetalleVoucher(pe.com.mig.model.bean.DetalleVoucherBean)
	 */
	@Override
	public List<DetalleVoucherBean> listarDetalleVoucher(DetalleVoucherBean voucher) throws Exception {
		return iCompraDao.listarDetalleVoucher(voucher);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarCierresMes(pe.com.mig.model.bean.CierreMesBean)
	 */
	@Override
	public List<CierreMesBean> listarCierresMes(CierreMesBean cierre) throws Exception {
		return iCompraDao.listarCierresMes(cierre);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarCierresMes(pe.com.mig.model.bean.CierreMesBean)
	 */
	@Override
	public List<CierreMesBean> listarCierresMesV(CierreMesBean cierre) throws Exception {
		return iCompraDao.listarCierresMesV(cierre);
	}
	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarDatosPs4(pe.com.mig.model.bean.ComprasIngresosBean)
	 */
	@Override
	public List<ComprasIngresosBean> listarDatosPs4(ComprasIngresosBean com_ingreso) throws Exception {
		return iCompraDao.listarDatosPs4(com_ingreso);
	}

	/* (non-Javadoc)
	 * @see pe.com.mig.service.IComprasIngresosService#listarDatos4ta(pe.com.mig.model.bean.ComprasIngresosBean)
	 */
	@Override
	public List<ComprasIngresosBean> listarDatos4ta(ComprasIngresosBean com_ingreso) throws Exception {
		List<ComprasIngresosBean> lista = iCompraDao.listarDatos4ta(com_ingreso);
		if (!isEmpty(lista)) {
			com_ingreso.setInd_cua_categoria(Constantes.ONE_INT);
			List<ComprasIngresosBean> lis_det = iCompraDao.listarDatos4ta(com_ingreso);
			if (!isEmpty(lis_det)) {
				List<ComprasIngresosBean> lis_aux = new ArrayList<ComprasIngresosBean>();				
				for (ComprasIngresosBean rep_compra : lista) {
					for (ComprasIngresosBean com : lis_det) {
						if (rep_compra.getCod_com_ingresos().equals(com.getCod_pad_com_ingresos())) {
							ComprasIngresosBean com_not_cre = com;
							com_not_cre.setInd_retencion(Constantes.ZERO_STRING);
							lis_aux.add(com_not_cre);
						}						
					}
				}				
				lista.addAll(lis_aux);
			}
		}
		return lista;
	}

}
