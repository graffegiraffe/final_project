package by.ilyakate.model.fileprocessing.description;

public class DocumentStatistics {
    private double totalInvoices;
    private double totalOrders;
    private double totalReceipts;

    public double getTotalInvoices() {
        return totalInvoices;
    }

    public void setTotalInvoices(double totalInvoices) {
        this.totalInvoices = totalInvoices;
    }

    public double getTotalOrders() {
        return totalOrders;
    }

    public double getTotalReceipts() {
        return totalReceipts;
    }

    public void setTotalReceipts(double totalReceipts) {
        this.totalReceipts = totalReceipts;
    }
}