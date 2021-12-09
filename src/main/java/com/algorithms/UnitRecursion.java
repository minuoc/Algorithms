package com.algorithms;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UnitRecursion {

    public static void main(String[] args) {
        UnitConvertion u1 = new UnitConvertion("zhi","xiang",BigDecimal.valueOf(80));
        UnitConvertion u2 = new UnitConvertion("xiang","duo",BigDecimal.valueOf(5));
        UnitConvertion u3 = new UnitConvertion("duo","dui",BigDecimal.valueOf(5));
        UnitConvertion u4 = new UnitConvertion("dui","dd",BigDecimal.valueOf(4));

        List<UnitConvertion> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);

        BigDecimal b = getQuantity(u1,list,"dd");
        System.out.println(b);
    }

    public static BigDecimal getQuantity(UnitConvertion baseUnit,List<UnitConvertion> list,String target){
        BigDecimal b = BigDecimal.ONE;
        UnitConvertion unitConvertion = list.stream()
                .filter(s->s.getBase().equals(baseUnit.getTarget()))
                .findFirst().orElse(null);
        if (unitConvertion != null){
            b = unitConvertion.getQuantity();
            if (!target.equals(unitConvertion.getTarget())){
                b = b.multiply(getQuantity(unitConvertion,list,target));
            }
        }
        return b;
    }

}

@Data
class UnitConvertion {
    private String base;
    private String target;
    private BigDecimal quantity;

    public UnitConvertion(String base, String target, BigDecimal quantity) {
        this.base = base;
        this.target = target;
        this.quantity = quantity;
    }
}
