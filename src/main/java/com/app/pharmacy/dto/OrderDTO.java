package com.app.pharmacy.dto;

import com.app.pharmacy.model.StatusEnum;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Chris Tzelis
 */
public class OrderDTO {

    private Integer orderId;

    private Date orderDate;

    private Integer prescriptionZipcode;

    private StatusEnum status;

    private String payment;

    private byte[] prescription;

    private List<ProductDTO> productDTOList;

    private Integer customerId;

    private String customerInfo;

    private AddressDTO addressInfoDto;

    public OrderDTO() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getPrescriptionZipcode() {
        return prescriptionZipcode;
    }

    public void setPrescriptionZipcode(Integer prescriptionZipcode) {
        this.prescriptionZipcode = prescriptionZipcode;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public byte[] getPrescription() {
        return prescription;
    }

    public void setPrescription(byte[] prescription) {
        this.prescription = prescription;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<ProductDTO> getProductDTOList() {
        return productDTOList;
    }

    public void setProductDTOList(List<ProductDTO> productDTOList) {
        this.productDTOList = productDTOList;
    }

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public AddressDTO getAddressInfoDto() {
        return addressInfoDto;
    }

    public void setAddressInfoDto(AddressDTO addressInfoDto) {
        this.addressInfoDto = addressInfoDto;
    }


}
