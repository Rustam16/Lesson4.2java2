package com.company;


public class Runner extends Thread {
    private final int number;

    public Runner(String name, int number) {
        super(name);
        this.number = number;
    }

    public void run() {
        System.out.println(this.getName() + number + " берет палочку");
        System.out.println(getName() + number + " бежит к " + getName() + (number + 1));


        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (number + 1 == 5)
            for (int i = 5; i >= 1; i--) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(getName() + i + " берет палочку ");
                if (i == 5) {
                    System.out.println(getName() + i + " бежит к финишу");
                }

                if (i != 1) System.out.println(getName() + i + " бежит к " + getName() + (i - 1));

            }

    }
}
