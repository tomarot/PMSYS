package com.magic.www.permissions.vo;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/8/21
 * Time: 12:54
 * To change this template use File | Settings | File Templates.
 * 股票与板块的关联关系
 * 通过left join 查询
 */
public class StockPlateRelationVo {

    private Integer id;

    private Integer stockId;

    private String stockCode;

    private String stockName;

    private Integer plateId;

    private String plateCode;

    private String plateName;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Integer getPlateId() {
        return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
