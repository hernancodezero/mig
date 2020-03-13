package pe.com.mig.service;

import java.math.BigDecimal;
import java.util.List;

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

/**
 * @className: IComprasIngresosService.java
 * @description: 
 * @date: 14 de jun. de 2016
 * @author: SUMERIO.
 */
public interface IComprasIngresosService {	

	/**
	 * @param compra
	 * @return
	 * @throws Exception
	 */
	public abstract List<ComprasIngresosBean> listarComprasSerie(ComprasIngresosBean cod_serie) throws Exception;
	/**
	 * @param compra
	 * @return
	 * @throws Exception
	 */
	public abstract List<ComprasIngresosBean> listarNotasRet(ComprasIngresosBean compra) throws Exception;
	/**
	 * @param compra
	 * @return
	 * @throws Exception
	 */
	public abstract List<ComprasIngresosBean> listarCompras(ComprasIngresosBean compra) throws Exception;	
	
	/**
	 * @param compra
	 * @return
	 * @throws Exception
	 */
	public abstract List<DetalleComprasBean> listarDetalleCompras(ComprasIngresosBean compra) throws Exception;
	
	/**
	 * @param compra
	 * @param detalle
	 * @return
	 * @throws Exception
	 */
	public abstract Integer grabarCompra(ComprasIngresosBean compra, List<DetalleComprasBean> detalle) throws Exception;
	
	/**
	 * @param compra
	 * @throws Exception
	 */
	public abstract void eliminarCompra(ComprasIngresosBean compra) throws Exception;
	
	/**
	 * @param transferencia
	 * @return
	 * @throws Exception
	 */
	public abstract BigDecimal montoTransferencia(TransferenciaBean transferencia) throws Exception;
	
	/**
	 * @param transferencia
	 * @return
	 * @throws Exception
	 */
	public abstract BigDecimal montoCompraNota(TransferenciaBean transferencia) throws Exception;
	
	/**
	 * @param servicio
	 * @return
	 * @throws Exception
	 */
	public abstract List<TarifaServicioBean> listarTarifaServicios(TarifaServicioBean servicio) throws Exception;
	
	/**
	 * @param producto
	 * @return
	 * @throws Exception
	 */
	public abstract List<ProductoBean> listarProductos(ProductoBean producto) throws Exception;
	
	/**
	 * @param boleto
	 * @return
	 * @throws Exception
	 */
	public abstract List<TarifaBoletoBean> listarBoletos(TarifaBoletoBean boleto) throws Exception;
	
	/**
	 * @param tupa
	 * @return
	 * @throws Exception
	 */
	public abstract List<TarifaTupaBean> listarTupas(TarifaTupaBean tupa) throws Exception;
	
	/**
	 * @param otros
	 * @return
	 * @throws Exception
	 */
	public abstract List<DetalleOtrosBean> listarOtros(DetalleOtrosBean otros) throws Exception;

	/**
	 * @param ingreso
	 * @param detalle
	 * @param det_voucher 
	 * @return
	 * @throws Exception 
	 */
	public abstract Integer grabarIngreso(ComprasIngresosBean ingreso, List<DetalleIngresosBean> detalle, List<DetalleVoucherBean> det_voucher) throws Exception;
	
	/**
	 * @param ingreso
	 * @return
	 * @throws Exception
	 */
	public abstract List<DetalleIngresosBean> listarDetalleIngresos(ComprasIngresosBean ingreso) throws Exception;

	/**
	 * @param com_ingreso
	 * @param det_compras
	 * @param det_ingresos
	 * @return
	 * @throws Exception 
	 */
	public abstract Integer grabarNotaCredito(ComprasIngresosBean com_ingreso, DetalleComprasBean det_compras, DetalleIngresosBean det_ingresos) throws Exception;
	
	/**
	 * @param compra
	 * @return
	 * @throws Exception 
	 */
	public abstract List<ReporteDetalleComprasBean> listarReporteCompras(ComprasIngresosBean compra) throws Exception;

	/**
	 * @param ingreso
	 * @return
	 * @throws Exception 
	 */
	public abstract List<ReporteDetalleIngresosBean> listarReporteIngresos(ComprasIngresosBean ingreso) throws Exception;

	/**
	 * @param voucher
	 * @return
	 * @throws Exception 
	 */
	public abstract List<DetalleVoucherBean> listarDetalleVoucher(DetalleVoucherBean voucher) throws Exception;

	/**
	 * @param cierre
	 * @return
	 * @throws Exception 
	 */
	public abstract List<CierreMesBean> listarCierresMes(CierreMesBean cierre) throws Exception;
	/**
	 * @param cierre
	 * @return
	 * @throws Exception 
	 */
	public abstract List<CierreMesBean> listarCierresMesV(CierreMesBean cierre) throws Exception;	
	/**
	 * @param com_ingreso
	 * @return
	 * @throws Exception
	 */
	public abstract List<ComprasIngresosBean> listarDatosPs4(ComprasIngresosBean com_ingreso) throws Exception;
	
	/**
	 * @param com_ingreso
	 * @return
	 * @throws Exception
	 */
	public abstract List<ComprasIngresosBean> listarDatos4ta(ComprasIngresosBean com_ingreso) throws Exception;


}
