package com.example.javademo.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @author: zhaos
 * @date: 2021/6/29
 */
@Data
public class Pizza {

    private PizzaStatus status;

    @Getter
    public enum PizzaStatus {
        ORDERED (5){
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY (2){
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED (0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " + this.getStatus().getTimeToDelivery());
    }


    public static void main(String[] args) {
        Pizza testPz = new Pizza();
        testPz.setStatus(PizzaStatus.READY);
        System.out.println(testPz.isDeliverable());
        testPz.printTimeToDeliver();
    }

}
