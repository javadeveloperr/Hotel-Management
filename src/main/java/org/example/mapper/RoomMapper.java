package org.example.mapper;

import org.example.stuatus.RoomType;

public class RoomMapper {
    private Integer id;
    private Integer number;
    private Integer floor;
    private RoomType type;
    private Double price;
    private Double area;
    private Integer comfortId;

    public RoomMapper(Integer id, Integer number, Integer floor, RoomType type, Double price, Double area, Integer comfortId) {
        this.id = id;
        this.number = number;
        this.floor = floor;
        this.type = type;
        this.price = price;
        this.area = area;
        this.comfortId = comfortId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getComfortId() {
        return comfortId;
    }

    public void setComfortId(Integer comfortId) {
        this.comfortId = comfortId;
    }

    @Override
    public String toString() {
        return "RoomMapper{" +
                "id=" + id +
                ", number=" + number +
                ", floor=" + floor +
                ", type=" + type +
                ", price=" + price +
                ", area=" + area +
                ", comfortId=" + comfortId +
                '}';
    }
}
