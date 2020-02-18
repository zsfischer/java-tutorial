package hu.java.tutorial.java8;

import java.util.Optional;

//Más nyelvekben Elvis Operátorként ismert (?)
public class SafeNavigation
{

    public static void main(String[] args)
    {
        SafeNavigation sn = new SafeNavigation();

        String version = sn
                .getComputer()
                .flatMap(Computer::getSoundcard)
                .flatMap(Soundcard::getUsb)
                .map(USB::getVersion)
                .orElse(null);

        System.out.println(version);
    }

    public Optional<Computer> getComputer()
    {
        return Optional.of(new Computer(Optional.of(new Soundcard(Optional.of(new USB("3.0"))))));
    }

    private static class Computer
    {
        private Optional<Soundcard> soundcard;

        public Computer(Optional<Soundcard> soundcard)
        {
            super();
            this.soundcard = soundcard;
        }

        public Optional<Soundcard> getSoundcard()
        {
            return soundcard;
        }

        public void setSoundcard(Optional<Soundcard> soundcard)
        {
            this.soundcard = soundcard;
        }
    }

    private static class Soundcard
    {
        private Optional<USB> usb;

        public Soundcard(Optional<USB> usb)
        {
            super();
            this.usb = usb;
        }

        public Optional<USB> getUsb()
        {
            return usb;
        }

        public void setUsb(Optional<USB> usb)
        {
            this.usb = usb;
        }
    }

    private class USB
    {
        private String version;

        public USB(String version)
        {
            super();
            this.version = version;
        }

        public String getVersion()
        {
            return version;
        }

        public void setVersion(String version)
        {
            this.version = version;
        }
    }
}
