package com.company;


import jdk.swing.interop.SwingInterOpUtils;

public class Runner extends Thread {

    private Runner beforeRunner;
    private Runner afterRunner;


    public Runner(String name) {
        super(name);
    }

    public void setRunner(Runner beforeRunner, Runner afterRunner) {
        this.beforeRunner = beforeRunner;
        this.afterRunner = afterRunner;

    }

    public void run() {
        try {
            System.out.println(getName() + " берет палочку ");
            // вместо getName() у нас ИМЯ текущего runner-а
            if (getName() == "runner5") {
                // тут у нас идёт проверка, если getName() равняется на runner5
                System.out.println(getName() + " бежит к финишув ");
                System.out.println(getName() + " бежит к " + beforeRunner.getName());
            } else {
                // в остальных случаях бегут другие runner-ы
                System.out.println(getName() + " бежит к " + afterRunner.getName());
                afterRunner.start();
                // afterRunner запускает у себя метод start(), который запускает метод run()
                afterRunner.join();
                // afterRunner активирует метод join(), чтобы потоки не путались позициями
            }

            if (getName() != "runner5")
            {
                System.out.println(getName() + " берет палочку");
                sleep(1000);
                if (getName() != "runner1")
                System.out.println(getName() + " бежит к " + beforeRunner.getName());
            }



        } catch (Exception ignore
        ) {

        }
    }
}
