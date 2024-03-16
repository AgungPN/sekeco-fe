package print;

import dtos.order.OrderDetailToReport;
import java.util.HashMap;
import java.util.Map;

import dtos.order.OrderResponse;
import dtos.product.Product;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

@AllArgsConstructor
@NoArgsConstructor
public class ReportManager {

    private static ReportManager instance;

    private JasperReport invoiceCashier;
//    private JasperReport reportInvoice;

    public static ReportManager getInstance() {
        if (instance == null) {
            instance = new ReportManager();
        }
        return instance;
    }

    public void compileReport() throws JRException {
        invoiceCashier = JasperCompileManager.compileReport(getClass().getResourceAsStream("/print/InvoiceCashier.jrxml"));
//        reportInvoice = JasperCompileManager.compileReport(getClass().getResourceAsStream("/print/report_invoice.jrxml"));
    }

    public void printReportPayment(OrderResponse data) throws JRException {
        Map parametermeter = new HashMap();
        parametermeter.put("transaksi", data.getOrderId());
        parametermeter.put("kasir", data.getUserId().getUsername());
        parametermeter.put("tanggal", data.getCreatedAt());
        parametermeter.put("totalItems", data.getTotalItems());
        parametermeter.put("totalPrice", data.getTotalPrice());
        parametermeter.put("amount", data.getAmount());
        parametermeter.put("refund", data.getRefund());
        List<OrderDetailToReport> list = new ArrayList<>();
        for(int i = 0; i < data.getOrderDetails().size(); i++){
            list.add(OrderDetailToReport.convertToDataReport(data.getOrderDetails().get(i)));
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
        JasperPrint print = JasperFillManager.fillReport(invoiceCashier, parametermeter, dataSource);
        view(print);
    }

//    public void printReportInvoice(ParameterReportInvoice data) throws JRException {
//        Map parameter = new HashMap();
//        parameter.put("totalQty", data.getTotalQty());
//        parameter.put("totalAmount", data.getTotalAmount());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getFields());
//        JasperPrint print = JasperFillManager.fillReport(reportInvoice, parameter, dataSource);
//        view(print);
//    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }
}
