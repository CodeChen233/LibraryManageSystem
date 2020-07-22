package com.gychen.po;

import java.io.Serializable;

public class ClassInfo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_info.id
     *
     * @mbggenerated Mon Jul 20 13:54:44 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_info.name
     *
     * @mbggenerated Mon Jul 20 13:54:44 CST 2020
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_info.remarks
     *
     * @mbggenerated Mon Jul 20 13:54:44 CST 2020
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table class_info
     *
     * @mbggenerated Mon Jul 20 13:54:44 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_info.id
     *
     * @return the value of class_info.id
     *
     * @mbggenerated Mon Jul 20 13:54:44 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_info.id
     *
     * @param id the value for class_info.id
     *
     * @mbggenerated Mon Jul 20 13:54:44 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_info.name
     *
     * @return the value of class_info.name
     *
     * @mbggenerated Mon Jul 20 13:54:44 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_info.name
     *
     * @param name the value for class_info.name
     *
     * @mbggenerated Mon Jul 20 13:54:44 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_info.remarks
     *
     * @return the value of class_info.remarks
     *
     * @mbggenerated Mon Jul 20 13:54:44 CST 2020
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_info.remarks
     *
     * @param remarks the value for class_info.remarks
     *
     * @mbggenerated Mon Jul 20 13:54:44 CST 2020
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}